// 3. Write a Java program that creates three threads. First thread displays "Good
// Morning" every one second, the second thread displays "Hello" every two
// seconds and the third thread displays "Welcome" every three seconds. Use any
// one method for creating threads in Java.


class GoodMorningThread extends Thread {

    public void run() {
        while (true) {
            System.out.println("Good Morning");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class HelloThread extends Thread {

    public void run() {
        while (true) {
            System.out.println("Hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}

class WelcomeThread extends Thread {

    public void run() {

    
        while(true){
        System.out.println("Welcome");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    }
}

public class ThreeThreads {

    public static void main(String[] args) {
        GoodMorningThread t1 = new GoodMorningThread();
        HelloThread t2 = new HelloThread();
        WelcomeThread t3 = new WelcomeThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
