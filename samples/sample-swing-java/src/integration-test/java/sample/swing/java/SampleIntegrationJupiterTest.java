/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2008-2018 the original author or authors.
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
package sample.swing.java;

import griffon.test.swing.GriffonFestExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleIntegrationJupiterTest {
    static {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
    }

    @RegisterExtension
    public static final GriffonFestExtension FEST = GriffonFestExtension.builder()
        .build();

    @Test
    void typeNameAndClickButton() {
        // given:
        FEST.getWindow().textBox("inputField").enterText("Griffon");

        // when:
        FEST.getWindow().button("sayHelloButton").click();

        // then:
        FEST.getWindow().label("outputLabel").requireText("Hello Griffon");
    }

    @Test
    void doNotTypeNameAndClickButton() {
        // given:
        FEST.getWindow().textBox("inputField").enterText("");

        // when:
        FEST.getWindow().button("sayHelloButton").click();

        // then:
        FEST.getWindow().label("outputLabel").requireText("Howdy stranger!");
    }
}