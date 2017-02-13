package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("sasha", true, 12);
        Human child2 = new Human("lesha", true, 14);
        Human child3 = new Human("lena", false, 16);
        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human mother = new Human("oksana", false, 39, children);
        Human father = new Human("pasha", true, 43, children);

        Human grandpa1 = new Human("mazai", true, 67, mother);
        Human grandma1 = new Human("liza", false, 66, mother);

        Human grandpa2 = new Human("igor", true, 70, father);
        Human grandma2 = new Human("olga", false, 68, father);

        ArrayList<Human> list = new ArrayList<>();
        list.add(grandpa1);
        list.add(grandpa2);
        list.add(grandma1);
        list.add(grandma2);

        list.add(father);
        list.add(mother);

        list.addAll(children);
        for (Human human : list) {
            System.out.println(human);
        }

    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<>();

        public Human() {
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human child) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(child);
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
