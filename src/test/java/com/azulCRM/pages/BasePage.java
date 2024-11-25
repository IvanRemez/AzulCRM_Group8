package com.azulCRM.pages;

import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

// NEW:
    @FindBy(id = "logo_24_a")
    public WebElement homeButton;
// OLDER:
    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;


    /**
     * @return page name, for example: Dashboard
     */

    public static void goToPage(String pageName){
        WebElement page = Driver.getDriver().findElement(By.linkText(pageName));
        page.click();
    }









}
