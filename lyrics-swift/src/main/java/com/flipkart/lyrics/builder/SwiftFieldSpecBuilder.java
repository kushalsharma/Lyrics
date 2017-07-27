package com.flipkart.lyrics.builder;


import com.flipkart.swiftpoet.PropertySpec;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftFieldSpecBuilder implements FieldSpecBuilder<PropertySpec.Builder, PropertySpec, Object> {
    private PropertySpec.Builder builder;

    public SwiftFieldSpecBuilder(PropertySpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public PropertySpec.Builder getBuilder() {
        return builder;
    }

    @Override
    public void initializer(String format, Object... args) {

    }

    @Override
    public PropertySpec getFieldSpec() {
        return builder.build();
    }

    @Override
    public void addAnnotation(Class annotationClass) {
    }

    @Override
    public void addAnnotation(Object className) {
    }
}
