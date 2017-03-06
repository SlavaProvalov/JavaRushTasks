package com.javarush.task.task15.task1530;

/**
 * Created by Provalov on 21.02.2017.
 */
public abstract class DrinkMaker {

    public abstract void getRightCup();

    public abstract void putIngredient();

    public abstract void pour();

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }


}

