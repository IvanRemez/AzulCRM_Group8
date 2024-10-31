package com.azulCRM.step_definitions;

import com.azulCRM.pages.CompanyPage;
import com.azulCRM.utilities.BrowserUtils;
import com.azulCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class CompanyPage_StepDefs {
    CompanyPage page=new CompanyPage();

    @When("user navigates to the company page")
    public void user_navigates_to_the_company_page() {
       page.companyLink.click();
       BrowserUtils.waitForPageToLoad(2);
    }

    @Then("user see the following modules in the Company page:")
    public void userSeeTheFollowingModulesInTheCompanyPage(List<String> modules) {
         List<String> moduleLinks= BrowserUtils.getElementsText(cssSelector("a.main-buttons-item-link"));

        Assert.assertEquals(moduleLinks,modules);

    }
}
