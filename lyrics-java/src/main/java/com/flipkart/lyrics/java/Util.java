package com.flipkart.lyrics.java;

import com.flipkart.lyrics.specs.*;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author kushal.sharma on 10/08/17.
 */
class Util {

    static com.squareup.javapoet.TypeSpec getTypeSpec(TypeSpec type) {
        com.squareup.javapoet.TypeSpec.Builder builder;

        switch (type.kind) {
            case CLASS:
                builder = com.squareup.javapoet.TypeSpec.classBuilder(type.name);
                break;
            case INTERFACE:
                builder = com.squareup.javapoet.TypeSpec.interfaceBuilder(type.name);
                break;
            case ENUM:
                builder = com.squareup.javapoet.TypeSpec.enumBuilder(type.name);
                break;
            case ANNOTATION:
                builder = com.squareup.javapoet.TypeSpec.annotationBuilder(type.name);
                break;
            case ANONYMOUS:
                builder = com.squareup.javapoet.TypeSpec.anonymousClassBuilder(type.anonymousTypeArgumentsFormat, type.anonymousTypeArgumentsArgs);
                break;
            default:
                builder = com.squareup.javapoet.TypeSpec.classBuilder(type.name);
        }

        if (type.superclass != null) {
            builder.superclass(getJavaTypeName(type.superclass));
        }
        for (FieldSpec fieldSpec : type.fieldSpecs) {
            builder.addField(getFieldSpec(fieldSpec));
        }
        for (AnnotationSpec annotationSpec : type.annotations) {
            builder.addAnnotation(getAnnotationSpec(annotationSpec));
        }
        for (MethodSpec methodSpec : type.methodSpecs) {
            builder.addMethod(getMethodSpec(methodSpec));
        }
        for (Modifier modifier : type.modifiers) {
            builder.addModifiers(getJavaModifier(modifier));
        }
        for (String key : type.enumConstants.keySet()) {
            TypeSpec t = type.enumConstants.get(key);
            if (t == null) {
                builder.addEnumConstant(key);
            } else {
                builder.addEnumConstant(key, getTypeSpec(t));
            }
        }
        for (TypeName superinterface : type.superinterfaces) {
            builder.addSuperinterface(getJavaTypeName(superinterface));
        }
        for (TypeSpec t : type.typeSpecs) {
            builder.addType(getTypeSpec(t));
        }
        for (TypeVariableName typeVariableName : type.typeVariables) {
            builder.addTypeVariable(getJavaTypeVariableName(typeVariableName));
        }
        return builder.build();
    }

    private static com.squareup.javapoet.MethodSpec getMethodSpec(MethodSpec methodSpec) {
        com.squareup.javapoet.MethodSpec.Builder builder = com.squareup.javapoet.MethodSpec.methodBuilder(methodSpec.name);

        for (Modifier modifier : methodSpec.modifiers) {
            builder.addModifiers(getJavaModifier(modifier));
        }
        if (methodSpec.returnType != null) {
            builder.returns(getJavaTypeName(methodSpec.returnType));
        }
        for (AnnotationSpec annotation : methodSpec.annotations) {
            builder.addAnnotation(getAnnotationSpec(annotation));
        }
        if (!methodSpec.code.isEmpty()) {
           ;
            builder.addCode(getJavaCodeBlock(methodSpec.code));
        }
        for (ParameterSpec parameter : methodSpec.parameters) {
            builder.addParameter(getParameterSpec(parameter));
        }
        if (methodSpec.defaultValue != null) {
            builder.defaultValue(getJavaCodeBlock(methodSpec.defaultValue));
        }
        return builder.build();
    }

    private static com.squareup.javapoet.CodeBlock getJavaCodeBlock(CodeBlock code) {
        try {
            List<String> formatParts = (List<String>) FieldUtils.readField(code, "formatParts", true);
            List<Object> args = (List<Object>) FieldUtils.readField(code, "args", true);
            com.squareup.javapoet.CodeBlock.Builder codeBlockBuilder = com.squareup.javapoet.CodeBlock.builder();
            FieldUtils.writeField(codeBlockBuilder, "formatParts", formatParts, true);
            FieldUtils.writeField(codeBlockBuilder, "args", args, true);
            return codeBlockBuilder.build();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return com.squareup.javapoet.CodeBlock.builder().build();
    }

    private static com.squareup.javapoet.ParameterSpec getParameterSpec(ParameterSpec parameter) {
        com.squareup.javapoet.ParameterSpec.Builder builder = com.squareup.javapoet.ParameterSpec
                .builder(getJavaTypeName(parameter.type), parameter.name, getJavaModifiers(parameter.modifiers));

        for (AnnotationSpec annotation : parameter.annotations) {
            builder.addAnnotation(getAnnotationSpec(annotation));
        }
        return builder.build();
    }

    private static com.squareup.javapoet.AnnotationSpec getAnnotationSpec(AnnotationSpec annotationSpec) {
        com.squareup.javapoet.AnnotationSpec.Builder builder = com.squareup.javapoet.AnnotationSpec
                .builder(getJavaClassName(annotationSpec.type));

        for (String name : annotationSpec.members.keySet()) {
            com.squareup.javapoet.CodeBlock codeBlock = getJavaCodeBlock(annotationSpec.members.get(name).get(0));
            List<Object> args = new ArrayList<>();
            try {
                args.addAll((List<Object>) FieldUtils.readField(codeBlock, "args", true));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            Object[] newArgs = new Object[args.size()];
            for (int i = 0; i < args.size(); i++) {
                if (args.get(i) instanceof ClassName) {
                    ClassName className = (ClassName) args.get(i);
                    newArgs[i] = getJavaClassName(className);
                } else {
                    newArgs[i] = args.get(i);
                }
            }

            try {
                FieldUtils.writeField(codeBlock, "args", newArgs, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            builder.addMember(name, codeBlock);
        }
        return builder.build();
    }

    private static com.squareup.javapoet.FieldSpec getFieldSpec(FieldSpec fieldSpec) {
        com.squareup.javapoet.FieldSpec.Builder builder = com.squareup.javapoet.FieldSpec
                .builder(getJavaTypeName(fieldSpec.type), fieldSpec.name, getJavaModifiers(fieldSpec.modifiers));

        if (!fieldSpec.initializer.isEmpty()) {
            builder.initializer(getJavaCodeBlock(fieldSpec.initializer));
        }
        for (AnnotationSpec annotationSpec : fieldSpec.annotations) {
            builder.addAnnotation(getAnnotationSpec(annotationSpec));
        }
        return builder.build();
    }

    private static javax.lang.model.element.Modifier[] getJavaModifiers(Set<Modifier> modifiers) {
        Modifier[] modifiersArray = modifiers.toArray(new Modifier[modifiers.size()]);
        javax.lang.model.element.Modifier[] javaModifiers = new javax.lang.model.element.Modifier[modifiersArray.length];
        for (int i = 0; i < modifiersArray.length; i++) {
            javaModifiers[i] = getJavaModifier(modifiersArray[i]);
        }
        return javaModifiers;
    }

    private static javax.lang.model.element.Modifier getJavaModifier(Modifier modifier) {
        switch (modifier) {
            case PUBLIC:
                return javax.lang.model.element.Modifier.PUBLIC;
            case PROTECTED:
                return javax.lang.model.element.Modifier.PROTECTED;
            case PRIVATE:
                return javax.lang.model.element.Modifier.PRIVATE;
            case ABSTRACT:
                return javax.lang.model.element.Modifier.ABSTRACT;
            case DEFAULT:
                return javax.lang.model.element.Modifier.DEFAULT;
            case STATIC:
                return javax.lang.model.element.Modifier.STATIC;
            case FINAL:
                return javax.lang.model.element.Modifier.FINAL;
            case TRANSIENT:
                return javax.lang.model.element.Modifier.TRANSIENT;
            case VOLATILE:
                return javax.lang.model.element.Modifier.VOLATILE;
            case SYNCHRONIZED:
                return javax.lang.model.element.Modifier.SYNCHRONIZED;
            case NATIVE:
                return javax.lang.model.element.Modifier.NATIVE;
            case STRICTFP:
                return javax.lang.model.element.Modifier.STRICTFP;
            default:
                return null;
        }
    }

    private static com.squareup.javapoet.TypeName getJavaTypeName(TypeName typeName) {
        if (typeName == TypeName.INT) {
            return com.squareup.javapoet.TypeName.INT;
        } else if (typeName == TypeName.BOOLEAN) {
            return com.squareup.javapoet.TypeName.BOOLEAN;
        } else if (typeName == TypeName.BYTE) {
            return com.squareup.javapoet.TypeName.BYTE;
        } else if (typeName == TypeName.CHAR) {
            return com.squareup.javapoet.TypeName.CHAR;
        } else if (typeName == TypeName.FLOAT) {
            return com.squareup.javapoet.TypeName.FLOAT;
        } else if (typeName == TypeName.DOUBLE) {
            return com.squareup.javapoet.TypeName.DOUBLE;
        } else if (typeName == TypeName.LONG) {
            return com.squareup.javapoet.TypeName.LONG;
        } else if (typeName == TypeName.SHORT) {
            return com.squareup.javapoet.TypeName.SHORT;
        } else if (typeName == TypeName.VOID) {
            return com.squareup.javapoet.TypeName.VOID;
        } else if (typeName == TypeName.OBJECT) {
            return com.squareup.javapoet.TypeName.OBJECT;
        } else if (typeName instanceof ClassName) {
            return getJavaClassName(typeName);
        } else if (typeName instanceof ParameterizedTypeName) {
            return getJavaParameterizedTypeName((ParameterizedTypeName) typeName);
        } else if (typeName instanceof ArrayTypeName) {
            return com.squareup.javapoet.ArrayTypeName.of(getJavaTypeName(((ArrayTypeName) typeName).componentType));
        } else if (typeName instanceof TypeVariableName) {
            return getJavaTypeVariableName((TypeVariableName) typeName);
        }
        return com.squareup.javapoet.TypeName.OBJECT;
    }

    private static com.squareup.javapoet.ClassName getJavaClassName(TypeName typeName) {
        if (typeName instanceof ClassName) {
            ClassName className = (ClassName) typeName;
            return com.squareup.javapoet.ClassName.get(className.packageName(), className.simpleName());
        } else throw new ClassCastException();
    }

    private static com.squareup.javapoet.ParameterizedTypeName getJavaParameterizedTypeName(ParameterizedTypeName parameterizedTypeName) {
        com.squareup.javapoet.TypeName[] typeNameArray = new com.squareup.javapoet.TypeName[parameterizedTypeName.typeArguments.size()];
        for (int i = 0; i < parameterizedTypeName.typeArguments.size(); i++) {
            typeNameArray[i] = getJavaTypeName(parameterizedTypeName.typeArguments.get(i));
        }
        return com.squareup.javapoet.ParameterizedTypeName.get(getJavaClassName(parameterizedTypeName.rawType), typeNameArray);
    }

    private static com.squareup.javapoet.TypeVariableName getJavaTypeVariableName(TypeVariableName typeVariableName) {
        com.squareup.javapoet.TypeName[] typeNameArray = new com.squareup.javapoet.TypeName[typeVariableName.bounds.size()];
        for (int i = 0; i < typeVariableName.bounds.size(); i++) {
            typeNameArray[i] = getJavaTypeName(typeVariableName.bounds.get(i));
        }
        return com.squareup.javapoet.TypeVariableName.get(typeVariableName.name, typeNameArray);
    }
}
