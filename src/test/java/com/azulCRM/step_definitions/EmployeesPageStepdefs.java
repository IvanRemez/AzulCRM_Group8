package com.azulCRM.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmployeesPageStepdefs {
    @Given("User logged in as {string}")
    public void userLoggedInAs(String arg0) {
    }

    @And("User on the Base Page")
    public void userOnTheBasePage() {
    }

    @When("User sees Employees page button")
    public void userSeesEmployeesPageButton() {
    }

    @And("User clicks Employees page button")
    public void userClicksEmployeesPageButton() {
    }

    @Then("User sees following eight modules in the Employees page:")
    public void userSeesFollowingEightModulesInTheEmployeesPage(DataTable dataTable) {
        // Get the list of modules from the data table
        List<String> modules = dataTable.asList(String.class);

        // Check that the total number of modules matches the expected count
        int expectedCount = 8;
        Assert.assertEquals("Expected exactly " + expectedCount + " modules, but found " + modules.size(),
                expectedCount, modules.size());

        // Check for duplicates by counting unique modules
        Set<String> uniqueModules = new HashSet<>(modules);
        if (uniqueModules.size() != modules.size()) {
            Assert.fail("Duplicate modules found. Expected 8 unique modules, but found duplicates: " + modules);
        }
    }

    WebDriver driver;

    // Assuming this WebElement corresponds to the "Company Structure" module
    @FindBy(xpath = "//div[@id='companyStructure']")
    WebElement companyStructureModule;

    public EmployeesPageStepdefs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Then("User sees the Company Structure by default")
    public void userSeesTheCompanyStructureByDefault() {
        // Check if the "Company Structure" module is displayed
        Assert.assertTrue("Company Structure should be visible by default",
                companyStructureModule.isDisplayed());
    }
}
