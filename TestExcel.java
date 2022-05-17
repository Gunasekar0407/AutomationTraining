import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
    String userDirectory=System.getProperty("user.dir");
	File file;
    Scanner input = new Scanner(System.in);
    XSSFWorkbook xssfWorkbook;

    public ArrayList<String> fileReader(File file) throws IOException {
        // File file = new File("C:\\Users\\gunasekar.dhanapal\\IdeaProjects\\Excersize\\src\\main\\java\\StudentOne.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String read = " ";
        ArrayList<String> listOne = new ArrayList<String>();
        while ((read = bufferedReader.readLine()) != null) {
            listOne.add(read);
        }
        return listOne;
    }

    public void writeToXlsxFile() {
    	try {
            file = new File(userDirectory+File.separator+"StudentOne.txt");
            ArrayList<String> firstFile = fileReader(file);
            file = new File(userDirectory+File.separator+"StudentTwo.txt");
            ArrayList<String> secondFile = fileReader(file);
            file = new File(userDirectory+File.separator+"StudentThree.txt");
        ArrayList<String> thirdFile = fileReader(file);
        ArrayList<String> header=new ArrayList<String>();
        header.add("RollNo");
        header.add("Name");
        header.add("Marks");
        header.add("Status");
//        System.out.println(firstFile);
//        System.out.println(secondFile);
//        System.out.println(thirdFile);
        System.out.println("Enter your FileName");
        String filename=input.next();
        String path=userDirectory+File.separator+filename;
        File file=new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet5");
        XSSFRow nRow;
        Map<String, ArrayList>map=new TreeMap<String, ArrayList>();
        map.put("0", header);
        map.put("1", firstFile);
        map.put("2", secondFile);
        map.put("3", thirdFile);
        Set<String> key = map.keySet();
        int row = 0; //Null pointer Exception
        for (String str: key) {
            nRow = xssfSheet.createRow(row++);
            ArrayList objArray = map.get(str);
            int cell = 0;
            for (Object obj: objArray) {
                XSSFCell xssfCell = nRow.createCell(cell++);
                xssfCell.setCellValue((String)obj);
            }

        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("XLsheet was writed Successfully");

   	} catch (Exception exception) {
   		System.err.println(exception.getMessage());
	}}


    public static void main(String[] args) throws IOException {
        TestExcel TestExcel = new TestExcel();
        TestExcel.writeToXlsxFile();
    }

}

