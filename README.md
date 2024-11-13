# Demo Project for Zilch

## Description

This is Maven Test Automation project that can be used for:
- Mobile Test Automation
- API Test Automation
- API Testing using Wiremock

Technologies:

- Java, Appium, TestNG, WireMock, RestAssure, others.
## Getting Started

### Dependencies

* Appium server installed
* Java JDK 11
* Android studio and configure emulator


### Installing

* mvn clean install -DskipTests

### Executing program

* mvn test -Dtest<testclassname>
* Other system parameters can be used to orchestrate the execution of different needs

```
code blocks for commands
```

### Help

## Directories and classes

Project functionalities by class:
/pom.xml - Maven file
/src/main/java/driver
- AppData -> initializing and configuration of the driver
- AppLauncher -> setuping the appium server start up , application option configuration and starting/stopping of the processes
/src/main/java/enums
- Here should be classes that are having enums defined. In the specific demo are used as part of API configuration
/src/main/java/RestModule
- Configuration and first level of communication with RestAssure methods
/src/main/java/system
- BaseTest is class used from Mobile Testing for BeforeTest runs
- DataLoader is class containing mechanism of reading from properties files
- SysData is class to contain the system parameters that are used across the project
- UtilityMethods invoked from different part of the code that can be used for different purposes Mobile or API
- WireMockBase class that handles the WireMock server and configuration of stubs
/src/main/resources
- here are properties files or files containing json objects for API testing
/APK -contains the *.apk file that tests are running on
/src/test/java/pages
- pages of the app under test
/src/test/java/endpoints
- contains different classes for different endpoint paths
/src/test/java/tests
DemoApiTests contains API and Mocking test examples
DemoMobileTests contains Mobile Tests

##System parameters
mobilePlatform => default is android -> platfor(OS) on which mobile test will be runned
appiumAutoRun => default is false -> if true appium will be started before test running
envConfig => default is local -> in the resources.Configs there is configuration file that can be added and the test to run under that
apiEnv => default is test -> based on this parameter rest API-s will run . Configuration implemented as enums

#Techniques and approaches covered
- OOP concepts (encapsulation, inheritence)
- Functional programming
- Usage of Libraries from different contributers (WireMock, RestAssure, Selenium)
- Different PO models (Selenium, PageFactory)
- TestNG
- others

## Authors

Vlatko Miovski
