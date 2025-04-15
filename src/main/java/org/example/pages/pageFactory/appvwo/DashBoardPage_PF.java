package org.example.pages.pageFactory.appvwo;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.WaitHelpers.visibilityOfElement;

public class DashBoardPage_PF extends CommonToAllPage {
    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;


    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

}
