package FilesAndExceptionHandling;

import java.io.*;

public class FileLineNumber {
    public static void main(String[] args) {
        try {
            FileReader fr=new FileReader("sample.txt");

            BufferedReader br=new BufferedReader(fr);

            String line;
            int lineNumber=1;
            while((line=br.readLine())!=null){
                System.out.println(lineNumber+ " : "+line);
                lineNumber++;
            }
            br.close();
        } catch (IOException  e) {
            System.out.println("Error reading file: "+e.getMessage());
        }
    }
    
}
