package com.flipkart.lyrics.specs;

import com.flipkart.lyrics.helper.Util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static com.flipkart.lyrics.helper.Util.checkArgument;
import static com.flipkart.lyrics.helper.Util.checkNotNull;
import static com.flipkart.lyrics.helper.Util.checkState;

/**
 * @author kushal.sharma on 09/08/17.
 */
public class MethodSpec {
    static final String CONSTRUCTOR = "<init>";

    public final String name;
    public final CodeBlock doc;
    public final List<AnnotationSpec> annotations;
    public final Set<Modifier> modifiers;
    public final List<TypeVariableName> typeVariables;
    public final TypeName returnType;
    public final List<ParameterSpec> parameters;
    public final boolean varargs;
    public final List<TypeName> exceptions;
    public final CodeBlock defaultValue;
    public final CodeBlock code;

    protected MethodSpec(Builder builder) {
        CodeBlock code = builder.code.build();
        this.name = checkNotNull(builder.name, "name == null");
        this.doc = builder.doc.build();
        this.annotations = Util.immutableList(builder.annotations);
        this.modifiers = Util.immutableSet(builder.modifiers);
        this.typeVariables = Util.immutableList(builder.typeVariables);
        this.returnType = builder.returnType;
        this.parameters = Util.immutableList(builder.parameters);
        this.varargs = builder.varargs;
        this.exceptions = Util.immutableList(builder.exceptions);
        this.defaultValue = builder.defaultValue;
        this.code = code;
    }

    public boolean hasModifier(Modifier modifier) {
        return modifiers.contains(modifier);
    }

    public static Builder methodBuilder(String name) {
        return new Builder(name);
    }

    public static Builder constructorBuilder() {
        return new Builder(CONSTRUCTOR);
    }

    public Builder toBuilder() {
        Builder builder = new Builder(name);
        builder.doc.add(doc);
        builder.annotations.addAll(annotations);
        builder.modifiers.addAll(modifiers);
        builder.typeVariables.addAll(typeVariables);
        builder.returnType = returnType;
        builder.parameters.addAll(parameters);
        builder.exceptions.addAll(exceptions);
        builder.varargs = varargs;
        builder.defaultValue = defaultValue;
        builder.code.add(code);
        return builder;
    }

    public boolean isConstructor() {
        return name.equals(CONSTRUCTOR);
    }

    public static final class Builder {
        private final String name;
        private final CodeBlock.Builder doc = CodeBlock.builder();
        private final List<AnnotationSpec> annotations = new ArrayList<>();
        private final List<Modifier> modifiers = new ArrayList<>();
        private List<TypeVariableName> typeVariables = new ArrayList<>();
        private TypeName returnType;
        private final List<ParameterSpec> parameters = new ArrayList<>();
        private final Set<TypeName> exceptions = new LinkedHashSet<>();
        private boolean varargs;
        private CodeBlock defaultValue;
        private final CodeBlock.Builder code = CodeBlock.builder();

        protected Builder(String name) {
            this.name = name;
        }

        public MethodSpec.Builder addModifiers(Modifier... modifiers) {
            this.modifiers.addAll(Arrays.asList(modifiers));
            return this;
        }

        public MethodSpec.Builder returns(TypeName typeName) {
            this.returnType = typeName;
            return this;
        }

        public MethodSpec.Builder returns(Type type) {
            this.returnType = TypeName.get(type);
            return this;
        }

        public MethodSpec.Builder addAnnotation(Class<?> clazz) {
            this.annotations.add(AnnotationSpec.builder(clazz).build());
            return this;
        }

        public MethodSpec.Builder addAnnotation(ClassName className) {
            this.annotations.add(AnnotationSpec.builder(className).build());
            return this;
        }

        public MethodSpec.Builder addParameter(ParameterSpec parameterSpec) {
            this.parameters.add(parameterSpec);
            return this;
        }

        public MethodSpec.Builder addParameter(TypeName typeName, String name, Modifier... modifiers) {
            this.parameters.add(ParameterSpec.builder(typeName, name, modifiers).build());
            return this;
        }

        public MethodSpec.Builder addParameter(Class<?> type, String name, Modifier... modifiers) {
            this.parameters.add(ParameterSpec.builder(type, name, modifiers).build());
            return this;
        }

        public MethodSpec.Builder defaultValue(String format, Object... args) {
            this.defaultValue = CodeBlock.of(format, args);
            return this;
        }

        public Builder addCode(String format, Object... args) {
            code.add(format, args);
            return this;
        }

        public Builder addComment(CodeBlock codeBlock) {
            code.add(codeBlock);
            return this;
        }

        public MethodSpec.Builder addComment(String format, Object... args) {
            this.code.add("// " + format + "\n", args);
            return this;
        }

        public Builder addStatement(String format, Object... args) {
            code.add("// " + format + "\n", args);
            return this;
        }

        public MethodSpec build() {
            return new MethodSpec(this);
        }
    }
}