package com.flipkart.lyrics.builder;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;

/**
 * @author kushal.sharma on 25/07/17.
 */
public class JavaMethodSpecBuilder implements MethodSpecBuilder<MethodSpec.Builder, ClassName> {

    private MethodSpec.Builder builder;

    public JavaMethodSpecBuilder(MethodSpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public MethodSpec.Builder getMethodSpec() {
        return builder;
    }

    @Override
    public void addParameter(ParameterSpecBuilder parameterSpecBuilder) {
        builder.addParameter(((ParameterSpec.Builder) parameterSpecBuilder.getBuilder()).build());
    }

    @Override
    public void addAnnotation(ClassName className) {
        builder.addAnnotation(className);
    }

    @Override
    public void addStatement(String format, Object... args) {
        builder.addStatement(format, args);
    }

    @Override
    public void addComment(String format, Object... args) {
        builder.addComment(format, args);
    }

    @Override
    public void addCode(String format, Object... args) {
        builder.addCode(format, args);
    }
}
