// 1. Write a Java program for creating two threads. One thread should display the
// message, "JAVA" 5 times and another thread should display the message,
// "PROGRAMMING" 10 times. Use any one method for creating threads in Java.

class JavaThread implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("JAVA");
        }
    }
}

class  ProgrammingThread implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("PROGRAMMING");
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        JavaThread t1=new JavaThread();
        ProgrammingThread t2=new ProgrammingThread();

        Thread th1=new Thread(t1);
        Thread th2=new Thread(t2);

        th1.start();
        th2.start();
    }
}
