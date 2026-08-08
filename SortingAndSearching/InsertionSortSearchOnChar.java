//2.Write a Java program that uses functions to perform the following:
// i)sorts a list of characters in ascending order using insertion sort.
// ii)then searches for a key value(character) recursively in the above sorted list
// using binary search.

import java.util.*;

public class InsertionSortSearchOnChar {

    public static void insertionSort(char[] arr){
        int n=arr.length;

        for(int i=1;i<n;i++){
            char key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static int binarySearch(char[] arr,int left,int right,char key){
        if(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==key){
                return mid;
            }else if (arr[mid]>key){
                return binarySearch(arr,left,mid-1,key);
            }else{
                return binarySearch(arr, mid+1, right, key);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();

        char[] arr=new char[n];

        System.out.println("Enter the characters into the array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.next().charAt(0);
        }

        insertionSort(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }

        System.out.print("\nEnter the Key: ");
        char key=sc.next().charAt(0);

        int result=binarySearch(arr, 0, arr.length-1, key);

        if(result==-1){
            System.out.println("Character Not Found in the Array");
        }else{
            System.out.println("Character Found in the Array");
        }
    }
    
}
