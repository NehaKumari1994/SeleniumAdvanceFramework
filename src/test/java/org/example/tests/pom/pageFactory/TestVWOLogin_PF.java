package org.example.tests.pom.pageFactory;

import org.apache.logging.log4j.LogManager;
import org.example.base.CommonToAllPage;
import org.example.pages.pageFactory.appvwo.loginPage_PF;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.example.driver.DriverManager.getDriver;

public class TestVWOLogin_PF extends CommonToAllPage {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);


    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        getDriver().get(PropertiesReader.readKey("url"));
        loginPage_PF loginPage_PF = new loginPage_PF(getDriver());
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        logger.info("Error msg I got "+ error_msg);
        logger.info("Finished the Testcases Page Factory");
        logger.debug("Finished the Testcases Page Factory");
        logger.error("Finished the Testcases Page Factory");
        logger.fatal("Fatal error - code is dead!");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}