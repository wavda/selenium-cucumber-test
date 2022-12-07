package tests.stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.General;
import tests.pages.panel.HomePage;
import tests.pages.panel.HostingDashboardPage;
import tests.pages.panel.WebsiteInstallerPage;
import tests.pages.panel.WordPressDashboardPage;
import tests.utils.PasswordGenerator;

public class HostingSteps {
    General general;
    HomePage homePage;
    HostingDashboardPage hostingPage;
    WebsiteInstallerPage websiteInstallerPage;
    WordPressDashboardPage wordPressDashboardPage;

    public HostingSteps(ContextSteps contextSteps) {
        general = new General(contextSteps);
        homePage = new HomePage(contextSteps);
        hostingPage = new HostingDashboardPage(contextSteps);
        websiteInstallerPage = new WebsiteInstallerPage(contextSteps);
        wordPressDashboardPage = new WordPressDashboardPage(contextSteps);
    }

    @Given("User visit manage hosting page")
    public void user_visit_manage_hosting_page() {
        homePage.clickManageOrder();
        hostingPage.verifyPageDisplayed();
    }

    @When("User navigate to auto installer page")
    public void user_navigate_to_auto_installer() {
        hostingPage.navigateToAutoInstallerPage();
        websiteInstallerPage.verifyUrl();
        general.waitLoadingAnimationDisappear();
    }

    @When("User click auto installer")
    public void user_click_auto_installer() {
        wordPressDashboardPage.navigateToAutoInstaller();
        websiteInstallerPage.verifyUrl();
    }

    @When("User select {string} auto-installer")
    public void user_select_application_auto_installer(String application_name) {
        websiteInstallerPage.selectAutoInstallerApplication(application_name);
        general.waitLoadingAnimationDisappear();
        websiteInstallerPage.verifyAutoInstallerPopupDisplayed(application_name);
    }

    @When("User enter site title and admin password")
    public void user_enter_site_title_and_admin_password() {
        String password = new PasswordGenerator().generateRandomPassword(7) + "@123";
        websiteInstallerPage.inputAutoInstallerWebsiteCredentials(password);
    }

    @When("User click on the button next and install")
    public void user_click_button_next_and_install() {
        websiteInstallerPage
                .clickNext()
                .clickConfirmApplicationInstallation();
    }

    @Then("{string} installation success")
    public void application_installation_success(String application_name) {
        general.waitLoadingAnimationDisappear();
        wordPressDashboardPage.verifyInstallationSuccess(application_name);
    }

    @When("User click on the button {string} from installed application action menu")
    public void user_click_button_action_from_installed_action_menu(String selected_action) {
        websiteInstallerPage.selectActionMenu(selected_action);
    }

    @When("User select data to delete and confirm")
    public void user_select_data_to_delete_and_confirm() {
        websiteInstallerPage
                .selectDataToDelete("installation files")
                .selectDataToDelete("database")
                .confirmDeleteInstallation();
    }

    @Then("Uninstall application success")
    public void uninstall_application_success() {
        websiteInstallerPage.verifyDeleteInstallationSuccess();
    }
}
