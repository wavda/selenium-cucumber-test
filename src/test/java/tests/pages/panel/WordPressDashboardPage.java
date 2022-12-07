package tests.pages.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

public class WordPressDashboardPage {
    WebDriver driver;
    PageUtils utils;

    public WordPressDashboardPage(ContextSteps contextSteps) {
        this.driver = contextSteps.driver;
        this.utils = new PageUtils(contextSteps);
    }

    public WordPressDashboardPage navigateToAutoInstaller() {
        utils.click(By.xpath("//*[text()='Auto Installer']"));
        return this;
    }

    public WordPressDashboardPage verifyInstallationSuccess(String application_name) {
        By edit_website_button = By.id("hpanel_tracking-wordpress-dashboard-edit_website_button");
        utils.waitUntilUrlContains(application_name.toLowerCase() + "/dashboard");
        utils.waitUntilElementClickable(edit_website_button);
        return this;
    }
}
