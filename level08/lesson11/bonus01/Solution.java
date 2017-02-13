package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> monthes = new ArrayList<>();
        String[] m = {"January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "September", "October", "November",
                "December"};
        for (int i = 0; i < m.length; i++) {
            monthes.add(m[i]);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int size = monthes.size();
        for (int i = 0; i < size; i++) {
            String month = monthes.get(i);
            if (line.equalsIgnoreCase(month)) {
                System.out.println(month + " is " + (i + 1) + " month");
            }
        }
    }

}
