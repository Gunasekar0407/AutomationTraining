package Tasks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("phone" + Keys.ENTER);
        List<String> list = new ArrayList<>();
        for (int i = 16; i < 50;i++) {
            String  xpath = "(//li[@class=\"a-spacing-micro\"])"+"["+i+"]";
            WebElement text = webDriver.findElement(By.xpath(xpath));
            String phone = text.getAttribute("aria-label");
            list.add(phone);
        }
        System.out.println("WebElements Present :");
        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        String brand;
        System.out.println("Enter the brand:");
        brand = scanner.next();
        if (list.contains(brand)){
            System.out.println("Elements present");
        }else{
            System.out.println("Elements not present");
        }
    }
}
