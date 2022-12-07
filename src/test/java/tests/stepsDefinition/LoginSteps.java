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

    @Given("User visit the login page")
    public void user_visit_the_login_page() {
        loginPage.navigateToPage().acceptCookie();
    }

    @When("User enter email and password")
    public void user_enter_email_and_password() {
        String email = System.getProperty("email", properties.getProperty("EMAIL"));
        String password = System.getProperty("password", properties.getProperty("PASSWORD"));

        loginPage
                .inputText("email", email)
                .inputText("password", password);
    }

    @When("User click on the login button")
    public void user_click_login_button() {
        loginPage.clickLogin();
        general.waitLoadingAnimationDisappear();
    }

    @Then("login success and profile menu should be displayed")
    public void login_success_and_profile_menu_should_display() {
        general.waitLoadingAnimationDisappear();
        general.verifyClientLoggedIn();
    }
}
