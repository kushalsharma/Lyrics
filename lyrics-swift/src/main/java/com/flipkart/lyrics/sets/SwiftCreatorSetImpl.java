package com.flipkart.lyrics.sets;

import com.flipkart.lyrics.creator.SwiftClassCreator;
import com.flipkart.lyrics.creator.TypeCreator;

/**
 * @author kushal.sharma on 27/06/17.
 */
public class SwiftCreatorSetImpl extends CreatorSet {
    @Override
    public TypeCreator getClassCreator() {
        return new SwiftClassCreator();
    }

    @Override
    public TypeCreator getAnnotationCreator() {
        return null;
    }

    @Override
    public TypeCreator getEnumCreator() {
        return null;
    }

    @Override
    public TypeCreator getEnumWithFieldsCreator() {
        return null;
    }

    @Override
    public TypeCreator getInterfaceCreator() {
        return null;
    }
}
