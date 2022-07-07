package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestBoxTwo {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/");
    }

    @Test

    public void fillingTextBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement elements = webDriver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[1]"));
        Thread.sleep(2000);
        elements.click();
        WebElement deselectElement = webDriver.findElement(By.xpath("(//*[@class='header-wrapper'])[1]"));
        deselectElement.click();
        Thread.sleep(2000);
        WebElement selectForms = webDriver.findElement(By.xpath("(//*[@class='header-wrapper'])[2]"));
        selectForms.click();
        Thread.sleep(2000);
        WebElement selectPracticeForms = webDriver.findElement(By.xpath("(//*[@class='menu-list'])[2]"));
        selectPracticeForms.click();
        WebElement firstName = webDriver.findElement(By.xpath("(//*[@type='text'])[1]"));
        firstName.sendKeys("Gunasekar");
        WebElement lastName = webDriver.findElement(By.xpath("(//*[@type='text'])[2]"));
        lastName.sendKeys("D");
        WebElement email = webDriver.findElement(By.xpath("(//*[@type='text'])[3]"));
        email.sendKeys("gunasekar0407@gmail.com");
        WebElement selectGender = webDriver.findElement(By.xpath("(//*[@class='custom-control-label'])[1]"));
        selectGender.click();
        WebElement phoneNumber = webDriver.findElement(By.xpath("(//*[@type='text'])[4]"));
        phoneNumber.sendKeys("8939065082");
        Thread.sleep(2000);
        WebElement subjects=webDriver.findElement(By.className("css-1g6gooi"));
        Thread.sleep(4000);
        subjects.sendKeys("s");
        Thread.sleep(4000);
        List<WebElement> optionList=webDriver.findElements(By.xpath("(//*[@type='text'])[6]"));
        System.out.println(optionList.size());
        for (WebElement webElement:optionList){
            if (webElement.getText().equals("English")){
                webElement.click();
                System.out.println("Selecting" + webElement.getText());
                break;
            }
        }
        WebElement hobbies = webDriver.findElement(By.xpath("(//*[@class='custom-control-label'])[4]"));
        hobbies.click();
        WebElement address = webDriver.findElement(By.xpath("(//*[@class='form-control'])[2]"));
        address.sendKeys("chennai");
        Thread.sleep(3000);

    }

//    @AfterMethod
//    public void afterMethod() {
//        webDriver.quit();
//    }
}

