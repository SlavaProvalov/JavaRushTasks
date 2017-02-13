package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int maximum = Integer.parseInt(reader.readLine());
        int temp;
        for (int i = 0; i < n - 1; i++) {
            temp = Integer.parseInt(reader.readLine());
            maximum = max(temp, maximum);
        }


        System.out.println(maximum);


    }

    private static int max(int a, int b) {
        return a > b ? a : b;

    }
}