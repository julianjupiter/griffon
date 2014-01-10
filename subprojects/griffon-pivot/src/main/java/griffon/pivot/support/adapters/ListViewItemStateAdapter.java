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
public class ListViewItemStateAdapter implements GriffonPivotAdapter, org.apache.pivot.wtk.ListViewItemStateListener {
    private CallableWithArgs<?> itemCheckedChanged;

    public CallableWithArgs<?> getItemCheckedChanged() {
        return this.itemCheckedChanged;
    }


    public void setItemCheckedChanged(CallableWithArgs<?> itemCheckedChanged) {
        this.itemCheckedChanged = itemCheckedChanged;
    }


    public void itemCheckedChanged(org.apache.pivot.wtk.ListView arg0, int arg1) {
        if (itemCheckedChanged != null) {
            itemCheckedChanged.call(arg0, arg1);
        }
    }

}
