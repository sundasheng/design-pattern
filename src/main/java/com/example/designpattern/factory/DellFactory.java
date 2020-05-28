package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 15:24
 **/
public class DellFactory extends AbstractPcFactory {
    @Override
    Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
