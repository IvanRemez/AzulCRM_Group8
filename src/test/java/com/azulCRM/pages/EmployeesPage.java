package com.azulCRM.pages;

import com.azulCRM.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeesPage extends BasePage {


    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesPageButton;

    @FindBy(css = ".main-buttons-item")
    private List<WebElement> modules;

    @FindBy(id = "companyStructure")
    private WebElement companyStructure;

    public EmployeesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void clickEmployeesPageButton() {
            employeesPageButton.click();
    }

    public boolean isCompanyStructureVisible() {
       return companyStructure.isDisplayed();

    }
    public List<String> getModuleNames() {
        return modules.stream().map(WebElement::getText).toList();
    }

}


