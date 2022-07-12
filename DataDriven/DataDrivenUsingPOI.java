package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDrivenUsingPOI {
    static List<String> userNameList=new ArrayList<String>();
    static List<String> passwordList=new ArrayList<String>();
    String userWorkingDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userWorkingDirectory + pathSeparator + "DataDriven.xlsx";
    WebDriver driver;
    public void readExcel() throws IOException {
        FileInputStream excel=new FileInputStream(filePath);
        Workbook workbook=new XSSFWorkbook(excel);
        Sheet sheet= workbook.getSheetAt(0);
        Iterator<Row> rowIterator=sheet.iterator();
        while (rowIterator.hasNext()){
            Row rowValue=rowIterator.next();
            Iterator<Cell> columnIterator=rowValue.iterator();
            int i=2;
            while (columnIterator.hasNext()){
                if (i%2==0){
                    userNameList.add(columnIterator.next().getStringCellValue());
                }else {
                    passwordList.add(columnIterator.next().getStringCellValue());
                }
                i++;
            }
        }
    }
    public void login(String uName, String pWord) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.hrberry.com/smarthr/index.php?q=cms&m=index&client=atmecs");
        WebElement username = driver.findElement(By.xpath("//input[@id='userid']"));
        username.sendKeys(uName);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pWord);
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        driver.quit();
}
public void executeTest(){
        for (int i=0; i<userNameList.size(); i++){
            login(userNameList.get(i),passwordList.get(i));
        }
}
    public static void main(String[] args) throws IOException {
        DataDrivenUsingPOI usingPOI=new DataDrivenUsingPOI();
        usingPOI.readExcel();
        usingPOI.executeTest();
    }
}
