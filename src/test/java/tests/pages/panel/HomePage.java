package tests.pages.panel;

import org.openqa.selenium.By;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

public class HomePage {
    PageUtils utils;

    public HomePage(ContextSteps contextSteps) {
        this.utils = new PageUtils(contextSteps);
    }

    public HomePage clickManageOrder() {
        By manage_order_button = By.id("hpanel_tracking-home-manage_button");
        utils.click(manage_order_button);
        return this;
    }
}
