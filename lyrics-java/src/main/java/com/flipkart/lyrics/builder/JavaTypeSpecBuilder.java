package com.flipkart.lyrics.builder;

import com.squareup.javapoet.*;

import java.io.File;
import java.io.IOException;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaTypeSpecBuilder implements TypeSpecBuilder<TypeSpec.Builder, FieldSpec> {

    private TypeSpec.Builder builder;

    public JavaTypeSpecBuilder(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public JavaTypeSpecBuilder(String type, String name) {
        switch (type) {
            case "CLASS":
                this.builder = TypeSpec.classBuilder(name);
        }
    }

    @Override
    public TypeSpec.Builder getBuilder() {
        return builder;
    }

    @Override
    public void writeTo(File file, String fullPackage) throws IOException {
        JavaFile javaFile = JavaFile.builder(fullPackage, builder.build())
                .indent("    ")
                .skipJavaLangImports(true)
                .build();
        javaFile.writeTo(file);
    }

    @Override
    public void addField(FieldSpec fieldSpec) {
        builder.addField(fieldSpec);
    }

    @Override
    public void addAnnotation(Class annotationClass) {
        builder.addAnnotation(annotationClass);
    }

    @Override
    public void addAnnotation(AnnotationSpecBuilder annotationSpecBuilder) {
        builder.addAnnotation(((AnnotationSpec.Builder) annotationSpecBuilder.getAnnotationSpec()).build());
    }

    @Override
    public void addMethod(MethodSpecBuilder methodSpecBuilder) {
        builder.addMethod(((MethodSpec.Builder) methodSpecBuilder.getMethodSpec()).build());
    }
}
