package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage extends BasePage{
    public UploadPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement messageTab;
    @FindBy(id ="feed-add-post-form-tab-tasks")
    public WebElement taskTab;
    @FindBy(id ="feed-add-post-form-tab-calendar")
    public WebElement eventTab;
    @FindBy(id ="feed-add-post-form-tab-vote")
    public WebElement pollTab;
    @FindBy(id ="feed-add-post-form-link-text")
    public WebElement moreTab;
    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    public WebElement uploadFileIcon;
@FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFileAndPicture;
    @FindBy(xpath = "//td[@class='files-info']")
    public WebElement insertButton;
    @FindBy(xpath = "//td[@class='files-del-btn']")
    public WebElement removeButton;
    @FindBy(id="blog-submit-button-save")
    public WebElement sendButton;
    @FindBy(id = "disk-attach-block-Ny1b1Y")
    public WebElement firstBlog;
    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;
    @FindBy(xpath = "//table[@class='files-list']//td[5]")
    public WebElement cancelIcon;
    @FindBy(xpath = "//table[@class='files-list']//td")
    public WebElement uploadedFileTable;
}
