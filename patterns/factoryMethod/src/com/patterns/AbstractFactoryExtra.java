package com.patterns;

public class AbstractFactoryExtra {
    public static void main(String[] args){
        Client client = new Client(new CocaColaFactory());
        client.pourWater();
    }
}
class Client {
    AbstractWater w;
    AbstractBottle b;

    Client(AbstractFactory wtFc){
        w = wtFc.makeWater();
        b = wtFc.makeBottle();
    }
    public void pourWater(){
        b.pour(w);
    }
}

interface AbstractFactory{
    AbstractBottle makeBottle();
    AbstractWater  makeWater();
}

class CocaColaFactory implements AbstractFactory{
    public AbstractBottle makeBottle(){
        return new CocaColaBottle();
    }
    public AbstractWater makeWater(){
        return new CocaColaWater();
    }
}

class PepsiColaFactory implements AbstractFactory{
    public AbstractBottle makeBottle(){
        return new PepsiColaBottle();
    }
    public AbstractWater makeWater(){
        return new PepsiColaWater();
    }
}

abstract class AbstractBottle {
    void pour(AbstractWater w){
        System.out.println(this + " bottle is poured with a water " + w);
    }
}

class PepsiColaBottle extends AbstractBottle{

}

class CocaColaBottle extends AbstractBottle{

}
abstract class AbstractWater{

}

class PepsiColaWater extends AbstractWater{}

class CocaColaWater extends AbstractWater{}