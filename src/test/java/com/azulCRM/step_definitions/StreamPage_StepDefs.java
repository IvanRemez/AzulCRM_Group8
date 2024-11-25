package com.azulCRM.step_definitions;

import com.azulCRM.pages.ActiveStreamPage;
import com.azulCRM.pages.BasePage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StreamPage_StepDefs {
    ActiveStreamPage page = new ActiveStreamPage();
    String expectedMessage;

    //userStory 4
    @Given("user clicks {string}")
    public void user_clicks(String pageName) {
        BasePage.goToPage(pageName);
    }

    @And("user clicks on {string} tab")
    public void userClicksOnTab(String tabName) {
        page.clickTab(tabName);
    }

    @And("user enter {string} into the textBox")
    public void userEnterIntoTheTextBox(String text) {
        expectedMessage = page.fakeMessage(text);
        page.sendTextInTexBox(expectedMessage);
    }

    @When("user clicks Send button")
    public void userClicksSendButton() {
        BrowserUtils.waitForPageToLoad(1);
        page.sendButton.click();
    }

    @Then("user should be able to see message which is sent")
    public void userShouldBeAbleToSeeMessageWhichIsSent() {
        String actual = page.getFirstMessage();
        System.out.println(actual);
        Assert.assertEquals(actual, expectedMessage);
    }

    @Then("user should see error message that {string}")
    public void userShouldSeeErrorMessageThat(String errorMessage) {
        String actualError = page.errorMessage.getText();
        Assert.assertEquals(actualError, errorMessage);
        Assert.assertTrue(page.errorMessage.isDisplayed());
    }

    @Then("user cancel default option All employees from delivery box")
    public void userCancelDefaultOptionAllEmployeesFromDeliveryBox() {
        page.allEmployeesCancel.click();
    }

    @Then("user should be able to see the message delivery is to {string} by default")
    public void userShouldBeAbleToSeeTheMessageDeliveryIsToByDefault(String defaultDelivery) {
        Assert.assertEquals(page.toSend.getText(), defaultDelivery);
    }

    @When("user clicks Cancel button")
    public void userClicksCancelButton() {
        page.cancelButton.click();

    }

    @Then("user should see the {string} default box")
    public void userShouldSeeTheDefaultBox(String defaultMessageBox) {
        BrowserUtils.waitForPageToLoad(1);
        Assert.assertTrue(page.emptyMessageBox.isDisplayed());
        Assert.assertEquals(page.emptyMessageBox.getText(), defaultMessageBox);
        Driver.getDriver().switchTo().defaultContent();

    }
}
