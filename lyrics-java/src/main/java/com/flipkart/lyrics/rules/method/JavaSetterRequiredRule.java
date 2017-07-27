package com.flipkart.lyrics.rules.method;

import com.flipkart.lyrics.builder.MethodSpecBuilder;
import com.flipkart.lyrics.builder.ParameterSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.rules.method.MethodRule;

/**
 * Created by shrey.garg on 10/01/17.
 */
public class JavaSetterRequiredRule extends MethodRule {

    public JavaSetterRequiredRule(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public void process(MethodSpecBuilder methodSpec, FieldModel fieldModel, ParameterSpecBuilder parameterSpec) {
        if (!fieldModel.isRequired() || (fieldModel.isPrimitive() && !fieldModel.isArray())) {
            return;
        }

        tune.getValidationAnnotatorStyles().forEach(style -> style.processRequiredRuleForSetters(methodSpec, fieldModel, parameterSpec));
    }
}
