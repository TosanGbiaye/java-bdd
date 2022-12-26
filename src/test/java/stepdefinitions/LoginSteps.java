package stepdefinitions;


import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pagerunner.LoginPageSteps;
import pagerunner.Selectors;


public class LoginSteps {
    Selectors sel;
    LoginPageSteps lps = new LoginPageSteps();
    @Before
    public void i_launch_the_swag_lab_app_on_the_desktop() {
        lps.set_up();
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        lps.click_login_button();
    }
    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        lps.view_products_page();
        lps.tear_down();
    }
    @And("I insert the {string}")
    public void i_insert_the(String text) {
        lps.insert_a_text(sel.usernameField, text);
    }

    @And("I insert the password")
    public void i_insert_the_Password() {
        lps.insert_password();
    }

    @Then("I should have access based on my {string}")
    public void iShouldHaveAccessBasedOnMy(String access) {
        switch (access) {
            case "success" -> lps.view_products_page();
            case "distorted" -> lps.view_similar_images();
            case "locked" -> lps.view_error_message();
        }
    }
    @After
    public void tear_down_session(){
        lps.tear_down();
    }
}
