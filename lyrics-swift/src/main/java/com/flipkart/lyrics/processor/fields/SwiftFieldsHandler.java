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
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.sets.RuleSet;

import static com.flipkart.lyrics.helper.Helper.getFieldTypeHandler;

/**
 * @author shrey.garg on 29/11/16.
 */
public class SwiftFieldsHandler extends Handler {

    public SwiftFieldsHandler(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public void process(TypeSpecBuilder typeBuilder, TypeModel typeModel) {
        for (String key : typeModel.getFields().keySet()) {
            FieldModel fieldModel = typeModel.getFields().get(key);
            FieldSpecBuilder originalFieldBuilder = getFieldTypeHandler(fieldModel.getFieldType(), tune.getFieldTypeHandlerSet())
                    .process(typeBuilder, key, fieldModel);
            typeBuilder.addField(originalFieldBuilder.getFieldSpec());
        }
    }
}
