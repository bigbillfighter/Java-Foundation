package com.company.chap7seven;

abstract class Contents{
    abstract public int value();
}

interface Destination{
    String readLabel();
}

public class Parcel4 {
    public Destination dest(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel(){return label;}
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Tanzania");
    }
}
