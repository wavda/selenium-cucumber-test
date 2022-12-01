# Tool and Programming Language
Selenium, Cucumber, JUnit, Allure, Maven, Java

# Execute Test
1. Update URL, Email, Password value in `src/resources/config.properties` file
2. Run `mvn clean test -Dheadless=...` (headless option: true/false, default: true)

# Generate Report
Run `mvn allure:serve`

# Note
- Use login URL that allows captcha bypass
- Test script was intended for an account that does not have any existing installed app on the hosting
