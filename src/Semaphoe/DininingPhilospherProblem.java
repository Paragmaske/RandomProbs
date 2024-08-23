package Semaphoe;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ChopStick {
    private Lock lock;

    ChopStick() {
        lock = new ReentrantLock();
    }

    public boolean pickup() {
        return lock.tryLock();
    }

    public void putDown() {

    }
}

class Philospher extends Thread {
    ChopStick left;
    ChopStick right;
    String name;

    @Override
    public void run() {
        eat();
    }

    Philospher(String name,ChopStick left,ChopStick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    void eat() {
        while (true) {
            if (left.pickup()) {
                if (right.pickup()) {
                    try {
                        System.out.println(this.name + "is eating noodles");
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    } finally {
                        right.putDown();
                        left.putDown();
                    }

                } else {
                    left.putDown();
                }

            }
        }
    }
}

public class DininingPhilospherProblem {
    public static void main(String[] args) {
Scanner sc =new Scanner(System.in);
        System.out.println("Enter no of philosophers on the table");
        int philosphers=sc.nextInt();


        ChopStick[] chopSticks=new ChopStick[philosphers];
        Philospher[] phils=new Philospher[philosphers];


        for(int i=0;i<philosphers;i++)
        {
            chopSticks[i]=new ChopStick();
        }

        for(int i=0;i<philosphers;i++)
        {
            phils[i]=new Philospher(" Philospher"+(i+1),chopSticks[i],chopSticks[(i+1)%philosphers]);
            phils[i].start();
        }
        }
}
