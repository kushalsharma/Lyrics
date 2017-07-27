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

package com.flipkart.lyrics.processor.methods;

import com.flipkart.lyrics.builder.JavaMethodSpecBuilder;
import com.flipkart.lyrics.builder.MethodSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.FieldType;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.sets.RuleSet;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

import static com.flipkart.lyrics.utils.Helper.getGetterSetterName;

/**
 * Created by shrey.garg on 25/11/16.
 */
public class JavaGetterHandler {

    private Tune tune;
    private MetaInfo metaInfo;
    private RuleSet ruleSet;

    public JavaGetterHandler(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        this.tune = tune;
        this.metaInfo = metaInfo;
        this.ruleSet = ruleSet;
    }

    public void process(TypeSpecBuilder typeBuilder, FieldSpec fieldSpec, FieldModel fieldModel) {
        String methodName = getGetterSetterName(fieldSpec.name, false, fieldModel.getFieldType() == FieldType.BOOLEAN, fieldModel.isPrimitive());
        MethodSpecBuilder builder = new JavaMethodSpecBuilder(MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .returns(fieldSpec.type)
                .addStatement("return $L", fieldSpec.name));

        ruleSet.getGetterRequiredRule().process(builder, fieldModel, null);
        ruleSet.getGetterNotRequiredRule().process(builder, fieldModel, null);

        typeBuilder.addMethod(builder);
    }
}
