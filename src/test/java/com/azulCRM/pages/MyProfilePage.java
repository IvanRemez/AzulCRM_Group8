package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MyProfilePage extends BasePage  {

 @FindBy(id="USER_LOGIN")
 public WebElement username;
 @FindBy(id="USER_PASSWORD")
 public WebElement password;





@FindBy(id="user-block")
public WebElement userBlock;


@FindBy(xpath="//span[.='My Profile']")
    public WebElement myProfile;

@FindBy(xpath="//div[@id='profile-menu-filter']/a")
    public WebElement allTabs;

@FindBy(xpath="//div[@id='profile-menu-filter']/a[.='General']")
public WebElement generalTab;

@FindBy(xpath = "//div[@id='profile-menu-filter']/a[normalize-space(text())='Tasks']")
public WebElement tasksTab;

@FindBy(xpath = "//div[@id='profile-menu-filter']/a[normalize-space(text())='Calendar']")
public WebElement calendarTab;

@FindBy(xpath = "//div[@id='profile-menu-filter']/a[normalize-space(text())='Conversations']")
public WebElement conversationsTab;



}
