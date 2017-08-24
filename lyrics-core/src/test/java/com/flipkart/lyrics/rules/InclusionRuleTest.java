/*
 * Copyright 2016 Flipkart Internet, pvt ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.lyrics.rules;

import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.specs.FieldSpec;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.model.InclusionType;
import com.flipkart.lyrics.test.annotation.TuneProvider;
import com.flipkart.lyrics.test.extensions.ConfigurationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.flipkart.lyrics.test.extensions.ConfigurationExtension.JACKSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by shrey.garg on 11/12/16.
 */
@ExtendWith(ConfigurationExtension.class)
public class InclusionRuleTest {

    @Test
    public void testNoInclusion(@TuneProvider Tune tune) {
        FieldSpec.Builder builder = FieldSpec.builder(String.class, "test");
        FieldModel model = mock(FieldModel.class);
        when(model.getInclusion()).thenReturn(null);

        new InclusionRule(tune, null).process(builder, model);

        FieldSpec spec = builder.build();

        assertEquals("test", spec.name, "Wrong name found.");
//        assertEquals(0, spec.annotationSpecs.size(), "Annotations found.");
    }

    @Test
    public void testNoParsers(@TuneProvider Tune tune) {
        FieldSpec.Builder builder = FieldSpec.builder(String.class, "test");
        FieldModel model = mock(FieldModel.class);
        when(model.getInclusion()).thenReturn(InclusionType.NON_NULL);

        new InclusionRule(tune, null).process(builder, model);

        FieldSpec spec = builder.build();

        assertEquals("test", spec.name, "Wrong name found.");
//        assertEquals(0, spec.annotationSpecs.size(), "Annotations found.");
    }

    @Test
    public void testJacksonParser(@TuneProvider(JACKSON) Tune tune) {
        FieldSpec.Builder builder = FieldSpec.builder(String.class, "test");
        FieldModel model = mock(FieldModel.class);
        when(model.getInclusion()).thenReturn(InclusionType.NON_NULL);

        new InclusionRule(tune, null).process(builder, model);

        FieldSpec spec = builder.build();

        assertEquals("test", spec.name, "Wrong name found.");
//        assertEquals(1, spec.annotationSpecs.size(), "Annotation not found.");

//        AnnotationSpec annotationSpec = spec.annotationSpecs.get(0);
//        assertEquals(JsonSerialize.class.getName(), annotationSpec.clazz.getName(), "Wrong annotation found.");
//        assertEquals(1, annotationSpec.members.size(), "More than one annotation members found.");

//        assertNotNull(annotationSpec.members.get("include"), "Annotation inclusion not found");
//        assertEquals("JsonSerialize.Inclusion.NON_NULL", annotationSpec.members.get("include").get(0).toString(), "Wrong value found.");
    }
}