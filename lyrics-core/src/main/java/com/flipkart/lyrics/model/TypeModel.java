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

package com.flipkart.lyrics.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import javax.lang.model.element.Modifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.*;

/**
 * @author shrey.garg on 25/11/16.
 */
public class TypeModel {
    private Type type;
    private Modifier[] modifiers = new Modifier[0];
    private VariableModel extendsType;
    private Set<VariableModel> interfaces = new HashSet<>();
    private List<GenericVariableModel> genericVariables = new ArrayList<>();
    private List<AnnotationModel> annotations = new ArrayList<>();
    private Map<String, FieldModel> fields = new LinkedHashMap<>();
    private Map<String, MethodModel> methods = new LinkedHashMap<>();
    private InclusionType inclusion;
    private List<String> values;
    private Map<String, Object[]> valuesWithFields = new LinkedHashMap<>();
    private List<String> fieldOrder = new ArrayList<>();
    private SubTypeModel subTypes;
    private RetentionPolicy retention;
    private ElementType[] elementTypes;
    private boolean testSuperEquality = false;
    private boolean deprecated;
    private List<String> customConstructorFields;
    private final Map<String, Object> additionalFields = new HashMap<>();

    public TypeModel() {
    }

    public TypeModel(Type type, Modifier[] modifiers, VariableModel extendsType, Set<VariableModel> interfaces, List<GenericVariableModel> genericVariables, List<AnnotationModel> annotations, Map<String, FieldModel> fields, Map<String, MethodModel> methods, InclusionType inclusion, List<String> values, Map<String, Object[]> valuesWithFields, List<String> fieldOrder, SubTypeModel subTypes, RetentionPolicy retention, ElementType[] elementTypes, List<String> customConstructorFields) {
        this.type = type;
        this.modifiers = modifiers;
        this.extendsType = extendsType;
        this.interfaces = interfaces;
        this.genericVariables = genericVariables;
        this.annotations = annotations;
        this.fields = fields;
        this.methods = methods;
        this.inclusion = inclusion;
        this.values = values;
        this.valuesWithFields = valuesWithFields;
        this.fieldOrder = fieldOrder;
        this.subTypes = subTypes;
        this.retention = retention;
        this.elementTypes = elementTypes;
        this.customConstructorFields = customConstructorFields;
    }

    public Type getType() {
        return type;
    }

    public Modifier[] getModifiers() {
        return modifiers;
    }

    public VariableModel getExtendsType() {
        return extendsType;
    }

    public Set<VariableModel> getInterfaces() {
        return interfaces;
    }

    public List<GenericVariableModel> getGenericVariables() {
        return genericVariables;
    }

    public List<AnnotationModel> getAnnotations() {
        return annotations;
    }

    public Map<String, FieldModel> getFields() {
        return fields;
    }

    public Map<String, MethodModel> getMethods() {
        return methods;
    }

    public InclusionType getInclusion() {
        return inclusion;
    }

    public List<String> getValues() {
        return values;
    }

    public Map<String, Object[]> getValuesWithFields() {
        return valuesWithFields;
    }

    public List<String> getFieldOrder() {
        return fieldOrder;
    }

    public SubTypeModel getSubTypes() {
        return subTypes;
    }

    public RetentionPolicy getRetention() {
        return retention;
    }

    public ElementType[] getElementTypes() {
        return elementTypes;
    }

    public boolean isTestSuperEquality() {
        return testSuperEquality;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public List<String> getCustomConstructorFields() {
        return customConstructorFields;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalFields() {
        return additionalFields;
    }

    @JsonAnySetter
    public void addAdditionalProperties(String name, Object value) {
        this.additionalFields.put(name, value);
    }
}
