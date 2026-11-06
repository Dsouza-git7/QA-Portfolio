# QA Testing Lab – All Frontend Elements

## Project Overview

QA Testing Lab – All Frontend Elements is a Java-based Selenium WebDriver automation framework developed to automate and validate commonly used frontend web elements and interactions.

The framework uses Java, Selenium WebDriver, TestNG and Maven, following the Page Object Model (POM) design pattern to maintain reusable, structured and maintainable automation scripts.

The project also incorporates Continuous Integration (CI) using GitHub Actions to automate the build and execution of Selenium test cases, validate code changes and publish test execution results.

## Project Objectives

- Automate frontend web element interactions using Selenium WebDriver.
- Implement the Page Object Model (POM) design pattern.
- Develop reusable automation scripts using Java and TestNG.
- Validate application behaviour through automated assertions.
- Manage project dependencies and test execution using Maven.
- Integrate automated test execution into a CI pipeline using GitHub Actions.
- Generate and review automated test execution reports.

## Technologies and Tools

| Technology / Tool | Purpose |
|---|---|
| Java 26 | Programming language |
| Selenium WebDriver 4.49.0 | Browser automation |
| TestNG 7.12.0 | Test execution and assertions |
| Maven | Dependency and project management |
| IntelliJ IDEA | Development environment |
| Google Chrome | Browser under test |
| Git / GitHub | Version control and source code management |
| GitHub Actions | Continuous Integration and automated test execution |

## Continuous Integration

GitHub Actions is used to integrate automated Selenium test execution into the development workflow.

The CI pipeline is designed to:

- Trigger automated builds when code is pushed to GitHub.
- Execute the Maven build.
- Run Selenium TestNG test cases using Chrome.
- Capture test execution results.
- Publish TestNG reports as workflow artifacts.
- Provide visibility into successful and failed pipeline executions.

## Test Execution Summary

The current local TestNG execution contains 11 test methods.

| Metric | Result |
|---|---:|
| Total Test Methods | 11 |
| Executed | 11 |
| Passed | 11 |
| Failed | 0 |
| Skipped | 0 |
| Execution Time | Approximately 1 minute 24 seconds |

The GitHub Actions execution results will be documented separately once the CI workflow has been configured and verified.

## Future Enhancements

- Expand automated frontend test coverage.
- Improve test reporting and execution diagnostics.
