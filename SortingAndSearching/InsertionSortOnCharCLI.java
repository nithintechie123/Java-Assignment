// 8.Write a Java program that sorts a list of characters passed from the command-
// line in ascending order using insertion sort.

package SortingAndSearching;

public class InsertionSortOnCharCLI {

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

    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Please provide names as command-line arguments");
            return;
        }

        char[] arr=new char[args.length];

        for(int i=0;i<args.length;i++){
            arr[i]=args[i].charAt(0);
        }

        insertionSort(arr);

        System.out.println("Sorted Characters after using Insertion Sort:");
        for(char ch:arr){
            System.out.print(ch + " ");
        }

    }
}
