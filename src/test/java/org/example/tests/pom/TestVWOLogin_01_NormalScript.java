package org.example.tests.pom;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.pageObjectModal.appvwo.DashboardPage;
import org.example.pages.pageObjectModal.appvwo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript {

    @Description("Verify with invalid email and pwd, error message is shown")
    @Test
    public void test_negative_vwo_login() throws Exception {
        //Driver Manage Code - 1
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        //Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCred("adam@gmail.com", "12340");

        //Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();


    }

    @Owner("Neha")
    @Description("Verify with valid credentials, dashboard page is loaded")
    @Test
    public void test_positive_vwo_login() throws Exception{
        //Driver Manage Code
        WebDriver driver = new EdgeDriver();

        //Page Object Modal Code
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashBoardPage  = new DashboardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        //Assertion Code
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");

        driver.quit();
    }

}

