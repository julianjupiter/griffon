/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2008-2019 the original author or authors.
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
 */
package griffon.builder.lanterna3.factory

import com.googlecode.lanterna.gui2.Direction
import com.googlecode.lanterna.gui2.Panel

/**
 * @author Andres Almiray
 * @since 3.0.0
 */
class PanelFactory extends ComponentFactory {
    PanelFactory() {
        super(Panel)
    }

    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        def direction = attributes.remove('direction') ?: Direction.HORIZONTAL
        if (direction instanceof CharSequence) {
            direction = direction.toString().toLowerCase()
            switch (direction) {
                case 'vertical':
                    direction = Direction.VERTICAL
                    break
                case 'horizontal':
                case 'horisontal':
                default:
                    direction = Direction.HORIZONTAL
            }
        } else if (!(direction instanceof Direction)) {
            throw new IllegalArgumentException("In $name the value of direction: must be either 'horisontal' or 'vertical'.")
        }

        new Panel(direction)
    }
}
