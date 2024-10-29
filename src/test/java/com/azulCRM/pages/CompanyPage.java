package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage extends BasePage{
    public CompanyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Company']")
    public WebElement companyLink;


}
