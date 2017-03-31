package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
//        ---------------TEST------------
//        String[] args = {"D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1920\\fileTest"};
//        -------------------------------
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        while (fileReader.ready()) {
            String[] pars = fileReader.readLine().split(" ");
            String name = pars[0];
            Double salary = Double.parseDouble(pars[1]);
            map.put(name, map.containsKey(name) ? map.get(name) + salary : salary);
        }
        fileReader.close();
        double max = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double salary = entry.getValue();
            if (salary > max) {
                max = salary;
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }
    }
}
