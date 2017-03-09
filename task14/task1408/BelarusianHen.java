package com.javarush.task.task14.task1408;

/**
 * Created by Provalov on 17.02.2017.
 */
public class BelarusianHen extends Hen {
    @Override
    String getDescription() {
        return super.getDescription() + String.format(" Моя страна - %1$s. Я несу %2$d яиц в месяц.", Country.BELARUS, getCountOfEggsPerMonth());
    }

    @Override
    int getCountOfEggsPerMonth() {
        return 20;
    }
}