package com.javarush.test.level06.lesson08.task03;

/* Класс Util
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра
*/

import com.javarush.test.level06.lesson08.task04.ConsoleReader;

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(sqr(x1 - x2) + sqr(y1 - y2));
    }

    public static double sqr(double x) {
        return x * x;
    }



}
