package com.example.designpattern.builder;

/**
 * @author sunjing
 * @create 2019-09-26 16:18
 **/
public class HumanBuilderTest {
    public static void main(String[] args) {
        Human human = Human.builder().buildBody("body").buildFoot("foot").buildHand("hand").buildHead("head").build();
        System.out.println(human);
    }
}
