package com.azulCRM.pages;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActiveStreamPage extends BasePage {
    public ActiveStreamPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement messageTab;
    @FindBy(id = "feed-add-post-form-tab-tasks")
    public WebElement taskTab;
    @FindBy(id = "feed-add-post-form-tab-calendar")
    public WebElement eventTab;
    @FindBy(id = "feed-add-post-form-tab-vote")
    public WebElement pollTab;
    @FindBy(id = "feed-add-post-form-link-text")
    public WebElement moreTab;
    @FindBy(css = "iframe.bx-editor-iframe")
    public WebElement iframe;
    @FindBy(xpath = "//html/body")
    public WebElement texBox;
    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;
    @FindBy(xpath = "//div[contains(@id,'blog_post_outer_')]")
    public List<WebElement> messages;
    @FindBy (css = "span.feed-add-info-text")
    public WebElement errorMessage;
    @FindBy(css="span.feed-add-post-del-but")
    public WebElement allEmployeesCancel;
    @FindBy(css = "span.feed-add-post-destination-text")
    public WebElement toSend;
@FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;
@FindBy(className = "feed-add-post-micro-title")
    public WebElement emptyMessageBox;
    public void clickTab(String tabName) {
        tabName = tabName.substring(0, 1).toUpperCase() + tabName.substring(1).toLowerCase();
        String locator = "(//span[.='" + tabName + "'])[1]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    public void sendTextInTexBox(String text) {
        Driver.getDriver().switchTo().frame(iframe);
        texBox.sendKeys(text);
        BrowserUtils.waitForPageToLoad(2);
        Driver.getDriver().switchTo().parentFrame();

    }
    public String getFirstMessage() {
        return messages.get(0).getText();
    }
    public String fakeMessage(String text){
        Faker faker = new Faker();
        return text+" "+faker.name().fullName();
    }
}
