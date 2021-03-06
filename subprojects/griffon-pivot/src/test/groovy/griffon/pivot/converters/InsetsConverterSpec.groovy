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
package griffon.pivot.converters

import org.apache.pivot.wtk.Insets
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import javax.application.converter.ConversionException

@Unroll
class InsetsConverterSpec extends Specification {
    @Shared
    private Insets sharedInsets = new Insets(1, 2, 3, 4)

    void "Insets format '#format' should be equal to #insets"() {
        setup:
        InsetsConverter converter = new InsetsConverter()

        when:
        Insets parsedInsets = converter.fromObject(format)

        then:
        insets == parsedInsets

        where:
        insets                 | format
        null                   | null
        null                   | ''
        null                   | ' '
        null                   | []
        null                   | [:]
        new Insets(1, 0, 0, 0) | '1'
        new Insets(1, 2, 0, 0) | '1,2'
        new Insets(1, 2, 3, 0) | '1,2,3'
        sharedInsets           | '1,2,3,4'
        sharedInsets           | '1, 2, 3, 4'
        sharedInsets           | ' 1, 2, 3, 4'
        sharedInsets           | ' 1, 2,3 , 4 '
        sharedInsets           | [1, 2, 3, 4]
        sharedInsets           | ['1', '2', '3', '4']
        new Insets(1, 1, 1, 1) | 1
        new Insets(1, 0, 0, 0) | [1]
        new Insets(1, 0, 0, 0) | ['1']
        sharedInsets           | [top: 1, left: 2, right: 3, bottom: 4]
        sharedInsets           | [top: '1', left: '2', right: '3', bottom: '4']
        sharedInsets           | [t: 1, l: 2, r: 3, b: 4]
        sharedInsets           | [t: '1', l: '2', r: '3', b: '4']
        sharedInsets           | sharedInsets
        new Insets(0, 0, 0, 0) | [foo: 1, bar: 2]
    }

    void "Invalid insets format '#format'"() {
        setup:
        InsetsConverter converter = new InsetsConverter()

        when:
        converter.fromObject(format)

        then:
        thrown(ConversionException)

        where:
        format << [
            'garbage',
            '1, 2, 3,4 ,5',
            '1, a',
            [1, 2, 3, 4, 5],
            [new Object()],
            [top: new Object()],
            [top: 'a'],
            [t: 'b'],
            new Object()
        ]
    }

    void "Formatted insets '#expected'"() {
        given:
        InsetsConverter converter = new InsetsConverter()

        when:
        String actual = converter.toString(converter.fromObject(value))

        then:
        expected == actual

        where:
        value        | expected
        null         | null
        sharedInsets | '1, 2, 3, 4'
    }
}
