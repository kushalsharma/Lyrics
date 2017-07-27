package com.flipkart.lyrics.creator;

import com.flipkart.lyrics.builder.JavaTypeSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.sets.HandlerSet;
import com.flipkart.lyrics.sets.RuleSet;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaClassCreator extends TypeCreator {

    @Override
    public TypeSpecBuilder process(HandlerSet handlerSet, TypeModel typeModel) {
        RuleSet ruleSet = handlerSet.getRuleSet();
        TypeSpecBuilder typeBuilder = new JavaTypeSpecBuilder("CLASS", handlerSet.getMetaInfo().getClassName());

        handlerSet.getTypeAnnotationHandler().process(typeBuilder, typeModel);
        //handlerSet.getGenericsHandler().process(typeBuilder, typeModel);
        handlerSet.getModifiersHandler().process(typeBuilder, typeModel);
        //handlerSet.getSuperClassHandler().process(typeBuilder, typeModel);
        //handlerSet.getInterfacesHandler().process(typeBuilder, typeModel);
        handlerSet.getFieldsHandler().process(typeBuilder, typeModel);
        handlerSet.getEqualsAndHashCodeHandler().process(typeBuilder, typeModel);
        handlerSet.getToStringHandler().process(typeBuilder, typeModel);
        handlerSet.getNoArgsConstructorHandler().process(typeBuilder, typeModel);
        handlerSet.getRequiredFieldsConstructorHandler().process(typeBuilder, typeModel);
        handlerSet.getCustomConstructorHandler().process(typeBuilder, typeModel);
        //handlerSet.getSpecialInterfacesHandler().process(typeBuilder, typeModel);

        ruleSet.getGlobalInclusionRule().process(typeBuilder, typeModel);
        ruleSet.getSubTypeRule().process(typeBuilder, typeModel);
        ruleSet.getGlobalDeprecatedRule().process(typeBuilder, typeModel);
        ruleSet.getPropertyOrderRule().process(typeBuilder, typeModel);

        handleAdditionalProperties(handlerSet.getTune(), typeBuilder, typeModel);

        return typeBuilder;
    }
}
