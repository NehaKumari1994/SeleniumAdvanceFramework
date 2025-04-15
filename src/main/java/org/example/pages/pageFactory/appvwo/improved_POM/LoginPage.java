package org.example.pages.pageFactory.appvwo.improved_POM;


import org.example.base.CommonToAllPage;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllPage {
    // Page Class
    // Page Locators
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);

    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

    }



}
