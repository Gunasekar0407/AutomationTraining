package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.amazon.in/");
    }
    @Test
    public void placeOrder() throws IOException {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search= webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("phones"+ Keys.ENTER);
        WebElement selectPhone= webDriver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        selectPhone.click();
        Set<String> handles=webDriver.getWindowHandles();
        for (String newWindow: handles
        ) {
            webDriver.switchTo().window(newWindow);
        }
        WebElement addToCart= webDriver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCart.click();
        WebElement proceedCheckout= webDriver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']"));
        proceedCheckout.click();
        WebElement username= webDriver.findElement(By.id("ap_email"));
        username.sendKeys("8939065082"+Keys.ENTER);
        WebElement password= webDriver.findElement(By.id("ap_password"));
        password.sendKeys("Gracia@03"+Keys.ENTER);
        WebElement selectAddress=webDriver.findElement(By.xpath("//*[@id='shipToThisAddressButton']"));
        Assert.assertEquals(true, selectAddress.isDisplayed());
        selectAddress.click();
        TakesScreenshot screenshot=(TakesScreenshot) webDriver;
        String userDirectory=System.getProperty("user.dir");
        File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
        File pathLocation=new File(userDirectory+File.separator+"Amazonphonetwo.jpeg");
        FileHandler.copy(sourceFile, pathLocation);
        System.out.println("Screenshot Taken and saved in"+ pathLocation);


    }
    @AfterMethod
    public void closeWindow(){
        webDriver.quit();
    }

}
