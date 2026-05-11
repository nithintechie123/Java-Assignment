
import java.util.InputMismatchException;
import java.util.Scanner;

// 2. Write a class for stack in Java. The class should have the methods,
// push(), pop(), isEmpty(), isFull() and size().Use an array representation
// for the stack. Write a Java program that reads a list of integers, uses
// the above stack methods and displays list of integers in reverse order.
// Program should handle the exceptions that may arise during stack operations.
public class Stack {

    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack Size must be greater than 0.");
        }
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int data) throws Exception {
        if (isFull()) {
            throw new Exception("Stack Overflow Exception: Stack is Full.");
        }
        arr[++top] = data;
        System.out.println(data + " pushed into stack");
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow Exception: Stack is Empty.");
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return;
        }

        System.out.println("\nStack Elements: ");

        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter Stack Size: ");
            int size = sc.nextInt();
            Stack s = new Stack(size);

            System.out.println("Enter number of elements to Push: ");

            int n = sc.nextInt();

            System.out.println("Enter Elements: ");

            for (int i = 0; i < n; i++) {
                try {
                    int value = sc.nextInt();
                    s.push(value);
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException : Please enter integers only");
                    sc.next();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            s.display();

            System.out.println("\n Popped Elements(Reverse Order): ");
            while (!s.isEmpty()) {
                try {
                    System.out.println(s.pop());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                s.pop();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "IllegalArgumentException : "
                    + e.getMessage()
            );
        } catch (InputMismatchException e) {
            System.out.println(
                    "InputMismatchException : Invalid Input"
            );
        } catch (Exception e) {
            System.out.println(
                    "General Exception : " + e.getMessage()
            );
        } finally {
            System.out.println(
                    "\nProgram Executed Successfully"
            );
            sc.close();
        }
    }
}
