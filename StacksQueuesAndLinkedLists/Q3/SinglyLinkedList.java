
import java.util.Scanner;


// 3. Write Java program that uses functions to perform the following operations:
// a)create a singly linked list of integers.
// b)traverse the above list and display its contents.
// c)search and delete an integer from the above list and display the contents
// of the list after deletion.
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head = null;

    public void create(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node temp = head;
        System.out.println("\nLinked List Elements: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void searchAndDelete(int key) {
        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            System.out.println(key + " deleted from the linked list.");
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(key + " not found in the list.");
            return;
        }

        prev.next = temp.next;
        System.out.println(key + " deleted from the list.");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SinglyLinkedList list=new SinglyLinkedList();

        System.out.println("Enter Number of Elements: ");

        int n=sc.nextInt();
        System.out.println("Enter Elements: ");

        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.create(value);
        }

        list.traverse();

        System.out.println("\nEnter Element to Search and Deleter: ");


        int key=sc.nextInt();

        list.searchAndDelete(key);

        System.out.println("\nLinked List after Deletion: ");

        list.traverse();
        sc.close();
    }
}
