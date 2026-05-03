// Write a Java program that uses functions to perform the following:
// i)sorts a list of integers in ascending order using selection sort.
// ii)then searches for a key value(integer) non recursively in the above sorted
// list using binary search.

import java.util.Scanner;

public class SelectionSortBinarySearch {


     // ----------------------------------------------------
    // Function to perform Selection Sort (Ascending Order)
    // ----------------------------------------------------
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int selectedIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[selectedIndex]){
                  selectedIndex=j;
                }
            }
            int temp=arr[selectedIndex];
            arr[selectedIndex]=arr[i];
            arr[i]=temp;
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

        selectionSort(arr);

        System.out.println("Sorted Elements using Selection Sort: ");
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
