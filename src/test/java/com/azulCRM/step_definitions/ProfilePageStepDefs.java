package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MyProfilePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProfilePageStepDefs {

    //Creating object class
    LoginPage loginPage = new LoginPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @Given("User log in")
    public void user_log_in() {
        loginPage.login("helpdesk101@Cydeo.com","UserUser");
    }
    @Given("User is on the My Profile page")
    public void user_is_on_the_my_profile_page() {
        myProfilePage.userBlock.click();
        myProfilePage.myProfile.click();
    }
    @When("User views the general tab menu")
    public void user_views_the_general_tab_menu() {
        myProfilePage.allTabs.isDisplayed();
    }
    @Then("User sees the following tab options:")
    public void user_sees_the_following_tab_options(List<String> expectedTab) {

        List<String> actualTabs = BrowserUtils.getElementsText(By.xpath("//div[@id='profile-menu-filter']/a"));

        Assert.assertEquals(actualTabs, expectedTab);





    }

}

