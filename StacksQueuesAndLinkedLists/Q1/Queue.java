// 1. Write a class for queue in Java. The class should have the methods,
// enqueue(), dequeue(), isEmpty(), isFull() and size().Use an array
// representation for the queue. Write a Java program that reads a
// list of integers, uses the above queue methods and displays list of
// integers in first in first out order. Program should handle the
// exceptions that may arise during queue operations.
package StacksQueuesAndLinkedLists.Q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Queue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than 0");
        }

        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int data) throws Exception {
        if (isFull()) {
            throw new Exception("Queue Overflow Exception: Queue is full.");
        }

        rear = (rear + 1) % capacity;

        arr[rear] = data;
        count++;

        System.out.println(data + " inserted into queue");
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue Underflow Exception: Queue is Empty");
        }

        int removedElement = arr[front];

        front = (front + 1) % capacity;
        count--;

        return removedElement;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("\nQueue Elements: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.println(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter Queue Size: ");
            int size = sc.nextInt();

            Queue q = new Queue(size);

            System.out.println("Enter Number of Elements to insert: ");

            int n = sc.nextInt();

            System.out.println("Enter Elements: ");
            for (int i = 0; i < n; i++) {
                try {
                    int value = sc.nextInt();
                    q.enqueue(value);
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Please enter integers only.");
                    sc.next();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            q.display();

            System.out.println("\nCurrent Queue Size: "+ q.size());

            System.out.println("\nDequeued Elements (FIFO Order)");

            while(!q.isEmpty()){
                try {
                    System.out.println(q.dequeue());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                q.dequeue();
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(
                "IllegalArgumentException : "
                + e.getMessage()
            );
        }catch(InputMismatchException e){
             System.out.println(
                "InputMismatchException : Invalid Input"
            );
        }catch(Exception e){
            System.out.println(
                "General Exception : " + e.getMessage()
            );
        }
        finally{
            System.out.println("\nProgram Executed Successfully.");
            sc.close();
        }
    }
}
