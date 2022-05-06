package utilitys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class for WebDriver instances management. Only one can be created for execution.
 */
public class Driver {
    private static Driver single_api = null;
    private static WebDriver webdriver;
    private static String URI;

    private Driver(String browser) {
        if((browser.equals("CHROME"))) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--no-sandbox");
            opt.addArguments("--incognito");
            webdriver = new ChromeDriver(opt);
            webdriver.manage().window().maximize();
        }
    }

    public static Driver getInstance(String URI, String browser) {
        if (single_api == null)
            single_api = new Driver(browser);

        if(!URI.equals(Driver.URI))
            Driver.URI = URI;

        return single_api;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void goToURI() {
        webdriver.navigate().to(URI);
    }

    public void goToURL(String url) {
        webdriver.navigate().to(url);
    }

    public void closeDriver() {
        getWebdriver().close();
        getWebdriver().quit();
    }
}
