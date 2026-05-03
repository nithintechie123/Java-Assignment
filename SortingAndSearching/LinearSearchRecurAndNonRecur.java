// 6.Write a Java program that uses recursive and non recursive functions to search
// for an integer key in a list of integers using linear search.

package SortingAndSearching;

import java.util.Scanner;

public class LinearSearchRecurAndNonRecur {

    //Linear Search Non-Recursive Method
    public static int linearSearchIterative(int[] arr,int key) {
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    //Linear Search Recursive Method
    public static int linearSearchRecursive(int[] arr,int key,int index){
        //base case
        if(index>arr.length){
            return -1;
        }

        if(arr[index]==key){
            return index;
        }

        return linearSearchRecursive(arr, key, index+1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();

        int[] arr=new int[n];

        System.out.println("Enter the elements into the array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the key element: ");
        int key=sc.nextInt();

        System.out.println("Menu:\n1.Iterative Method\n2.Recursive Method");
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();


        switch (choice) {
            case 1:
                //Iterative Function Invoke
                int resultIterative=linearSearchIterative(arr, key);
                if(resultIterative==-1){
                    System.out.println("Key Element Not Found");
                }else{
                    System.out.println("Key Element Found using Iterative Linear Search at index: "+resultIterative);
                }
                break;
            case 2:
                //Invoking Recursive Method
                int resultRecursive=linearSearchRecursive(arr, key, 0);
                if(resultRecursive==-1){
                    System.out.print("Key Element Not Found");
                }else{
                    System.out.print("Key Element Found using Recursive Linear Search at index: "+resultRecursive);
                }
            default:
                break;
        }
    }
}
