/*
 * Copyright 2008-2016 the original author or authors.
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
package griffon.javafx.support;

import javafx.collections.ObservableMap;

import javax.annotation.Nonnull;

/**
 * @author Andres Almiray
 * @see griffon.javafx.collections.DelegatingObservableMap
 * @since 2.9.0
 * @deprecated use {@code griffon.javafx.collections.DelegatingObservableMap} instead.
 */
@Deprecated
public abstract class DelegatingObservableMap<K, V> extends griffon.javafx.collections.DelegatingObservableMap<K, V> {
    public DelegatingObservableMap(@Nonnull ObservableMap<K, V> delegate) {
        super(delegate);
    }
}