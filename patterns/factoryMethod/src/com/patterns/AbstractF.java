package com.patterns;

public class AbstractF {
    public static void main(String[] args){
        UIdeviceFactory factory = getUIdeviceFactoryByCountry("ENG");
        KeyBoard k = factory.getKeyboard();
        TouchPad t = factory.getTouchPad();
        Mouse m = factory.getMouse();

        m.dblClick();
        t.track(4,8);
        k.print();

    }
    private static UIdeviceFactory getUIdeviceFactoryByCountry(String countryCode){
        switch (countryCode){
            case "RU":
                return new RuUIdeviceFactory();
            case "ENG" :
                return new EngUIdeviceFactory();
            default: throw new RuntimeException("Unsopported country code " + countryCode);
        }
    }
}

interface Mouse{
    void click();
    void dblClick();
    void scroll(int direction);
}

interface KeyBoard{
    void print();
    void println();
}

interface TouchPad{
   void track(int deltaX, int deltaY);
}

interface UIdeviceFactory{
    Mouse getMouse();
    KeyBoard getKeyboard();
    TouchPad getTouchPad();
}

class RuUIdeviceFactory implements UIdeviceFactory{
    @Override
    public KeyBoard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchpad();
    }
}

class EngUIdeviceFactory implements UIdeviceFactory{
    @Override
    public KeyBoard getKeyboard() {
        return new EngKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return new EngMouse();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EngTouchpad();
    }
}

class RuMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Клик");
    }

    @Override
    public void dblClick() {
        System.out.println("Двойной Клик");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("Скролим");
    }
}
class RuKeyboard implements KeyBoard{
    @Override
    public void print() {
        System.out.println("Cтрока");
    }

    @Override
    public void println() {
        System.out.println("Строка с переводом");
    }
}
class RuTouchpad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}

class EngMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dblClick() {
        System.out.println("double click ");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("Scroll");
    }
}

class EngKeyboard implements KeyBoard{
    @Override
    public void print() {
        System.out.println("Line");
    }

    @Override
    public void println() {
        System.out.println("Change line");
    }
}

class EngTouchpad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        System.out.println("shifted by " + s + " pixels");
    }
}