package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {
    ExamplePage examplePage;

    @BeforeMethod
    public void beforeTest() {
        examplePage =  new ExamplePage(driver);
    }

    @Test
    @Parameters("FileLocalPath")
    public void T0001_Example(String fileLocalPath) {
        examplePage.UploadFile(fileLocalPath);
        examplePage.assertUploadFile(fileLocalPath);
    }
}