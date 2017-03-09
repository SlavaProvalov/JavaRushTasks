package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 2;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            float stopTimer = 0.0f;
            try {
                while (!currentThread().isInterrupted()) {
                    if (stopTimer % 1 == 0) {
                        System.out.print(countSeconds + " ");
                        countSeconds--;
                    }
                    Thread.sleep(500);
                    stopTimer = stopTimer + 0.5f;
                    if (countSeconds == 0 && stopTimer < 3.5) {
                        System.out.println("Марш!");
                        currentThread().interrupt();//TODO Why this interrupt() doesn't call InterruptedException?
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}
