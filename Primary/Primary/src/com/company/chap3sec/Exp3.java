package com.company.chap3sec;

class GeneralType <Type extends Number>{
    Type obj;
    public GeneralType(Type obj){
        this.obj = obj;
    }
    public Type getObj(){
        return obj;
    }
}

class GeneralMethod{
    <Type> void printClassName(Type obj){
        System.out.println(obj.getClass().getName());
    }
}

class ShowType{
    public void show(GeneralType<?> o){
        System.out.println(o.getObj().getClass().getName());
    }
}

public class Exp3 {
    public static void main(String[] args){
        GeneralType<Integer> t = new GeneralType<Integer>(2);
        GeneralType<Double> d = new GeneralType<Double>(4.3d);
        System.out.println(t.getObj());
        System.out.println((Double) d.getObj());

        GeneralMethod c = new GeneralMethod();
        c.printClassName(3L);
        c.printClassName(3);
        c.printClassName(3.0);
        c.printClassName(3.3f);
        c.printClassName("Hello");
        c.printClassName((Integer)3);

        ShowType st = new ShowType();
        st.show(t);
        st.show(d);
    }
}
