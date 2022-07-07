package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("http://www.leafground.com/pages/table.html");
        List<WebElement> row = webDriver.findElements(By.xpath("//div[@id='contentblock']/section/div/table/tbody/tr"));
        int rowSize = row.size();
        System.out.println(rowSize);
        for (int countRow = 2; countRow <= rowSize; countRow++) {
            List<WebElement> column = webDriver.findElements(By.xpath("//div[@id='contentblock']/section/div/table/tbody/tr" + "[" + countRow + "]" + "/td"));
            int coloumCount = column.size();
            for (int countColumn = 1; countColumn <= coloumCount; countColumn++) {
                String path = "//div[@id='contentblock']/section/div/table/tbody/tr" + "[" + countRow + "]" + "/td[" + countColumn + "]";
                path = webDriver.findElement(By.xpath(path)).getText();
                System.out.println(path);
            }
        }
        webDriver.quit();
    }
}