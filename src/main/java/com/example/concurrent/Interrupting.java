package com.example.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunjing
 * @create 2019-10-17 17:02
 **/
class BlockMutex{
    private Lock lock = new ReentrantLock();
    public BlockMutex(){
        lock.lock();
    }
    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted from lock acquisitions");
        }
    }
}

class Blocked2 implements Runnable{

    BlockMutex blocked = new BlockMutex();

    @Override
    public void run() {
        System.out.println("Waiting fro f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}


public class Interrupting {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt");
        t.interrupt();
    }
}

