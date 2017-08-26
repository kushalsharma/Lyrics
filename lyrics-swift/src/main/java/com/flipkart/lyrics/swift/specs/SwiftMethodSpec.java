package com.flipkart.lyrics.swift.specs;

import com.flipkart.lyrics.specs.MethodSpec;

/**
 * @author kushal.sharma on 09/08/17.
 */
public class SwiftMethodSpec extends MethodSpec {
    SwiftMethodSpec(Builder builder) {
        super(builder);
    }

    @Override
    public Object getMethodSpec() {
        return null;
    }

    public static final class Builder extends MethodSpec.Builder {
        public Builder() {
            super("<init>");
        }

        public Builder(String name) {
            super(name);
        }

        public MethodSpec build() {
            return new SwiftMethodSpec(this);
        }
    }
}
