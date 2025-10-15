# PowerShell script to create a Word document with the framework explanation

$word = New-Object -ComObject Word.Application
$word.Visible = $false
$doc = $word.Documents.Add()

$content = @"
Complete Automation Framework for Sample Map Application

I have successfully created a comprehensive automation framework for a sample map application with spatial data features, addressing all aspects of the assessment. The framework is built in Java using Maven, with Selenium and Playwright for UI automation, and integrates CI/CD processes. All files are saved in the Projects/map-automation folder.

1. Key Considerations for Setting Up Automation Framework

Given that the company lacks an automation framework but works with spatial data, the following considerations were addressed:

- Tool Selection:
  - Selenium: Chosen for its cross-browser compatibility, wide support, and ability to handle complex web interactions. Ideal for enterprise environments with existing infrastructure.
  - Playwright: Selected for modern web applications, faster execution, and better handling of dynamic content like maps. It provides built-in waiting mechanisms and supports multiple browsers.
  - Language: Java was used due to its strong typing, enterprise adoption, and excellent support for both Selenium and Playwright.

- Spatial Data Handling:
  - Used freeware data sources like OpenStreetMap tiles via the Leaflet library to avoid proprietary dependencies.
  - Implemented proper synchronization for map loading and geolocation interactions.
  - Considered headless mode for CI/CD to avoid display issues, while using headed mode for local development visibility.

- Execution Strategy:
  - Headed Mode: For local development and debugging to visually verify automation steps.
  - Headless Mode: For CI/CD pipelines to run tests in server environments without GUI.
  - Parallel test execution to speed up CI/CD pipelines.
  - Added delays (2-3 seconds) between actions for visibility during demonstration.
  - Data-driven approach for testing multiple locations and categories.

- Framework Structure:
  - Maven: For dependency management and build lifecycle.
  - JUnit: As the test framework for assertions and test organization.
  - Page Object Model: For maintainable and reusable code (though simplified in this demo).
  - CI/CD Integration: GitHub Actions for automated build, test, and deployment.

2. Automation Scripts

Created two Java test classes to automate the specified user flow: login, location search, change location, select location, and logout.

- LoginTest.java (Selenium):
  - Uses Selenium WebDriver with Chrome in headed mode.
  - Automates: Login form submission, OTP verification, location search, map interactions, logout.
  - Includes assertions to verify UI state changes.

- LocationTest.java (Playwright):
  - Uses Playwright's Chromium browser in headed mode.
  - Automates the same flow with Playwright's API for modern web interactions.
  - Includes assertions to verify UI state changes.

Both scripts handle:
- Username/password login
- OTP verification (mock implementation)
- Location search (e.g., "london" centers the map)
- Change location (moves map to Paris)
- Select location (adds marker at map center)
- Logout and verification of return to login form

3. Integration of Automated Build, Test, Deployment Processes

Implemented a complete CI/CD pipeline using GitHub Actions:

- Build Process: Maven compiles the project and resolves dependencies.
- Test Process: Runs JUnit tests in headless mode for CI efficiency.
- Deployment Process: Deploys the sample app to GitHub Pages on successful main branch pushes.
- Workflow File: .github/workflows/ci.yml defines the pipeline with caching for faster builds.

The pipeline ensures automated quality checks and deployment, demonstrating integration of build, test, and deploy processes.

4. Freeware Implementation

- Sample Application: Built with HTML, CSS, JavaScript using the free Leaflet library for map rendering.
- Map Data: Uses OpenStreetMap tiles, a free and open-source map data provider.
- No Proprietary Tools: All dependencies (Selenium, Playwright, JUnit, Maven) are open-source and free.

Project Structure

Projects/map-automation/
├── pom.xml                          # Maven configuration with dependencies
├── README.md                        # Documentation and setup instructions
├── .github/workflows/ci.yml         # GitHub Actions CI/CD pipeline
└── src/
    ├── main/resources/index.html    # Sample map application
    └── test/java/
        ├── LoginTest.java           # Selenium automation script
        └── LocationTest.java        # Playwright automation script

Running the Framework

- Local Execution: mvn test runs all tests in headed mode for visibility.
- Specific Tests: mvn test -Dtest=LoginTest or mvn test -Dtest=LocationTest.
- CI/CD: Automatically triggered on GitHub pushes.

This framework provides a solid foundation for automating spatial data applications, with considerations for scalability, maintainability, and integration into development workflows.
"@

$doc.Content.Text = $content
$doc.SaveAs("C:\Users\PM\Desktop\Projects\map-automation\framework_explanation.docx")
$word.Quit()
