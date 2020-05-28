package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 15:15
 **/
public abstract class AbstractPcFactory {
    abstract Mouse createMouse();
    abstract Keyboard createKeyboard();

}
