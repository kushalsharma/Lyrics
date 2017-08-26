package com.flipkart.lyrics.swift.specs;

import com.flipkart.lyrics.specs.Modifier;
import com.flipkart.lyrics.specs.ParameterSpec;
import com.flipkart.lyrics.specs.TypeName;

/**
 * @author kushal.sharma on 11/08/17.
 */
public class SwiftParameterSpec extends ParameterSpec {
    SwiftParameterSpec(Builder builder) {
        super(builder);
    }

    @Override
    public Object getParameterSpec() {
        return null;
    }

    public static final class Builder extends ParameterSpec.Builder {
        public Builder(TypeName type, String name, Modifier... modifiers) {
            super(type, name, modifiers);
        }

        public Builder(Class<?> clazz, String name, Modifier... modifiers) {
            super(clazz, name, modifiers);
        }

        @Override
        public ParameterSpec build() {
            return new SwiftParameterSpec(this);
        }
    }
}
