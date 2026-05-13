
import java.util.Iterator;
import java.util.PriorityQueue;

// 8.Write a Java program to perform the following:
// i)Create a PriorityQueue collection and add the following string
// objects(colors) in the order given:
// red , blue, green, yellow, black.
// ii)Use an appropriate iterator, traverse the above PriorityQueue and display
// the contents.
// iii)Remove the elements(string objects(colors)) from the above PriorityQueue
// and display them.

public class PriorityQueueColors {
    public static void main(String[] args) {
        PriorityQueue<String> colors=new PriorityQueue<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");

        System.out.println("Contents of PriorityQueue: ");

        Iterator<String> iterator=colors.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\nRemoving elements from PriorityQueue");

        while(!colors.isEmpty()){
            System.out.println(colors.poll());
        }
    }
}
