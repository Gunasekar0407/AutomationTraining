package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectPassword {
    @Test
    @Parameters({"userName","Password"})
    public void loginWithCorrectPassword(String uName, String pWord){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hrberry.com/smarthr/index.php?q=cms&m=index&client=atmecs");
        WebElement username = driver.findElement(By.xpath("//input[@id='userid']"));
        username.sendKeys(uName);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pWord);
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        driver.quit();
    }
}
