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

import java.util.Map;

/**
 * @author shrey.garg on 30/11/16.
 */
public class SubTypeModel {
    private String property;
    private boolean existingProperty;
    private Map<String, String> subTypeMapping;

    public SubTypeModel() {
    }

    public SubTypeModel(String property, Map<String, String> subTypeMapping) {
        this.property = property;
        this.subTypeMapping = subTypeMapping;
    }

    public String getProperty() {
        return property;
    }

    public boolean isExistingProperty() {
        return existingProperty;
    }

    public Map<String, String> getSubTypeMapping() {
        return subTypeMapping;
    }

}
