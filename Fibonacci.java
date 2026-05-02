// The Fibonacci sequence is defined by the following rule: The fist two values in
// the sequence are 1 and 1. Every subsequent value is the sum of the two values
// preceding it. Write a Java program that uses both recursive and non recursive
// functions to print the nth value in the Fibonacci sequence.


import java.util.Scanner;

public class Fibonacci{
    public static long fibRecursive(int n) {
        if (n<=2){
            return 1;

        }
        return fibRecursive(n-1)+fibRecursive(n-2);
    }

    public static long fibIterative(int n) {
        if(n<=2){
            return  1;
        }
        long prev=1,curr=1,next;
        for(int i=3;i<=n;i++){
            next=prev+curr;
            prev=curr;
            curr=next;
        }
        return curr;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the n value: ");
        int n=scanner.nextInt();

        System.out.println("nth Fibonacci number using Recursive: "+fibRecursive(n));
        System.out.println("nth Fibonacci number using Iterative: "+fibIterative(n));
    }
}