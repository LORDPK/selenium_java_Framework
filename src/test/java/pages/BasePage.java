package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import utilitys.Driver;

import java.time.Duration;

public abstract class BasePage {
    protected Driver driver;
    protected WebDriverWait wait;
    private final java.time.Duration TIMEOUT = Duration.ofSeconds(60);

    public BasePage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getWebdriver(), TIMEOUT);
    }
}
