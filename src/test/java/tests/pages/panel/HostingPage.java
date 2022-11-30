package tests.pages.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

import static tests.utils.PageUtils.*;

public class HostingPage {
    WebDriver driver;
    PageUtils utils;

    public HostingPage(ContextSteps contextSteps) {
        this.driver = contextSteps.driver;
        this.utils = new PageUtils(contextSteps);
    }

    public HostingPage verifyPageDisplayed() {
        By side_menu = By.xpath("//*[@class='side-menu side-menu--hosting']");
        utils.waitUntilTitleContains("Dashboard");
        utils.waitUntilElementVisible(side_menu);
        return this;
    }

    public HostingPage navigateToAutoInstallerPage() {
        String manage_hosting_url = driver.getCurrentUrl();
        utils.navigateToUrl(manage_hosting_url + "/website/auto-installer");
        utils.waitUntilTitleContains("Auto Installer");
        return this;
    }

    public HostingPage selectAutoInstallerApplication(String application_name) {
        By select_button = By.id("hpanel_tracking-website-autoinstaller-install-new-" + application_name.toLowerCase());
        utils.click(select_button);
        return this;
    }

    public HostingPage verifyAutoInstallerPopupDisplayed(String application_name) {
        utils.waitUntilElementVisible(By.id("hpanel_tracking-new-app-installation"));
        utils.waitUntilElementVisible(By.xpath("//h2[contains(text(),'Install " + application_name + "')]"));
        return this;
    }

    public HostingPage inputAutoInstallerWebsiteCredentials(String password) {
        By site_title_locator = By.id("autoinstaller-sitetitle");
        By admin_password_locator = By.id("autoinstaller-password");
        utils.writeText(site_title_locator, "Automated Test");
        utils.writeText(admin_password_locator, password);
        return this;
    }

    public HostingPage clickNext() {
        By next_button = By.id("hpanel_tracking-website-autoinstaller-website-credentials-next");
        utils.click(next_button);
        return this;
    }

    public HostingPage clickConfirmApplicationInstallation() {
        By install_button = By.id("hpanel_tracking-website-autoinstaller-application-setup-next");
        utils.click(install_button);
        return this;
    }

    public HostingPage verifyInstallationSuccess(String application_name) {
        By edit_website_button = By.id("hpanel_tracking-wordpress-dashboard-edit_website_button");
        utils.waitUntilUrlContains(application_name.toLowerCase() + "/dashboard");
        utils.waitUntilElementClickable(edit_website_button);
        return this;
    }

    public HostingPage selectActionMenu(String selected_action) {
        By action_menu = By.xpath("//*[@icon='actionDots']");
        By action_button = By.xpath("//button//*[text()='" + selected_action + "']");
        utils.waitUntilElementVisible(By.id("h-data-table_body"));
        utils.click(action_menu);
        utils.click(action_button);
        return this;
    }

    public HostingPage selectDataToDelete(String data_type) {
        By popup_delete = By.id("-modal");
        By checkbox_option = By.xpath("//*[@data-msgid='Delete " + data_type + "']");
        utils.waitUntilElementVisible(popup_delete);
        utils.click(checkbox_option);
        return this;
    }

    public HostingPage confirmDeleteInstallation() {
        By confirm_delete_button = By.id("hpanel_tracking-website-auto-installer--modal-delete_button");
        utils.click(confirm_delete_button);
        return this;
    }

    public HostingPage verifyDeleteInstallationSuccess() {
        By popup_auto_installer = By.id("actions-auto-installer");
        By installed_application_section = By.xpath("//*[text()='Installed Applications']");
        utils.waitUntilElementPresent(popup_auto_installer);
        utils.waitUntilElementInvisible(installed_application_section);
        return this;
    }
}
