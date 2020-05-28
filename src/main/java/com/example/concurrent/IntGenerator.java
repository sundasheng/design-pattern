package com.example.concurrent;

/**
 * @author sunjing
 * @create 2019-10-16 11:41
 **/
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
