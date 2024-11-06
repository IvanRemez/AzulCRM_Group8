package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends BasePage {


    @FindBy(xpath="//div[@id='profile-menu-filter']/a")
    public List<WebElement> allTabs;


}
