package com.company;

public class TryInnerFromOther {
    public static void main(String[] arg){
        Outer outer = new Outer();
        Outer.Inner i = outer.new Inner();
        i.chain();
    }
}
