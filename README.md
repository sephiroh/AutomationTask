# Task 2 - Technical Task (Test Automation)

Create a simple automation suite that exercises one of the most basic functions of MyAmaysim: managing settings. Using the provided credentials, create a simple test suite that logs into MyAmaysim and validates that the manage settings functionality is working as expected. Assume that these tests are part of a pre/post release suite that will be run against production (and lower environments). A particular area that has broken several times during releases in the past is setting up of call forwarding...


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisites

What things you need to install the software and how to install them

- [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Eclipse IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon2)
- [Selenium WebDriver Java Client](http://docs.seleniumhq.org/download/)
- [Chrome Driver Server](http://chromedriver.storage.googleapis.com/index.html?path=2.20/)


### Installing

A step by step series of examples that tell you have to get a development env running

- [Installing Java](http://toolsqa.com/selenium-webdriver/download-and-install-java/)
- [Set up Eclipse IDE](http://toolsqa.com/selenium-webdriver/download-and-start-eclipse/)
- [Configure Eclipse with Selenium WebDriver](http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/)

## Running the tests

Upon setting up of the necessary requirements, we can now proceed on running the Automation Suite.

### Step-by-step guide

1. From Eclipse IDE, import the Automation Suite (SampleTask folder name) from Github.
2. Verify if all the file are imported.
3. Setup desired Test Data by navigating to SampleTask2/src/dataEngine/DataEngine.xlsx
4. Run the Execution Engine (SampleTask2/src/executionEngine/DriverScript.java)
5. Wait until the automation run is completed.
6. Verify results through Sampletask2/logfile.log and/or DataEngine.xlss

## Authors

* **Robert Cecil Vibora** - *Initial work* - [AutomationTask](https://github.com/sephiroh/AutomationTask)

## References

- [Toolsqa](http://toolsqa.com/selenium-webdriver)
