package SortingAndSearching;

// Write a Java program that sorts a list of integers passed from the command-
// line in ascending order using bubble sort.

public class BubbleSortCLI {
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

    public static void main(String[] args) {
        
        if(args.length==0){
            System.out.println("Please provide integers as command-line arguments.");
        }

        int [] arr=new int[args.length];

        for(int i=0;i<args.length;i++){
            arr[i]=Integer.parseInt(args[i]);
        }

        bubbleSort(arr);

        //Display Bubble Sort

        System.out.println("Sorted Elements after using Bubble Sort:");
        for(int num:arr){
            System.out.print(num+ " ");
        }
    }

}
