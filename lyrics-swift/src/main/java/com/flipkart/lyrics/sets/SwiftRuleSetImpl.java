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
import com.flipkart.lyrics.rules.FieldRule;
import com.flipkart.lyrics.rules.method.MethodRule;
import com.flipkart.lyrics.rules.type.TypeRule;

/**
 * @author shrey.garg on 30/12/16.
 */
public class SwiftRuleSetImpl extends RuleSet {

    public SwiftRuleSetImpl() {
        super();
    }

    public SwiftRuleSetImpl(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public TypeRule getSubTypeRule() {
        return null;
    }

    @Override
    public TypeRule getGlobalInclusionRule() {
        return null;
    }

    @Override
    public TypeRule getPropertyOrderRule() {
        return null;
    }

    @Override
    public TypeRule getGlobalDeprecatedRule() {
        return null;
    }

    @Override
    public FieldRule getDeprecatedRule() {
        return null;
    }

    @Override
    public FieldRule getNamedAsRule() {
        return null;
    }

    @Override
    public FieldRule getInclusionRule() {
        return null;
    }

    @Override
    public FieldRule getRequiredRule() {
        return null;
    }

    @Override
    public MethodRule getGetterRequiredRule() {
        return null;
    }

    @Override
    public MethodRule getSetterRequiredRule() {
        return null;
    }

    @Override
    public FieldRule getNotRequiredRule() {
        return null;
    }

    @Override
    public MethodRule getGetterNotRequiredRule() {
        return null;
    }

    @Override
    public MethodRule getSetterNotRequiredRule() {
        return null;
    }

}
