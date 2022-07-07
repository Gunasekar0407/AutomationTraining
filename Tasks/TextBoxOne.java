package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxOne {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/");
    }

    @Test
    public void fillingTextBox() {
        WebElement elements = webDriver.findElement(By.className("card-up"));
        elements.click();
        WebElement testBox = webDriver.findElement(By.id("item-0"));
        testBox.click();
        WebElement enterName = webDriver.findElement(By.id("userName"));
        enterName.sendKeys("Gunasekar");
        WebElement enterEmail = webDriver.findElement(By.id("userEmail"));
        enterEmail.sendKeys("Gunasekar0407@gmail.com");
        WebElement enterAddress = webDriver.findElement(By.id("currentAddress"));
        enterAddress.sendKeys("Chennai");
        WebElement enterPermanentAddress = webDriver.findElement(By.id("permanentAddress"));
        enterPermanentAddress.sendKeys("Chennai");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
