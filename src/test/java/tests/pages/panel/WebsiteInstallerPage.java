package tests.pages.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.stepsDefinition.ContextSteps;
import tests.utils.PageUtils;

public class WebsiteInstallerPage {
    WebDriver driver;
    PageUtils utils;

    public WebsiteInstallerPage(ContextSteps contextSteps) {
        this.driver = contextSteps.driver;
        this.utils = new PageUtils(contextSteps);
    }

    public WebsiteInstallerPage verifyUrl() {
        utils.waitUntilTitleContains("Auto Installer");
        return this;
    }

    public WebsiteInstallerPage selectAutoInstallerApplication(String application_name) {
        By select_button = By.id("hpanel_tracking-website-autoinstaller-install-new-" + application_name.toLowerCase());
        utils.click(select_button);
        return this;
    }

    public WebsiteInstallerPage verifyAutoInstallerPopupDisplayed(String application_name) {
        utils.waitUntilElementVisible(By.id("hpanel_tracking-new-app-installation"));
        utils.waitUntilElementVisible(By.xpath("//h2[contains(text(),'Install " + application_name + "')]"));
        return this;
    }

    public WebsiteInstallerPage inputAutoInstallerWebsiteCredentials(String password) {
        By site_title_locator = By.id("autoinstaller-sitetitle");
        By admin_password_locator = By.id("autoinstaller-password");
        utils.writeText(site_title_locator, "Automated Test");
        utils.writeText(admin_password_locator, password);
        return this;
    }

    public WebsiteInstallerPage clickNext() {
        By next_button = By.id("hpanel_tracking-website-autoinstaller-website-credentials-next");
        utils.click(next_button);
        return this;
    }

    public WebsiteInstallerPage clickConfirmApplicationInstallation() {
        By install_button = By.id("hpanel_tracking-website-autoinstaller-application-setup-next");
        utils.click(install_button);
        return this;
    }

    public WebsiteInstallerPage verifyInstallationSuccess(String application_name) {
        By edit_website_button = By.id("hpanel_tracking-wordpress-dashboard-edit_website_button");
        utils.waitUntilUrlContains(application_name.toLowerCase() + "/dashboard");
        utils.waitUntilElementClickable(edit_website_button);
        return this;
    }

    public WebsiteInstallerPage selectActionMenu(String selected_action) {
        By action_menu = By.xpath("//*[@icon='actionDots']");
        By action_button = By.xpath("//button//*[text()='" + selected_action + "']");
        utils.waitUntilElementVisible(By.id("h-data-table_body"));
        utils.click(action_menu);
        utils.click(action_button);
        return this;
    }

    public WebsiteInstallerPage selectDataToDelete(String data_type) {
        By popup_delete = By.id("-modal");
        By checkbox_option = By.xpath("//*[@data-msgid='Delete " + data_type + "']");
        utils.waitUntilElementVisible(popup_delete);
        utils.click(checkbox_option);
        return this;
    }

    public WebsiteInstallerPage confirmDeleteInstallation() {
        By confirm_delete_button = By.id("hpanel_tracking-website-auto-installer--modal-delete_button");
        utils.click(confirm_delete_button);
        return this;
    }

    public WebsiteInstallerPage verifyDeleteInstallationSuccess() {
        By popup_auto_installer = By.id("actions-auto-installer");
        By installed_application_section = By.xpath("//*[text()='Installed Applications']");
        utils.waitUntilElementPresent(popup_auto_installer);
        utils.waitUntilElementInvisible(installed_application_section);
        return this;
    }
}
