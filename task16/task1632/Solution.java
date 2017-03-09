package com.javarush.task.task16.task1632;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        @Override
        public void showWarning() {
            if (this.isAlive()) {
                this.interrupt();
            }
        }
    }

    public static class ThreadFive extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        @Override
        public void run() {
            try {
                ArrayList<Integer> array = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (!isInterrupted()) {
                    String read = reader.readLine();
                    if (read.equals("N")) {
                        int sum = 0;
                        for (int i = 0; i < array.size(); i++) {
                            sum += array.get(i);
                        }
                        System.out.println(sum);
                    } else {
                        array.add(Integer.parseInt(read));
                    }
                }
            } catch (IOException e) {
            }

        }
    }
}