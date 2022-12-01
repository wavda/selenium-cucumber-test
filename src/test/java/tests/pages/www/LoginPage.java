package tests.pages.www;

import org.openqa.selenium.By;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

import java.util.Properties;

public class LoginPage {
    PageUtils utils;
    Properties properties;

    public LoginPage(ContextSteps contextSteps) {
        this.utils = new PageUtils(contextSteps);
        this.properties = contextSteps.properties;
    }

    public LoginPage navigateToPage() {
        String url = properties.getProperty("URL");
        utils.navigateToUrl(url);
        return this;
    }

    public LoginPage acceptCookie() {
        By accept_cookie = By.id("hgr-cookie_consent-accept_all_btn");
        if (utils.isPresent(accept_cookie)) {
            utils.click(accept_cookie);
        }
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
