# Rest Assured and TestNG API Automation

This project automates the verification of user tasks using Rest Assured and TestNG. The scenario involves checking that all users from the city `FanCode` have completed more than half of their todo tasks.

## Scenario

- **Given**: User has todo tasks
- **And**: User belongs to the city `FanCode`
- **Then**: User's completed task percentage should be greater than 50%

`FanCode` city can be identified by latitude between `-40` to `5` and longitude between `5` to `100` in the users API.

## Prerequisites

- Java 8 or higher
- Maven
- Git

## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/<repoName>.git

2. Install the dependencies:

```mvn clean install```

## Running the Tests

To execute the tests, use the following command:

```mvn clean test```

## Project Structure

```
src
└── main
    └── java
        └── models
            └── Address.java
            └── Company.java
            └── Geo.java
            └── Todos.java
            └── Users.java
        └── service
            └── TodoService.java
            └── UsersService.java
        └── utilities
            └── common
               └── AppUtils.java
            └── globalConstants
               └── APIEndPoint.java
               └── HttpStatus.java
└── test
   └── java
      ├── Runner.java
      └── feature
         └── fancode.feature
      └── StepDefination
         └── StepDefinations.java
      └── resources
         └── cucumber.properties   
```
## Dependencies
Ensure the following dependencies are included in your pom.xml:

```
<dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.18.0</version>
        </dependency>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured-common</artifactId>
            <version>4.1.1</version>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.11.1</version>
        </dependency>

        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.28</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.15.2</version>
        </dependency>

        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20230618</version>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.13.0</version>
        </dependency>

        <dependency>
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy</artifactId>
            <version>3.0.8</version>
        </dependency>

    </dependencies>
  ```
## Report
The test results are generated using Cucumber results. After test execution, the report is available at console like this:

```
┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/8e3eb95d-6544-4391-a9d9-a7c1ecbdfc38 │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │
└──────────────────────────────────────────────────────────────────────────┘[
```

## Test Execution
The test verifies the following:

1. Fetches users from the city FanCode based on latitude and longitude conditions and verifies the status code and response.
2. Checks that all users from FanCode city have completed more than 50% of their todos.
