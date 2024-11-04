package com.azulCRM.pages;

import org.openqa.selenium.WebElement;
import com.azulCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStream2Page {
    public ActivityStream2Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Activity Stream']")
    public WebElement activityStreamLink;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    WebElement activityStreamLink2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Activity Stream']")));
}

