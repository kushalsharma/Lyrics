package com.flipkart.lyrics.builder;

/**
 * @author kushal.sharma on 27/06/17.
 */
public interface FieldSpecBuilder<T, V, C> {
    T getBuilder();

    void initializer(String format, Object... args);

    V getFieldSpec();

    void addAnnotation(Class annotationClass);

    void addAnnotation(C className);
}
