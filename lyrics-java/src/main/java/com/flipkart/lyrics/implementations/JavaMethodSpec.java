package com.flipkart.lyrics.implementations;

import com.flipkart.lyrics.specs.AnnotationSpec;
import com.flipkart.lyrics.specs.MethodSpec;
import com.flipkart.lyrics.specs.ParameterSpec;
import com.flipkart.lyrics.specs.CodeBlock;
import com.flipkart.lyrics.specs.Modifier;

import static com.flipkart.lyrics.helper.JavaHelper.*;

/**
 * @author kushal.sharma on 09/08/17.
 */
public class JavaMethodSpec extends MethodSpec {
    public final com.squareup.javapoet.MethodSpec.Builder builder;

    JavaMethodSpec(Builder builder) {
        super(builder);

        this.builder = com.squareup.javapoet.MethodSpec.methodBuilder(this.name);

        for (Modifier modifier : this.modifiers) {
            this.builder.addModifiers(getJavaModifier(modifier));
        }
        if (this.returnType != null) {
            this.builder.returns(getJavaTypeName(this.returnType));
        }
        for (CodeBlock statement : this.statements) {
            this.builder.addStatement(statement.format, statement.arguments);
        }
        for (AnnotationSpec annotation : this.annotations) {
            this.builder.addAnnotation((com.squareup.javapoet.AnnotationSpec) annotation.getAnnotationSpec());
        }
        for (CodeBlock code : this.codeBlocks) {
            this.builder.addCode(code.format, code.arguments);
        }
        for (CodeBlock comment : this.comments) {
            this.builder.addComment(comment.format, comment.arguments);
        }
        for (ParameterSpec parameter : this.parameters) {
            this.builder.addParameter((com.squareup.javapoet.ParameterSpec) parameter.getParameterSpec());
        }
        if (this.defaultValue != null) {
            this.builder.defaultValue(this.defaultValue.format, this.defaultValue.arguments);
        }
    }

    @Override
    public Object getMethodSpec() {
        return builder.build();
    }

    public static final class Builder extends MethodSpec.Builder {
        public Builder() {
            super("<init>");
        }

        public Builder(String name) {
            super(name);
        }

        public MethodSpec build() {
            return new JavaMethodSpec(this);
        }
    }
}
