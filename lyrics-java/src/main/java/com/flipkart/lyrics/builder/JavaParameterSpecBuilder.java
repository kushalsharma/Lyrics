package com.flipkart.lyrics.builder;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;

/**
 * @author kushal.sharma on 21/07/17.
 */
public class JavaParameterSpecBuilder implements ParameterSpecBuilder<ParameterSpec.Builder, ClassName> {

    private ParameterSpec.Builder builder;

    public JavaParameterSpecBuilder(ParameterSpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public ParameterSpec.Builder getBuilder() {
        return builder;
    }

    @Override
    public void addAnnotation(ClassName className) {
        builder.addAnnotation(className);
    }
}
