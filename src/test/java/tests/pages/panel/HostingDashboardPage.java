package tests.pages.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

public class HostingDashboardPage {
    WebDriver driver;
    PageUtils utils;

    public HostingDashboardPage(ContextSteps contextSteps) {
        this.driver = contextSteps.driver;
        this.utils = new PageUtils(contextSteps);
    }

    public HostingDashboardPage verifyPageDisplayed() {
        By side_menu = By.xpath("//*[@class='side-menu side-menu--hosting']");
        utils.waitUntilTitleContains("Dashboard");
        utils.waitUntilElementVisible(side_menu);
        return this;
    }

    public HostingDashboardPage navigateToAutoInstallerPage() {
        String manage_hosting_url = driver.getCurrentUrl();
        utils.navigateToUrl(manage_hosting_url + "/website/auto-installer");
        return this;
    }
}
