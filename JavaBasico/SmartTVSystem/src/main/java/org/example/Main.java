package org.example;

public class Main {
    public static void main(String[] args) {
        SmartTV Samsung = new SmartTV();
        Samsung.turnOn();
        Samsung.incrementVolume();
        Samsung.incrementVolume();
        Samsung.decrementVolume();
        Samsung.setChannel(7);
        Samsung.changeChannel('+');
        System.out.printf(Samsung.toString());
        Samsung.turnOff();
    }
}