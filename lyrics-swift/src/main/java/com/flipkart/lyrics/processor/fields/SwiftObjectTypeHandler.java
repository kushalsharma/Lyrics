package com.flipkart.lyrics.processor.fields;

import com.flipkart.lyrics.builder.FieldSpecBuilder;
import com.flipkart.lyrics.builder.SwiftFieldSpecBuilder;
import com.flipkart.lyrics.builder.TypeSpecBuilder;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.InitializerModel;
import com.flipkart.lyrics.model.MetaInfo;
import com.flipkart.swiftpoet.PropertySpec;
import com.flipkart.swiftpoet.TypeName;
import com.flipkart.swiftpoet.TypeSpec;

/**
 * @author kushal.sharma on 21/07/17.
 */
public class SwiftObjectTypeHandler extends FieldTypeHandler{
    public SwiftObjectTypeHandler(Tune tune, MetaInfo metaInfo) {
        super(tune, metaInfo);
    }

    @Override
    public FieldSpecBuilder process(TypeSpecBuilder typeSpec, String key, FieldModel fieldModel) {
        TypeName typeName;
        if (fieldModel.getType() == null) {
            typeName = TypeName.ANY;
        } else {
            String fullTypeName = fieldModel.getType().getType();
            String type = fullTypeName.substring(fullTypeName.lastIndexOf(".") + 1, fullTypeName.length());
            typeName = new TypeName(type);
        }

        InitializerModel initializerModel = fieldModel.getInitializeWith();
        String defaultValue = null;
        if (initializerModel != null) {
            defaultValue = (String) initializerModel.getValue();
        }
        SwiftFieldSpecBuilder builder = new SwiftFieldSpecBuilder(PropertySpec.builder(true, key, typeName, defaultValue != null));
        builder.getBuilder().addModifiers(TypeSpec.Modifier.DYNAMIC);
        if (defaultValue != null) {
            builder.getBuilder().defaultValue(defaultValue);
        }
        return builder;
    }
}
