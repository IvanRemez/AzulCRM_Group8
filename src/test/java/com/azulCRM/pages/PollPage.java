package com.azulCRM.pages;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PollPage extends BasePage {

    public PollPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locators for elements on the Poll page
    @FindBy(xpath = "//*[@id='feed-add-post-form-tab-vote']")
    private WebElement pollTab;

    @FindBy(css = "span[class*='feed-add-post-destination-text']")
    private WebElement deliveryDefaultOption;

    @FindBy(xpath = "//div[@class='feed-add-post-destination']//span[@class='feed-add-post-destination-text']")
    private WebElement recipientsField;

    @FindBy(xpath = "//input[@class='feed-add-post-inp']")
    private WebElement pollTitleInput;

    @FindBy(linkText = "Add question")
    private WebElement addQuestionLink;

    @FindBy(xpath = "//input[contains(@id,'question_')]")
    private List<WebElement> questionInputs;

    @FindBy(xpath = "//div[contains(@id,'answers')]//input[contains(@placeholder, 'Answer')]")
    private List<WebElement> answerInputs;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@name,'MULTIPLE')]")
    private List<WebElement> allowMultipleChoiceCheckboxes;

    @FindBy(xpath = "//button[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[contains(@class, 'feed-add-error')]")
    private WebElement errorMessage;
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    // Navigate to Poll Tab
    public void navigateToPoll() {
        BrowserUtils.waitForClickablility(pollTab, 15).click();
    }


    // Verify user is on the Poll Creation Page
    public boolean isOnPollCreationPage() {
        return BrowserUtils.waitForVisibility(pollTab, 15).getAttribute("class").contains("active");
    }

    // Get Default Delivery Option
    public String getDefaultDeliveryOption() {
        return BrowserUtils.waitForVisibility(deliveryDefaultOption, 15).getText();
    }

    // Get Default Recipient
    public String getDefaultRecipient() {
        return BrowserUtils.waitForVisibility(recipientsField, 15).getText();
    }

    // Clear Poll Title
    public void clearPollTitle() {
        BrowserUtils.waitForVisibility(pollTitleInput, 15).clear();
    }

    // Add a Question
    public void addQuestion(String questionText) {
        if (questionInputs.isEmpty()) {
            addNewQuestion(questionText);
        } else {
            WebElement firstQuestionInput = questionInputs.get(0);
            BrowserUtils.waitForVisibility(firstQuestionInput, 15).clear();
            firstQuestionInput.sendKeys(questionText);
        }
    }

    // Add Another Question
    public void addAnotherQuestion(String questionText) {
        addNewQuestion(questionText);
    }

    private void addNewQuestion(String questionText) {
        BrowserUtils.waitForClickablility(addQuestionLink, 15).click();
        WebElement newQuestionInput = Driver.getDriver()
                .findElements(By.xpath("//input[contains(@id,'question_')]"))
                .get(questionInputs.size());
        BrowserUtils.waitForVisibility(newQuestionInput, 15).clear();
        newQuestionInput.sendKeys(questionText);
    }

    // Add Answers to the Last Question
    public void addAnswersToLastQuestion(List<String> answers) {
        int lastQuestionIndex = questionInputs.size() - 1;
        String answersXpath = "//div[@id='answers" + lastQuestionIndex + "']//input[contains(@placeholder, 'Answer')]";
        List<WebElement> currentAnswerInputs = Driver.getDriver().findElements(By.xpath(answersXpath));

        for (int i = 0; i < answers.size(); i++) {
            if (i < currentAnswerInputs.size()) {
                BrowserUtils.waitForVisibility(currentAnswerInputs.get(i), 15).clear();
                currentAnswerInputs.get(i).sendKeys(answers.get(i));
            } else {
                WebElement addAnswerLink = Driver.getDriver()
                        .findElement(By.xpath("//a[@onclick='voteAddAnswer(" + lastQuestionIndex + ")']"));
                BrowserUtils.waitForClickablility(addAnswerLink, 15).click();
                currentAnswerInputs = Driver.getDriver().findElements(By.xpath(answersXpath));
                BrowserUtils.waitForVisibility(currentAnswerInputs.get(i), 15).clear();
                currentAnswerInputs.get(i).sendKeys(answers.get(i));
            }
        }
    }

    // Get Number of Questions
    public int getNumberOfQuestions() {
        return questionInputs.size();
    }

    // Verify Each Question Has Respective Answers
    public boolean questionsHaveRespectiveAnswers() {
        for (int i = 0; i < questionInputs.size(); i++) {
            String answersXpath = "//div[@id='answers" + i + "']//input[contains(@placeholder, 'Answer')]";
            if (Driver.getDriver().findElements(By.xpath(answersXpath)).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Check Checkbox for Question
    public void checkCheckboxForQuestion(String checkboxName) {
        WebElement checkbox = allowMultipleChoiceCheckboxes.get(questionInputs.size() - 1);
        if (!checkbox.isSelected()) {
            BrowserUtils.waitForClickablility(checkbox, 15).click();
        }
    }

    // Verify Multiple Answer Selection is Allowed
    public boolean isMultipleAnswerSelectionAllowed() {
        WebElement checkbox = allowMultipleChoiceCheckboxes.get(questionInputs.size() - 1);
        return checkbox.isSelected();
    }

    // Clear Recipients
    public void clearRecipients() {
        List<WebElement> removeButtons = Driver.getDriver().findElements(By.xpath("//span[@class='feed-add-post-del-but']"));
        for (WebElement removeButton : removeButtons) {
            BrowserUtils.waitForClickablility(removeButton, 15).click();
        }
    }

    // Clear Questions
    public void clearQuestions() {
        for (WebElement questionInput : questionInputs) {
            BrowserUtils.waitForVisibility(questionInput, 15).clear();
        }
    }

    // Clear Answers
    public void clearAnswers() {
        for (WebElement answerInput : answerInputs) {
            BrowserUtils.waitForVisibility(answerInput, 15).clear();
        }
    }

    // Click Send Button
    public void clickSendButton() {
        BrowserUtils.waitForClickablility(sendButton, 15).click();
    }

    // Get Error Message
    public String getErrorMessage() {
        return BrowserUtils.waitForVisibility(errorMessage, 15).getText();
    }

    // Verify Poll Creation Success
    public boolean isPollCreated() {
        return Driver.getDriver().getCurrentUrl().contains("stream");
    }

    public void navigateToPollCreationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(pollTab)).click();
    }
}
