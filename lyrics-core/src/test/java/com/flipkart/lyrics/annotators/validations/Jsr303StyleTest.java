/*
 * Copyright 2017 Flipkart Internet, pvt ltd.
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

package com.flipkart.lyrics.annotators.validations;

import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.interfaces.FieldSpec;
import com.flipkart.lyrics.interfaces.MethodSpec;
import com.flipkart.lyrics.interfaces.ParameterSpec;
import com.flipkart.lyrics.model.FieldModel;
import com.flipkart.lyrics.test.annotation.TuneProvider;
import com.flipkart.lyrics.test.extensions.ConfigurationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by shrey.garg on 07/06/17.
 */

@ExtendWith(ConfigurationExtension.class)
public class Jsr303StyleTest {

    @Test
    public void testRequiredRule(@TuneProvider Tune tune) {
        FieldSpec.Builder builder = FieldSpec.builder(String.class, "test");
        FieldModel model = mock(FieldModel.class);

        new Jsr303Style().processRequiredRule(builder, model);

        FieldSpec fieldSpec = builder.build();
        assertEquals("test", fieldSpec.name);
        assertEquals(1, fieldSpec.annotationClasses.size());

        Class<?> requiredAnnotation = fieldSpec.annotationClasses.get(0);
        assertEquals(NotNull.class.getName(), requiredAnnotation.getName());
    }

    @Test
    public void processRequiredRuleForGetters(@TuneProvider Tune tune) {
        FieldModel model = mock(FieldModel.class);
        MethodSpec.Builder builder = MethodSpec.methodBuilder("test");

        new Jsr303Style().processRequiredRuleForGetters(builder, model);

        MethodSpec methodSpec = builder.build();
        assertEquals("test", methodSpec.name);
        assertEquals(1, methodSpec.annotationClasses.size());

        Class<?> requiredAnnotation = methodSpec.annotationClasses.get(0);
        assertEquals(NotNull.class.getName(), requiredAnnotation.getName());
    }

    @Test
    public void processRequiredRuleForSetters(@TuneProvider Tune tune) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder("test");
        ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(String.class, "one");
        FieldModel model = mock(FieldModel.class);

        new Jsr303Style().processRequiredRuleForSetters(builder, model, parameterBuilder);

        MethodSpec methodSpec = builder.build();
        assertEquals("test", methodSpec.name);
        assertEquals(0, methodSpec.annotationClasses.size());

        ParameterSpec parameterSpec = parameterBuilder.build();
        assertEquals("one", parameterSpec.name);
        assertEquals(1, parameterSpec.classes.size());

        Class<?> requiredAnnotation = parameterSpec.classes.get(0);
        assertEquals(NotNull.class.getName(), requiredAnnotation.getName());
    }

    @Test
    public void processNotRequiredRule(@TuneProvider Tune tune) {
        FieldSpec.Builder builder = FieldSpec.builder(String.class, "test");
        FieldModel model = mock(FieldModel.class);

        new Jsr303Style().processNotRequiredRule(builder, model);

        FieldSpec fieldSpec = builder.build();
        assertEquals("test", fieldSpec.name);
        assertEquals(0, fieldSpec.annotationClasses.size());
    }

    @Test
    public void processNotRequiredRuleForGetters(@TuneProvider Tune tune) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder("test");
        FieldModel model = mock(FieldModel.class);

        new Jsr303Style().processNotRequiredRuleForGetters(builder, model);

        MethodSpec methodSpec = builder.build();
        assertEquals("test", methodSpec.name);
        assertEquals(0, methodSpec.annotationClasses.size());
    }

    @Test
    public void processNotRequiredRuleForSetters(@TuneProvider Tune tune) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder("test");
        ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(String.class, "one");
        FieldModel model = mock(FieldModel.class);

        new Jsr303Style().processNotRequiredRuleForSetters(builder, model, parameterBuilder);

        MethodSpec methodSpec = builder.build();
        assertEquals("test", methodSpec.name);
        assertEquals(0, methodSpec.annotationClasses.size());

        ParameterSpec parameterSpec = parameterBuilder.build();
        assertEquals("one", parameterSpec.name);
        assertEquals(0, parameterSpec.classes.size());
    }

    @Test
    public void processRequiredRuleForConstructor(@TuneProvider Tune tune) {
        ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(String.class, "one");

        new Jsr303Style().processRequiredRuleForConstructor(parameterBuilder);

        ParameterSpec parameterSpec = parameterBuilder.build();
        assertEquals("one", parameterSpec.name);
        assertEquals(1, parameterSpec.classes.size());

        Class<?> requiredAnnotation = parameterSpec.classes.get(0);
        assertEquals(NotNull.class.getName(), requiredAnnotation.getName());
    }

    @Test
    public void processNotRequiredRuleForConstructor(@TuneProvider Tune tune) {
        ParameterSpec.Builder parameterBuilder = ParameterSpec.builder(String.class, "one");

        new Jsr303Style().processNotRequiredRuleForConstructor(parameterBuilder);

        ParameterSpec parameterSpec = parameterBuilder.build();
        assertEquals("one", parameterSpec.name);
        assertEquals(0, parameterSpec.classes.size());
    }
}