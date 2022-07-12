package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithSingleClass {
    // this is class which we are providing data in the script directly.
    // Other four classes are for sample, this is the write one of data driven.
    // providing four combination of logins in stringtwo dimensional arrayand using dataprovider method to returnthe datas and then using dataprovider to testmethod to pass the data's.
    String [][] data={
        {"CorrectuserName","IncorrectPassword"},
        {"IncorrectuserName","CorrectPassword"},
        {"IncorrectuserName","IncorrectPassword"},
        {"2082","Atmecs@12345"}};
    @DataProvider(name ="loginData")
    public String [][] loginDataProvider(){
        return data;}
    @Test(dataProvider ="loginData")
    @Parameters({"userName","Password"})
    public void loginWithBothCorrect(String uName, String pWord){
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
