package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

import java.util.Random;

import static tests.utils.PageUtils.*;

public class General {
    PageUtils utils;

    public General(ContextSteps contextSteps) {
        this.utils = new PageUtils(contextSteps);
    }

    public General waitLoadingAnimationDisappear() {
        By loading_animation = By.xpath("//*[@class='animation-loader']");
        utils.waitUntilElementInvisible(loading_animation);
        return this;
    }

    public General verifyClientLoggedIn() {
        By profile_menu_button = By.id("hpanel_tracking-h_header-header_menu_item-link-user_profile");
        utils.waitUntilUrlContains("hpanel");
        utils.waitUntilElementVisible(profile_menu_button);
        return this;
    }
}
