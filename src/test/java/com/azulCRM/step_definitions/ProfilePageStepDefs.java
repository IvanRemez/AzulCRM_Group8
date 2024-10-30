package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MyProfilePage;
import com.azulCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePageStepDefs {

    //Creating object class
    LoginPage loginPage = new LoginPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @Given("User log in")
    public void user_log_in() {
       loginPage.login("helpdesk1@cydeo.com","UserUser");
    }
    @When("User clicks on user block")
    public void user_clicks_on_user_block() {
        myProfilePage.userBlock.click();
    }
    @When("User clicks my profile")
    public void user_clicks_my_profile() {
        myProfilePage.myProfile.click();
    }
    @Then("User sees the following tab options on General:")
    public void user_sees_the_following_tab_options_on_general(List<String> expectedTabs) {




    }




}
