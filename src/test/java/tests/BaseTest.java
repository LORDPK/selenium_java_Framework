package tests;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utilitys.Driver;

public class BaseTest {
    Driver driver;

    @BeforeTest
    @Parameters({"URI", "browser"})
    public void beforeTest(String URI, String browser) {
        driver = Driver.getInstance(URI, browser);
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
