/*
 * Copyright 2012 the original author or authors.
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

package org.codehaus.griffon.cli.shell.command;

import griffon.util.CollectionUtils;
import org.codehaus.griffon.cli.shell.AbstractGriffonCommand;
import org.codehaus.griffon.cli.shell.Argument;
import org.codehaus.griffon.cli.shell.Command;
import org.codehaus.griffon.cli.shell.Option;

import java.util.List;

/**
 * @author Andres Almiray
 * @since 0.9.5
 */
@Command(scope = "griffon",
        name = "package",
        description = "Packages a Griffon project according to its type")
public class PackageCommand extends AbstractGriffonCommand {
    @Argument(index = 0,
            name = "packages",
            description = "Optional list of packages to create, e.g. zip jar izpack. Valid only when packaging an application.",
            required = false,
            multiValued = true)
    private List<String> packages = CollectionUtils.newList("applet", "jar", "webstart", "zip");

    @Option(name = "--name",
            description = "Name of the application jar to create. USed when 'jar' package is in effect.",
            required = false)
    private String name;

    @Option(name = "--codebase",
            description = "Codebase to be set in the JNLP file. USed when 'applet' or 'webstart' packages are in effect.",
            required = false)
    private String codebase;
}