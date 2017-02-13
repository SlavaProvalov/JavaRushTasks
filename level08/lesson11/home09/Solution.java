package com.javarush.test.level08.lesson11.home09;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isDateOdd(String date) {
        Date newYearDate = new Date();

        newYearDate.setHours(0);
        newYearDate.setMinutes(0);
        newYearDate.setSeconds(0);
        newYearDate.setDate(1);
        newYearDate.setMonth(0);

        Date currentDate = new Date(date);
        int daycount = (int) ((currentDate.getTime() - newYearDate.getTime()) / (24 * 60 * 60 * 1000));
        if (daycount % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
