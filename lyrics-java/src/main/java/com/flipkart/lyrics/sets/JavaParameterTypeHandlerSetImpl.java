package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.processor.constructors.JavaObjectParameterTypeHandler;
import com.flipkart.lyrics.processor.constructors.ParameterTypeHandler;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaParameterTypeHandlerSetImpl extends ParameterTypeHandlerSet {

    @Override
    public ParameterTypeHandler getObjectTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getIntegerTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getBooleanTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getLongTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getDoubleTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getCharacterTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getShortTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getByteTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getFloatTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getStringTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }

    @Override
    public ParameterTypeHandler getEnumTypeHandler() {
        return new JavaObjectParameterTypeHandler(tune, metaInfo);
    }
}
