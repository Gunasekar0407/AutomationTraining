package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebTable {
    WebDriver webDriver;
    Properties properties = new Properties();
    String path;
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java" + pathSeparator + "Tasks" + pathSeparator + "PropertyFile.Properties";

    @BeforeMethod
    public void launchBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        FileReader reader = new FileReader(filePath);
        properties.load(reader);
        String websiteLink = properties.getProperty("leafGroundWebsiteLink");
        System.out.println(websiteLink);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(websiteLink);
    }

    @Test(priority = 0)
    public void getTableText() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        List<WebElement> row = webDriver.findElements(By.xpath(properties.getProperty("xpath")));
        int rowSize = row.size();
        System.out.println(rowSize);
        for (int countRow = 2; countRow <= rowSize; countRow++) {
            List<WebElement> column = webDriver.findElements(By.xpath(properties.getProperty("xpath") + "[" + countRow + "]" + "/td"));
            int coloumCount = column.size();
            for (int countColumn = 1; countColumn <= coloumCount; countColumn++) {
                path = properties.getProperty("xpath") + "[" + countRow + "]" + "/td[" + countColumn + "]";
                path = webDriver.findElement(By.xpath(path)).getText();
                System.out.println(path);
            }
        }
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}

