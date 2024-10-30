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

    public void sendMessage() {
        message.click();
        allEmpOption.isDisplayed();
    }
    public void clickSendMessage(String message) {
        Driver.getDriver().switchTo().frame(iframe);
        typeMsg.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
    }

}
