// 1. Write a Java program for creating two threads. One thread should display the
// message, "JAVA" 5 times and another thread should display the message,
// "PROGRAMMING" 10 times. Use any one method for creating threads in Java.

class JavaThread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("JAVA");
        }
    }
}

class  ProgrammingThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("PROGRAMMING");
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        JavaThread t1=new JavaThread();
        ProgrammingThread t2=new ProgrammingThread();

        t1.start();
        t2.start();
    }
}
