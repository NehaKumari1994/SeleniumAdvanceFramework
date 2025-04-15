package org.example.pages.pageObjectModal.orangeHRM;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.utils.WaitHelpers.waitJVM;

public class EmployeeListHomePage extends CommonToAllPage {
    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");


    // Page Actions
    public String loggedInUserName() {
        waitJVM(5000);
        return getText(userNameOnDashboard);
    }

}
