package com.javarush.task.task15.task1522;

/**
 * Created by Provalov on 20.02.2017.
 */
public class Earth implements Planet {
    private static volatile Earth instance;

    private Earth() {
    }

    public static Earth getInstance() {
        Earth localInstance = instance;
        if (localInstance == null) {
            synchronized (Earth.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Earth();
                }
            }
        }
        return localInstance;
    }
}
