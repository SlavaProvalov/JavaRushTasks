package com.javarush.task.task14.task1413;

/**
 * Created by Provalov on 17.02.2017.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
