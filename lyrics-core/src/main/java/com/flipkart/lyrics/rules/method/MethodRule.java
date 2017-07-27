package com.flipkart.lyrics.rules.method;

import com.flipkart.lyrics.builder.MethodSpecBuilder;
import com.flipkart.lyrics.builder.ParameterSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.MetaInfo;

/**
 * @author shrey.garg on 10/01/17.
 */
public abstract class MethodRule {

    protected Tune tune;
    protected MetaInfo metaInfo;

    public MethodRule(Tune tune, MetaInfo metaInfo) {
        this.tune = tune;
        this.metaInfo = metaInfo;
    }

    public abstract void process(MethodSpecBuilder methodSpec, FieldModel fieldModel, ParameterSpecBuilder parameterSpec);
}
