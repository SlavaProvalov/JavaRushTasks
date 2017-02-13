package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        private String name;
        private String surname;
        private int age;
        private String height;
        private boolean sex;
        private String orientation;

        //1
        public Human(int age, String height, boolean sex, String orientation) {
            this.age = age;
            this.height = height;
            this.sex = sex;
            this.orientation = orientation;
        }

        //2
        public Human(String name) {
            this.name = name;
        }

        //3
        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        //4
        public Human(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        //5
        public Human(String name, String surname, int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
        }

        //6
        public Human(String name, String surname, int age, String height, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }

        //7
        public Human(int age, boolean sex) {
            this.age = age;
            this.sex = sex;
        }

        //8
        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        //9
        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        //10
        public Human(int age, String height, boolean sex) {
            this.age = age;
            this.height = height;
            this.sex = sex;
        }
    }
}
