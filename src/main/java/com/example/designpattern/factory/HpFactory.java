package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 15:29
 **/
public class HpFactory extends AbstractPcFactory {
    @Override
    Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
