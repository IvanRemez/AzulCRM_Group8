package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.PollPage;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PollStepDefinitions {

    PollPage pollPage = new PollPage();
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        // Navigate to the main page and log in
        Driver.getDriver().get("https://qa.azulcrm.com/");
        loginPage.login("hr11@cydeo.com", "UserUser");

        // Navigate to the Poll tab in the Activity Stream
        pollPage.navigateToPoll();

        // Validate navigation was successful
        Assert.assertTrue("User is not on the expected Poll page.",
                Driver.getDriver().getCurrentUrl().contains("/stream/"));
    }

    @Then("the delivery should be {string} by default")
    public void the_delivery_should_be_by_default(String expectedDelivery) {
        String actualDelivery = pollPage.getDeliveryDefaultOption();
        Assert.assertEquals("Default delivery option mismatch", expectedDelivery, actualDelivery);
    }

    @When("the user adds a question with text {string}")
    public void the_user_adds_a_question_with_text(String questionText) {
        pollPage.addQuestion(questionText);
    }

    @When("the user adds answers {string}, {string}, and {string}")
    public void the_user_adds_answers_and(String answer1, String answer2, String answer3) {
        pollPage.addAnswer(answer1);
        pollPage.addAnswer(answer2);
        pollPage.addAnswer(answer3);
    }

    @When("the user submits the poll")
    public void the_user_submits_the_poll() {
        pollPage.clickSend();
    }

    @Then("the poll should be successfully created")
    public void the_poll_should_be_successfully_created() {
        Assert.assertTrue("Poll creation failed", pollPage.isPollCreated());
    }

    @When("the user selects the {string} option")
    public void the_user_selects_the_option(String option) {
        if (option.equalsIgnoreCase("Allow multiple choice")) {
            pollPage.selectAllowMultipleChoice();
        }
    }

    @Then("the poll should allow multiple choice selection")
    public void the_poll_should_allow_multiple_choice_selection() {
        Assert.assertTrue("Multiple choice option is not enabled", pollPage.isMultipleChoiceEnabled());
    }

    @When("the user tries to submit the poll without specifying a recipient")
    public void the_user_tries_to_submit_the_poll_without_specifying_a_recipient() {
        pollPage.clearRecipients();
        pollPage.clickSend();
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = pollPage.getErrorMessage();
        Assert.assertEquals("Error message mismatch", expectedErrorMessage, actualErrorMessage);
    }

    @When("the user tries to submit the poll without a title")
    public void the_user_tries_to_submit_the_poll_without_a_title() {
        pollPage.clearTitle();
        pollPage.clickSend();
    }

    @When("the user adds a question without text and tries to save")
    public void the_user_adds_a_question_without_text_and_tries_to_save() {
        pollPage.addQuestion(""); // Add a blank question to test error handling
        pollPage.clickSend();
    }

    @When("the user adds a question with no answers and tries to save")
    public void the_user_adds_a_question_with_no_answers_and_tries_to_save() {
        pollPage.addQuestion("What is your favorite fruit?");
        pollPage.clearAnswers(); // Clear all existing answers
        pollPage.clickSend();
    }

    @When("the user adds answers {string}, {string}")
    public void the_user_adds_answers(String answer1, String answer2) {
        pollPage.addAnswer(answer1);
        pollPage.addAnswer(answer2);
    }
}
