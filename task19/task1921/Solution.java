package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
//        -----------------TEST----------------
//        String[] args = {"D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1921\\fileTest"};
//        -------------------------------------
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        while (fileReader.ready()) {
            String[] pars = fileReader.readLine().split(" ");
            int year = Integer.parseInt(pars[pars.length - 1]);
            int month = Integer.parseInt(pars[pars.length - 2]);
            int day = Integer.parseInt(pars[pars.length - 3]);
            String name = getName(pars);
            PEOPLE.add(new Person(name, new Date(year - 1900, month - 1, day)));
        }
        fileReader.close();

    }

    private static String getName(String[] pars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pars.length - 3; i++) {
            builder.append(pars[i]);
            if (i < pars.length - 4) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
