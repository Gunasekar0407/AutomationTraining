package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assessment {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @Test
    public void xpathFinding() {
        WebElement managerLogin=webDriver.findElement(By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]"));
        managerLogin.click();
        WebElement addCustomer= webDriver.findElement(By.xpath("//body/div[1]/div[1]"));
}}
