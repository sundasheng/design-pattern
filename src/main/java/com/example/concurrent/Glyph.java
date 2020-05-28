package com.example.concurrent;

/**
 * @author sunjing
 * @create 2019-10-12 9:57
 **/
public class Glyph {

    void draw(){
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph before draw()");
        draw();
        System.out.println("Glyph after draw");
    }
}
