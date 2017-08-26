package com.flipkart.lyrics.swift.specs;

import com.flipkart.lyrics.specs.FieldSpec;
import com.flipkart.lyrics.specs.Modifier;
import com.flipkart.lyrics.specs.TypeName;

/**
 * @author kushal.sharma on 10/08/17.
 */
public class SwiftFieldSpec extends FieldSpec {
    SwiftFieldSpec(Builder builder) {
        super(builder);
    }

    @Override
    public Object getFieldSpec() {
        return null;
    }

    public static final class Builder extends FieldSpec.Builder {
        public Builder(TypeName typeName, String name, Modifier... modifiers) {
            super(typeName, name, modifiers);
        }

        public Builder(Class<?> clazz, String name, Modifier... modifiers) {
            super(clazz, name, modifiers);
        }

        @Override
        public FieldSpec build() {
            return new SwiftFieldSpec(this);
        }
    }
}
