/*
 * Copyright © 2019 Eclipse Krazo committers and contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.eclipse.krazo.binding.convert.impl;

import org.eclipse.krazo.binding.convert.ConverterResult;

import java.text.ParseException;
import java.util.Locale;

/**
 * Converter for integer primitive or wrapper types.
 *
 * @author Christian Kaltepoth
 */
public class ShortConverter extends NumberConverter<Short> {

    @Override
    public boolean supports(Class<Short> rawType) {
        return Short.class.equals(rawType) || Short.TYPE.equals(rawType);
    }

    @Override
    public ConverterResult<Short> convert(String value, Class<Short> rawType, Locale locale) {

        Short defaultValue = Short.TYPE.equals(rawType) ? (short) 0 : null;
        try {

            return ConverterResult.success(parseNumber(value, locale).map(Number::shortValue).orElse(defaultValue));

        } catch (ParseException e) {
            return ConverterResult.failed(defaultValue, e.getMessage());
        }

    }
}
