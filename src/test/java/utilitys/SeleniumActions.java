package utilitys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {
    private Driver driver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final java.time.Duration TIMEOUT = Duration.ofSeconds(60);//TODO Move this to a constants class

    public SeleniumActions(Driver driver) {
        this.driver = driver;
        this.webDriver = driver.getWebdriver();
        wait = new WebDriverWait(this.webDriver, TIMEOUT);
    }

    /**
     * Add a file to input file field
     * @param locator input file element Locator
     * @param fileLocalPath path from the file to add to the input field
     */
    public void addFileInputField(By locator, String fileLocalPath) {
        String path = FileManager.getAbsolutePathFromRelativePath(fileLocalPath);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        webDriver.findElement(locator).sendKeys(path);
    }

    /**
     * Evaluate if the file was correctly added to the input file
     * @param locator input file element Locator
     * @param fileLocalPath path from the file added to the input field
     */
    public void evaluateCorrectlyInputFile(By locator, String fileLocalPath) {
        String valueExpected = FileManager.getFileName(fileLocalPath);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String elementValue = webDriver.findElement(locator).getAttribute("value");

        Asserts.assertStringContainsString(elementValue, valueExpected);
    }
}
