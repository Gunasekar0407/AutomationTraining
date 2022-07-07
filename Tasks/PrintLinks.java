package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PrintLinks {
    WebDriver webDriver;
    Properties properties = new Properties();
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java" + pathSeparator + "Tasks" + pathSeparator + "PropertyFile.Properties";
    XSSFWorkbook xssfWorkbook;
    String totalLinks, browserLink;

    @BeforeMethod
    public void launchingBrowser() {
        try {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
             browserLink = properties.getProperty("myntraWebsiteLink");
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.get(browserLink);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    @Test
    public void verifyPage() throws IOException {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Assert.assertEquals(browserLink, webDriver.getCurrentUrl());
            System.out.println("Opened webpage and expected webpage are same");
        } catch (Throwable pageNavigationError) {
            System.out.println("Opened webpage and expected webpage are not same");
        }
        List<WebElement> links = webDriver.findElements(By.xpath(properties.getProperty("myntraPageLinks")));
        System.out.println("Number of Links in the Page is " + links.size());
        ArrayList<String> webpageLinks = new ArrayList<>();
        for (WebElement ratingList : links) {
            totalLinks = ratingList.getAttribute("href");
            webpageLinks.add(totalLinks);
            System.out.println(totalLinks);
        }
        System.out.println("Enter your FileName");
        String filename = "MyntraLink.xlsx";
        String path = userDirectory + File.separator + filename;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("ink");
        XSSFRow nRow;
        Map<String, ArrayList> map = new TreeMap<>();
        map.put("1", webpageLinks);
        Set<String> key = map.keySet();
        int row = 0;
        int i=0;
        for (String str : webpageLinks) {
            nRow=xssfSheet.createRow(i);
            nRow.createCell(0).setCellValue(i);
            nRow.createCell(1).setCellValue(str);
            i++;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Excel file has been generated successfully.");
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}