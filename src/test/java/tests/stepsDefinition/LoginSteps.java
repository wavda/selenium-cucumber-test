package tests.stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.General;
import tests.pages.www.LoginPage;

public class LoginSteps {
    LoginPage loginPage;
    General general;

    public LoginSteps(ContextSteps contextSteps) {
        loginPage = new LoginPage(contextSteps);
        general = new General(contextSteps);
    }

    @Given("User is on the login page")
    public void I_visit_login_page() {
        loginPage.navigateToPage().acceptCookie();
    }

    @When("User enter email and password")
    public void enter_text() {
        String email = System.getProperty("email");
        String password = System.getProperty("password");

        loginPage
                .inputText("email", email)
                .inputText("password", password);
    }

    @When("User click on the login button")
    public void click_login() {
        loginPage.clickLogin();
        general.waitLoadingAnimationDisappear();
    }

    @Then("login success and profile menu should be displayed")
    public void check_profile_page() {
        general.waitLoadingAnimationDisappear();
        general.verifyClientLoggedIn();
    }
}
