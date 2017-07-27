package com.flipkart.lyrics;

import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.creator.TypeCreator;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.lyrics.model.TypeModel;
import com.flipkart.lyrics.sets.HandlerSet;
import com.flipkart.lyrics.sets.RuleSet;

import java.io.File;
import java.io.IOException;

import static com.flipkart.lyrics.helper.Helper.getCreator;
import static com.flipkart.lyrics.helper.Injector.*;

/**
 * @author shrey.garg on 27/11/16.
 */
public class Song {
    private Tune tune;

    public Song(Tune tune) {
        this.tune = tune;
    }

    public void createType(String name, String fullPackage, TypeModel typeModel, File targetFolder) throws IOException {
        MetaInfo metaInfo = new MetaInfo(name, fullPackage);
        RuleSet ruleSet = processRuleSet(tune, metaInfo);
        HandlerSet handlerSet = processHandlerSet(tune, metaInfo, ruleSet);
        processFieldTypeHandlerSet(tune, metaInfo);
        processParameterTypeHandlerSet(tune, metaInfo);
        processFieldAdditionalHandlers(tune, metaInfo);
        processTypeAdditionalHandlers(tune, metaInfo);
        processFieldModificationHandlers(tune, metaInfo);

        TypeCreator creator = getCreator(typeModel.getType(), tune.getCreatorSet());
        TypeSpecBuilder typeSpecBuilder = creator.process(handlerSet, typeModel);
        typeSpecBuilder.writeTo(targetFolder, fullPackage);
    }
}