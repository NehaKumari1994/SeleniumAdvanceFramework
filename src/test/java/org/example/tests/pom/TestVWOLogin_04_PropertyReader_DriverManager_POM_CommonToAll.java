package org.example.tests.pom;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.pageFactory.appvwo.improved_POM.DashBoardPage;
import org.example.pages.pageObjectModal.appvwo.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_04_PropertyReader_DriverManager_POM_CommonToAll extends CommonToAllTest {
    @Description("TC#1- Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Page Class Code (POM Code) - 2
        LoginPage loginPage  = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }

}
