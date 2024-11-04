package com.azulCRM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesPage extends BasePage {

    WebDriver driver;

    @FindBy(css = ".module-item")  // Update this locator to match your app's HTML structure
    private List<WebElement> moduleElements;

    @FindBy(css = ".active-module")  // Locator for the active module
    private WebElement activeModule;

    public EmployeesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(String pageName) {
        driver.findElement(By.linkText(pageName)).click();
    }

    public List<String> getModuleNames() {
        return moduleElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnModule(String moduleName) {
        for (WebElement module : moduleElements) {
            if (module.getText().equals(moduleName)) {
                module.click();
                break;
            }
        }
    }

    public String getActiveModuleName() {
        return activeModule.getText();
    }
}