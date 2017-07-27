package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.processor.fields.FieldTypeHandler;
import com.flipkart.lyrics.processor.fields.SwiftObjectTypeHandler;
import com.flipkart.lyrics.processor.fields.SwiftPrimitiveTypeHandler;
import com.flipkart.lyrics.processor.fields.SwiftStringTypeHandler;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftFieldTypeHandlerSetImpl extends FieldTypeHandlerSet {
    @Override
    public FieldTypeHandler getObjectTypeHandler() {
        return new SwiftObjectTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getIntegerTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getBooleanTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getLongTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getDoubleTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getCharacterTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getShortTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getByteTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getFloatTypeHandler() {
        return new SwiftPrimitiveTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getStringTypeHandler() {
        return new SwiftStringTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getEnumTypeHandler() {
        return new SwiftObjectTypeHandler(tune, metaInfo);
    }
}
