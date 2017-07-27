package com.flipkart.lyrics.helper;

import com.flipkart.lyrics.creator.TypeCreator;
import com.flipkart.lyrics.model.FieldType;
import com.flipkart.lyrics.model.Type;
import com.flipkart.lyrics.processor.fields.FieldTypeHandler;
import com.flipkart.lyrics.sets.CreatorSet;
import com.flipkart.lyrics.sets.FieldTypeHandlerSet;

/**
 * @author kushal.sharma on 26/06/17.
 */
public class Helper {

    public static TypeCreator getCreator(Type type, CreatorSet creatorSet) {
        switch (type) {
            case ANNOTATION:
                return creatorSet.getAnnotationCreator();
            case CLASS:
                return creatorSet.getClassCreator();
            case ENUM:
                return creatorSet.getEnumCreator();
            case ENUM_WITH_FIELDS:
                return creatorSet.getEnumWithFieldsCreator();
            case INTERFACE:
                return creatorSet.getInterfaceCreator();
            default:
                return creatorSet.getClassCreator();
        }
    }

    public static FieldTypeHandler getFieldTypeHandler(FieldType type, FieldTypeHandlerSet handlerSet) {
        switch (type) {
            case BOOLEAN:
                return handlerSet.getBooleanTypeHandler();
            case BYTE:
                return handlerSet.getByteTypeHandler();
            case CHARACTER:
                return handlerSet.getCharacterTypeHandler();
            case DOUBLE:
                return handlerSet.getDoubleTypeHandler();
            case FLOAT:
                return handlerSet.getFloatTypeHandler();
            case INTEGER:
                return handlerSet.getIntegerTypeHandler();
            case LONG:
                return handlerSet.getLongTypeHandler();
            case SHORT:
                return handlerSet.getShortTypeHandler();
            case OBJECT:
                return handlerSet.getObjectTypeHandler();
            case STRING:
                return handlerSet.getStringTypeHandler();
            case ENUM:
                return handlerSet.getEnumTypeHandler();
            default:
                return handlerSet.getObjectTypeHandler();
        }
    }
}
