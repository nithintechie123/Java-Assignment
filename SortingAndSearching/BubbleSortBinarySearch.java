// Write a Java program that uses functions to perform the following:
// i)sorts a list of integers in ascending order using bubble sort.
// ii)then searches for a key value(integer) non recursively in the above sorted
// list using binary search.

import java.util.Scanner;

public class BubbleSortBinarySearch {


     // ----------------------------------------------------
    // Function to perform Bubble Sort (Ascending Order)
    // ----------------------------------------------------
    public static void bubbleSort(int[] arr){
        int n=arr.length;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){

                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    // ----------------------------------------------------
    // Function to perform Binary Search
    // ----------------------------------------------------
    public static int binarySearch(int[] arr,int key){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
    return -1;
    }

    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of elements to be entered in the array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];

        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        bubbleSort(arr);

        System.out.println("Sorted Elements using BubbleSort: ");
        for(int num:arr){
            System.out.print(num+ " ");
        }

        System.out.println("\nEnter Key Element");
        int key=sc.nextInt();

        int result=binarySearch(arr, key);

        if(result!=-1){
            System.out.println("Element Found using Binary Search");
        }else{
            System.out.println("Element Not Found");
        }
    }
}
