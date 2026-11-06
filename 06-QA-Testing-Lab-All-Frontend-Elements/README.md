# QA Testing Lab – All Frontend Elements

### Project Overview

QA Testing Lab – All Frontend Elements is a Java-based Selenium WebDriver automation framework developed to automate and validate commonly used frontend web elements and interactions.

The framework uses Java, Selenium WebDriver, TestNG and Maven, following the Page Object Model (POM) design pattern to maintain reusable, structured and maintainable automation scripts.

The project also incorporates Continuous Integration (CI) using GitHub Actions to automate test execution, validate code changes and publish test execution reports.

### Project Objectives

- Automate frontend web element interactions using Selenium WebDriver.
- Implement the Page Object Model (POM) design pattern.
- Develop reusable automation scripts using Java and TestNG.
- Validate application behaviour through automated assertions.
- Manage project dependencies and test execution using Maven.
- Integrate automated test execution using GitHub Actions.
- Generate and review automated test execution reports.
- Capture and attach screenshots automatically when tests fail.

### Technologies and Tools

| Technology / Tool | Purpose |
|---|---|
| Java 26 | Programming language |
| Selenium WebDriver 4.49.0 | Browser automation |
| TestNG 7.12.0 | Test execution and assertions |
| Maven | Dependency and project management |
| ExtentReports 5.1.2 | HTML test execution reporting |
| IntelliJ IDEA | Development environment |
| Google Chrome | Browser under test |
| Git / GitHub | Version control and source code management |
| GitHub Actions | Continuous Integration |

### Framework Design – Page Object Model (POM)

The project follows the Page Object Model (POM) design pattern.

- **BasePage:** Provides common page interaction functionality.
- **Page Classes:** Maintain locators and reusable methods for individual application pages.
- **BaseTest:** Manages browser setup and teardown.
- **Test Classes:** Contain test scenarios and assertions.
- **ExtentReportListener:** Manages test reporting and automatic failure screenshot capture.

This separation improves code organisation, reusability and maintainability.

### Test Coverage

The framework covers the following frontend elements and interactions:

| Module | Test Coverage |
|---|---|
| Form Elements | Text inputs, special inputs, text areas, buttons and links |
| Dropdowns | Single select, dependent dropdowns, multi-select and custom dropdowns |
| Checkboxes and Radio Buttons | Individual and grouped selections |
| Tables | Static, searchable, sortable and complex tables |
| Alerts and Popups | JavaScript alerts, confirmation dialogs, prompts and custom modals |
| Dynamic Elements | Show/hide elements, delayed elements, loading indicators and notifications |
| iFrames | Single and multiple iFrame interactions |
| File Upload | Single, multiple and form-based file uploads |
| Drag and Drop | Drag-and-drop interactions and Kanban-style elements |

### Test Execution Summary

The current verified local TestNG execution contains 11 automated test methods.

| Metric | Result |
|---|---:|
| Total Test Methods | 11 |
| Executed | 11 |
| Passed | 11 |
| Failed | 0 |
| Skipped | 0 |

### Test Reporting

The framework generates two types of HTML test execution reports.

**1. TestNG HTML Report**

- Displays individual test method results.
- Shows passed, failed and skipped test counts.
- Provides execution details and timings.

**2. ExtentReports Dashboard**

- Displays a visual test execution summary.
- Shows individual test method results and status.
- Records execution timestamps and duration.
- Displays exception and failure details.
- Supports automatic failure screenshot capture.

**Automatic Failure Screenshot Capture**

When a test fails, the ExtentReportListener automatically:

1. Captures a screenshot of the browser.
2. Saves the screenshot under `target/extent-reports/screenshots/`.
3. Embeds the screenshot into the corresponding ExtentReports test entry using Base64 encoding.
4. Records the failure details.

This functionality was verified locally using a controlled test failure. The temporary assertion was subsequently removed, and all 11 original tests passed again.

### Continuous Integration – GitHub Actions

GitHub Actions is integrated into the project to automate Selenium test execution.

The CI workflow is configured to:

- Trigger on pushes and pull requests to the `main` branch.
- Set up the Java environment.
- Execute Maven test commands.
- Run Selenium TestNG test cases using headless Chrome.
- Generate TestNG and ExtentReports HTML reports.
- Upload both report directories as downloadable workflow artifacts.

The combined report artifact is named `selenium-test-reports`.

### Project Structure

```text
QA-Testing-Lab-All-Frontend-Elements/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BasePage.java
│   │   └── pages/
│   │       ├── AlertsPage.java
│   │       ├── CheckboxesRadioButtonsPage.java
│   │       ├── DragDropPage.java
│   │       ├── DropDownsPage.java
│   │       ├── DynamicElementsPage.java
│   │       ├── FileUploadPage.java
│   │       ├── FormElementsPage.java
│   │       ├── HomePage.java
│   │       ├── IframesPage.java
│   │       └── TablesPage.java
│   │
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   ├── listeners/
│       │   │   └── ExtentReportListener.java
│       │   └── tests/
│       │       └── FirstTest.java
│       │
│       └── resources/
│           ├── SeleniumProject/
│           └── test-data/
│
├── Test_Documentation/
│   └── Selenium_Test_Cases.xlsx
│
├── pom.xml
└── README.md
```

### Running Tests Locally

**Prerequisites**

- Java Development Kit (JDK)
- Maven
- Google Chrome
- IntelliJ IDEA or another Java IDE

**Execution Steps**

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to resolve the project dependencies.
4. Execute the Maven `test` lifecycle goal.

The automated test suite executes using Chrome in headless mode.

### Future Enhancements

- Expand automated frontend test coverage.
- Improve test execution diagnostics.
- Add more detailed test execution logging.
- Extend automation coverage for additional application scenarios.