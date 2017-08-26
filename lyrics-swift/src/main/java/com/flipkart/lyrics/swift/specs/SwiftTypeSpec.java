package com.flipkart.lyrics.swift.specs;

import com.flipkart.lyrics.specs.Kind;
import com.flipkart.lyrics.specs.TypeSpec;

import java.io.File;

/**
 * @author kushal.sharma on 11/08/17.
 */
public class SwiftTypeSpec extends TypeSpec {
    SwiftTypeSpec(Builder builder) {
        super(builder);
    }

    @Override
    public Object getTypeSpec() {
        return null;
    }

    @Override
    public void writeToFile(String fullPackage, File targetFolder) {

    }

    public static final class Builder extends TypeSpec.Builder {
        public Builder(Kind kind, String name) {
            super(kind, name);
        }

        public Builder(Kind kind, String typeArgumentsFormat, Object... args) {
            super(kind, typeArgumentsFormat, args);
        }

        @Override
        public TypeSpec build() {
            return new SwiftTypeSpec(this);
        }
    }
}
