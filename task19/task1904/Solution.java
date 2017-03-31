package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер

Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String person = fileScanner.nextLine();
            String[] pers = person.split(" ");
            int day = Integer.parseInt(pers[4]);
            int month = Integer.parseInt(pers[5]);
            int year = Integer.parseInt(pers[6]);
            return new Person(pers[2], pers[1], pers[3], new Date(year, month, day));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
