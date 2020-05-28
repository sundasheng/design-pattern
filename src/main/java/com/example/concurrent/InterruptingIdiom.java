package com.example.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author sunjing
 * @create 2019-10-18 10:16
 **/
class NeedCleanup{
    private final int id;

    NeedCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " +id);
    }

    public void cleanup(){
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable{

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 1;i<2500000;i++){
                            d = d+(Math.PI+Math.E)/d;
                        }
                        System.out.println("Finished time-consuming operation");
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(10000);
        t.interrupt();
    }

}
