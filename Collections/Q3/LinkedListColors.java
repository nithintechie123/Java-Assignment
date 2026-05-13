
import java.util.LinkedList;
import java.util.ListIterator;

// 3. Write a Java program to perform the following:
// i)Create a LinkedList collection containing the following string objects(colors):
// red , blue, green, yellow, black.
// ii)Using a ListIterator, scan the above list in the reverse order(ie. from last to
// first) and remove all elements(colors) that have a string length of less than 5.


public class LinkedListColors {
    public static void main(String[] args){
        LinkedList<String> colors=new LinkedList<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");

        System.out.println("Original List:");
        System.out.println(colors);

        ListIterator<String> iterator=colors.listIterator(colors.size());

        while(iterator.hasPrevious()){
            String color=iterator.previous();
            if(color.length()<5){
                iterator.remove();
            }
        }
        
        System.out.println("List after removing elements with length less than 5:");
        System.out.println(colors);

    }
}
