package com.flipkart.lyrics.builder;

/**
 * @author kushal.sharma on 27/06/17.
 */
public interface MethodSpecBuilder<T, C> {
    T getMethodSpec();

    void addParameter(ParameterSpecBuilder parameterSpecBuilder);

    void addAnnotation(C className);

    void addStatement(String format, Object... args);

    void addComment(String format, Object... args);

    void addCode(String format, Object... args);
}
