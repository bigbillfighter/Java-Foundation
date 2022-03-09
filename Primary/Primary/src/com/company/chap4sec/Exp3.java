package com.company.chap4sec;

abstract class Vechicle{
    String type;
    public Vechicle(){}
    public Vechicle(String t){type = t;}
    public abstract void driveByMale();
    public abstract void driveByFemale();
}

class Car extends Vechicle {
    public Car(){type="Car";}
    public void driveByMale(){
        System.out.println("Car drived by male");
    }
    public void driveByFemale(){
        System.out.println("Car drived by female");
    }
}

class Bus extends Vechicle {
    public Bus(){type="Bus";}
    public void driveByMale(){
        System.out.println("Bus drived by male");
    }
    public void driveByFemale(){
        System.out.println("Bus drived by female");
    }
}

abstract class Driver{
    public abstract void drive(Vechicle v);
}

class Male extends Driver {
    public void drive(Vechicle v){
        v.driveByMale();
    }
}

class Female extends Driver {
    public void drive(Vechicle v){
        v.driveByFemale();
    }
}

public class Exp3 {
    public static void main(String[] args){
        Driver a = new Male();
        Driver b = new Female();
        Vechicle x = new Car();
        Vechicle y = new Bus();
        a.drive(x);
        b.drive(y);
    }
}
