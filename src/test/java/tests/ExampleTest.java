package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {
    ExamplePage examplePage;

    @BeforeClass
    public void beforeClass() {
        examplePage =  new ExamplePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.goToURI();
    }

    @Test
    @Parameters("FileLocalPath")
    public void T0001_ExampleFileUpload(String fileLocalPath) {
        examplePage.UploadFile(fileLocalPath);
        examplePage.assertUploadFile(fileLocalPath);
    }

    @Test
    public void T0002_ExampleSendKeyAndClick() {
        String example = "Example";
        examplePage.selectFemaleSex();
        examplePage.informFirstName(example);
        examplePage.assertFemaleSelected();
        examplePage.assertFirstNameInputCorrectly(example);
    }

    @Test
    public void T0003_ExampleSelectElement() {
        examplePage.selectSouthAmericaContinent();
        examplePage.assertContinentSouthAmerica();
    }

    @Test
    public void T0004_ExampleScrollDownUntilElementScreen() {
        driver.getWebdriver().navigate().to("https://markheath.net/post/simple-tables-with-css-grid-layout");
        examplePage.assertAnotherDescription();
    }
}