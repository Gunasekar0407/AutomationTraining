package FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    boolean result;
    public void create(){
        File file=new File("D:\\Guna\\FileHandling\\CreateFile.txt");
        try
        {
            result = file.createNewFile();  //creates a new file
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();    //prints exception if any
        }
    }
        public void writer() throws IOException {
            System.out.println("Content");
            FileWriter fileWriter =new FileWriter(String.valueOf(result));
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            Scanner scanner=new Scanner(System.in);
            String Lines=" ";
            while (!Lines.equals("Exit")){
                Lines=scanner.nextLine();
                if (Lines.equals("exit")){
                    break;
                }else {
                    bufferedWriter.write(Lines);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    public static void main(String[] args) throws IOException {
        CreateFile createFile=new CreateFile();
        createFile.create();
        createFile.writer();
    }
}
