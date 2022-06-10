package utilitys;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.Constants.*;

/**
 * Class for all the actions that uses Selenium WebDriver for Browser Interactions.
 * Examples: Click Element, Move to Element, Select element from List, etc.
 */
public class SeleniumActions {
    private final Driver driver;
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private final Actions actions;

    public SeleniumActions(Driver driver) {
        this.driver = driver;
        this.webDriver = driver.getWebdriver();
        wait = new WebDriverWait(this.webDriver, TIMEOUT);
        this.actions = new Actions(this.webDriver);
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
     * Move cursor to element present in the page then click on it
     * @param locator Select Element
     */
    public void moveToElementAndClickIt(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.actions.moveToElement(webElement).click().build().perform();
    }

    /**
     * Change iframe, if iframe is empty change to default content
     * @param iframe Iframe name or ID
     */
    public void ChangeIframe(String iframe) {
        if(iframe.isEmpty()) {
            this.ChangeDefaultContent();
        }
        else {
            this.webDriver.switchTo().frame(iframe);
        }
    }

    /**
     * Return to default Content
     */
    public void ChangeDefaultContent() {
            this.webDriver.switchTo().defaultContent();
    }

    /**
     * Scroll down to element on screen,
     * Use this method when element doesn't exist on screen at the moment of execution
     * @param locator Select Element
     */
    public boolean scrollDownUntilElementOnScreen(By locator) {
        boolean elementVisible = false;
        int reIntent = 0;

        while(!elementVisible)
        {
            try {
                Thread.sleep(WAITSHORTTIME);
                this.webDriver.findElement(locator).click();
                elementVisible = true;
            }
            catch(Exception Ex) {
                reIntent++;
            }

            if(!elementVisible) {
                this.actions.sendKeys(Keys.PAGE_DOWN).perform();
            }

            if(reIntent > REINTENTLIMIT) {
                return false;
            }
        }

        return true;
    }
}
