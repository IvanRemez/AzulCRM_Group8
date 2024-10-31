package com.azulCRM.pages;


import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement invalidCredentialsError;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[.='Remember me on this computer']")
    public WebElement rememberMeLabel;

    @FindBy(xpath = "//a[@class='login-link-forgot-pass']")
    public WebElement forgotPasswordLink;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

}
