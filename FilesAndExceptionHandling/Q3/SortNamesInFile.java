// 3.Write a Java program that reads names from a file, sorts them in
// ascending order, and writes them to another file.


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortNamesInFile {
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Enter Valid Arguments in Command Line");
            return;
        }

        String inputFile=args[0];
        String outputFile=args[1];

        ArrayList<String> names=new ArrayList<>();

        try {
            BufferedReader reader=new BufferedReader(new FileReader(inputFile));

            String name;
            while((name=reader.readLine())!=null){
                names.add(name);
            }
            reader.close();
            
            Collections.sort(names);

            BufferedWriter writer=new BufferedWriter(new FileWriter(outputFile));

            for(String n:names){
                writer.write(n);
                writer.newLine();
            }

            writer.close();

            System.out.println("Names sorted successfully and written to output file.");

        } catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
        }
    }
}    

