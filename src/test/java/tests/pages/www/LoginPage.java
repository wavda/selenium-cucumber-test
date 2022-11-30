package tests.pages.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

import static tests.utils.PageUtils.*;

public class LoginPage {
    PageUtils utils;

    public LoginPage(ContextSteps contextSteps) {
        this.utils = new PageUtils(contextSteps);
    }

    public LoginPage navigateToPage() {
        utils.navigateToUrl("https://www.hostinger.com/cpanel-login?bypass_hcaptcha=1");
        return this;
    }

    public LoginPage acceptCookie() {
        By accept_cookie = By.id("hgr-cookie_consent-accept_all_btn");
        utils.click(accept_cookie);
        return this;
    }

    public LoginPage inputText(String locator, String value) {
        utils.waitUntilElementClickable(By.xpath("//*[@value='Log in']"));
        utils.writeText(By.name(locator), value);
        return this;
    }

    public LoginPage clickLogin() {
        utils.click(By.xpath("//*[@value='Log in']"));
        utils.waitUntilUrlNotContains("login");
        return this;
    }
}
