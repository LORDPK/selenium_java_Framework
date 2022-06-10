package tests;

import data.ExecutionConfig;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utilitys.Driver;

public class BaseTest {
    Driver driver;
    ExecutionConfig exeConfig;

    @BeforeTest
    public void beforeTest() {
        exeConfig = new ExecutionConfig();
        driver = Driver.getInstance(exeConfig);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            String testName = result.getName();

            System.out.println("ERROR");
            Reporter.log("Error in testcase: " + testName);
        }
    }

    @AfterTest
    public void afterTest() {
        driver.closeDriver();
    }
}
