package com.flipkart.lyrics.creator;

import com.flipkart.lyrics.builder.SwiftTypeSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.sets.HandlerSet;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftClassCreator extends TypeCreator {

    @Override
    public TypeSpecBuilder process(HandlerSet handlerSet, TypeModel typeModel) {
        TypeSpecBuilder typeBuilder = new SwiftTypeSpecBuilder("CLASS", handlerSet.getMetaInfo().getClassName());
        handlerSet.getFieldsHandler().process(typeBuilder, typeModel);

        return typeBuilder;
    }
}
