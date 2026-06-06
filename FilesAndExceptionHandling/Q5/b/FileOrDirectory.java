// b)Write a Java program to check whether a file is ordinary file or directory file.

import java.io.File;

public class FileOrDirectory {
    public static void main(String[] args) {
        
        try{
            //check command line arguments
        if(args.length!=1){
            throw new ArrayIndexOutOfBoundsException();
        }

        String path=args[0];

        //create file object
        File file=new File(path);

        //Check whether file or directory exists
        if(!file.exists()){
            throw new IllegalArgumentException("File or Directory does not exists.");
        }

        //Check ordinary file
        if(file.isFile()){
            System.out.println("It is an ordinary file");
        }
        //Check directory
        else if(file.isDirectory()){
            System.out.println("It is a directory file.");
        }
        //Handles unknown file type
        else{
            System.out.println("Unknown file type.");
        }
    }
    //Handles missing command line argument
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Error: Please provide file or directory name in command line.");
    }
    //Handles invalid path or non-existing file 
    catch(IllegalArgumentException e){
        System.out.println("Error: "+ e.getMessage());
    }
    //Handles permission denied issues
    catch(SecurityException e){
        System.out.println("Permission denied to access the file or directory.");
    }
    //Handles null values
    catch(NullPointerException e){
        System.out.println("Error:  File path is null.");
    }
    //Handles all unexpected exceptions
    catch(Exception e){
        System.out.println("Unexpected Error: "+ e.getMessage());
    }
}
}
