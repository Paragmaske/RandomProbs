package Semaphoe;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;

public class Semaphoretest {
    public static void main(String[] args) {
        Semaphore semaphore  = new Semaphore(3);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("INSIDE THE RUN " +Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    semaphore.release();
                }
            }
        };

        Thread[] threads  = new Thread[10];
        for(int i=0 ;i< 10;i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
    }
}
