package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.processor.annotations.JavaClassAnnotationHandler;
import com.flipkart.lyrics.processor.constructors.JavaCustomConstructorHandler;
import com.flipkart.lyrics.processor.constructors.JavaNoArgsConstructorHandler;
import com.flipkart.lyrics.processor.constructors.JavaOrderedConstructorHandler;
import com.flipkart.lyrics.processor.constructors.JavaRequiredFieldsConstructorHandler;
import com.flipkart.lyrics.processor.fields.JavaFieldsHandler;
import com.flipkart.lyrics.processor.instances.JavaEnumValuesHandler;
import com.flipkart.lyrics.processor.instances.JavaEnumWithFieldsValuesHandler;
import com.flipkart.lyrics.processor.methods.JavaEqualsAndHashCodeHandler;
import com.flipkart.lyrics.processor.methods.JavaToStringHandler;
import com.flipkart.lyrics.processor.modifiers.JavaModifiersHandler;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaHandlerSetImpl extends HandlerSet {

    public JavaHandlerSetImpl() {
        super();
    }

    public JavaHandlerSetImpl(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getTypeAnnotationHandler() {
        return new JavaClassAnnotationHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getGenericsHandler() {
        return null;
    }

    @Override
    public Handler getModifiersHandler() {
        return new JavaModifiersHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getSuperClassHandler() {
        return null;
    }

    @Override
    public Handler getInterfacesHandler() {
        return null;
    }

    @Override
    public Handler getFieldsHandler() {
        return new JavaFieldsHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getEqualsAndHashCodeHandler() {
        return new JavaEqualsAndHashCodeHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getToStringHandler() {
        return new JavaToStringHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getNoArgsConstructorHandler() {
        return new JavaNoArgsConstructorHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getRequiredFieldsConstructorHandler() {
        return new JavaRequiredFieldsConstructorHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getCustomConstructorHandler() {
        return new JavaCustomConstructorHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getSpecialInterfacesHandler() {
        return null;
    }

    @Override
    public Handler getAnnotationMethodsHandler() {
        return null;
    }

    @Override
    public Handler getEnumValuesHandler() {
        return new JavaEnumValuesHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getEnumValuesWithFieldsHandler() {
        return new JavaEnumWithFieldsValuesHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getOrderedConstructorHandler() {
        return new JavaOrderedConstructorHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getInterfaceMethodsHandler() {
        return null;
    }
}
