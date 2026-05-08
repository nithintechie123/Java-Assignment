// 6.Write a Java program that copies the contents of one file to another file. The
// file names are passed as a command line arguments. The program should
// handle any exceptions that may arise when the file operations are performed.


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException();
            }

            String sourceFile = args[0];
            String destinationFile = args[1];

            // Open source file for reading
            input = new FileInputStream(sourceFile);

            // Open destination file for writing
            output = new FileOutputStream(destinationFile);

            int data;

            // Read and write byte by byte
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            System.out.println("File copied successfully");

        } // Handles missing command line arguments
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please provide source and destination file names.");
        } // Handles file not found
        catch (FileNotFoundException e) {
            System.out.println("Error: Source file does not exist.");
        } // Handles file read/write errors
        catch (IOException e) {
            System.out.println("Error: Problem occurred during file operation.");
        } // Handles permission issues
        catch (SecurityException e) {
            System.out.println("Error: Permission denied to access the file.");
        } // Handles null values
        catch (NullPointerException e) {
            System.out.println("Error: File name is null.");
        } // Handles all unexpected exceptions
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }

                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing files.");
            }
        }
    }
}
