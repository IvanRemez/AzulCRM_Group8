package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActivityStream2Page;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class ActivityStream_StepDefs {

    ActivityStream2Page page = new ActivityStream2Page();

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @When("User navigates to the activity stream page")
    public void user_navigates_to_the_activity_stream_page() {
        page.activityStreamLink.click();
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("User sees the following options:")
    public void userSeesTheFollowingOptions(List<String> expectedModules) {
        List<String> actualModules = BrowserUtils.getElementsText(cssSelector("a.main-buttons-item-link"));

        Assert.assertEquals("Module list does not match!", expectedModules, actualModules);
    }

    @Then("User sees the following options under the More tab:")
    public void userSeesTheFollowingOptionsUnderTheMoreTab(List<String> expectedMoreOptions) {
        List<String> actualMoreOptions = BrowserUtils.getElementsText(cssSelector("a.main-buttons-item-link"));

        Assert.assertEquals("More options list does not match!", expectedMoreOptions, actualMoreOptions);
    }
}