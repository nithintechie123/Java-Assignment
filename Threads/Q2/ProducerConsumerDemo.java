public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Thread producer = new Thread(new Producer(buffer), "Producer");
        Thread consumer = new Thread(new Consumer(buffer), "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Producer and Consumer have finished.");
    }
}

class SharedBuffer {
    private final int[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public SharedBuffer(int size) {
        buffer = new int[size];
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (count == buffer.length) {
            // Buffer is full, wait until consumer removes an item
            wait();
        }

        buffer[in] = value;
        in = (in + 1) % buffer.length;
        count++;
        System.out.println(Thread.currentThread().getName() + " produced: " + value);

        // Notify the consumer that an item is available
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            // Buffer is empty, wait until producer adds an item
            wait();
        }

        int value = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " consumed: " + value);

        // Notify the producer that there is space available
        notifyAll();
        return value;
    }
}

class Producer implements Runnable {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                Thread.sleep(500); // simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
                Thread.sleep(700); // simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
