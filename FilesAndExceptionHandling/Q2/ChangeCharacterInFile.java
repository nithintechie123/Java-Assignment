package FilesAndExceptionHandling.Q2;
// 2. Write a Java program to change a specific character in a file. Filename,
// number of the byte in the file to be changed
// specified on the command line.

import java.io.RandomAccessFile;

public class ChangeCharacterInFile {
    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("Provide valid Arguments in command line");
            return;
        }

        String fileName=args[0];
        int position=Integer.parseInt(args[1]);
        char newChar=args[2].charAt(0);

        try {
            RandomAccessFile file=new RandomAccessFile(fileName, "rw");
            
            if(position<0 || position >= file.length()){
                System.out.println("Invalid byte position");
                file.close();
                return;
            }

            file.seek(position);

            file.writeByte(newChar);

            System.out.println("Character Changed Successfully");

            file.close();
            
        } catch (Exception e) {
            System.out.println("Error Message: "+e.getMessage());
        }
    }
}
