/*
 * MIT License
 *
 * Copyright (c) 2024 fixyldev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.fixyl.componentviewer.config.type;

import net.minecraft.client.option.SimpleOption;

public abstract class AbstractConfig<T> {
    protected SimpleOption<T> simpleOption;
    protected final T defaultValue;
    protected final String translationKey;
    protected final String tooltipTranslationKey;

    public AbstractConfig(T defaultValue, String translationKey, String tooltipTranslationKey) {
        this.defaultValue = defaultValue;
        this.translationKey = translationKey;
        this.tooltipTranslationKey = tooltipTranslationKey;
    }

    public SimpleOption<T> getSimpleOption() {
        return this.simpleOption;
    }

    public T getValue() {
        return this.simpleOption.getValue();
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public void setValue(T value) {
        if (value == null) {
            this.setValueToDefault();
            return;
        }

        this.simpleOption.setValue(value);
    }

    public void setValueToDefault() {
        this.simpleOption.setValue(this.defaultValue);
    }
}
