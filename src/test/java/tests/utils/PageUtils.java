package tests.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.stepsDefinition.ContextSteps;

public class PageUtils {
    WebDriver driver;
    WebDriverWait wait;

    public PageUtils(ContextSteps contextSteps) {
        this.driver = contextSteps.driver;
        this.wait = contextSteps.wait;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void click(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
    }

    public void writeText(By element, String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).sendKeys(value);
    }

    public void waitUntilElementPresent(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitUntilElementClickable(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
    }

    public void waitUntilElementVisible(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public void waitUntilElementInvisible(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
    }

    public void waitUntilUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }

    public void waitUntilUrlNotContains(String value) {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(value)));
    }

    public void waitUntilTitleContains(String value) {
        wait.until(ExpectedConditions.titleContains(value));
    }
}
