import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;

public class TopperFinder {
    String userDirectory = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);
    String filename;
    int studentCount;
    String name, result, excel;
    int rollNumber, marks;

    public void writeToJsonFile() throws IOException {
        System.out.println("Enter your FileName");
        filename = scanner.next();
        String path = userDirectory + File.separator + filename;
        FileWriter file = new FileWriter(path);
        System.out.println("Provide the Student Count:");
        studentCount = scanner.nextInt();
        JSONArray student = new JSONArray();
        for (int count = 0; count < studentCount; count++) {
            System.out.println("Enter the RollNo: ");
            rollNumber = scanner.nextInt();
            System.out.println("Enter the Name: ");
            name = scanner.next();
            System.out.println("Enter the Total Marks out of 500: ");
            marks = scanner.nextInt();
            System.out.println("Enter the Result: ");
            result = scanner.next();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("rollNumber", rollNumber);
            jsonObject.put("name", name);
            jsonObject.put("marks", marks);
            jsonObject.put("result", result);
            student.add(jsonObject);
        }
        file.write(student.toString());
        file.close();
    }

    public JSONArray readJsonFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        String path2 = userDirectory + File.separator + filename;
        JSONArray students = (JSONArray) jsonParser.parse(new FileReader(path2));
        System.out.println(students);
        return students;
    }

    public JSONObject findTheTopperStudent(JSONArray students) {
        List<JSONObject> jsonList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            jsonList.add((JSONObject) students.get(i));
        }
        System.out.println(jsonList);
        Collections.sort(jsonList, new Comparator<JSONObject>() {
            public int compare(JSONObject a, JSONObject b) {
                long valA = 0;
                long valB = 0;
                System.out.println("suvedha");
                System.out.println(a);
                try {
                    valA = (long) a.get("marks");
                    valB = (long) b.get("marks");
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                }
                return Long.compare(valB, valA);
            }
        });
        System.out.println(jsonList);
        System.out.println(jsonList.get(0));
        return jsonList.get(0);
    }

    public void writeToXlsxFile(JSONObject student) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");
        Map<String, Object[]> map = new TreeMap<>();
        map.put("0", new Object[]{"RollNumber", "Name", "Marks", "Result"});
        map.put(("1"), new Object[]{student.get("rollNumber"), student.get("name"), student.get("marks"), student.get("result")});
        Set<String> keyset = map.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = xssfSheet.createRow(rownum++);
            Object[] objArr = map.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
            }
        }
        System.out.println("Enter the ExcelFile Name");
        excel = scanner.next();
        FileOutputStream fileOutputStream = new FileOutputStream(excel);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("XLsheet was writed Successfully");
    }

    public static void main(String[] args) throws IOException, ParseException {
        TopperFinder topperFinder = new TopperFinder();
        topperFinder.writeToJsonFile();
        JSONArray students = topperFinder.readJsonFile();
        JSONObject topper = topperFinder.findTheTopperStudent(students);
        topperFinder.writeToXlsxFile(topper);
    }
}
