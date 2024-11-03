package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrivePage extends BasePage {
    public DrivePage() {
    PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(xpath = "//a[@title='Drive']")
    public WebElement DriveLink;

}
