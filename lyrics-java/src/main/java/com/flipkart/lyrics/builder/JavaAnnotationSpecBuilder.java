package com.flipkart.lyrics.builder;

import com.squareup.javapoet.AnnotationSpec;

/**
 * @author kushal.sharma on 25/07/17.
 */
public class JavaAnnotationSpecBuilder implements AnnotationSpecBuilder<AnnotationSpec.Builder> {

    private AnnotationSpec.Builder builder;

    public JavaAnnotationSpecBuilder(AnnotationSpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public AnnotationSpec.Builder getAnnotationSpec() {
        return builder;
    }
}
