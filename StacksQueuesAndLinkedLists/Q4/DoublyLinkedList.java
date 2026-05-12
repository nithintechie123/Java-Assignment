
import java.util.Scanner;

// Write Java program that uses functions to perform the following operations:
// a)create a doubly linked list of integers.
// b)traverse the above list and display its contents.
// c)search and delete an integer from the above list and display the contents
// of the list after deletion.

class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}

public class DoublyLinkedList {
    Node head=null;

    public void create(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
        }
    }

    public void traverse(){
        if(head==null){
            System.out.println("Doubly Linked List is Empty.");
            return;
        }
        Node temp=head;
        System.out.println("\nDoubly Linked List Elements: ");
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void searchAndDelete(int key){
        if(head==null){
            System.out.println("Doubly Linked List is Empty.");
            return;
        }

        Node temp=head;
        while(temp!=null && temp.data!=key){
            temp=temp.next;
        }

        if(temp==null){
            System.out.println(key+ " not found in the list");
            return;
        }

        if(temp==head){
            head=temp.next;
            if(head!=null){
                head.prev=null;
            }
        }else{
            temp.prev.next=temp.next;
            if(temp.next!=null){
                temp.next.prev=temp.prev;
            }
        }
        System.out.println(key+ " deleted from the list");
    }

    public static void main(String[] args){
            Scanner sc=new Scanner(System.in);

            DoublyLinkedList list=new DoublyLinkedList();

            System.out.println("Enter the number of Elements: ");
            int n=sc.nextInt();

            System.out.println("Enter Elements: ");
            for(int i=0;i<n;i++){
                int value=sc.nextInt();
                list.create(value);
            }

            list.traverse();

            System.out.println("\nEnter Element to Search and Delete: ");
            int key=sc.nextInt();

            list.searchAndDelete(key);

            System.out.println("\nDoubly Linked List After Deletion:");

            list.traverse();
            sc.close();
        }
}
