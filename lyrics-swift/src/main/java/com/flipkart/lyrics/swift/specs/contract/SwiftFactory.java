package com.flipkart.lyrics.swift.specs.contract;

import com.flipkart.lyrics.swift.specs.*;
import com.flipkart.lyrics.specs.*;
import com.flipkart.lyrics.specs.contract.Factory;

/**
 * @author kushal.sharma on 09/08/17.
 */
public class SwiftFactory implements Factory {
    @Override
    public MethodSpec.Builder createConstructorBuilder() {
        return new SwiftMethodSpec.Builder();
    }

    @Override
    public MethodSpec.Builder createMethodBuilder(String name) {
        return new SwiftMethodSpec.Builder(name);
    }

    @Override
    public AnnotationSpec.Builder createAnnotationBuilder(ClassName className) {
        return new SwiftAnnotationSpec.Builder(className);
    }

    @Override
    public TypeSpec.Builder createClassBuilder(String name) {
        return new SwiftTypeSpec.Builder(Kind.CLASS, name);
    }

    @Override
    public TypeSpec.Builder createAnnotationBuilder(String name) {
        return new SwiftTypeSpec.Builder(Kind.ANNOTATION, name);
    }

    @Override
    public TypeSpec.Builder createInterfaceBuilder(String name) {
        return new SwiftTypeSpec.Builder(Kind.INTERFACE, name);
    }

    @Override
    public TypeSpec.Builder createEnumBuilder(String name) {
        return new SwiftTypeSpec.Builder(Kind.ENUM, name);
    }

    @Override
    public TypeSpec.Builder createAnonymousClassBuilder(String typeArgumentsFormat, Object... args) {
        return new SwiftTypeSpec.Builder(Kind.ANONYMOUS, typeArgumentsFormat, args);
    }

    @Override
    public FieldSpec.Builder createFieldBuilder(TypeName typeName, String name, Modifier[] modifiers) {
        return new SwiftFieldSpec.Builder(typeName, name, modifiers);
    }

    @Override
    public ParameterSpec.Builder createParameterBuilder(TypeName typeName, String name, Modifier[] modifiers) {
        return new SwiftParameterSpec.Builder(typeName, name, modifiers);
    }
}
