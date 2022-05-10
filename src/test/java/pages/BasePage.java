package pages;

import org.testng.Assert;
import utilitys.Driver;
import utilitys.SeleniumActions;

public abstract class BasePage {
    protected SeleniumActions selenium;

    public BasePage(Driver driver) {
        selenium = new SeleniumActions(driver);
    }

    public void assertTextAlert(String expectedText) {
        String recoverText = selenium.recoverTextAlert();
        selenium.acceptDismissAlert(false);
        Assert.assertEquals(recoverText, expectedText,
                "Error text recover in Alert:'" + recoverText + "' different from expected:'"+ expectedText +"'.");
    }
}
