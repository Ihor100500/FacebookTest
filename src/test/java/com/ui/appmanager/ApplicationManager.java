package com.ui.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.fail;

public class ApplicationManager {

    protected WebDriver driver;
    private String browser;
    private final Properties properties;
    private SessionHelper sessionHelper;
    private PostHelper postHelper;
    private StringBuffer verificationErrors = new StringBuffer();
    private static Map<String, Object> prefs = new HashMap<>();

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        String target = System.getProperty("target", "authdata");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", prefs);
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);

        sessionHelper = new SessionHelper(driver);
        postHelper = new PostHelper(driver);
        driver.get(properties.getProperty("web.baseUrl"));
        driver.manage().window().maximize();
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));


    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public PostHelper post() {
        return postHelper;
    }
}