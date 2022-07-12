package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestCase {
    @Test
    public void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://phptravels.org/login");
        // using inbuildPageFactory method for pageobjectmodel in selenium
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, LoginPageObjects.class);//initiating driver to proceed loginpageobject class using default methods.
        LoginPageObjects.username.sendKeys("gunasekar0407@gmail.com");
        LoginPageObjects.password.sendKeys("Gunaraina@48");
        LoginPageObjects.submit.click();


        // these are used for basic pageobjectmodel using findelement
//        LoginPageObjects.userName(driver).sendKeys("gunasekar0407@gmail.com");
//        LoginPageObjects.password(driver).sendKeys("Gunaraina@48");
//        LoginPageObjects.loginButton(driver).click();
            }
}
