// 7.Write a Java program that sorts a list of names passed from the command-
// line in ascending order using selection sort.

package SortingAndSearching;

public class SelectionSortOnNamesCLI {

    public static void selectionSort(String[] arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            int selectedIndex=i;
            for(int j=i+1;j<n;j++){
                if((arr[j].compareToIgnoreCase(arr[selectedIndex]))<0){
                    selectedIndex=j;
                }
            }
            String temp=arr[selectedIndex];
            arr[selectedIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Please provide names as command-line arguments");
            return;
        }

        selectionSort(args);

        System.out.println("Sorted Names after using Selection Sort:");
        for(String name:args){
            System.out.print(name + " ");
        }

    }
}
