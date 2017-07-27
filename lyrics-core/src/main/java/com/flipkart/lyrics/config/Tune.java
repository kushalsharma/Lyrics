package com.flipkart.lyrics.config;

import com.flipkart.lyrics.annotators.AnnotatorStyle;
import com.flipkart.lyrics.annotators.validations.ValidationAnnotatorStyle;
import com.flipkart.lyrics.model.AnnotationModel;
import com.flipkart.lyrics.processor.fields.FieldAdditionalHandler;
import com.flipkart.lyrics.processor.fields.FieldModificationHandler;
import com.flipkart.lyrics.processor.types.TypeAdditionalHandler;
import com.flipkart.lyrics.sets.*;
import com.flipkart.lyrics.styles.objectmethods.ObjectMethodsStyle;

import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Map;

/**
 * @author kushal.sharma on 26/06/17.
 */
public interface Tune {
    boolean forceDefaultFieldModifiers();

    Modifier getDefaultFieldModifier();

    Modifier getDefaultClassModifier();

    CreatorSet getCreatorSet();

    HandlerSet getHandlerSet();

    RuleSet getRuleSet();

    FieldTypeHandlerSet getFieldTypeHandlerSet();

    ParameterTypeHandlerSet getParameterTypeHandlerSet();

    Map<String, FieldAdditionalHandler> getFieldsAdditionalPropertiesHandler();

    Map<String, FieldModificationHandler> getFieldModificationHandlers();

    Map<String, TypeAdditionalHandler> getTypeAdditionalPropertiesHandler();

    List<AnnotatorStyle> getAnnotatorStyles();

    List<ValidationAnnotatorStyle> getValidationAnnotatorStyles();

    List<AnnotationModel> getClassLevelAnnotations();

    boolean areAccessorsNeeded();

    boolean isToStringNeeded();

    ObjectMethodsStyle getObjectMethodsStyle();

    boolean areHashCodeAndEqualsNeeded();

    boolean isRequiredFieldConstructorNeeded();

    boolean excludeInitializedFieldsFromConstructor();

    boolean isCustomConstructorNeeded();
}
