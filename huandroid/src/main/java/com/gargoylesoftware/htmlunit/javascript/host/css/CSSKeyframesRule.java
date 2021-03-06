/*
 * Copyright (c) 2002-2018 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.javascript.host.css;

import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxGetter;

import static com.gargoylesoftware.htmlunit.BrowserVersionFeatures.JS_CSS_MOZ_CSS_KEYFRAMES_RULE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF52;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.IE;

/**
 * A JavaScript object for {@code CSSKeyframesRule}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@JsxClass({CHROME, FF52, IE, EDGE})
public class CSSKeyframesRule extends CSSRule {

    /**
     * Default constructor.
     */
    @JsxConstructor({CHROME, EDGE})
    public CSSKeyframesRule() {
    }

    /**
     * Creates a new instance.
     * @param stylesheet the Stylesheet of this rule.
     * @param rule the wrapped rule
     */
    protected CSSKeyframesRule(final CSSStyleSheet stylesheet, final org.w3c.dom.css.CSSUnknownRule rule) {
        super(stylesheet, rule);
    }

    /**
     * Returns the type of the rule.
     * @return the type of the rule.
     */
    @Override
    @JsxGetter
    public short getType() {
        return KEYFRAMES_RULE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getDefaultValue(final Class<?> hint) {
        if ((String.class.equals(hint) || hint == null)
                && getBrowserVersion().hasFeature(JS_CSS_MOZ_CSS_KEYFRAMES_RULE)) {
            return "[object MozCSSKeyframesRule]";
        }
        return super.getDefaultValue(hint);
    }
}
