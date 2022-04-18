package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ExamplePage;
import utilitys.Driver;

public class ExampleTest extends BaseTest {
    ExamplePage examplePage;

    @BeforeMethod
    public void beforeTest() {
        examplePage =  new ExamplePage(driver);
    }

    @Test
    public void T0001_Example() {

    }
}