# Simple Calculator

A simple desktop calculator application built using Java 21 and JavaFX. This project demonstrates object-oriented programming concepts, modular code organization, input validation, and unit testing using JUnit 5.

## Features

- Addition
- Subtraction
- Multiplication
- Division
- Input validation
- Division-by-zero handling
- User-friendly JavaFX interface

## Technologies Used

- Java 21
- JavaFX 21
- Maven
- JUnit 5
- Git and GitHub

## Project Structure

```text
simple-calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── calculator/
│   │           ├── CalculatorApp.java
│   │           ├── CalculatorLogic.java
│   │           └── InputValidator.java
│   └── test/
│       └── java/
│           └── calculator/
│               ├── CalculatorLogicTest.java
│               └── InputValidatorTest.java
├── pom.xml
└── README.md
```

## Requirements

- JDK 21 or later
- Maven

## How to Run

Clone the repository:

```bash
git clone <your-repository-url>
```

Navigate to the project directory:

```bash
cd simple-calculator
```

Run the application:

```bash
mvn javafx:run
```

## Running Unit Tests

Execute:

```bash
mvn test
```

The project includes 9 JUnit test cases covering calculator operations and input validation.

## Test Results

- CalculatorLogicTest: 5 tests passed
- InputValidatorTest: 4 tests passed
- Total: 9 tests passed
- Failures: 0

## Author

Aneesh Gowda N, Ajay MS, Charan Reddy MV