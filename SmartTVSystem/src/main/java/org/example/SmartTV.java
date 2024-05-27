package org.example;

public class SmartTV {

    private boolean on;
    private int channel;
    private int volume;

    public SmartTV() {
        this.on = false;
        this.channel = 0;
        this.volume = 0;
    }

    @Override
    public String toString() {
        return "SmartTV{" +
                "on=" + on +
                ", channel=" + channel +
                ", volume=" + volume +
                '}';
    }

    public void turnOn(){
        this.on = true;
        System.out.println("SmartTV ON");
    }

    public void turnOff(){
        this.on = false;
        System.out.println("\nSmarTV OFF");
    }

    public void incrementVolume(){
        if(isOn()){
            this.volume++;
        } else{
            System.out.println("TV is off");
        }
    }

    public void decrementVolume(){
        if(isOn()){
            this.volume--;
        } else{
            System.out.println("TV is off");
        }
    }

    public void setChannel(int newChannel){
        if(isOn()){
            if(newChannel > 0){
                this.channel = newChannel;
            } else{
                System.out.println("CHANNEL INVALID");
            }
        } else{
            System.out.println("TV is off");
        }
    }

    public void changeChannel(char option){
        if(isOn()){
            if(option == '+'){
                this.channel++;
            }else if(option == '-'){
                this.channel--;
            }else{
                System.out.println("Option is invalid");
            }
        }else{
            System.out.println("TV is off");
        }
    }

    public boolean isOn() {
        return on;
    }
}
