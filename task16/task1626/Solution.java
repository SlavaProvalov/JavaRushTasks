package com.javarush.task.task16.task1626;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Date;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();

        new Thread(new CountUpRunnable(), "Увеличиваем").start();

    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = 1;

        @Override
        public void run() {
            try {

                while (true) {
                    System.out.println(toString());
                    countIndexUp++;
                    Thread.sleep(500);
                    if (countIndexUp > number) {
                        return;
                    }

                }

            } catch (InterruptedException e) {
            }

        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() +
                    ": " + countIndexUp;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {

                while (true) {
                    System.out.println(toString());
                    countIndexDown--;
                    Thread.sleep(500);
                    if (countIndexDown < 1) {
                        return;
                    }


                }

            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
