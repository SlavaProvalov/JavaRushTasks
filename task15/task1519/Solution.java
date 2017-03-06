package com.javarush.task.task15.task1519;

import java.io.*;
import java.util.Iterator;


/* 
Разные методы для разных типов

1. Считать с консоли данные, пока не введено слово «exit«.
2. Для каждого значения, кроме «exit«, вызвать метод print. Если значение:
2.1. содержит точку ‘.‘, то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) {
                break;
            }
            s = s.trim();
            int x;
            if (isNumber(s)) {
                if (s.contains(".") || s.contains("d")) {
                    print((Double) Double.parseDouble(s));
                } else {
                    x = Integer.parseInt(s);
                    if (x < 128 && x > 0) {
                        print((short) x);
                    } else if (x >= 128 || x <= 0) {
                        print((Integer) x);
                    }
                }
            } else {
                print(s);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    public static boolean isNumber(String str) { //TODO
        int counterPoints = 0;
        int counterChars = 0;
        int counterDigits = 0;
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                counterPoints++;
            } else if (str.charAt(i) == 'd' || str.charAt(i) == 'f') {
                counterChars++;
            } else if (Character.isDigit(str.charAt(i))) {
                counterDigits++;
            }

            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.' && str.charAt(str.length() - 1) != 'd' /*&& str.charAt(str.length() - 1) != 'f'*/ && str.charAt(0) != '-')
                return false;
        }
        if (counterPoints < 2 && counterChars < 2 && counterDigits > 0) {
            return true;
        } else return false;
    }
}
