package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginWithJXLExcel {
    String userWorkingDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userWorkingDirectory + pathSeparator + "DataDriven.xls";
    String[][] data = null;
    WebDriver driver;

    @DataProvider(name = "loginData")
    public String[][] loginDataProvider() throws BiffException, IOException {
        data = getExcelData();
        return data;
    }

    public String[][] getExcelData() throws IOException, BiffException {
        FileInputStream excel = new FileInputStream(filePath);
        Workbook workbook = Workbook.getWorkbook(excel);
        Sheet sheet = workbook.getSheet(0);
        int rowCount = sheet.getRows();
        int columnCount = sheet.getColumns();
        String testData[][] = new String[rowCount - 1][columnCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                testData[i - 1][j] = sheet.getCell(j, i).getContents();
            }
        }
        return testData;
    }
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.hrberry.com/smarthr/index.php?q=cms&m=index&client=atmecs");
    }

    @Test(dataProvider = "loginData")
    @Parameters({"userName", "Password"})
    public void loginWithBothCorrect(String uName, String pWord) {
        WebElement username = driver.findElement(By.xpath("//input[@id='userid']"));
        username.sendKeys(uName);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pWord);
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
