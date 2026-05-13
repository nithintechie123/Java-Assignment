
import java.util.Iterator;
import java.util.TreeSet;

// Write a Java program to perform the following:
// i)Create a TreeSet collection containing the following string objects(colors):
// red , blue, green, yellow, black.
// ii)Use an appropriate iterator, traverse the above TreeSet and display the
// contents.

public class TreeSetColors {
    public static void main(String[] args) {
        TreeSet<String> colors=new TreeSet<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");

        Iterator<String> iterator=colors.iterator();

        System.out.println("Colors in TreeSet: ");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
