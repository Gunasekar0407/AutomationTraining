package FileHandling;

import java.io.*;
import java.util.Scanner;

public class TwoFiles {
    File fileOne, fileTwo;
    String nameOfFileOne, nameOfFileTwo;
    String lineOne, lineTwo;

    public void fileOne() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Name Your FirstFile");
        nameOfFileOne = scanner1.nextLine();
        String userWorkingDirectoryOne = System.getProperty("user.dir");
        String firstFileLocation = userWorkingDirectoryOne + File.separator + nameOfFileOne;
        System.out.println(firstFileLocation);
        try {
            fileOne = new File(firstFileLocation);
            fileOne.createNewFile();
        } catch (IOException ioExeception) {
            System.out.println(ioExeception.getMessage());
        }
    }

    public void fileTwo() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Name Your SecondFile");
        nameOfFileTwo = scanner2.nextLine();
        String userWorkingDirectoryTwo = System.getProperty("user.dir");
        String secondFileLocation = userWorkingDirectoryTwo + File.separator + nameOfFileTwo;
        System.out.println(secondFileLocation);
        fileTwo = new File(secondFileLocation);
        try {
            fileTwo.createNewFile();
        } catch (IOException ioExeception) {
            System.out.println(ioExeception.getMessage());
        }
    }

    public void writeFirstFile() {
        try {
            FileWriter fileWriter1 = new FileWriter(fileOne);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter1);
            lineOne = "Core Java Training Session";
            while (!lineOne.equals("Exit")) {
                if (lineOne.equals("exit")) {
                    break;
                } else {
                    bufferedWriter.write(lineOne);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void writeSeondFile() {
        try {
            FileWriter fileWriter2 = new FileWriter(fileTwo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2);
            lineTwo = "Core Java Training Session";
            while (!lineTwo.equals("Exit")) {
                if (lineTwo.equals("exit")) {
                    break;
                } else {
                    bufferedWriter.write(lineTwo);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void compareTwoFiles() {
        try {
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileOne));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileTwo));
            String countOne = bufferedReader1.readLine();
            String countTwo = bufferedReader2.readLine();
            boolean areEqual = false;
            while (countOne != null || countTwo != null) {
                if (countOne.equalsIgnoreCase(countTwo)) {
                    areEqual = true;
                } else {
                    areEqual = false;
                    break;
                }
                countOne = bufferedReader1.readLine();
                countTwo = bufferedReader2.readLine();
            }
            if (areEqual) {
                FileWriter fileWriter = new FileWriter("C:\\Users\\gunasekar.dhanapal\\IdeaProjects\\Example\\Output.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String location = "C:\\Users\\gunasekar.dhanapal\\IdeaProjects\\Example\\guna1.txt";
                FileReader reader = new FileReader(location);
                BufferedReader readerOne = new BufferedReader(reader);
                int totalWords = 0;
                String line;
                while ((line = readerOne.readLine()) != null) {
                    if (line.equals(" ")) {
                        break;
                    } else {
                        String words[] = line.split(" ");
                        totalWords = totalWords + words.length;
                    }
                }
                System.out.println("Content in both the files are Same");
                System.out.println("Content in File One:" + lineOne);
                System.out.println("Content in file Two:" + lineTwo);
                System.out.println(" Number of words in reach file:" + totalWords);
                readerOne.close();
                bufferedWriter.write(lineOne);
                bufferedWriter.write(lineTwo);
                bufferedWriter.write("Total No of Words:" + totalWords);
                bufferedWriter.newLine();
                bufferedWriter.close();

            } else {
                System.out.println("File are Different");
            }
            bufferedReader1.close();
            bufferedReader2.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

        public static void main(String[] args) {
        TwoFiles twoFiles = new TwoFiles();
        twoFiles.fileOne();
        twoFiles.fileTwo();
        twoFiles.writeFirstFile();
        twoFiles.writeSeondFile();
        twoFiles.compareTwoFiles();
    }
}
