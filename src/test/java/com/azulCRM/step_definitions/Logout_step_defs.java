package com.azulCRM.step_definitions;

import com.azulCRM.pages.LoginPage;
import com.azulCRM.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Logout_step_defs {

    @Given("the user is logged in on the homepage")
    public void the_user_is_logged_in_on_the_homepage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("hr11@cydeo.com", "UserUser");
    }

    @When("the user clicks on the profile icon")
    public void the_user_clicks_on_the_profile_icon() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='user-block']")));
        profileIcon.click();
    }

    @When("the user selects {string} from the options")
    public void the_user_selects_from_the_options(String option) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-popup']//span[text()='" + option + "']")));
        optionElement.click();
    }

    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList().stream().map(String::trim).collect(Collectors.toList());
        List<String> actualOptions = Driver.getDriver()
                .findElements(By.xpath("//div[@class='menu-popup']//span"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        Assert.assertTrue("Profile menu options should contain expected items", actualOptions.containsAll(expectedOptions));
    }

    @Then("the user should be logged out and redirected to the login page")
    public void the_user_should_be_logged_out_and_redirected_to_the_login_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        // Update the expected URLs with the new URL
        boolean isRedirected = wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe("https://qa.azulcrm.com/"),
                ExpectedConditions.urlToBe("https://qa.azulcrm.com/auth/?backurl=%2Fstream%2F"),
                ExpectedConditions.urlToBe("https://qa.azulcrm.com/auth/?backurl=%2Flicense_restriction.php")
        ));

        Assert.assertTrue("User should be redirected to the login page URL", isRedirected);

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("USER_LOGIN")));
        Assert.assertTrue("Username field should be visible on the login page", usernameField.isDisplayed());
    }
}
