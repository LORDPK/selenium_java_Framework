package pages;

import utilitys.Driver;
import utilitys.SeleniumActions;

public abstract class BasePage {
    protected SeleniumActions selenium;

    public BasePage(Driver driver) {
        selenium = new SeleniumActions(driver);
    }
}
