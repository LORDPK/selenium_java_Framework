package utilitys;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
     * Click element
     * @param locator element to click Locator
     */
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        webDriver.findElement(locator).click();
    }

    /**
     * input text in a element
     * @param locator element to input text locator
     * @param text text to input
     */
    public void sendKeyElement(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        webDriver.findElement(locator).sendKeys(text);
    }

    /**
     * Evaluate value of a element
     * @param locator element Locator to recover value
     */
    public String getElementValue(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webDriver.findElement(locator).getAttribute("value");
    }

    /**
     * Return enabled State
     * @param locator element to get enable state
     */
    public boolean getEnableStateElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = webDriver.findElement(locator);

        return element.isEnabled();
    }

    /**
     * Set value to a Select Element
     * @param locator Select Element
     * @param visibleText Text to set value
     */
    public void setElementFromSelectElement(By locator, String visibleText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select selectElement = new Select(webDriver.findElement(locator));
        selectElement.selectByVisibleText(visibleText);
    }

    /**
     * Accept or Dismiss a Alert Depending on parameter value
     * @param acceptAlert Boolean parameter, if is true then accept the alert else dismiss it
     */
    public void acceptDismissAlert(boolean acceptAlert) {
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        if(acceptAlert) {
            this.webDriver.switchTo().alert().accept();
        }
        else {
            this.webDriver.switchTo().alert().dismiss();
        }
    }

    /**
     * Recover the text description in the alert on screen
     * @return Alert text description
     */
    public String recoverTextAlert() {
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        this.webDriver.switchTo().alert();
        return a.getText();
    }
}
