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
import com.flipkart.lyrics.builder.SwiftFieldSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.swiftpoet.PropertySpec;
import com.flipkart.swiftpoet.TypeName;
import com.flipkart.swiftpoet.TypeSpec;

/**
 * @author shrey.garg on 25/11/16.
 */
public class SwiftStringTypeHandler extends FieldTypeHandler {

    public SwiftStringTypeHandler(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public FieldSpecBuilder process(TypeSpecBuilder typeSpec, String key, FieldModel fieldModel) {
        PropertySpec.Builder propertySpecBuilder = PropertySpec.builder(true, key, TypeName.STRING, fieldModel.isRequired());
        propertySpecBuilder.addModifiers(TypeSpec.Modifier.DYNAMIC);
        String defaultValue = null;
        if (fieldModel.getInitializeWith() != null) {
            defaultValue = (String) fieldModel.getInitializeWith().getValue();
        }
        if (defaultValue != null) {
            propertySpecBuilder.defaultValue("\"" + defaultValue + "\"");
        }
        return new SwiftFieldSpecBuilder(propertySpecBuilder);
    }
}
