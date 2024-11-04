package com.azulCRM.step_definitions;


import com.azulCRM.pages.LoginPage;
import io.cucumber.java.en.Given;

public class ProfilePageStepDefs {

    LoginPage loginPage = new LoginPage();

@Given("the user is logged in")
    public void the_user_is_logged_in() {
    loginPage.userName.sendKeys("helpdesk101@Cydeo.com");
    loginPage.password.sendKeys("UserUser");
    loginPage.submit.click();

}



}

