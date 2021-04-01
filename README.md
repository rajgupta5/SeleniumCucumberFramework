# This repo contains code of Selenium Framework with Cucumber with latest versions

# Important
Make sure you have JAVA 10 or above installed to run this framework

## TechStack
- JAVA 10
- SELENIUM 4
- TESTNG 7
  - TESTNG.xml file
  - TESTNG Runner
- JEXCELAPI - FOR READING EXCEL FILES
- CUCUMBER 6 - FOR BDD LAYER
- EXTENT REPORT/ CUCUMBER REPORT
- PARALLELISM USING THREAD LOCAL
  ~~~
   private static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
   public static RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriverThreadLocal.get();
    }
   static void setRemoteWebDriverThreadLocal(RemoteWebDriver driverThreadLocal) {
        remoteWebDriverThreadLocal.set(driverThreadLocal);
    }
  ~~~
- LOMBOK 
  - @Data and @Builder for automatically creating getter and setters.
- MAVEN
  - SUREFIRE PLUGIN
  ~~~
  <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.21.0</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/TestNg.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
  ~~~
  - CUCUMBER REPORTING PLUGIN
  ~~~
  <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>3.16.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>Automation</projectName>
                            <outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
  ~~~

