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
       }else{
           System.err.println("\"All employees\" - No option Available");
       }
    }
    @Then("the message should be sent to All employees by default")
    public void the_message_should_be_sent_to_by_default() {
main.SendMessageButton.click();
    }

//Scenario2
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
}
