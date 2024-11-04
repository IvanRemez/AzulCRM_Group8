package com.azulCRM.pages;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PollPage extends BasePage {

    public PollPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locators for elements on the Poll page
    @FindBy(css = "span[class*='feed-add-post-destination-text']")
    private WebElement deliveryDefaultOption;

    @FindBy(xpath = "//*[@id='feed-add-post-form-tab-vote']")
    private WebElement pollTab;

    @FindBy(linkText = "Add question")
    private WebElement addQuestionLink;

    @FindBy(xpath = "//*[@id=\"question_0\"]")
    private WebElement questionInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'Answer')]")
    private List<WebElement> answerInputs;

    @FindBy(xpath = "//button[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[contains(@class, 'feed-add-error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@type='checkbox' and @name='MULTIPLE']")
    private WebElement allowMultipleChoiceCheckbox;

    @FindBy(xpath = "//div[@class='feed-add-post-destination']//span[@class='feed-add-post-destination-text']")
    private WebElement recipientsField;

    @FindBy(xpath = "//input[@class='feed-add-post-inp']")
    private WebElement pollTitleInput;

    private final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    // Method to navigate to the Poll tab
    public void navigateToPoll() {
        BrowserUtils.waitForClickablility(pollTab, 15).click();
    }

    // Method to get the default delivery option text
    public String getDeliveryDefaultOption() {
        BrowserUtils.waitForVisibility(deliveryDefaultOption, 15);
        return deliveryDefaultOption.getText();
    }

    // Method to add a question to the poll
    public void addQuestion(String questionText) {
        BrowserUtils.waitForClickablility(addQuestionLink, 15).click();
        BrowserUtils.waitForVisibility(questionInput, 15).clear();
        questionInput.sendKeys(questionText);
    }

    // Method to add an answer to a question
    public void addAnswer(String answerText) {
        for (WebElement answerInput : answerInputs) {
            if (answerInput.getAttribute("value").isEmpty()) {
                BrowserUtils.waitForVisibility(answerInput, 15).sendKeys(answerText);
                break;
            }
        }
    }

    // Method to click the 'Send' button to submit the poll
    public void clickSend() {
        BrowserUtils.waitForClickablility(sendButton, 15).click();
    }

    // Method to check if the poll was successfully created
    public boolean isPollCreated() {
        return Driver.getDriver().getCurrentUrl().contains("stream");
    }

    // Method to select the 'Allow multiple choice' option
    public void selectAllowMultipleChoice() {
        if (!allowMultipleChoiceCheckbox.isSelected()) {
            BrowserUtils.waitForClickablility(allowMultipleChoiceCheckbox, 15).click();
        }
    }

    // Method to clear recipients
    public void clearRecipients() {
        BrowserUtils.waitForVisibility(recipientsField, 15);
        try {
            recipientsField.click(); // Bring focus to the field
            recipientsField.clear(); // Attempt to clear (may need to use JavaScript or backspace)
        } catch (Exception e) {
            System.out.println("Could not clear recipients field: " + e.getMessage());
        }
    }

    // Method to clear the poll title
    public void clearTitle() {
        BrowserUtils.waitForVisibility(pollTitleInput, 15);
        try {
            pollTitleInput.clear(); // Clear the input field
        } catch (Exception e) {
            System.out.println("Could not clear the poll title: " + e.getMessage());
        }
    }

    // Method to check if the multiple choice option is enabled
    public boolean isMultipleChoiceEnabled() {
        BrowserUtils.waitForVisibility(allowMultipleChoiceCheckbox, 15);
        return allowMultipleChoiceCheckbox.isSelected();
    }

    // Method to get the error message displayed on the page
    public String getErrorMessage() {
        BrowserUtils.waitForVisibility(errorMessage, 15);
        return errorMessage.getText();
    }

    // Additional method to clear all answer inputs (useful for negative tests)
    public void clearAnswers() {
        for (WebElement answerInput : answerInputs) {
            BrowserUtils.waitForVisibility(answerInput, 15).clear();
        }
    }
}
