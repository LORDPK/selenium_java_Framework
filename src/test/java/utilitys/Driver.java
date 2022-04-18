package utilitys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;

public class Driver {
    private static Driver single_api = null;
    private static WebDriver webdriver;
    private static String URI;

    private Driver(String URI, String browser) {
        this.URI = URI;

        if((browser.equals("CHROME"))) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--no-sandbox");
            opt.addArguments("headless");
            webdriver = new ChromeDriver(opt);
            webdriver.manage().window().maximize();
            webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public static Driver getInstance(String URI, String browser) {
        if (single_api == null)
            single_api = new Driver(URI, browser);

        if(!URI.equals(single_api.URI))
            single_api.URI = URI;

        single_api.webdriver.navigate().to(single_api.URI);

        return single_api;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
