package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="user-block")
    public WebElement userBlock;

    @FindBy(xpath="//span[.='My Profile']")
    public WebElement myProfile;



}
