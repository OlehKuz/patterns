package com.patterns;

import  java.util.Date;

public class FactoryMethodApp {

    public static void main(String[] args) {
	    WatchMaker maker = getWatchMakerByName("Digital");
	    Watch watch = maker.createWatch(); // ccилка на інтерфейс і на виробника годинників
        watch.showTime(); // наш клієнтський код не міняється
    }

    public static WatchMaker getWatchMakerByName(String maker){
        if(maker.equals("Digital")) return new DigitalWatchMaker();
        else if (maker.equals("Rome")) return new RomeWatchMaker();
        else{
            throw new RuntimeException("Не поддерживаемая производственная линия часов "+ maker) ;
        }
    }
}



interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime(){ // needs to be public
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    public void showTime(){
        System.out.println("XV - VII");
    }
}

interface WatchMaker{
    // фабричний метод який повертає ссилку на watch
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{ // під кожну реалізацію годинника потрібно створити свого WatchMaker
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new RomeWatch();
    }
}