package com.flipkart.lyrics.builder;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaFieldSpecBuilder implements FieldSpecBuilder<FieldSpec.Builder, FieldSpec, ClassName> {

    private FieldSpec.Builder builder;

    public JavaFieldSpecBuilder(FieldSpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public FieldSpec.Builder getBuilder() {
        return builder;
    }

    @Override
    public void initializer(String format, Object... args) {
        builder.initializer(format, args);
    }

    @Override
    public FieldSpec getFieldSpec() {
        return builder.build();
    }

    @Override
    public void addAnnotation(Class annotationClass) {
        builder.addAnnotation(annotationClass);
    }

    @Override
    public void addAnnotation(ClassName className) {
        builder.addAnnotation(className);
    }
}
