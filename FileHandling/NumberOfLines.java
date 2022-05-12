package FileHandling;

import java.io.*;
import java.util.Scanner;

public class NumberOfLines {
    File file;
    String nameOfFile, read, Line = " ";
    int numberOfLines;

    public void create() {
        try {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Name Your File");
        nameOfFile = scanner1.next();
        String userWorkingDirectory = System.getProperty("user.dir");
        String fileLocation = userWorkingDirectory + File.separator + nameOfFile;
        System.out.println(fileLocation);
            file = new File(fileLocation);
            file.createNewFile();
        } catch (IOException ioExeception) {
            System.out.println(ioExeception.getMessage());
        }
    }

    public void write() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the No of Lines");
            numberOfLines = scan.nextInt();
            System.out.println("Enter the Text");
            for (int count = 0; count <numberOfLines; count++) {
                Line = scan.next();
                bufferedWriter.write(Line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((read = bufferedReader.readLine()) != null) {
                System.out.println("Text in the File:" + read);
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        NumberOfLines numberOfLines = new NumberOfLines();
        numberOfLines.create();
        numberOfLines.write();
        numberOfLines.read();
    }
}

