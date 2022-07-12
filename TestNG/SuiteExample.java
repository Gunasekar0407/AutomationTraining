package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteExample {
    // open chrome and go to
    // 1. google.co.in 2. bing.com 3. yahoo.com and then close the browser.
    WebDriver driver;
    long startTime, endTime, totalTime;

    @BeforeSuite
    public void launchBrowser() {
        long startTime = System.currentTimeMillis();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        long startTime = System.currentTimeMillis();// this will store the time taken for execute
        driver.get("http://www.google.co.in");
    }

    @Test
    public void openBing() {
        driver.get("http://www.bing.com");
    }

    @Test
    public void openYahoo() {
        driver.get("http://www.yahoo.com");
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("TimeTaken : " + totalTime);
    }
}
