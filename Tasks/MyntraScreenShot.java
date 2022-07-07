package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.IsNamedMatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class MyntraScreenShot {
    WebDriver webDriver;
    Properties properties = new Properties();
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java" + pathSeparator + "Tasks" + pathSeparator + "Myntra.Properties";

    @BeforeMethod
    public void launchingBrowser() {
        try {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            String browserLink = properties.getProperty("myntraWebsiteLink");
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.get(browserLink);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    @Test
    public void searchProduct() throws IOException {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(properties.getProperty("searchBox"))).sendKeys("Watches" + Keys.ENTER);
        List<String> watchNames = new ArrayList<>();
        List<WebElement> watches= webDriver.findElements(By.xpath(properties.getProperty("brandNames")));
            for (WebElement watchLists : watches) {
                String brandNames = watchLists.getText();
                System.out.println(brandNames);
                watchNames.add(brandNames);
            }
            List<String> watchRating = new ArrayList<>();
            List<WebElement> ratings = webDriver.findElements(By.xpath(properties.getProperty("ratingLists")));
            for (WebElement ratingList : ratings) {
                String userRatings = ratingList.getText();
                System.out.println(userRatings);
                if (userRatings != null) {
                    watchRating.add(userRatings);
                }
            }
            System.out.println(watchRating);
        Boolean check=  watchRating.containsAll(watchNames);
        if(check){
            TreeSet<Double> map = new TreeSet<>();
            for (String max : watchRating) {
                double listOfRatings = Double.parseDouble(max);
                map.add(listOfRatings);
            }
            System.out.println("Highest Rating " + map.last());
        } else {
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File pathLocation = new File(userDirectory + File.separator + "Myntra.jpeg");
            FileHandler.copy(sourceFile, pathLocation);
            System.out.println("Screenshot Taken and saved in" + pathLocation);

        }
   }
    @AfterMethod
    public void closeWindow() {
        webDriver.quit();
    }
}

