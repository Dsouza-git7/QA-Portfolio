# BlazeDemo Performance Testing Project – Apache JMeter

## 1. Project Overview

This project demonstrates hands-on performance testing of the **BlazeDemo web application** using Apache JMeter.

The objective was to evaluate application behaviour under different simulated user loads, observe response-time patterns, measure throughput, and monitor error rates across selected user workflows.

The project includes structured performance testing documentation, 22 documented performance test cases, JMeter test plans, execution configurations, CLI commands, screenshots, and consolidated test results.

## 2. Project Objectives

- Understand the application's performance testing requirements.
- Identify key user workflows for performance testing.
- Design and document performance test scenarios and test cases.
- Prepare JMeter test plans to simulate user activity.
- Execute baseline, load, stress and spike testing.
- Observe response times, throughput and error rates.
- Analyse application behaviour under different load conditions.
- Document execution results and performance observations.

## 3. Application Under Test

| Attribute | Details |
|---|---|
| Application | BlazeDemo |
| Application URL | https://blazedemo.com/ |
| Application Type | Web-based flight booking application |
| Testing Type | Performance Testing |
| Testing Tool | Apache JMeter |

## 4. Testing Scope

The project covers performance testing of selected BlazeDemo application workflows.

Testing activities include:

- Performance requirements analysis.
- Test scenario and test case preparation.
- JMeter test plan creation.
- Baseline testing.
- Load testing.
- Stress testing.
- Spike testing.
- Command-line test execution.
- Response-time and throughput analysis.
- Error-rate monitoring.
- Performance results documentation.

## 5. Performance Testing Approach

The following testing approaches were covered:

| Testing Type | Purpose |
|---|---|
| Baseline Testing | Observe application performance under baseline conditions. |
| Load Testing | Evaluate application behaviour under expected user loads. |
| Stress Testing | Observe application behaviour under progressively increasing user loads. |
| Spike Testing | Evaluate application behaviour during sudden changes in user load. |

### Stress Testing Workflows

Stress testing was performed on three selected workflows:

1. Application Access
2. Flight Search
3. Complete End-to-End User Flow

Each workflow was evaluated at five virtual-user levels: 100, 250, 500, 750 and 1,000.

## 6. Test Execution Results – Stress Testing

The following results are taken from the recorded stress test results workbook.

### 6.1 Application Access

| Virtual Users | Avg. Response (ms) | P99 (ms) | Throughput (samples/sec) | Errors |
|---:|---:|---:|---:|---:|
| 100 | 778.95 | 9339.17 | 4.86 | 0% |
| 250 | 811.74 | 5594.68 | 7.97 | 0% |
| 500 | 643.16 | 2108.42 | 9.93 | 0% |
| 750 | 667.42 | 2669.72 | 9.92 | 0% |
| 1,000 | 636.53 | 2479.65 | 9.89 | 0% |

### 6.2 Flight Search

| Virtual Users | Avg. Response (ms) | P99 (ms) | Throughput (samples/sec) | Errors |
|---:|---:|---:|---:|---:|
| 100 | 599.70 | 1336.26 | 4.95 | 0% |
| 250 | 593.47 | 1274.92 | 8.24 | 0% |
| 500 | 595.22 | 1784.49 | 9.93 | 0% |
| 750 | 610.43 | 2235.90 | 9.96 | 0% |
| 1,000 | 588.20 | 1176.90 | 9.97 | 0% |

### 6.3 Complete End-to-End User Flow

| Virtual Users | Avg. Response (ms) | P99 (ms) | Throughput (samples/sec) | Errors |
|---:|---:|---:|---:|---:|
| 100 | 512.34 | 1304.47 | 3.84 | 0% |
| 250 | 502.42 | 969.79 | 8.85 | 0% |
| 500 | 500.84 | 916.97 | 15.90 | 0% |
| 750 | 548.99 | 1280.91 | 21.11 | 0% |
| 1,000 | 503.08 | 995.85 | 24.96 | 0% |

### 6.4 Key Performance Observations

- All three tested workflows recorded a 0% error rate across the five tested virtual-user levels.
- Application Access throughput reached approximately 9.9 samples/sec from 500 virtual users onwards.
- Flight Search throughput reached approximately 10 samples/sec at higher virtual-user levels.
- Complete End-to-End User Flow throughput increased to 24.96 samples/sec at 1,000 virtual users.
- Application Access recorded its highest P99 response time of 9,339.17 ms at 100 virtual users.
- Average response times and P99 response times showed different patterns, highlighting the importance of examining more than one performance metric.

These observations describe the recorded test results and do not represent a production-capacity assessment or an SLA pass/fail determination.

## 7. Project Documentation

The project includes the following documentation:

**01_Project_Documentation**
- Document Structure
- Performance Testing Project Overview
- Performance Testing Requirements
- Performance Testing Strategy
- Test Environment Details

**02_Application_Information**
- Application-related information used during test planning.

**03_Test_Scenarios**
- Performance test scenarios.

**04_Test_Cases**
- 22 documented performance test cases.

**05_JMeter_Test_Plans**
- Main JMeter test plan.
- Supporting JMeter test plans for individual workflows and testing approaches.

**06_Test_Execution**
- Baseline, Load, Spike and Stress configuration documents.
- PTC-organised execution screenshots.
- JMeter CLI commands.
- Consolidated Stress Test Results workbook.

**07_Defects**
- Defect documentation and supporting evidence, where applicable.

## 8. Tools and Technologies

- **Apache JMeter:** Performance test plan preparation and execution.
- **BlazeDemo:** Application under test.
- **JMeter CLI:** Non-GUI test execution.
- **Microsoft Excel:** Test case and performance result documentation.
- **Microsoft Word:** Performance testing documentation.
- **GitHub:** Portfolio project hosting.
- **GitKraken:** Git repository management.

## 9. Defect Documentation

The project includes a dedicated defect documentation folder for recording performance-related findings and supporting evidence, where applicable.

## 10. Key Learning Outcomes

Through this project, I gained practical exposure to:

- Performance testing concepts and methodologies.
- Preparing and configuring JMeter test plans.
- Simulating concurrent virtual users.
- Performing baseline, load, stress and spike testing.
- Executing JMeter scripts through the command line.
- Monitoring response times, throughput and error rates.
- Analysing performance behaviour at different load levels.
- Organising execution evidence and documenting test findings.

## 11. Project Summary

This project demonstrates practical performance testing using Apache JMeter, supported by structured test documentation, 22 performance test cases, multiple JMeter test plans, execution evidence and recorded stress testing results.

It forms part of my QA portfolio and demonstrates my ability to plan, execute, analyse and document performance testing activities.