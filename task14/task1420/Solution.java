package com.javarush.task.task14.task1420;

/* 
НОД

Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int one, two;
        one = Integer.parseInt(reader.readLine());
        two = Integer.parseInt(reader.readLine());
        System.out.println(greatestCommonDivisor(one, two));


    }

    static int greatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        } else if (a < 0 || b < 0) {
            throw new IllegalArgumentException();
        }
        int greater = a > b ? a : b;
        int lower = a < b ? a : b;
        int x = greater % lower;
        while (x > 0) {
            x = greater % lower;
            greater = lower;
            if (x != 0) {
                lower = x;
            }
        }
        return lower;
    }

}
