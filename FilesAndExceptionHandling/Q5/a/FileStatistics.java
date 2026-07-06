// a)Write a Java program that counts the number of lines, words, and characters in a text file. The file name is passed as a command line argument. The program should handle any exceptions that may arise

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStatistics {

    public static void main(String[] args) {

        int words = 0;
        int lines = 0;
        int characters = 0;

        try {

            if (args.length != 1) {
                throw new ArrayIndexOutOfBoundsException();
            }

            String fileName = args[0];

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {
                //Count lines
                lines++;

                characters += line.replace(" ","").length();

                //Removes extra spaces and count words only if line is not empty
                if (!line.trim().isEmpty()) {
                    //System.out.println(line);
                    String[] wordArray = line.split("\\s+");
                    
                    words += wordArray.length;
                    //System.out.println(words);
                }

            }
            reader.close();

            System.out.println("Number of Lines: " + lines);
            System.out.println("Number of words: " + words);
            System.out.println("Number of Characters: " + characters);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please provide file name in command line.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File does not exist.");
        } catch (IOException e) {
            System.out.println("Error:Problem occurred while reading the file.");
        } catch (SecurityException e) {
            System.out.println("Error: Permission denied to access the file.");
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
