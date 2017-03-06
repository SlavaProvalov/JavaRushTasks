package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений

Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
//        1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
//2
        try {
            Integer integer = null;
            integer.toString();
        } catch (Exception e) {
            exceptions.add(e);
        }
//3
        try {
            Object a = "ababa";
            ((Integer) a).intValue();

        } catch (Exception e) {
            exceptions.add(e);
        }
//4
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//5
        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//6
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//7
        try {
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//8
        try {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//9
        try {
            throw new SecurityException();
        } catch (Exception e) {
            exceptions.add(e);
        }
//10
        try {
            throw new NumberFormatException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
