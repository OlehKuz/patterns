package com.company;


public class Outer {
    private String s;
    Outer(){
        s = "abracadabra";
    }
    class Inner{
        public void chain(){
            System.out.println("Inner class");
        }
        public String toString(){
            return s;
        }
    }
    private Inner inner(){
        return new Inner();
    }

    public static void main(String[] arg){
        Outer outer = new Outer();
        Inner i = outer.inner();
        i.chain();
        System.out.println(i.toString());
    }
}
