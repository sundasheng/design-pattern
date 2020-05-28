package com.example.concurrent;

import com.sun.glass.ui.Size;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunjing
 * @create 2019-10-25 10:51
 **/
abstract class Accumulator {
    public static long cycles = 5000L;
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 10000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        Random rand = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = rand.nextInt();
        }
    }

    public abstract void accumulate();

    public abstract long read();

    private class Modifier implements Runnable {
        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Reader implements Runnable {
        private volatile long value;

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                value = read();
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void timeTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-13s : %13d\n", id, duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2) {
        System.out.printf("%-22s : %.2f\n", acc1.id + "/" + acc2.id, (double) acc1.duration / (double) acc2.duration);
    }
}

class BaseLine extends Accumulator {
    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        value+=preLoaded[index++];
        if(index>=SIZE) {
            index = 0;
        }
    }

    @Override
    public long read() {
        return value;
    }
}

class SynchronizedTest extends Accumulator{
    {
        id = "synchronized";
    }
    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if(index>= SIZE){
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator{
    {
        id = "LOCK";
    }
    private Lock lock = new ReentrantLock();
    @Override
    public void accumulate() {
        lock.lock();
        try{
            value+=preLoaded[index++];
            if(index>= SIZE){
                index = 0;
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try{
           return value;
        }finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator{
    {
        id = "Atomic";
    }
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);
    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        value.getAndAdd(preLoaded[i]);
        if(++i>SIZE){
            index.set(0);
        }
    }

    @Override
    public long read() {
        return value.get();
    }
}

public class SynchroizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();
    static void test(){
        System.out.println("================================");
        System.out.printf("%-12s : %13d\n","Cycles",Accumulator.cycles);
        baseLine.timeTest();
        synch.timeTest();
        lock.timeTest();
        atomic.timeTest();

        Accumulator.report(synch,baseLine);
        Accumulator.report(lock,baseLine);
        Accumulator.report(atomic,baseLine);
        Accumulator.report(synch,lock);
        Accumulator.report(synch,atomic);
        Accumulator.report(lock,atomic);
    }

    public static void main(String[] args) {
        int iterations = 5;
        System.out.println("Warmup");
        baseLine.timeTest();
        for (int i=0;i<iterations; i++){
            test();Accumulator.cycles*=2;
        }
        Accumulator.exec.shutdown();
    }
}








