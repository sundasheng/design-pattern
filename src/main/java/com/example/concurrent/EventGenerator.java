package com.example.concurrent;

/**
 * @author sunjing
 * @create 2019-10-16 14:28
 **/
public class EventGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EventGenerator());
    }
}
