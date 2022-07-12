package POMWOAnnotationAndFindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginWithoutFindBy {
    public static WebElement username;
    public static WebElement password;
    public static WebElement login;
    @Test
    public void login() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.org/login");
        PageFactory.initElements(driver, LoginWithoutFindBy.class);
        username.sendKeys("gunasekar0407@gmail.com");
        password.sendKeys("Gunaraina@48");
        login.click();
    }
}