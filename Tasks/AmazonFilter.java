package Tasks;

import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AmazonFilter {
    WebDriver webDriver;
    Properties properties = new Properties();
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java" + pathSeparator + "Tasks" + pathSeparator + "webPage.Properties";
    String csvPath = userDirectory + pathSeparator + "amazonfilter.csv";
    ArrayList<String> phoneNames = new ArrayList<>();
    ArrayList<String> phonePrices = new ArrayList<>();

    @BeforeClass
    public void beforeMethod() {
        try {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            String browserLink = properties.getProperty("link");
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.get(browserLink);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    @Test(priority = 0)
    public void applyFilter() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchProduct = webDriver.findElement(By.xpath(properties.getProperty("search")));
        searchProduct.sendKeys("phone" + Keys.ENTER);
        WebElement filter = webDriver.findElement(By.xpath(properties.getProperty("filterPrice")));
        filter.click();
//        WebElement lowPrice = webDriver.findElement(By.xpath(properties.getProperty("lowprice")));
//        lowPrice.sendKeys("1000" + Keys.ENTER);
//        WebElement highPrice = webDriver.findElement(By.xpath(properties.getProperty("highprice")));
//        highPrice.sendKeys("5000" + Keys.ENTER);
    }

    @Test(priority = 1)
    public void verifyProduct() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> phones = webDriver.findElements(By.xpath(properties.getProperty("productName")));
        for (WebElement phoneLists : phones) {
            String brandNames = phoneLists.getText();
            phoneNames.add(brandNames);
        }
        System.out.println(phoneNames);
        String validate = properties.getProperty("validatingProductText");
        boolean check = ElementsAction.validate(webDriver, validate);
        if (check == true) {
            System.out.println("Verified that the product is related to what we have searched.");
        } else if (check == false) {
            System.out.println("Verified that the product is not related to what we have searched.");
        }
    }

    @Test(priority = 2)
    public void verifyPrice() {
        List<WebElement> prices = webDriver.findElements(By.xpath(properties.getProperty("priceList")));
        for (WebElement priceList : prices) {
            String productPrice = priceList.getText();
            if (productPrice != null) {
                phonePrices.add(productPrice);
            }
        }
        System.out.println(phonePrices);
        String price = phonePrices.get(0);
        int checkPrice = Integer.parseInt(price.replaceAll(",", ""));
        if (1000 < checkPrice && checkPrice < 5000) {
            System.out.println("Verified that the PhonePrices are between 1000 to 5000");
        } else {
            System.out.println("Verified that the PhonePrices are not between 1000 to 5000");
        }
    }

    @Test(priority = 3)
    public void writeCsvFile() throws IOException {
        File file = new File(csvPath);
        FileWriter write=new FileWriter(file);
        CSVWriter writer =new CSVWriter(write);
        List<String[]> print = new ArrayList<String[]>();
        String[] nameOfPhones=phoneNames.toArray(new String[0]);
        String[] priceOfPhones=phonePrices.toArray(new  String[0]);
        print.add(nameOfPhones);
        print.add(priceOfPhones);
        writer.writeAll(print);
        writer.close();
        System.out.println("CSVFile was writed Successfully");
    }

    @AfterClass
    public void closingBrowser() {
        webDriver.quit();
    }
}