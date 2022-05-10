package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilitys.Driver;
import utilitys.FileManager;

public class ExamplePage extends BasePage {
    private final By uploadPhoto = By.cssSelector("input[name='photo']");
    private final By inputFirstName = By.cssSelector("input[name='firstname']");
    private final By sexFemaleRadioButton = By.cssSelector("input[name='sex'][value='Female']");
    private final By selectContinent = By.cssSelector("select[name='continents']");
    private final By alertButton = By.cssSelector("button[name='submit']");

    public ExamplePage(Driver driver) {
        super(driver);
    }

    public void UploadFile(String fileLocalPath) {
        String path = FileManager.getAbsolutePathFromRelativePath(fileLocalPath);
        selenium.sendKeyElement(uploadPhoto, path);
    }

    public void assertUploadFile(String fileLocalPath) {
        String valueExpected = FileManager.getFileName(fileLocalPath);
        String elementValue = selenium.getElementValue(uploadPhoto);
        Assert.assertTrue(elementValue.contains(valueExpected), "Error, File name not present in input file.");
    }

    public void informFirstName(String name) {
        selenium.sendKeyElement(inputFirstName, name);
    }

    public void selectFemaleSex() {
        selenium.clickElement(sexFemaleRadioButton);
    }

    public void clickAlertButton() {
        selenium.clickElement(alertButton);
    }

    public void selectSouthAmericaContinent() {
       selenium.setElementFromSelectElement(selectContinent, "South America");
    }

    public void assertFirstNameInputCorrectly(String Name) {
        String inputNameValue = selenium.getElementValue(inputFirstName);
        Assert.assertEquals(Name, inputNameValue, "Error, Name is not correctly informed.");
    }

    public void assertContinentSouthAmerica() {
        String elementValue = selenium.getElementValue(selectContinent);
        Assert.assertEquals(elementValue, "South America", "Error, South America is not selected.");
    }

    public void assertFemaleSelected() {
        boolean FemaleEnabled = selenium.getEnableStateElement(sexFemaleRadioButton);
        Assert.assertTrue(FemaleEnabled, "Error, Female is not selected.");
    }
}
