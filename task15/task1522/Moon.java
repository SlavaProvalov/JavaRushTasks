package com.javarush.task.task15.task1522;

/**
 * Created by Provalov on 20.02.2017.
 */
public class Moon implements Planet{
    private static volatile Moon instance;

    private Moon() {
    }

    public static Moon getInstance() {
        Moon localInstance = instance;
        if (localInstance == null) {
            synchronized (Moon.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Moon();
                }
            }
        }
        return localInstance;
    }

}
