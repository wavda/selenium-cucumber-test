# Tool, and Programming Language
Selenium, Cucumber, JUnit, Allure, Maven, Java

# Execute Test
### Option 1
Run `mvn clean test -Demail=... -Dpassword=... -Dheadless=true/false (default:true)`

### Option 2
1. Update URL, Email, Password value in `src/resources/config.properties` file
2. Run `mvn clean test`

# Generate Report
Run `mvn allure:serve`
