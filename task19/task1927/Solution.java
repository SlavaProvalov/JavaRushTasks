package com.javarush.task.task19.task1927;

/* 
Контекстная реклама

В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: «JavaRush — курсы Java онлайн»

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String advert = "JavaRush — курсы Java онлайн";
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);


        testString.printSomething();

        System.setOut(consoleStream);
        String[] pars = outputStream.toString().split(System.lineSeparator());
        for (int i = 0; i < pars.length; i++) {
            System.out.println(pars[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println(advert);
            }
        }
        outputStream.close();
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
