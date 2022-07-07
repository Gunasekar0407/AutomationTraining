package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class XpathLocator {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://abstracta.us/contact-us");
    }
    @Test
    public void xpathFinding() throws InterruptedException {
        WebElement name=webDriver.findElement(By.xpath("//input[@id='fullname']"));
        name.sendKeys("Guna");
        Thread.sleep(2000);
        WebElement organisation=webDriver.findElement(By.xpath("//input[@id='organization']"));
        organisation.sendKeys("Atmecs");
        WebElement role=webDriver.findElement(By.xpath("//input[@id='role']"));
        role.sendKeys("Trainee");
        WebElement email=webDriver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("gunasekar0407@gmail.com");
        WebElement phoneNumber= webDriver.findElement(By.xpath("//input[@id='phone']"));
        phoneNumber.sendKeys("8939065082");
        WebElement message=webDriver.findElement(By.xpath("//textarea[@id='message']"));
        message.sendKeys("Nothing");
        WebElement tickBox= webDriver.findElement(By.xpath("//label[@id='label_field_34']"));
        tickBox.click();

    }
}
