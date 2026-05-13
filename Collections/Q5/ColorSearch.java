// 5. Write a Java program to perform the following:
// i)Create a LinkedList collection containing the following string objects(colors):
// red , blue, green, yellow, black.
// ii)Sort the colors in ascending order and then search for a color(key) in the
// sorted list of colors using binary search. Display appropriate message.

import java.util.Collections;
import java.util.LinkedList;

public class ColorSearch {
    public static void main(String[] args) {

        // Creating LinkedList
        LinkedList<String> colors = new LinkedList<>();

        // Adding color objects
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");

        // Display original list
        System.out.println("Original List:");
        System.out.println(colors);

        // Sorting the list in ascending order
        Collections.sort(colors);

        System.out.println("\nSorted List:");
        System.out.println(colors);

        // Key to search
        String key = "green";

        // Performing binary search
        int result = Collections.binarySearch(colors, key);

        // Displaying result
        if (result >= 0) {
            System.out.println("\nColor \"" + key + "\" found at index: " + result);
        } else {
            System.out.println("\nColor \"" + key + "\" not found.");
        }
    }
}
