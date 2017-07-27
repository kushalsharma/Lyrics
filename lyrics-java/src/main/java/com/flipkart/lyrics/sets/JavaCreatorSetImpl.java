package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.creator.*;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class JavaCreatorSetImpl extends CreatorSet {

    @Override
    public TypeCreator getClassCreator() {
        return new JavaClassCreator();
    }

    @Override
    public TypeCreator getAnnotationCreator() {
        return new JavaAnnotationCreator();
    }

    @Override
    public TypeCreator getEnumCreator() {
        return new JavaEnumCreator();
    }

    @Override
    public TypeCreator getEnumWithFieldsCreator() {
        return new JavaEnumWithFieldsCreator();
    }

    @Override
    public TypeCreator getInterfaceCreator() {
        return new JavaInterfaceCreator();
    }
}
