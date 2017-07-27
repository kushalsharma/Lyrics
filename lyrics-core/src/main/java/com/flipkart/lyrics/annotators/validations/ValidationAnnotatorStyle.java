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

package com.flipkart.lyrics.annotators.validations;

import com.flipkart.lyrics.builder.FieldSpecBuilder;
import com.flipkart.lyrics.builder.MethodSpecBuilder;
import com.flipkart.lyrics.builder.ParameterSpecBuilder;
import com.flipkart.lyrics.model.FieldModel;

/**
 * Created by shrey.garg on 03/01/17.
 */
public abstract class ValidationAnnotatorStyle {

    public abstract void processRequiredRule(FieldSpecBuilder fieldSpec, FieldModel fieldModel);

    public abstract void processRequiredRuleForGetters(MethodSpecBuilder methodSpec, FieldModel fieldModel);

    public abstract void processRequiredRuleForSetters(MethodSpecBuilder methodSpec, FieldModel fieldModel, ParameterSpecBuilder param);

    public abstract void processNotRequiredRule(FieldSpecBuilder fieldSpec, FieldModel fieldModel);

    public abstract void processNotRequiredRuleForGetters(MethodSpecBuilder methodSpec, FieldModel fieldModel);

    public abstract void processNotRequiredRuleForSetters(MethodSpecBuilder methodSpec, FieldModel fieldModel, ParameterSpecBuilder param);

    public abstract void processRequiredRuleForConstructor(ParameterSpecBuilder parameterSpec);

    public abstract void processNotRequiredRuleForConstructor(ParameterSpecBuilder parameterSpec);

}
