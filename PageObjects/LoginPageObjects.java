package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects {
    // without findelement using PageFactory method for PageObjectModel
    @FindBy(how = How.NAME, using = "username")
    public static WebElement username;
    @FindBy(name = "password")
    public static WebElement password;
    @FindBy(xpath ="//*[@id='login']")
    public static WebElement submit;



    // using findelement basic pageObjectModel
//    public static WebElement userName(WebDriver driver){
//        return driver.findElement(By.name("username"));
//    }
//    public static WebElement password(WebDriver driver) {
//       return driver.findElement(By.name("password"));
//    }
//    public static WebElement loginButton(WebDriver driver){
//        return driver.findElement(By.xpath("//*[@id='login']"));
//    }
}
