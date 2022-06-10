package data;

public class ExecutionConfig {
    public String browser;
    public String URI;
    public String FileLocalPath;
    public String ChromeDriverPath;

    /*
    Execution Config constructor, for now only hardcode values.
    In the future should get values from multiple config files
     */
    public ExecutionConfig() {
        browser = Constants.CHROME;
        URI = "https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm";
        FileLocalPath = "files/file.txt";
        ChromeDriverPath = "files/Drivers/chromedriver ";
    }
}
