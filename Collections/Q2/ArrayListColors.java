
import java.util.ArrayList;
import java.util.ListIterator;

// 2.Write a Java program to perform the following:
// i)Create an ArrayList collection containing the following string objects(colors):
// red , blue, green, yellow, black.
// ii)Use foreach statement that scans above list and outputs the elements(colors).
// iii)Using an appropriate iterator, replace the string, "yellow" with string "purple"
// in the above list.

public class ArrayListColors {
    public static void main(String[] args) {
        ArrayList<String> colors=new ArrayList<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");

        System.out.println("Original ArrayList: ");
        for(String color:colors){
            System.out.println(color);
        }
    
        ListIterator<String> itr=colors.listIterator();

        while(itr.hasNext()){
            String color=itr.next();

            if(color.equals("yellow")){
                itr.set("purple");
            }
        }
        System.out.println("\nArrayList After Replacement: ");

        for(String color:colors){
            System.out.println(color);
        }
    }
}
