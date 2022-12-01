package tests.stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.General;
import tests.pages.www.LoginPage;

import java.util.Properties;

public class LoginSteps {
    LoginPage loginPage;
    General general;
    Properties properties;

    public LoginSteps(ContextSteps contextSteps) {
        loginPage = new LoginPage(contextSteps);
        general = new General(contextSteps);
        properties = contextSteps.properties;
    }

    @Given("User is on the login page")
    public void I_visit_login_page() {
        loginPage.navigateToPage().acceptCookie();
    }

    @When("User enter email and password")
    public void enter_text() {
        String email = System.getProperty("email", properties.getProperty("EMAIL"));
        String password = System.getProperty("password", properties.getProperty("PASSWORD"));

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
