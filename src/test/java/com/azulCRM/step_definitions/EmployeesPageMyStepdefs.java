package com.azulCRM.step_definitions;
/*
import com.azulCRM.pages.EmployeesPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeesPageMyStepdefs {

    EmployeesPage employeesPage = new EmployeesPage();

    @Given("User logged in as {string}")
    public void userLoggedInAs(String arg0) {
    }

  /*  @And("User navigates to Employees module")
    public void userNavigatesToEmployeesModule() {
        Assert.assertTrue("Employees module should be visible", employeesPage.navigateToModule(EmployeesPage));
        BrowserUtils.waitForPageToLoad(2);
    }


import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.ConfigurationReader;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@And("User on the Base Page")
    public void userOnTheBasePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url_base_page"));
    }

    @When("User sees Employees page button")
    public void userSeesEmployeesPageButton() {
                Assert.assertTrue("Employees link should be visible", employeesPage.navigateToModule(EmployeesPage));
                BrowserUtils.waitForPageToLoad(2);

    }

    @And("User clicks Employees page button")
    public void userClicksEmployeesPageButton() {
        employeesPage.employeesLink.click();
        BrowserUtils.waitForPageToLoad(2);
    }



    @Then("User sees following eight modules in the Employees page:")
   public void userSeesFollowingEightModulesInTheEmployeesPage(DataTable modulesTable) {
      //  Assert.assertEquals("Employees module should be visible", employeesPage.().size(), 8);
        List<String> expectedModules = modulesTable.asList();  // Convert DataTable to List<String>

        for (String module : expectedModules) {
            @FindBy((xpath= "//*[@id='bx_left_menu_menu_company']/a/span") + module + "')]");
            Assert.assertEquals("Module " + module + " should be visible", true, employeesPage.isDisplayed());
        }
    }



    @Given("User is on Base Page")
    public void userIsOnBasePage() {
    }

    @Then("User sees the Company Structure by default")
    public void userSeesTheCompanyStructureByDefault() {
    }


}
*/