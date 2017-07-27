/*
 * Copyright 2017 Flipkart Internet, pvt ltd.
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

package com.flipkart.lyrics.processor.constructors;

import com.flipkart.lyrics.builder.ParameterSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.sets.RuleSet;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

import static com.flipkart.lyrics.utils.Helper.getParameterTypeHandler;

/**
 * Created by shrey.garg on 06/02/17.
 */
public abstract class JavaConstructorHandler extends Handler {

    public JavaConstructorHandler(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public void process(TypeSpecBuilder typeSpec, TypeModel typeModel) {
        Map<String, FieldModel> fields = typeModel.getFields();

        List<String> constructorFields = getConstructorFields(typeModel);
        if (constructorFields.isEmpty()) {
            return;
        }

        MethodSpec.Builder constructor = MethodSpec.constructorBuilder();
        if (getModifier() != null) {
            constructor = constructor.addModifiers(getModifier());
        }

        for (String field : constructorFields) {
            ParameterSpecBuilder parameterSpec = getParameterTypeHandler(fields.get(field).getFieldType(), tune.getParameterTypeHandlerSet())
                    .process(typeSpec, field, fields.get(field));

            if (!fields.get(field).isPrimitive()) {
                tune.getValidationAnnotatorStyles().forEach(style -> {
                    if (fields.get(field).isRequired()) {
                        style.processRequiredRuleForConstructor(parameterSpec);
                    } else {
                        style.processNotRequiredRuleForConstructor(parameterSpec);
                    }
                });
            }

            constructor.addParameter(((ParameterSpec.Builder) parameterSpec.getBuilder()).build());
            constructor.addStatement("this.$L = $L", field, field);
        }

        ((TypeSpec.Builder)(typeSpec.getBuilder())).addMethod(constructor.build());
    }


    protected abstract List<String> getConstructorFields(TypeModel typeModel);

    protected abstract Modifier getModifier();
}
