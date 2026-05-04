package SortingAndSearching;
// 4.Write a Java program that uses functions to perform the following:
// i)sorts a list of names in ascending order using bubble sort.
// ii)then searches for a key value(name)
// using binary search.


import java.util.Scanner;

public class bubbleSortSearchOnName {


     // ----------------------------------------------------
    // Function to perform Bubble Sort (Ascending Order)
    // ----------------------------------------------------
    public static void bubbleSortOnName(String[] arr){
        int n=arr.length;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){

                if(arr[j].compareTo(arr[j+1])>0){
                    String temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    // ----------------------------------------------------
    // Function to perform Binary Search
    // ----------------------------------------------------
    public static int binarySearch(String[] arr,String key){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid].compareTo(key)==0){
                return mid;
            }else if(arr[mid].compareTo(key)>0){
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

        String[] arr=new String[n];

        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }

        bubbleSortOnName(arr);

        System.out.println("Sorted Elements using BubbleSort: ");
        for(String name:arr){
            System.out.print(name+ " ");
        }

        System.out.println("\nEnter Key Element");
        String key=sc.next();

        int result=binarySearch(arr, key);

        if(result!=-1){
            System.out.println("Element Found using Binary Search");
        }else{
            System.out.println("Element Not Found");
        }
    }
}

