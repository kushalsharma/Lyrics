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

package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.rules.method.JavaGetterNotRequiredRule;
import com.flipkart.lyrics.rules.method.JavaGetterRequiredRule;
import com.flipkart.lyrics.rules.method.JavaSetterNotRequiredRule;
import com.flipkart.lyrics.rules.method.JavaSetterRequiredRule;
import com.flipkart.lyrics.rules.*;
import com.flipkart.lyrics.rules.method.*;
import com.flipkart.lyrics.rules.type.*;

/**
 * @author shrey.garg on 30/12/16.
 */
public class JavaRuleSetImpl extends RuleSet {

    public JavaRuleSetImpl() {
        super();
    }

    public JavaRuleSetImpl(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public TypeRule getSubTypeRule() {
        return new JavaSubTypesRule(tune, metaInfo);
    }

    @Override
    public TypeRule getGlobalInclusionRule() {
        return new JavaGlobalInclusionRule(tune, metaInfo);
    }

    @Override
    public TypeRule getPropertyOrderRule() {
        return new JavaPropertyOrderRule(tune, metaInfo);
    }

    @Override
    public TypeRule getGlobalDeprecatedRule() {
        return new JavaGlobalDeprecatedRule(tune, metaInfo);
    }

    @Override
    public FieldRule getDeprecatedRule() {
        return new JavaDeprecatedRule(tune, metaInfo);
    }

    @Override
    public FieldRule getNamedAsRule() {
        return new JavaNamedAsRule(tune, metaInfo);
    }

    @Override
    public FieldRule getInclusionRule() {
        return new JavaInclusionRule(tune, metaInfo);
    }

    @Override
    public FieldRule getRequiredRule() {
        return new JavaRequiredRule(tune, metaInfo);
    }

    @Override
    public MethodRule getGetterRequiredRule() {
        return new JavaGetterRequiredRule(tune, metaInfo);
    }

    @Override
    public MethodRule getSetterRequiredRule() {
        return new JavaSetterRequiredRule(tune, metaInfo);
    }

    @Override
    public FieldRule getNotRequiredRule() {
        return new JavaNotRequiredRule(tune, metaInfo);
    }

    @Override
    public MethodRule getGetterNotRequiredRule() {
        return new JavaGetterNotRequiredRule(tune, metaInfo);
    }

    @Override
    public MethodRule getSetterNotRequiredRule() {
        return new JavaSetterNotRequiredRule(tune, metaInfo);
    }

}
