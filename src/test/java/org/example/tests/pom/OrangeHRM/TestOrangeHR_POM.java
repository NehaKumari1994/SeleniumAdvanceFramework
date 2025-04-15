package org.example.tests.pom.OrangeHRM;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommonToAllPage;
import org.example.pages.pageObjectModal.orangeHRM.EmployeeListHomePage;
import org.example.pages.pageObjectModal.orangeHRM.LoginPageOrangeHRM_POM;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.driver.DriverManager.getDriver;

public class TestOrangeHR_POM extends CommonToAllPage {

    @Owner("PRAMOD")
    @Description("Verify that the login to the OrangeHR ")
    @Test
    public void testLoginPositive() {


        LoginPageOrangeHRM_POM loginHRPage = new LoginPageOrangeHRM_POM(getDriver());
        loginHRPage.loginToHRCreds(PropertiesReader.readKey("ohr_username"),PropertiesReader.readKey("ohr_password"));

        EmployeeListHomePage dashboardPagePom = new EmployeeListHomePage(getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readKey("ohr_expected_username"));


    }
}
