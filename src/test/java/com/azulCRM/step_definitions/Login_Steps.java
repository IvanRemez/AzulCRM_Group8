package com.azulCRM.step_definitions;

import com.azulCRM.pages.BasePage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Login_Steps {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        BrowserUtils.verifyURLContains("azulcrm");
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equalsIgnoreCase("hr")) {
            username = ConfigurationReader.getProperty("hr_username");
            password = ConfigurationReader.getProperty("hr_password");
        } else if (userType.equalsIgnoreCase("helpdesk")) {
            username = ConfigurationReader.getProperty("help_desk_username");
            password = ConfigurationReader.getProperty("help_desk_password");
        } else if (userType.equalsIgnoreCase("marketing")) {
            username = ConfigurationReader.getProperty("marketing_username");
            password = ConfigurationReader.getProperty("marketing_password");
        }
        //send username and password and login
        loginPage.login(username, password);
    }
    // PARAMETERIZED OPTION:
//    @Given("the user logged in with username as {string} and password as {string}")
//    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {
//      LoginPage loginPage=new LoginPage();
//      loginPage.login(username,password);
//    }

    @Then("user lands on homepage")
    public void user_lands_on_homepage() {

        BrowserUtils.waitForVisibility(loginPage.homeButton, 3);
        Assert.assertTrue(loginPage.homeButton.isDisplayed());
    }

    @Given("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("{string} error is displayed")
    public void error_is_displayed(String invalidCredentialsError) {

        BrowserUtils.verifyElementDisplayed(loginPage.invalidCredentialsError);
        Assert.assertEquals(invalidCredentialsError, loginPage.invalidCredentialsError.getText());
    }

    @Then("user can see and interact with checkbox")
    public void user_can_see_and_interact_with_checkbox() {

        Assert.assertTrue(loginPage.rememberMeLabel.isDisplayed());
        Assert.assertTrue(loginPage.rememberMeCheckbox.isDisplayed());

        loginPage.rememberMeCheckbox.click();
        Assert.assertTrue(loginPage.rememberMeLabel.isEnabled());
    }

    @Then("user can see and interact with link")
    public void user_can_see_and_interact_with_link() {

        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed());

        loginPage.forgotPasswordLink.click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(
                "//div[.='Get Password']")).isDisplayed());
    }

    @Then("password field input is hidden")
    public void password_field_input_is_hidden() {

        Assert.assertEquals(loginPage.password
                .getAttribute("type"), "password");
    }

}
