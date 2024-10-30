package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.MainMsgPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Message_StepDefinition {
    LoginPage loginPage = new LoginPage();
    MainMsgPage main = new MainMsgPage();

    //Scenario 1
    @Given("user is logged in to AzulCRM")
    public void user_is_logged_in_to_azul_crm() {
        loginPage.login("hr1@cydeo.com", "UserUser");
    }

    @When("the user clicks on the Message tab")
    public void the_user_clicks_on_the_message_tab() {
        main.message.click();
    }

    @When("fills in the message content with {string}")
    public void fills_in_the_message_content_with(String message) {
        main.clickSendMessage(message);
    }

    @When("user should be able to sent to All employees by default")
    public void user_should_be_able_to_sent_to_All_employees_by_default() {
        if (main.allEmpOption.isDisplayed()) {
            System.out.println("User is able to send message to all employee");
        } else {
            System.err.println("\"All employees\" - No option Available");
        }
    }

    @Then("the message should be sent to All employees by default")
    public void the_message_should_be_sent_to_by_default() {
        main.SendMessageButton.click();
    }

    //Scenario 2
    @Given("user should be able to sent to recent person")
    public void user_should_be_able_to_sent_to_recent_person() {
        main.SenderOptions.click();
        Assert.assertTrue(main.RecentSenderOption.isDisplayed());

    }

    @Given("user should be able to sent to Employees and Departments")
    public void user_should_be_able_to_sent_to_recent_person_employees_and_departments() {
        Assert.assertTrue(main.EmployeesAndDepartmentsSenderOption.isDisplayed());
    }

    @Given("user should be able to sent to email users")
    public void user_should_be_able_to_sent_to_recent_person_email_users() {
        Assert.assertTrue(main.EmailSenderOption.isDisplayed());
    }

    //Scenario3


    @Given("selects no recipient")
    public void selects_no_recipient() {
        main.CancelAllRecepients.click();
    }

    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String string) {
        main.SendMessageButton.click();
        Assert.assertTrue(main.AllertNoRecipients.isDisplayed());
        Assert.assertTrue(main.AllertNoRecipients.getText().contains(string));
    }

    //Scenario 4

    @Given("decides to cancel the message")
    public void decides_to_cancel_the_message() {
        main.CancelMessage.click();
    }

    @Then("the message should not be sent")
    public void the_message_should_not_be_sent() {
        Assert.assertTrue(main.DefaultMessagePanel.isDisplayed());
    }


//Scenario 5


    @Given("user is able to see option to Upload files")
    public void user_is_able_to_see_option_to_upload_files() {
        main.UploadFileOption.click();
        Assert.assertTrue(main.UploadFile.isDisplayed());
    }

    @Given("user is able to see option to add Link")
    public void user_is_able_to_see_option_to_add_link() {
        main.AddLinkOption.click();
        Assert.assertTrue(main.AddLink.isDisplayed());
        main.AddLinkClose.click();
    }

    @Given("user is able to see option to insert Video")
    public void user_is_able_to_see_option_to_insert_video() {
        main.AddVideoOption.click();
        Assert.assertTrue(main.AddVideo.isDisplayed());
        main.AddVideoClose.click();
    }

    @Given("user is able to see option to quote text")
    public void user_is_able_to_see_option_to_quote_text() {
        main.IframeSwitch();
        Assert.assertTrue(main.AddQuote.isDisplayed());
        main.IframeSwitchtoDefault();
    }

    @Given("user is able to see option to add Mention")
    public void user_is_able_to_see_option_to_add_mention() {
        main.MentionOption.click();
        main.IframeSwitch();
        Assert.assertTrue(main.MentionInsert.isDisplayed());
        main.IframeSwitchtoDefault();
    }

    @Given("user is able to see option to add Tag")
    public void user_is_able_to_see_option_to_add_tag() {
        main.AddTagOption.click();
        Assert.assertTrue(main.AddTag.isDisplayed());
    }

    @Given("user is able to see option to Record Video")
    public void user_is_able_to_see_option_to_record_video() {
        main.AddVideoMessageOption.click();
        main.CameraAllowance.click();
        Assert.assertTrue(main.AddVideo.isDisplayed());
    }
}
