package com.javarush.task.task19.task1914;

/* 
Решаем пример

В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + — *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов — нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String resultString = outputStream.toString();

        String tempString = resultString.replaceAll(" ", "");
        String[] arguments = tempString.split("\\p{Punct}");
        System.setOut(consoleStream);
        int a = Integer.parseInt(arguments[0]);
        int b = Integer.parseInt(arguments[1]);

        if (resultString.contains("+")) {
            System.out.println(resultString + (a + b));
        } else if (resultString.contains("-")) {
            System.out.println(resultString + (a - b));
        } else if (resultString.contains("*")) {
            System.out.println(resultString + (a * b));
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

