package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilitys.Driver;

import java.io.File;
import java.time.Duration;

public abstract class BasePage {
    protected Driver driver;
    protected WebDriverWait wait;
    private final java.time.Duration TIMEOUT = Duration.ofSeconds(60);

    public BasePage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getWebdriver(), TIMEOUT);
    }

    public void addFileToField(By locator, String fileLocalPath) {
        File file = new File(fileLocalPath);
        String path = file.getAbsolutePath();
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.getWebdriver().findElement(locator).sendKeys(path);
    }

    public void assertCorrectAddFile(By locator, String fileLocalPath) {
        File file = new File(fileLocalPath);
        String valueExpected = file.getName();

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String elementValue = driver.getWebdriver().findElement(locator).getAttribute("value");

        Assert.assertTrue(
                elementValue.contains(valueExpected),
                "Error element value: '"+ elementValue +"' not contains expected value '" + valueExpected + "'"
                );
    }
}
