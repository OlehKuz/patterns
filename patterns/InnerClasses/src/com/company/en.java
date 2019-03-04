package com.company;

public class en {
    enum  Apples_enum {
        GOLDEN, GALA, FUJI;
    }
    public static void printApple(Apples_enum apple) {
        System.out.println("This is apple: " + apple);
    }

    public static void main(String[] arg){
        for (Apples_enum apple:Apples_enum.values()) {
            printApple(apple);
        }
    }
}
