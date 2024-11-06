package com.azulCRM.step_definitions;

import com.azulCRM.pages.HomePage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MyProfilePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ProfilePageStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @Given("User is login in homepage")
    public void userIsLoginInHomepage() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("help_desk_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("help_desk_password"));
        loginPage.submit.click();
    }


    @When("user clicks on User Block")
    public void userClicksOnUserBlock() {
        homePage.userBlock.click();
    }

    @And("clicks on My Profile")
    public void clicksOnMyProfile() {
        homePage.myProfile.click();
    }

    @Then("user sees the following general options tabs:")
    public void userSeesTheFollowingGeneralOptionsTabs(List<String> expectedOptions) {
                    //Polymorphism: down-casting List<Elements> to List<String>
        List <String> actualOptions = BrowserUtils.getElementsText(myProfilePage.allTabs);
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    @When("user lands on Profile Page")
    public void userLandsOnProfilePage() {
        String userEmail = myProfilePage.contactInfoEmail.getText();
        Assert.assertEquals(Driver.getDriver().getTitle(), userEmail);
    }


    @Then("user sees email address under the General tab")
    public void userSeesEmailAddressUnderTheGeneralTab() {
        Assert.assertTrue(myProfilePage.contactInfoEmail.isDisplayed());
    }
}
