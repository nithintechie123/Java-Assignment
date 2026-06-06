// 4.Write a Java program that reads numbers from a file, sorts them in
// ascending order, and writes them to another file.


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// 4.Write a Java program that reads numbers from a file, sorts them in
// ascending order, and writes them to another file.

public class SortNumbersInFile {
    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("Enter valid arguments(Inputfile and Outputfile) command Line");
            return;
        }

        String inputFile=args[0];
        String outputFile=args[1];

        ArrayList<Integer> numbers=new ArrayList<>();

        try {
            BufferedReader reader=new BufferedReader(new FileReader(inputFile));

            String line;
            while((line=reader.readLine())!=null){
                int number=Integer.parseInt(line);
                numbers.add(number);
            }

            reader.close();

            Collections.sort(numbers);

            BufferedWriter writer=new BufferedWriter(new FileWriter(outputFile));

            for(int n:numbers){
                writer.write(String.valueOf(n));
                writer.newLine();
            }
            writer.close();
            System.out.println("Integers sorted successfully written to output file");
        } catch (Exception e) {
            System.out.println("Error message: "+e.getMessage());
        }
    }
}
