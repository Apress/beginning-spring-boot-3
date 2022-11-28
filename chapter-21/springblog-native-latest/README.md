# Beginning SpringBoot 3


### Chapter 21 : Spring Native

**springblog-native-latest**: This module demonstrates Spring Native features without explicit Spring Native Dependency.

###NOTE:
To enable AOT feature, comment out the below code in the pom.xml file:

                <executions>
                    <execution>
                        <id>process-aot</id>
                        <goals>
                            <goal>process-aot</goal>
                        </goals>
                    </execution>
                </executions>

#### How to run?

To build a native image, run:

springblog-native-latest> mvn spring-boot:build-image

Then

springblog-native-latest> mvn spring-boot:run
