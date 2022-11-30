package tests.stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.General;
import tests.pages.panel.HomePage;
import tests.pages.panel.HostingPage;
import tests.utils.PasswordGenerator;

public class HostingSteps {
    General general;
    HomePage homePage;
    HostingPage hostingPage;

    public HostingSteps(ContextSteps contextSteps) {
        general = new General(contextSteps);
        homePage = new HomePage(contextSteps);
        hostingPage = new HostingPage(contextSteps);
    }

    @Given("User is on the manage hosting page")
    public void iVisitManageHostingPage() {
        homePage.clickManageOrder();
        hostingPage.verifyPageDisplayed();
    }

    @When("User navigate to auto installer page")
    public void navigate_to_auto_installer() {
        hostingPage.navigateToAutoInstallerPage();
        general.waitLoadingAnimationDisappear();
    }

    @When("User select {string} auto-installer")
    public void select_auto_installer(String application_name) {
        hostingPage.selectAutoInstallerApplication(application_name);
        general.waitLoadingAnimationDisappear();
        hostingPage.verifyAutoInstallerPopupDisplayed(application_name);
    }

    @When("User enter site title and admin password")
    public void input_site_title_and_password() {
        String password = new PasswordGenerator().generateRandomPassword(7) + "@123";
        hostingPage.inputAutoInstallerWebsiteCredentials(password);
    }

    @When("User click on the button next and install")
    public void click_next_and_install() {
        hostingPage
                .clickNext()
                .clickConfirmApplicationInstallation();
    }

    @Then("{string} installation success")
    public void verify_installation_success(String application_name) {
        general.waitLoadingAnimationDisappear();
        hostingPage.verifyInstallationSuccess(application_name);
    }

    @When("User click on the button {string} from installed application action menu")
    public void click_action_menu(String selected_action) {
        hostingPage.selectActionMenu(selected_action);
    }

    @When("User select data to delete and confirm")
    public void click_delete_application() {
        hostingPage
                .selectDataToDelete("installation files")
                .selectDataToDelete("database")
                .confirmDeleteInstallation();
    }

    @Then("Uninstall application success")
    public void verify_uninstall_success() {
        hostingPage.verifyDeleteInstallationSuccess();
    }
}
