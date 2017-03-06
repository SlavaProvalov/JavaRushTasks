package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Парсер реквестов

Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URI = reader.readLine();
        reader.close();
        if (URI.equals("") || !URI.startsWith("http://")) {
            throw new IllegalArgumentException();
        }



       /* Scanner scanner = new Scanner(System.in);
        String URI = scanner.next();
        scanner.close();*/
//        String URI = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        String URI = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
//        String URI = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa";

        String[] params = URI.split("\\?")[1].split("&");


        for (String s : params) {
            String[] str = s.split("=");
            System.out.print(str[0] + " ");
        }
        System.out.println();

        for (String s : params) {
            String[] str = s.split("=");
            if (str[0].equals("obj")) {
                if (isNumber(str[1])) {
                    alert(Double.parseDouble(str[1]));
                } else {
                    alert(str[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static boolean isNumber(String str) {
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


