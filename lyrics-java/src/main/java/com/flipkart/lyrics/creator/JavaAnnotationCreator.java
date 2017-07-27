/*
 * Copyright 2016 Flipkart Internet, pvt ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.lyrics.creator;

import com.flipkart.lyrics.builder.JavaAnnotationSpecBuilder;
import com.flipkart.lyrics.builder.JavaTypeSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.sets.HandlerSet;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.TypeSpec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shrey.garg on 27/11/16.
 */
public class JavaAnnotationCreator extends TypeCreator {

    @Override
    public TypeSpecBuilder process(HandlerSet handlerSet, TypeModel typeModel) {
        TypeSpecBuilder typeBuilder = new JavaTypeSpecBuilder(TypeSpec.annotationBuilder(handlerSet.getMetaInfo().getClassName()));

        handlerSet.getModifiersHandler().process(typeBuilder, typeModel);
        //handlerSet.getAnnotationMethodsHandler().process(typeBuilder, typeModel);

        if (typeModel.getRetention() != null) {
            typeBuilder.addAnnotation(new JavaAnnotationSpecBuilder(AnnotationSpec
                    .builder(Retention.class)
                    .addMember("value", "$T.$L", RetentionPolicy.class, typeModel.getRetention())));
        }

        if (typeModel.getElementTypes().length != 0) {
            AnnotationSpec.Builder builder = AnnotationSpec.builder(Target.class);
            for (ElementType elementType : typeModel.getElementTypes()) {
                builder.addMember("value", "$T.$L", ElementType.class, elementType);
            }
            typeBuilder.addAnnotation(new JavaAnnotationSpecBuilder(builder));
        }

        handlerSet.getRuleSet().getGlobalDeprecatedRule().process(typeBuilder, typeModel);

        handleAdditionalProperties(handlerSet.getTune(), typeBuilder, typeModel);

        return typeBuilder;
    }
}
