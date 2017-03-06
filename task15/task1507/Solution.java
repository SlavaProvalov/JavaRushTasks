package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка

Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    //1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    //2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    // 3
    public static void printMatrix() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(j * i * 10);
            }
            System.out.println();
        }
    }

    //4
    public static void printMatrix(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i * j);
            }
            System.out.println();
        }
    }

    //5
    public static void printMatrix(int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(j * i * 10);
            }
            System.out.println();
        }
    }

    //6
    public static void printMatrix(Integer m, Integer n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(j * i);
            }
            System.out.println();
        }
    }

    //7
    public static void printMatrix(Integer m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(j + i * 10);
            }
            System.out.println();

        }
    }

    //    8
    public static void printMatrix(Integer m, Integer n, String string) {
        printMatrix(m, n, (Object) string);
    }

    //    9
    public static void printMatrix(int m, int n, int value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(value);
            }
            System.out.println();
        }
    }

    //    10
    public static void printMatrix(String value) {
        printMatrix(10, 10, (Object) value);
    }
}
