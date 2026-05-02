// Write a Java program that prompts the user for an integer and then prints out
// all prime numbers up to that integer.

import java.util.Scanner;


public class SimplePrimes{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n=scanner.nextInt();
        scanner.close();

        System.out.print("Prime Number upto "+ n + ": ");

        for(int num=2;num<=n;num++){
            boolean isPrime=true;

            for (int i=2;i*i<=num;i++){
                if((num%i)==0){
                    isPrime=false;
                    break;
                }
            }

            if(isPrime){
                System.out.print(num+" ");
            }
        }
    }
}