package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMsgPage {

    public MainMsgPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='feed-add-post-micro-title']")
    public WebElement message;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement typeMsg;

    @FindBy(xpath = "//span[.='All employees']")
    public WebElement allEmpOption;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    public WebElement SendMessageButton;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement SenderOptions;

    @FindBy(xpath = "//a[.='Recent']")
    public WebElement RecentSenderOption;


    //My Groups     Employees and departments       E-mail users
    @FindBy(xpath = "//a[.='My Groups ']")
    public WebElement MyGroupsSenderOption;
    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement EmployeesAndDepartmentsSenderOption;
    @FindBy(xpath = "//a[.='E-mail users']")
    public WebElement EmailSenderOption;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement CancelAllRecepients;

    @FindBy(xpath = "//span[.='Please specify at least one person.']")
    public WebElement AllertNoRecipients;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-link']")
    public WebElement CancelMessage;

    @FindBy(xpath = "//div[@class='feed-add-post-micro']")
    public WebElement DefaultMessagePanel;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but feed-add-file']")
    public WebElement UploadFileOption;

    @FindBy(xpath = "//input[@class='diskuf-fileUploader wd-test-file-light-inp diskuf-filemacos']")
    public WebElement UploadFile;

    //bxhtmled-top-bar-btn bxhtmled-button-link
    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']")
    public WebElement AddLinkOption;

    @FindBy(xpath = "//div[@class='bx-core-adm-dialog-head']")
    public WebElement AddLink;

    @FindBy(xpath = "//div[@class=['bx-core-adm-icon-close']")
    public WebElement AddLinkClose;

    @FindBy(xpath = "//span[@class=['bxhtmled-top-bar-btn bxhtmled-button-video']")
    public WebElement AddVideoOption;

    @FindBy(xpath = "//input[@id='video_idPostFormLHE_blogPostForm-source']")
    public WebElement AddVideo;

    @FindBy(xpath = "//span[@class='bx-core-adm-icon-close']")
    public WebElement AddVideoClose;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-quote']")
    public WebElement AddQuoteOption;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement AddQuote;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but feed-add-mention']")
    public WebElement MentionOption;

    @FindBy(xpath = "(//blockquote[@class='bxhtmled-quote'])[1]")
    public WebElement MentionInsert;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but feed-add-tag']")
    public WebElement AddTagOption;

    @FindBy(xpath = "//span[@class='feed-add-post-tags-add']")
    public WebElement AddTag;
//feed-add-post-form-but-cnt feed-add-videomessage

    @FindBy(xpath = "//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']")
    public WebElement AddVideoMessageOption;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-blue']")
    public WebElement CameraAllowance;
    //bx-videomessage-video-overlay

    @FindBy(xpath = "//span[@class='bx-videomessage-video-overlay']")
    public WebElement AddVideoMessage;

    public void sendMessage() {
        message.click();
        allEmpOption.isDisplayed();
    }

    public void clickSendMessage(String message) {
        Driver.getDriver().switchTo().frame(iframe);
        typeMsg.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
    }

    public void IframeSwitch() {
        Driver.getDriver().switchTo().frame(iframe);
    }

    public void IframeSwitchtoDefault() {
        Driver.getDriver().switchTo().defaultContent();
    }
}
