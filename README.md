# Map Automation Framework

This project demonstrates an automation framework for a sample map application with spatial data features.

## Key Considerations for Setting Up Automation Framework

1. **Tool Selection**:
   - Selenium: For cross-browser compatibility and wide support.
   - Playwright: For modern web apps, faster execution, and better handling of dynamic content.
   - Language: Java for enterprise environments and strong typing.

2. **Spatial Data Handling**:
   - Use freeware data like OpenStreetMap tiles via Leaflet.
   - Handle geolocation APIs and map interactions carefully.
   - Consider headless mode for CI/CD to avoid display issues.

3. **Execution Strategy**:
   - Parallel test execution to speed up CI/CD.
   - Headless browsers for server environments.
   - Proper waits and synchronization for map loading.
   - Data-driven tests for multiple locations/categories.

4. **Framework Structure**:
   - Maven for dependency management.
   - JUnit for test framework.
   - Page Object Model for maintainable code.
   - CI/CD with GitHub Actions for automated build/test/deploy.

## Running the Tests

1. Ensure Java 11+ and Maven are installed.
2. Run `mvn test` to execute the automation scripts.

## Sample App

The sample app is in `src/main/resources/index.html` and includes:
- Login with OTP verification
- Location search
- Category/subcategory selection
- Map display with Leaflet
- Change/select location functionality
- Logout

## CI/CD Integration

GitHub Actions workflow:
- Builds and tests on push/PR.
- Deploys the sample app to GitHub Pages on main branch.
