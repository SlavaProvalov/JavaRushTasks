package com.javarush.task.task14.task1417;

/**
 * Created by Provalov on 17.02.2017.
 */
public class Hrivna extends Money{
    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
