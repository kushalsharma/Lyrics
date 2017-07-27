package com.flipkart.lyrics.builder;

import java.io.File;
import java.io.IOException;

/**
 * @author kushal.sharma on 27/06/17.
 */
public interface TypeSpecBuilder<T, Z> {
    T getBuilder();

    void writeTo(File file, String fullPackage) throws IOException;

    void addField(Z fieldSpec);

    void addAnnotation(Class annotationClass);

    void addAnnotation(AnnotationSpecBuilder annotationSpecBuilder);

    void addMethod(MethodSpecBuilder methodSpecBuilder);
}
