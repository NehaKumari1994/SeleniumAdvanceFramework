package org.example.pages.pageObjectModal.appvwo;

import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Page Class contains Page Locators and Page Actions

    WebDriver driver;

    public LoginPage(WebDriver driver)//parameterised constructor
    {
        this.driver = driver;
    }

    //Step 1 Page Locators
    // (using private for the concept of encapsulation)
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Step 2 Page Actions
    public String loginToVWOLoginInvalidCred(String user, String pwd) {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        //wait- Thread.Sleep
        WaitHelpers.waitJVM(5000);
        //Wait-Explicit wait
        // WaitHelpers.checkVisibility(driver,error_message);

        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;
    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        //wait- Thread.Sleep
        WaitHelpers.waitJVM(5000);

    }

}
