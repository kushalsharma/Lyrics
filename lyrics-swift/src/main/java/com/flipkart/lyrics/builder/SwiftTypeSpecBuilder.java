package com.flipkart.lyrics.builder;


import com.flipkart.swiftpoet.PropertySpec;
import com.flipkart.swiftpoet.SwiftFile;
import com.flipkart.swiftpoet.TypeSpec;

import java.io.File;
import java.io.IOException;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftTypeSpecBuilder implements TypeSpecBuilder<TypeSpec.Builder, PropertySpec> {
    private TypeSpec.Builder builder;

    public SwiftTypeSpecBuilder(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public SwiftTypeSpecBuilder(String type, String name) {
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
        SwiftFile swiftFile = SwiftFile.builder(builder.build()).build();
        swiftFile.writeTo(file);
    }

    @Override
    public void addField(PropertySpec fieldSpec) {
        builder.addProperty(fieldSpec);
    }

    @Override
    public void addAnnotation(Class annotationClass) {
    }

    @Override
    public void addAnnotation(AnnotationSpecBuilder annotationSpecBuilder) {
        // TODO implement this
    }

    @Override
    public void addMethod(MethodSpecBuilder methodSpecBuilder) {
        // TODO implement this
    }
}
