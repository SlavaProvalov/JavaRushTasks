package com.javarush.task.task15.task1529;

/**
 * Created by Provalov on 21.02.2017.
 */
public class Plane implements Flyable {
    private int passengers;

    public Plane(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public void fly() {

    }
}
