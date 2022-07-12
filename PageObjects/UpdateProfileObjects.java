package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpdateProfileObjects {
    // without findelement using PageFactory method for PageObjectModel
    @FindBy(how = How.XPATH, using ="//*[@id=\\\"main-body\\\"]/div/div[1]/div[1]/div[1]/div/div[3]/a")
    public static WebElement myProfile;
    @FindBy(name = "phone")
    public static WebElement phnNumber;
    @FindBy(name = "city")
    public static WebElement city;
    @FindBy(xpath ="//*[@id=\\\"main-body\\\"]/div/div[1]/div[2]/form/div[4]/input[1]")
    public static WebElement submit;


    // using findelement basic pageObjectModel
    //updating phnnumber and city
//    public static WebElement myProfile(WebDriver driver){
//        return driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[3]/a"));
//    }
//    public static WebElement phnNumber(WebDriver driver){
//       return driver.findElement(By.name("phone"));
//    }
//    public static WebElement city(WebDriver driver){
//       return driver.findElement(By.name("city"));
//    }
//    public static WebElement submit(WebDriver driver){
//        return driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/div[1]/div[2]/form/div[4]/input[1]"));
//    }
}
