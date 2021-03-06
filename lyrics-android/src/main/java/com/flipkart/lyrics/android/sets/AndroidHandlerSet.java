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

package com.flipkart.lyrics.android.sets;

import com.flipkart.lyrics.android.handlers.StringDefValuesHandler;
import com.flipkart.lyrics.android.handlers.StringDefValuesWithFieldsHandler;
import com.flipkart.lyrics.processor.Handler;
import com.flipkart.lyrics.sets.DefaultHandlerSet;

/**
 * Created by anshul.garg on 13/01/17.
 */
public class AndroidHandlerSet extends DefaultHandlerSet {
    @Override
    public Handler getEnumValuesHandler() {
        return new StringDefValuesHandler(tune, metaInfo, ruleSet);
    }

    @Override
    public Handler getEnumValuesWithFieldsHandler() {
        return new StringDefValuesWithFieldsHandler(tune, metaInfo, ruleSet);
    }
}
