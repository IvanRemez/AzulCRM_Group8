package com.azulCRM.step_definitions;

import com.azulCRM.pages.EmployeesPage;
import com.azulCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeesPageStepDefs {

    @Given("User logged in as {string}")
    public void userLoggedInAs(String arg0) {

    }

    EmployeesPage page = new EmployeesPage();

    @When("User clicks the Employees page button")
    public void userClicksTheEmployeesPageButton() {
        page.employeesPageButton.click();
        BrowserUtils.waitForPageToLoad(2);
    }


    @Then("User sees following eight modules in the Employees page:")
    public void userSeesFollowingEightModulesInTheEmployeesPage() {
    }

    @Then("User sees the Company Structure by default")
    public void userSeesTheCompanyStructureByDefault() {
    }
}



