class Buffer {

    int data;
    boolean available = false;

    // Producer adds data
    synchronized void produce(int value) {

        // Wait if buffer already has data
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        data = value;
        available = true;

        System.out.println("Produced: " + data);

        // Notify consumer
        notify();
    }

    // Consumer removes data
    synchronized void consume() {

        // Wait if buffer is empty
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed: " + data);

        available = false;

        // Notify producer
        notify();
    }
}


// Producer Thread
class Producer extends Thread {

    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}


// Consumer Thread
class Consumer extends Thread {

    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}


// Main Class
public class ProducerConsumerDemo {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}