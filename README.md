# Map Automation Framework

A hybrid automation testing framework for map-based web applications, implementing location search, category selection, login, and logout workflows using Playwright (Java) and Selenium (Java).

## 🚀 Features

- **Dual Framework Support**: Both Selenium and Playwright for comprehensive testing
- **Video Recording**: Automatic test execution recording in WebM format
- **Map Testing**: Specialized for location-based applications with Leaflet.js
- **Headless/Headed Modes**: Flexible execution for CI/CD and debugging
- **Modern Stack**: Java 11, Maven, JUnit 5, WebDriverManager

## 🛠️ Tech Stack

- **Language**: Java 11
- **Build Tool**: Maven 3.9.5
- **Test Framework**: JUnit 5
- **Automation Tools**: Selenium 4.15.0, Playwright 1.40.0
- **Web Driver Management**: WebDriverManager 5.5.3
- **Sample App**: HTML/CSS/JavaScript with Leaflet.js

## 📁 Project Structure

```
map-automation/
├── src/
│   ├── main/resources/
│   │   └── index.html          # Sample map application
│   └── test/java/
│       ├── LocationTest.java   # Playwright automation tests
│       └── LoginTest.java      # Selenium automation tests
├── test-results/videos/        # Video recordings (generated)
├── target/                     # Maven build artifacts (generated)
├── pom.xml                     # Maven configuration
└── README.md
```

## 🚦 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+ (or use included Maven 3.9.5)

### Installation
1. Clone the repository
2. Navigate to project directory
3. No additional installation required (Maven included)

### Running Tests

#### Run All Tests
```bash
# Using included Maven
.\apache-maven-3.9.5\bin\mvn.cmd test

# Or if Maven is in PATH
mvn test
```

#### Run Specific Tests
```bash
# Playwright test only
.\apache-maven-3.9.5\bin\mvn.cmd test -Dtest=LocationTest

# Selenium test only
.\apache-maven-3.9.5\bin\mvn.cmd test -Dtest=LoginTest
```

#### Run with Video Recording
```bash
# Tests automatically record videos in test-results/videos/
.\apache-maven-3.9.5\bin\mvn.cmd test -Dtest=LocationTest
```

## 🎯 Test Coverage

### LocationTest (Playwright)
- Login with username/password
- OTP verification
- Location search functionality
- Map interactions (change/select location)
- Logout process

### LoginTest (Selenium)
- Same workflow as LocationTest
- Cross-browser compatibility testing
- WebDriverManager integration

## 🗺️ Sample Application

The test target (`src/main/resources/index.html`) includes:
- **Authentication**: Login with OTP verification
- **Location Services**: Search and select locations
- **Map Integration**: Leaflet.js with OpenStreetMap tiles
- **Category Selection**: Restaurant/Park categories with subcategories
- **Interactive Features**: Change location, add markers, logout

## 📹 Video Recording

Tests automatically record execution videos:
- **Format**: WebM
- **Location**: `test-results/videos/`
- **Content**: Complete test execution with browser interactions
- **Usage**: Debugging, documentation, CI/CD reporting

## 🔧 Configuration

### Browser Settings
- **Default**: Chromium (both frameworks)
- **Mode**: Headed (visible browser windows)
- **Video**: Enabled by default for Playwright tests

### Maven Configuration
- **Java Version**: 11
- **Encoding**: UTF-8
- **Test Framework**: JUnit 5
- **Dependencies**: Auto-managed via Maven

## 🚀 CI/CD Integration

### GitHub Actions (Optional)
```yaml
name: Map Automation Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '11'
      - name: Run Tests
        run: mvn test
```

## 📊 Test Reports

Test results are generated in:
- **Surefire Reports**: `target/surefire-reports/`
- **Video Recordings**: `test-results/videos/`
- **Console Output**: Detailed execution logs

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add your tests
4. Run existing tests to ensure compatibility
5. Submit a pull request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).
