// 1.Write a Java program to perform the following:
// i)Create a LinkedList collection containing the following string objects(colors):
// // red , blue, green, yellow, black.
// ii)Using an iterator, scan the above list and remove all elements(colors) that have
// a string length of less than 5.

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListColors {
    public static void main(String[] args){
        LinkedList<String> colors=new LinkedList<>();

        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");
        
        System.out.println("Original LinkedList:");
        System.out.println(colors);

        System.out.println("\nColors with Length less than 5:");
        Iterator<String> itr=colors.iterator();

        while(itr.hasNext()){
            String color=itr.next();

            if(color.length()<5){
                System.out.println(color);
                itr.remove();
            }
        }

        System.out.println("\nLinkedList After Removal:");
        System.out.println(colors);
    }
}
