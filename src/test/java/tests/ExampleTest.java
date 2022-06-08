package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ExamplePage;
import utilitys.SQLActions;

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
     //  SQL test is not going to work because SQL connection data is not real.
    public void T000X_ExampleSQLSelect() {
        SQLActions sql = new SQLActions();
        var list = sql.getDataFromTable("SQLQuery");
        Assert.assertNotNull(list, "Error Database");
        for (var row: list) {
            System.out.println(row.get("ColumnName"));
        }
    }
}