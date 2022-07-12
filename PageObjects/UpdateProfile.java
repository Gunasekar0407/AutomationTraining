package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UpdateProfile {
    @Test
    public void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.org/login");
        // using inbuildPageFactory method for pageobjectmodel in selenium
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, LoginPageObjects.class);
        LoginPageObjects.username.sendKeys("Gunasekar07407@gmail.com");
        LoginPageObjects.password.sendKeys("Gunaraina@48");
        LoginPageObjects.submit.click();
        PageFactory.initElements(driver, UpdateProfileObjects.class);
        UpdateProfileObjects.myProfile.click();
        UpdateProfileObjects.phnNumber.sendKeys("12345678");
        UpdateProfileObjects.city.sendKeys("CGHIO");
        UpdateProfileObjects.submit.click();

// these are used for basic pageobjectmodel using findelement
//        LoginPageObjects.userName(driver).sendKeys("gunasekar0407@gmail.com");
//        LoginPageObjects.password(driver).sendKeys("Gunaraina@48");
//        LoginPageObjects.loginButton(driver).click();
//        UpdateProfileObjects.myProfile(driver).click();
//        UpdateProfileObjects.phnNumber(driver).sendKeys("12345678");
//        UpdateProfileObjects.city(driver).sendKeys("CGHIO");
//        UpdateProfileObjects.submit(driver).click();
    }
}
