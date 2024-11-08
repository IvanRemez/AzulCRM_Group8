package com.azulCRM.step_definitions;


import com.azulCRM.pages.DrivePage;
import com.azulCRM.pages.CompanyPage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
public class Drive_StepDefs{
    DrivePage page = new DrivePage();

    @When("User navigates to the Drive page")
    public void user_navigates_to_the_activity_stream_page() {
        page.DriveLink.click();
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("User sees the following options:")
    public void userSeeTheFollowingOptions(List<String> modules) {
        List<String> moduleLinks = BrowserUtils.getElementsText(cssSelector("a.main-buttons-item-link"));


        Assert.assertEquals(moduleLinks, modules);

    }

    @Given("The user logged in with username as \\{{string}} and password as \\{UserUser}")
    public void theUserLoggedInWithUsernameAsAndPasswordAsUserUser(String helpdesk1, String UserUser) {
    }

    @Then("User sees the following options under the More tab:")
    public void userSeesTheFollowingOptionsUnderTheMoreTab(List<String> modules) {
        List<String> moduleLinks = BrowserUtils.getElementsText(cssSelector("a.main-buttons-item-link"));
        Assert.assertEquals(moduleLinks, modules);
        {
        }
    }















}
