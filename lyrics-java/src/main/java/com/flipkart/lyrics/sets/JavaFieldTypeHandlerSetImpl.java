package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.model.Primitive;
import com.flipkart.lyrics.processor.fields.FieldTypeHandler;
import com.flipkart.lyrics.processor.fields.JavaObjectTypeHandler;
import com.flipkart.lyrics.processor.fields.JavaPrimitiveTypeHandler;
import com.flipkart.lyrics.processor.fields.JavaStringTypeHandler;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaFieldTypeHandlerSetImpl extends FieldTypeHandlerSet {

    @Override
    public FieldTypeHandler getObjectTypeHandler() {
        return new JavaObjectTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getIntegerTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.INTEGER);
    }

    @Override
    public FieldTypeHandler getBooleanTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.BOOLEAN);
    }

    @Override
    public FieldTypeHandler getLongTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.LONG);
    }

    @Override
    public FieldTypeHandler getDoubleTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.DOUBLE);
    }

    @Override
    public FieldTypeHandler getCharacterTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.CHARACTER);
    }

    @Override
    public FieldTypeHandler getShortTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.SHORT);
    }

    @Override
    public FieldTypeHandler getByteTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.BYTE);
    }

    @Override
    public FieldTypeHandler getFloatTypeHandler() {
        return new JavaPrimitiveTypeHandler(tune, metaInfo, Primitive.FLOAT);
    }

    @Override
    public FieldTypeHandler getStringTypeHandler() {
        return new JavaStringTypeHandler(tune, metaInfo);
    }

    @Override
    public FieldTypeHandler getEnumTypeHandler() {
        return new JavaObjectTypeHandler(tune, metaInfo);
    }
}
