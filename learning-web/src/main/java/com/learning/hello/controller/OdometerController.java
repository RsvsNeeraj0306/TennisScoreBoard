package com.learning.hello.controller;

public class OdometerController {
    private int currentReading;
    private int length;
    
    public OdometerController(int length) {
        this.length = length;
        this.currentReading = 123;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int reading) {
        if (reading >= 0 && reading < length) {
            this.currentReading = reading;
        } else {
            System.out.println("Invalid reading. Reading should be within the valid range.");
        }
    }

    public void getPreviousReading() {
        currentReading = (currentReading - 1 + length) % length;
    }

    public void getNextReading() {
        currentReading = (currentReading + 1) % length;
    }
}


