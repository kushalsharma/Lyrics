package com.flipkart.lyrics.config;

import com.flipkart.lyrics.annotators.AnnotatorStyle;
import com.flipkart.lyrics.annotators.validations.Jsr305Style;
import com.flipkart.lyrics.annotators.validations.ValidationAnnotatorStyle;
import com.flipkart.lyrics.model.AnnotationModel;
import com.flipkart.lyrics.processor.fields.FieldAdditionalHandler;
import com.flipkart.lyrics.processor.fields.FieldModificationHandler;
import com.flipkart.lyrics.processor.types.TypeAdditionalHandler;
import com.flipkart.lyrics.sets.*;
import com.flipkart.lyrics.styles.objectmethods.CommonsLang3Style;
import com.flipkart.lyrics.styles.objectmethods.ObjectMethodsStyle;

import javax.lang.model.element.Modifier;
import java.util.*;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaTuneImpl implements Tune {

    private final FieldTypeHandlerSet fieldTypeHandlerSet = new JavaFieldTypeHandlerSetImpl();
    private final ParameterTypeHandlerSet parameterTypeHandlerSet = new JavaParameterTypeHandlerSetImpl();
    private final CreatorSet creatorSet = new JavaCreatorSetImpl();
    private final HandlerSet handlerSet = new JavaHandlerSetImpl();
    private final RuleSet ruleSet = new JavaRuleSetImpl();
    private final Map<String, FieldAdditionalHandler> fieldAdditionalHandlerMap = new HashMap<>();
    private final Map<String, TypeAdditionalHandler> typeAdditionalHandlerMap = new HashMap<>();
    private final Map<String, FieldModificationHandler> fieldModificationHandlers = new HashMap<>();
    private final List<AnnotatorStyle> annotatorStyles = new ArrayList<>();
    private final List<ValidationAnnotatorStyle> validationAnnotatorStyles = Collections.singletonList(
            new Jsr305Style()
    );

    @Override
    public boolean forceDefaultFieldModifiers() {
        return false;
    }

    @Override
    public Modifier getDefaultFieldModifier() {
        return Modifier.PRIVATE;
    }

    @Override
    public Modifier getDefaultClassModifier() {
        return Modifier.PUBLIC;
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
        return annotatorStyles;
    }

    @Override
    public List<ValidationAnnotatorStyle> getValidationAnnotatorStyles() {
        return validationAnnotatorStyles;
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
        return true;
    }

    @Override
    public ObjectMethodsStyle getObjectMethodsStyle() {
        return new CommonsLang3Style();
    }

    @Override
    public boolean areHashCodeAndEqualsNeeded() {
        return true;
    }

    @Override
    public boolean isRequiredFieldConstructorNeeded() {
        return true;
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
