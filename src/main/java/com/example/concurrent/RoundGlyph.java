package com.example.concurrent;

/**
 * @author sunjing
 * @create 2019-10-12 10:59
 **/
public class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(),radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(),radius = " + radius);
    }

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
