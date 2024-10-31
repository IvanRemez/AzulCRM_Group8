package com.azulCRM.step_definitions;

import com.azulCRM.pages.UploadPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadFileAndPicture_StepDefs {
    UploadPage page = new UploadPage();

    @When("user clicks on {string} option")
    public void userClicksOnOption(String linkText) {
        BrowserUtils.sleep(3);
        if (linkText.equalsIgnoreCase("more")){page.moreTab.click();}
        else if (linkText.equalsIgnoreCase("message")) {page.messageTab.click();}
        else if (linkText.equalsIgnoreCase("task")) {page.taskTab.click();}
        else if (linkText.equalsIgnoreCase("poll")) {page.pollTab.click();}
        else if (linkText.equalsIgnoreCase("event")) {page.eventTab.click();}
        }

    @Then("user clicks on the upload files icon")
    public void userClicksOnTheUploadFilesIcon() {
        BrowserUtils.sleep(3);
        page.uploadFileIcon.click();
    }

    @And("user clicks on the Upload files and pictures button and selects a file {string} from their device")
    public void userClicksOnTheUploadFilesAndPicturesButtonAndSelectsAFileFromTheirDevice(String fileType) {
        BrowserUtils.sleep(3);
        if (fileType.equalsIgnoreCase("jpeg")){
            String projectPath = System.getProperty("user.dir");
            String filePathPNG = "src/test/resources/filesToUpload/sampleFile.jpeg";
            String fullPathJPG = projectPath + "/" + filePathPNG;
            BrowserUtils.waitForInvisibilityOf(page.uploadFileAndPicture);
            page.uploadFileAndPicture.sendKeys(fullPathJPG);
        } else if (fileType.equalsIgnoreCase("png")){
            String projectPath = System.getProperty("user.dir");
            String filePathPNG = "src/test/resources/filesToUpload/Screenshot 2024-10-29 at 19.39.02.png";
            String fullPathJPG = projectPath + "/" + filePathPNG;
            BrowserUtils.waitForInvisibilityOf(page.uploadFileAndPicture);
            page.uploadFileAndPicture.sendKeys(fullPathJPG);
        }else if (fileType.equalsIgnoreCase("pdf")){
            String projectPath = System.getProperty("user.dir");
            String filePathPNG = "src/test/resources/filesToUpload/Test_Case_Writing_Tips.docx.pdf";
            String fullPathJPG = projectPath + "/" + filePathPNG;
            BrowserUtils.waitForInvisibilityOf(page.uploadFileAndPicture);
            page.uploadFileAndPicture.sendKeys(fullPathJPG);}
        else if (fileType.equalsIgnoreCase("txt")) {
            String projectPath = System.getProperty("user.dir");
            String filePathPNG = "src/test/resources/filesToUpload/testFile.txt";
            String fullPathJPG = projectPath + "/" + filePathPNG;
            BrowserUtils.waitForInvisibilityOf(page.uploadFileAndPicture);
            page.uploadFileAndPicture.sendKeys(fullPathJPG);
        } else if (fileType.equalsIgnoreCase("docx")) {
            String projectPath = System.getProperty("user.dir");
            String filePathPNG = "src/test/resources/filesToUpload/Upload file functionality.docx";
            String fullPathJPG = projectPath + "/" + filePathPNG;
            BrowserUtils.waitForInvisibilityOf(page.uploadFileAndPicture);
            page.uploadFileAndPicture.sendKeys(fullPathJPG);
        }

    }

    @Then("user clicks on in text button insert the file into the text")
    public void user_clicks_on_in_text_button_insert_the_file_into_the_text() {
        BrowserUtils.sleep(3);
        page.insertButton.click();
    }
    @Then("user clicks on send button see the uploaded {string} in the Activity Stream")
    public void userClicksOnSendButtonSeeTheUploadedInTheActivityStream(String uploadedFileName) {
        BrowserUtils.waitForPageToLoad(5);
        page.sendButton.click();
        BrowserUtils.waitForPageToLoad(5);
        List<WebElement> posts=Driver.getDriver().findElements(By.xpath("//*[contains(@id,'disk-attach-')]"));
        List<String>postTitle=new ArrayList();
        for (WebElement each : posts) {
            postTitle.add(each.getAttribute("data-bx-title"));
            postTitle.add(each.getAttribute("title"));
        }
        System.out.println(postTitle);
        Assert.assertTrue(postTitle.contains(uploadedFileName));
    }


    @When("the user clicks on the x button to remove the file")
    public void theUserClicksOnTheXButtonToRemoveTheFile() {
        BrowserUtils.waitForPageToLoad(5);
        page.cancelIcon.click();
    }

    @Then("the file is removed from the message composition area")
    public void theFileIsRemovedFromTheMessageCompositionArea() {
        BrowserUtils.waitForPageToLoad(3);
        List<WebElement>uploadedFile=Driver.getDriver().findElements(By.xpath("//table[@class='files-list']//td"));
        System.out.println(uploadedFile);
        Assert.assertTrue(uploadedFile.isEmpty());
    }





    @When("user clicks on message option")
    public void userClicksOnMessageOption() {
        BrowserUtils.sleep(3);
        page.messageTab.click();
    }


}
