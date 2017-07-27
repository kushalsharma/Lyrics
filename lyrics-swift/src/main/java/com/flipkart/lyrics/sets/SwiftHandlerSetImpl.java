package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.processor.fields.SwiftFieldsHandler;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftHandlerSetImpl extends HandlerSet {

    public SwiftHandlerSetImpl() {
        super();
    }

    public SwiftHandlerSetImpl(Tune tune, MetaInfo metaInfo, RuleSet ruleSet) {
        super(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getTypeAnnotationHandler() {
        return null;
    }

    @Override
    public Handler getGenericsHandler() {
        return null;
    }

    @Override
    public Handler getModifiersHandler() {
        return null;
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
        return new SwiftFieldsHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getEqualsAndHashCodeHandler() {
        return null;
    }

    @Override
    public Handler getToStringHandler() {
        return null;
    }

    @Override
    public Handler getNoArgsConstructorHandler() {
        return null;
    }

    @Override
    public Handler getRequiredFieldsConstructorHandler() {
        return null;
    }

    @Override
    public Handler getCustomConstructorHandler() {
        return null;
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
        return null;
    }

    @Override
    public Handler getEnumValuesWithFieldsHandler() {
        return null;
    }

    @Override
    public Handler getOrderedConstructorHandler() {
        return null;
    }

    @Override
    public Handler getInterfaceMethodsHandler() {
        return null;
    }
}
