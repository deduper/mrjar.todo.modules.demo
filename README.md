# mrjar.todo.modules.demo
Demonstrates how to apply the ***mrJar*** Gradle plugin to resolve split packages in a JPMS-structured project.

## Requirements
1. JDK 13
    * the current version 0.0.16 of the ***mrJar*** plugin does not support JDK 14<sup>+</sup> at the moment<sup><em>1</em></sup>
2. Because of how the ***mrJar*** plugin is implemented, it's mandatory to run Gradle with the *`--enable-preview`* option when executing builds that apply the plugin. See the example in the *Steps to build*


## Steps to build

1. Download or clone this demo
2. In a terminal, *`cd`* to your download/clone location
3. After ensuring that you're using JDK 13, execute the following command within the root directory of the project:
```bash
./gradlew -Dorg.gradle.jvmargs="--enable-preview" check bootJar
```
4. Observe…
```bash
BUILD SUCCESSFUL in 43 seconds
…
```
5. Examine one of the successfully-assembled modular jars with the following command…
```bash
$ jar -f {{%your.path.to%}}/mrjar.todo.modules.demo/todo-domain/build/libs/todo.modules.demo.todo.domain-0.0.1-SNAPSHOT.jar --describe-module
```
6. Observe…
```bash
todo.modules.demo.todo.domain jar:file:///…/mrjar.todo.modules.demo/todo-domain/build/libs/todo.modules.demo.todo.domain-0.0.1-SNAPSHOT.jar/!module-info.class
exports works.hop.todo.domain.config
exports works.hop.todo.domain.model
exports works.hop.todo.domain.repository
exports works.hop.todo.domain.service
requires java.base mandated
requires lombok
requires spring.beans
requires spring.context
requires spring.data.commons
requires spring.data.relational
```
Please report ***any and all*** failures of any of the above steps in this project's [*Issues*](https://github.com/deduper/mrjar.todo.modules.demo/issues) section.

<br />
<br />
<br />
<br />

----


<sup><sup><em>1</em></sup></sup>&nbsp;<sup>I&nbsp;have&nbsp;it&nbsp;on&nbsp;good&nbsp;authority&nbsp;that&nbsp;the&nbsp;***mrJar***&nbsp;plugin&nbsp;is&nbsp;in&nbsp;the&nbsp;process&nbsp;of&nbsp;being&nbsp;upgraded&nbsp;with&nbsp;JDK14+&nbsp;support.&nbsp;Release&nbsp;of&nbsp;v0.0.17&nbsp;is&nbsp;expected&nbsp;to&nbsp;be&nbsp;announced&nbsp;within&nbsp;the&nbsp;next&nbsp;1-2&nbsp;days.</sup>