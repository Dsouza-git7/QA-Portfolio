# RESTful API CRUD Testing Project – Postman

## 1. Project Overview

This project demonstrates practical API testing skills through testing the Create, Read, Update, and Delete (CRUD) operations of a RESTful public API using Postman.

The project covers API documentation review, test scenario identification, test case design, request execution, response validation, defect reporting, and test result analysis.

It forms part of my QA portfolio and demonstrates my understanding of REST API testing and structured test documentation.

## 2. Application Under Test

| Attribute | Details |
|---|---|
| Project Name | RESTful API CRUD Testing |
| Application Type | RESTful Public API |
| Testing Tool | Postman |
| Testing Approach | API Functional Testing |
| Operations Covered | POST, GET, PUT, PATCH, DELETE |
| Test Environment | Public API Testing Environment |

## 3. Project Objectives

- Understand REST API functionality and CRUD operations.
- Review API documentation and understand available endpoints.
- Design positive and negative API test scenarios.
- Prepare structured API test cases.
- Validate HTTP status codes and response data.
- Test Create, Read, Update, and Delete operations.
- Identify and document API defects.
- Maintain Postman collections for API testing.
- Record and analyse test execution results.

## 4. Testing Scope

The project covers the following REST API operations:

| HTTP Method | Operation | Testing Focus |
|---|---|---|
| POST | Create | Validate resource creation and response data. |
| GET | Read | Validate resource retrieval and response content. |
| PUT | Update | Validate complete resource updates. |
| PATCH | Partial Update | Validate partial resource updates. |
| DELETE | Delete | Validate resource deletion. |

Additional testing activities include:

- Positive and negative test scenarios.
- Request and response validation.
- HTTP status code validation.
- Response body and field validation.
- Error handling.
- Defect identification and documentation.

## 5. Testing Process

The project follows a structured API testing workflow:

1. Review the available API documentation.
2. Understand the API endpoints and supported HTTP methods.
3. Identify test scenarios for CRUD operations.
4. Design API test cases with request details and expected results.
5. Configure and execute API requests using Postman.
6. Validate response status codes and response data.
7. Record actual results and test execution status.
8. Document identified issues with supporting screenshots.
9. Analyse and summarise API testing results.

## 6. Project Documentation

The repository contains the following project artefacts:

| Folder | Contents | Purpose |
|---|---|---|
| `01_API_Documentation` | API documentation and CRUD implementation document | Provides API information and implementation details. |
| `02_Test_Scenarios` | `API_Test_Scenarios.xlsx` | Contains identified API test scenarios. |
| `03_Test_Cases_Execution` | `API_Test_Cases_Execution.xlsx` | Contains API test cases and execution results. |
| `04_Postman_Collection` | Postman collection JSON file | Contains the API request collection. |
| `05_Defect_Reports` | `Defect_Report.xlsx` | Documents identified defects. |
| `06_Defect_Screenshots` | BUG_001, BUG_002, BUG_003 | Provides supporting evidence for documented issues. |

## 7. Tools and Technologies

- **Postman:** API request execution and response validation.
- **REST APIs:** API functionality tested using HTTP methods.
- **Microsoft Excel:** Test scenario, test case, execution, and defect documentation.
- **Microsoft Word:** API documentation and project implementation documentation.
- **Git:** Version control.
- **GitHub:** Project repository hosting and portfolio presentation.
- **GitKraken Desktop:** Graphical Git repository management.

## 8. API Test Execution Summary

The following table summarises the recorded test execution results across the CRUD operations.

| Operation | Test Cases | Executed | Passed | Failed |
|---|---:|---:|---:|---:|
| POST – Create | 6 | 6 | 3 | 3 |
| GET – Read | 8 | 8 | 8 | 0 |
| PUT/PATCH – Update | 7 | 7 | 5 | 2 |
| DELETE – Delete | 2 | 2 | 2 | 0 |
| **Total** | **23** | **23** | **18** | **5** |

### Execution Results

- **Total test cases:** 23
- **Executed:** 23
- **Passed:** 18
- **Failed:** 5
- **Execution completion:** 100%
- **Pass rate:** 78.26%
- **Fail rate:** 21.74%

All 23 test cases were executed. Of these, 18 passed and 5 failed.

The failed test cases and their corresponding observations are documented in the execution records and should be reviewed alongside the defect report.

## 9. Key Learning Areas

This project provided practical experience in:

- Understanding REST API architecture and CRUD operations.
- Working with HTTP methods such as POST, GET, PUT, PATCH, and DELETE.
- Designing positive and negative API test scenarios.
- Creating and executing API requests using Postman.
- Validating HTTP status codes and response data.
- Understanding request and response structures.
- Identifying API failures and documenting defects.
- Maintaining API testing documentation.
- Analysing test execution results across different HTTP methods.

## 10. Interview Revision Notes

When discussing this project during interviews, I should be prepared to explain:

1. **Project objective:** Why API testing was performed and what the project aimed to demonstrate.
2. **REST API fundamentals:** What REST APIs are and how client-server communication works.
3. **HTTP methods:** The differences between POST, GET, PUT, PATCH, and DELETE.
4. **Request structure:** How endpoints, headers, parameters, and request bodies are used.
5. **Response validation:** How status codes, response bodies, and data fields are validated.
6. **Positive and negative testing:** How valid and invalid requests are tested.
7. **Postman:** How requests and collections are organised and executed.
8. **Defect reporting:** How API issues are identified, documented, and supported with evidence.
9. **Test execution results:** How to explain the 23 test cases, 18 passes, and 5 failures.
10. **Challenges and learnings:** What issues were encountered and what was learned from API testing.

Before discussing a specific API failure in an interview, review the corresponding request, response, expected result, actual result, and defect documentation.

## 11. Repository Information

**Project Name:** RESTful API CRUD Testing Project

**Repository Folder:** `02-RESTful-API-CRUD-Testing`

This project is maintained as part of my QA portfolio to demonstrate practical API testing skills using Postman, structured test documentation, test execution, response validation, and defect reporting.