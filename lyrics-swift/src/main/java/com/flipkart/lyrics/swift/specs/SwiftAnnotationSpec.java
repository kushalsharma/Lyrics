package com.flipkart.lyrics.swift.specs;

import com.flipkart.lyrics.specs.AnnotationSpec;
import com.flipkart.lyrics.specs.ClassName;

/**
 * @author kushal.sharma on 10/08/17.
 */
public class SwiftAnnotationSpec extends AnnotationSpec {
    SwiftAnnotationSpec(Builder builder) {
        super(builder);
    }

    public Object getAnnotationSpec() {
        return null;
    }

    public static final class Builder extends AnnotationSpec.Builder {
        public Builder(ClassName className) {
            super(className);
        }

        @Override
        public AnnotationSpec build() {
            return new SwiftAnnotationSpec(this);
        }
    }
}
