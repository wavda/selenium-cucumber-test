package tests.stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utils.WebDriverFactory;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class ContextSteps {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup() {
        driver = new WebDriverFactory().setupDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        String current_url = driver.getCurrentUrl();
        Allure.addAttachment(current_url, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
