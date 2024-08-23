package Semaphoe;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaPr1BufferProblem {
    private static final int BUFFER_SIZE = 5; // Size of the buffer
    private static final Queue<Integer> buffer = new LinkedList<>(); // Shared buffer

    // Semaphores
    private static final Semaphore empty = new Semaphore(BUFFER_SIZE); // Number of empty slots
    private static final Semaphore full = new Semaphore(0); // Number of filled slots
    private static final Semaphore mutex = new Semaphore(1); // Mutex for mutual exclusion

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    int item = random.nextInt(100); // Produce a random item
                    empty.acquire(); // Wait for an empty slot
                    mutex.acquire(); // Enter critical section

                    buffer.add(item); // Add item to buffer
                    System.out.println("Produced: " + item + ", Buffer: " + buffer);

                    mutex.release(); // Exit critical section
                    full.release(); // Signal that an item is available

                    Thread.sleep(random.nextInt(1000)); // Simulate time taken to produce
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    full.acquire(); // Wait for an item to be available
                    mutex.acquire(); // Enter critical section

                    int item = buffer.poll(); // Remove item from buffer
                    System.out.println("Consumed: " + item + ", Buffer: " + buffer);

                    mutex.release(); // Exit critical section
                    empty.release(); // Signal that a slot is available

                    Thread.sleep(new Random().nextInt(1000)); // Simulate time taken to consume
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}