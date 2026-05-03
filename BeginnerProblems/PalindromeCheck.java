
import java.util.Scanner;


public class PalindromeCheck {
    public static boolean isPalindromeIterative(String str){
        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str,int left,int right){
        if(left>=right){
            return true;
        }

        if(str.charAt(left)!=str.charAt(right)){
            return  false;
        }

        return isPalindromeRecursive(str, left+1, right-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String input=sc.nextLine();

        input=input.toUpperCase();

        if(isPalindromeIterative(input)){
                System.out.println("Iterative: It is a Palindrome");
        }else{
                System.out.println("Iterative: Not a Palindrome");
        }

        if(isPalindromeRecursive(input, 0, input.length()-1)){
                System.out.println("Recursive: It is a Palindrome");
        }else{
                System.out.println("Recursive: Not a Palindrome");
        }

    }
}
