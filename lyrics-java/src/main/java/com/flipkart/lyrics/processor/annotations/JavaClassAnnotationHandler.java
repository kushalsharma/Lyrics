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

package com.flipkart.lyrics.processor.annotations;

import com.flipkart.lyrics.builder.JavaAnnotationSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.AnnotationModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.sets.RuleSet;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.flipkart.lyrics.utils.Helper.getClassName;

/**
 * Created by shrey.garg on 25/11/16.
 */
public class JavaClassAnnotationHandler extends Handler {

    public JavaClassAnnotationHandler(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public void process(TypeSpecBuilder typeSpec, TypeModel typeModel) {
        List<AnnotationModel> classAnnotations = consolidateClassAnnotations(tune, typeModel);
        for (AnnotationModel model : classAnnotations) {
            ClassName annotationName = getClassName(model.getClassName());
            AnnotationSpec.Builder annotationBuilder = AnnotationSpec.builder(annotationName);
            Optional.ofNullable(model.getMembers()).map(Map::entrySet)
                    .ifPresent(entries -> entries.forEach(entry -> annotationBuilder.addMember(entry.getKey(), entry.getValue())));
            typeSpec.addAnnotation(new JavaAnnotationSpecBuilder(annotationBuilder));
        }
    }

    private List<AnnotationModel> consolidateClassAnnotations(Tune configuration, TypeModel typeModel) {
        List<AnnotationModel> classAnnotations = new ArrayList<>();
        Optional.ofNullable(configuration.getClassLevelAnnotations()).ifPresent(annotations -> annotations.forEach(classAnnotations::add));
        Optional.ofNullable(typeModel.getAnnotations()).ifPresent(annotations -> annotations.forEach(classAnnotations::add));
        return classAnnotations;
    }
}
