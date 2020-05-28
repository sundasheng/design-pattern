package com.example.designpattern.builder;

/**
 * @author sunjing
 * @create 2019-09-26 16:11
 **/
public class Human {
    private String head;
    private String body;
    private String hand;
    private String foot;

    public static HumanBuilder builder(){
        return new HumanBuilder();
    }

    public static class HumanBuilder{
        private String head;
        private String body;
        private String hand;
        private String foot;

        public HumanBuilder buildHead(String head){
            this.head = head;
            return this;
        }

        public HumanBuilder buildBody(String body){
            this.body = body;
            return this;
        }
        public HumanBuilder buildHand(String hand){
            this.hand = hand;
            return this;
        }
        public HumanBuilder buildFoot(String foot){
            this.foot = foot;
            return this;
        }

        public Human build(){
            return new Human(head,body,hand,foot);
        }
    }

    public Human(String head, String body, String hand, String foot) {
        this.head = head;
        this.body = body;
        this.hand = hand;
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Human{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", hand='" + hand + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
