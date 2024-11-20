package com.azulCRM.step_definitions;

import com.azulCRM.pages.BasePage;
import com.azulCRM.pages.LoginPage;
import com.azulCRM.pages.PollPage;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Before;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PollStepDefinitions {

    PollPage pollPage = new PollPage();
    LoginPage  loginPage  = new LoginPage();
    @Given("the user is on the poll creation page")
    public void the_user_is_on_the_poll_creation_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        // Login to the application using the LoginPage
        loginPage.login(ConfigurationReader.getProperty("hr_username"), ConfigurationReader.getProperty("hr_password"));

        // Navigate to the poll creation page after login
        pollPage.navigateToPollCreationPage();
    }

    @Given("the user is logged into the application")
    public void the_user_is_logged_into_the_application() {

    }

    @When("the user navigates to the {string} module")
    public void the_user_navigates_to_the_module(String string) {

    }

    @Then("the default delivery recipient is {string}")
    public void the_default_delivery_recipient_is(String string) {

    }

    @When("the user adds a question {string}")
    public void the_user_adds_a_question(String string) {

    }

    @When("adds the following answers to the question:")
    public void adds_the_following_answers_to_the_question(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("the user adds another question {string}")
    public void the_user_adds_another_question(String string) {

    }

    @Then("the poll should contain {int} questions with their respective answers")
    public void the_poll_should_contain_questions_with_their_respective_answers(Integer int1) {

    }

    @When("the user checks the {string} checkbox for the question")
    public void the_user_checks_the_checkbox_for_the_question(String string) {

    }

    @Then("the question should allow multiple answer selection")
    public void the_question_should_allow_multiple_answer_selection() {

    }

    @When("the user attempts to create a poll without specifying the message title")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_message_title() {

    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {

    }

    @When("the user attempts to create a poll without specifying the recipient")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_recipient() {

    }

    @When("the user attempts to create a poll without specifying the question")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_question() {

    }

    @When("the user attempts to create a poll without specifying the answer")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_answer() {

    }

    @Then("an error message {string}<question_text>{string} should be displayed")
    public void an_error_message_question_text_should_be_displayed(String string, String string2) {

    }

    @When("attempts to create the poll without adding any answers")
    public void attempts_to_create_the_poll_without_adding_any_answers() {

    }

    @Then("an error message \"The question \"What is your role?{string} should be displayed")
    public void an_error_message_the_question_what_is_your_role_should_be_displayed(String string) {

    }



}
/*
    PollPage pollPage = new PollPage();
    LoginPage loginPage = new LoginPage();

    @Before
    public void setup() {
        // Launch the application
        Driver.getDriver().get("https://www.azulcrm.com/admin/login");
        // Wait for the page to load
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Login to the application
        loginPage.login("hr11@cydeo.com", "UserUser");
        // Navigate to the Poll module
        pollPage.navigateToPoll();
    }

    @Given("the user is on the poll creation page")
    public void the_user_is_on_the_poll_creation_page() {
        // Navigate to the poll creation page
        pollPage.navigateToPoll();
        // Verify that the user is on the poll creation page
        Assert.assertTrue("Not on the poll creation page", pollPage.isOnPollCreationPage());
    }

    @Then("the default delivery recipient is {string}")
    public void the_default_delivery_recipient_is(String expectedRecipient) {
        // Verify that the default recipient is as expected
        String actualRecipient = pollPage.getDefaultRecipient();
        Assert.assertEquals("Default recipient does not match", expectedRecipient, actualRecipient);
    }

    @Then("the delivery option should be set to {string} by default")
    public void the_delivery_option_should_be_set_to_by_default(String expectedDeliveryOption) {
        // Verify that the delivery option is set to the expected value
        String actualDeliveryOption = pollPage.getDefaultDeliveryOption();
        Assert.assertEquals("Default delivery option does not match", expectedDeliveryOption, actualDeliveryOption);
    }

    @When("the user adds a question {string}")
    public void the_user_adds_a_question(String questionText) {
        pollPage.addQuestion(questionText);
    }

    @When("adds the following answers to the question:")
    public void adds_the_following_answers_to_the_question(DataTable dataTable) {
        List<String> answers = dataTable.asList();
        pollPage.addAnswersToLastQuestion(answers);
    }

    @When("the user adds another question {string}")
    public void the_user_adds_another_question(String questionText) {
        pollPage.addAnotherQuestion(questionText);
    }

    @Then("the poll should contain {int} questions with their respective answers")
    public void the_poll_should_contain_questions_with_their_respective_answers(Integer expectedNumberOfQuestions) {
        // Verify that the poll contains the expected number of questions
        int actualNumberOfQuestions = pollPage.getNumberOfQuestions();
        Assert.assertEquals("Number of questions does not match", expectedNumberOfQuestions.intValue(), actualNumberOfQuestions);
        // Optionally, verify that each question has its respective answers
        Assert.assertTrue("Questions do not have respective answers", pollPage.questionsHaveRespectiveAnswers());
    }

    @When("the user checks the {string} checkbox for the question")
    public void the_user_checks_the_checkbox_for_the_question(String checkboxName) {
        // Check the specified checkbox for the question
        pollPage.checkCheckboxForQuestion(checkboxName);
    }

    @Then("the question should allow multiple answer selection")
    public void the_question_should_allow_multiple_answer_selection() {
        // Verify that the question allows multiple answer selection
        Assert.assertTrue("Question does not allow multiple answer selection", pollPage.isMultipleAnswerSelectionAllowed());
    }

    @When("the user attempts to create a poll without specifying the message title")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_message_title() {
        // Attempt to create a poll without a message title
        pollPage.clearMessageTitle();
        pollPage.clickSendButton();
    }

    @When("the user attempts to create a poll without specifying the recipient")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_recipient() {
        // Attempt to create a poll without specifying the recipient
        pollPage.clearRecipient();
        pollPage.clickSendButton();
    }

    @When("the user attempts to create a poll without specifying the question")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_question() {
        // Attempt to create a poll without specifying the question
        pollPage.clearQuestion();
        pollPage.clickSendButton();
    }

    @When("the user attempts to create a poll without specifying the answer")
    public void the_user_attempts_to_create_a_poll_without_specifying_the_answer() {
        // Attempt to create a poll without specifying the answer
        pollPage.clearAnswers();
        pollPage.clickSendButton();
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {
        // Verify that the error message is displayed
        String actualErrorMessage = pollPage.getErrorMessage();
        Assert.assertEquals("Error message does not match", expectedErrorMessage, actualErrorMessage);
    }

    @When("attempts to create the poll without adding any answers")
    public void attempts_to_create_the_poll_without_adding_any_answers() {
        // Attempt to create the poll without adding any answers
        pollPage.clearAnswers();
        pollPage.clickSendButton();
    }

    @Then("an error message {string}<question_text>{string} should be displayed")
    public void an_error_message_question_text_should_be_displayed(String string, String string2) {
        // Implementation depends on how you handle dynamic error messages
        String expectedErrorMessage = string + "<question_text>" + string2;
        String actualErrorMessage = pollPage.getErrorMessage();
        Assert.assertEquals("Error message does not match", expectedErrorMessage, actualErrorMessage);
    }

    @Then("an error message \"The question \"What is your role?{string} should be displayed")
    public void an_error_message_the_question_what_is_your_role_should_be_displayed(String string) {
        String expectedErrorMessage = "The question \"What is your role?" + string;
        String actualErrorMessage = pollPage.getErrorMessage();
        Assert.assertEquals("Error message does not match", expectedErrorMessage, actualErrorMessage);
    }
}

 */
