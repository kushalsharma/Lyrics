package com.flipkart.lyrics.builder;


/**
 * @author kushal.sharma on 27/06/17.
 */
public interface ParameterSpecBuilder<T, C> {
    T getBuilder();

    void addAnnotation(C className);
}
