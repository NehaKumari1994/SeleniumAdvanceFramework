package org.example.pages.pageFactory.appvwo.improved_POM;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.base.CommonToAllPage;
import org.example.utils.WaitHelpers;


public class DashBoardPage extends CommonToAllPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}





