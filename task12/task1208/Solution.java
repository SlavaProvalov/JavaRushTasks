package com.javarush.task.task12.task1208;

/* 
Пять методов print с разными параметрами
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static void print() {
        System.out.println("empty");
    }

    public static void print(int a) {
        System.out.println(a);
    }

    public static void print(int a, int b) {
        System.out.println(a + b);
    }

    public static void print(String a) {
        System.out.println(a);
    }

    public static void print(String a, int b) {
        System.out.println(a + b);
    }
}
