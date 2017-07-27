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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftTuneImpl implements Tune {

    private final FieldTypeHandlerSet fieldTypeHandlerSet = new SwiftFieldTypeHandlerSetImpl();
    private final ParameterTypeHandlerSet parameterTypeHandlerSet = new SwiftParameterTypeHandlerSetImpl();
    private final CreatorSet creatorSet = new SwiftCreatorSetImpl();
    private final HandlerSet handlerSet = new SwiftHandlerSetImpl();
    private final RuleSet ruleSet = new SwiftRuleSetImpl();
    private final Map<String, FieldAdditionalHandler> fieldAdditionalHandlerMap = new HashMap<>();
    private final Map<String, TypeAdditionalHandler> typeAdditionalHandlerMap = new HashMap<>();
    private final Map<String, FieldModificationHandler> fieldModificationHandlers = new HashMap<>();

    @Override
    public boolean forceDefaultFieldModifiers() {
        return false;
    }

    @Override
    public Modifier getDefaultFieldModifier() {
        return Modifier.PUBLIC;
    }

    @Override
    public Modifier getDefaultClassModifier() {
        return null;
    }

    @Override
    public CreatorSet getCreatorSet() {
        return creatorSet;
    }

    @Override
    public HandlerSet getHandlerSet() {
        return handlerSet;
    }

    @Override
    public RuleSet getRuleSet() {
        return ruleSet;
    }

    @Override
    public FieldTypeHandlerSet getFieldTypeHandlerSet() {
        return fieldTypeHandlerSet;
    }

    @Override
    public ParameterTypeHandlerSet getParameterTypeHandlerSet() {
        return parameterTypeHandlerSet;
    }

    @Override
    public Map<String, FieldAdditionalHandler> getFieldsAdditionalPropertiesHandler() {
        return fieldAdditionalHandlerMap;
    }

    @Override
    public Map<String, FieldModificationHandler> getFieldModificationHandlers() {
        return fieldModificationHandlers;
    }

    @Override
    public Map<String, TypeAdditionalHandler> getTypeAdditionalPropertiesHandler() {
        return typeAdditionalHandlerMap;
    }

    @Override
    public List<AnnotatorStyle> getAnnotatorStyles() {
        return null;
    }

    @Override
    public List<ValidationAnnotatorStyle> getValidationAnnotatorStyles() {
        return null;
    }

    @Override
    public List<AnnotationModel> getClassLevelAnnotations() {
        return null;
    }

    @Override
    public boolean areAccessorsNeeded() {
        return true;
    }

    @Override
    public boolean isToStringNeeded() {
        return false;
    }

    @Override
    public ObjectMethodsStyle getObjectMethodsStyle() {
        return null;
    }

    @Override
    public boolean areHashCodeAndEqualsNeeded() {
        return false;
    }

    @Override
    public boolean isRequiredFieldConstructorNeeded() {
        return false;
    }

    @Override
    public boolean excludeInitializedFieldsFromConstructor() {
        return false;
    }

    @Override
    public boolean isCustomConstructorNeeded() {
        return false;
    }
}
