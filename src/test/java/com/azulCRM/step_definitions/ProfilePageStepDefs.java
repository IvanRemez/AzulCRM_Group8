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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProfilePageStepDefs {

    //Creating object class
    MyProfilePage myProfilePage = new MyProfilePage();


@Given ("the user is logged in")
public void the_user_is_logged_in() {
    myProfilePage.userName.sendKeys("helpdesk101@Cydeo");
    myProfilePage.password.sendKeys("UserUser" + Keys.ENTER);
}

    @When("user clicks on user block")
    public void userClicksOnUserBlock() {
        myProfilePage.userBlock.click();
    }

    @And("user clicks on My Profile")
    public void userClicksOnMyProfile() {
        myProfilePage.myProfile.click();
    }

    @Then("User is on My Profile page")
    public void userIsOnMyProfilePage() {

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

