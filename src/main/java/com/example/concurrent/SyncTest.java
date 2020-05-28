package com.example.concurrent;

import java.util.Calendar;

/**
 * @author sunjing
 * @create 2019-10-11 16:20
 **/
public class SyncTest {


    public synchronized void a() {

        System.out.println("a sleep 5s");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a wake up");


    }

    public void b() {

        System.out.println("b run");

    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        SyncTest syncTest = new SyncTest();
//        new Thread(() ->
//                syncTest.a()
//        ).start();
//        new Thread(() ->
//                syncTest.b()
//        ).start();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,10,26);
        calendar.add(Calendar.DATE,100);
        System.out.println(calendar.getTime());
    }
}
