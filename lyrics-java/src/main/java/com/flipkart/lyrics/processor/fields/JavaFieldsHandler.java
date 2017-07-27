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

package com.flipkart.lyrics.processor.fields;

import com.flipkart.lyrics.builder.FieldSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.helper.Helper;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.processor.methods.JavaGetterHandler;
import com.flipkart.lyrics.processor.methods.JavaSetterHandler;
import com.flipkart.lyrics.sets.RuleSet;
import com.squareup.javapoet.FieldSpec;


import java.util.List;
import java.util.stream.Collectors;

import static com.flipkart.lyrics.utils.Helper.getFieldTypeHandler;

/**
 * @author shrey.garg on 29/11/16.
 */
public class JavaFieldsHandler extends Handler {

    public JavaFieldsHandler(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public void process(TypeSpecBuilder typeBuilder, TypeModel typeModel) {
        for (String key : typeModel.getFields().keySet()) {
            FieldModel fieldModel = typeModel.getFields().get(key);
            FieldSpecBuilder originalFieldBuilder = Helper.getFieldTypeHandler(fieldModel.getFieldType(), tune.getFieldTypeHandlerSet())
                    .process(typeBuilder, key, fieldModel);
            FieldSpecBuilder fieldBuilder = tune.getFieldModificationHandlers().entrySet().stream()
                    .filter(e -> fieldModel.getAdditionalFields().get(e.getKey()) != null).findFirst()
                    .map(e -> e.getValue().process(originalFieldBuilder, e.getKey(), fieldModel.getAdditionalFields().get(e.getKey()), fieldModel))
                    .orElse(originalFieldBuilder);
            handleFieldRules(fieldBuilder, fieldModel);

            List<Boolean> triggers = tune.getFieldsAdditionalPropertiesHandler().entrySet().stream()
                    .filter(e -> fieldModel.getAdditionalFields().get(e.getKey()) != null)
                    .map(e -> e.getValue().process(fieldBuilder, e.getKey(), fieldModel.getAdditionalFields().get(e.getKey())))
                    .collect(Collectors.toList());

            boolean hideField = triggers.stream().anyMatch(b -> !b);
            if (hideField) {
                continue;
            }

            FieldSpec fieldSpec = (FieldSpec) fieldBuilder.getFieldSpec();
            typeBuilder.addField(fieldSpec);

            if (tune.areAccessorsNeeded()) {
                new JavaGetterHandler(tune, metaInfo, ruleSet).process(typeBuilder, fieldSpec, fieldModel);
                new JavaSetterHandler(tune, metaInfo, ruleSet).process(typeBuilder, fieldSpec, fieldModel);
            }
        }
    }


    private void handleFieldRules(FieldSpecBuilder fieldSpec, FieldModel fieldModel) {
        ruleSet.getInclusionRule().process(fieldSpec, fieldModel);
        ruleSet.getNamedAsRule().process(fieldSpec, fieldModel);
        ruleSet.getRequiredRule().process(fieldSpec, fieldModel);
        ruleSet.getNotRequiredRule().process(fieldSpec, fieldModel);
        ruleSet.getDeprecatedRule().process(fieldSpec, fieldModel);
    }
}
