package pages;

import org.openqa.selenium.By;
import utilitys.Driver;

public class ExamplePage extends BasePage {
    private final By uploadPhoto = By.cssSelector("input[name='photo']");

    public ExamplePage(Driver driver) {
        super(driver);
    }

    public void UploadFile(String fileLocalPath) {
        selenium.addFileInputField(uploadPhoto, fileLocalPath);
    }

    public void assertUploadFile(String fileLocalPath) {
        selenium.evaluateCorrectlyInputFile(uploadPhoto, fileLocalPath);
    }

}
