package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FileReading {
    File file;
    String fileName, firstFileLocation, userWorkingDirectory;

    public void creatingFile() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Name Your File");
        fileName = scanner1.nextLine();
        userWorkingDirectory = System.getProperty("user.dir");
        firstFileLocation = userWorkingDirectory + File.separator + fileName;
        System.out.println(firstFileLocation);
        try {
            file = new File(firstFileLocation);
            file.createNewFile();
        } catch (IOException ioExeception) {
            System.out.println(ioExeception.getMessage());
        }
    }

    public void writingFile() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String Lines = "Core Java Training Session";
            while (!Lines.equals("Exit")) {
                if (Lines.equals("exit")) {
                    break;
                } else {
                    bufferedWriter.write(Lines);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void readingFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String read;
            while ((read = bufferedReader.readLine()) != null) {
                System.out.println("Words in the File:" + read);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
    public void findingCount() {
        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file))) {
            int numberOfLines = 0;
            int wordCount = 0;
            String currentLine = bufferedReader1.readLine();
            while (currentLine != null) {
                numberOfLines++;
                String[] words = currentLine.split(" ");
                wordCount = wordCount + words.length;
                currentLine = bufferedReader1.readLine();
            }
            System.out.println("Number of Line:" + numberOfLines);
            System.out.println("Number of Words:" + wordCount);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public static void main(String[] args) {
        FileReading fileReading = new FileReading();
        fileReading.creatingFile();
        fileReading.writingFile();
        fileReading.readingFile();
        fileReading.findingCount();
    }
}
