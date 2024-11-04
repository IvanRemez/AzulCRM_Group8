package com.azulCRM.step_definitions;


import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MyProfilePage;
import com.azulCRM.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class ProfilePageStepDefs {

    LoginPage loginPage = new LoginPage();
    MyProfilePage myProfilePage = new MyProfilePage();


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.userName.sendKeys("helpdesk101@Cydeo.com");
        loginPage.password.sendKeys("UserUser");
        loginPage.submit.click();

    }


    @When("user clicks on user block")
    public void userClicksOnUserBlock() {

        myProfilePage.userBlock.click();

    }

    @And("user clicks on My Profile")
    public void userClicksOnMyProfile() {
        myProfilePage.myProfile.click();
    }


    @Then("user sees the following tab options:")
    public void userSeesTheFollowingTabOptions(List<String> expectedTab) {

        List<String> actualTab = BrowserUtils.getElementsText(By.xpath("//div[@id='profile-menu-filter']/a"));
        Assert.assertEquals(actualTab, expectedTab);

    }
}

