package com.flipkart.lyrics.processor.fields;

import com.flipkart.lyrics.builder.FieldSpecBuilder;
import com.flipkart.lyrics.builder.JavaFieldSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.InitializerModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.squareup.javapoet.*;

import java.util.HashMap;

import static com.flipkart.lyrics.utils.Helper.*;

/**
 * @author kushal.sharma on 21/07/17.
 */
public class JavaObjectTypeHandler extends FieldTypeHandler{

    public JavaObjectTypeHandler(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public FieldSpecBuilder process(TypeSpecBuilder typeSpec, String key, FieldModel fieldModel) {
        TypeName typeName;
        if (fieldModel.getType() == null) {
            typeName = TypeName.OBJECT;
        } else {
            typeName = getResolvedTypeName(fieldModel.getType(), new HashMap<>()); // Need to look at this later
        }

        typeName = fieldModel.isArray() ? ArrayTypeName.of(typeName) : typeName;
        FieldSpecBuilder builder = new JavaFieldSpecBuilder(FieldSpec.builder(typeName, key, resolveModifiers(tune, fieldModel)));
        InitializerModel initializeWith = fieldModel.getInitializeWith();
        if (initializeWith != null) {
            if (initializeWith.getValue() != null) {
                ClassName fromType = getClassName(initializeWith.getFromType());
                builder.initializer("$T.$L", fromType, initializeWith.getValue());
            } else if (initializeWith.getNewInstanceOf() != null) {
                ClassName instanceOf = getClassName(initializeWith.getNewInstanceOf());
                String initializerString = "new $T" + (initializeWith.isInferGenerics() ? "<>" : "") + "()";
                builder.initializer(initializerString, instanceOf);
            }
        }

        return builder;
    }
}
