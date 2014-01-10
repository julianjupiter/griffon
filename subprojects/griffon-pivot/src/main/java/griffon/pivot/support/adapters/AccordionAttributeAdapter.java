/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.pivot.support.adapters;

import griffon.core.CallableWithArgs;

/**
 * @author Andres Almiray
 * @since 2.0.0
 */
public class AccordionAttributeAdapter implements GriffonPivotAdapter, org.apache.pivot.wtk.AccordionAttributeListener {
    private CallableWithArgs<?> headerDataChanged;
    private CallableWithArgs<?> tooltipTextChanged;

    public CallableWithArgs<?> getHeaderDataChanged() {
        return this.headerDataChanged;
    }

    public CallableWithArgs<?> getTooltipTextChanged() {
        return this.tooltipTextChanged;
    }


    public void setHeaderDataChanged(CallableWithArgs<?> headerDataChanged) {
        this.headerDataChanged = headerDataChanged;
    }

    public void setTooltipTextChanged(CallableWithArgs<?> tooltipTextChanged) {
        this.tooltipTextChanged = tooltipTextChanged;
    }


    public void headerDataChanged(org.apache.pivot.wtk.Accordion arg0, org.apache.pivot.wtk.Component arg1, java.lang.Object arg2) {
        if (headerDataChanged != null) {
            headerDataChanged.call(arg0, arg1, arg2);
        }
    }

    public void tooltipTextChanged(org.apache.pivot.wtk.Accordion arg0, org.apache.pivot.wtk.Component arg1, java.lang.String arg2) {
        if (tooltipTextChanged != null) {
            tooltipTextChanged.call(arg0, arg1, arg2);
        }
    }

}
