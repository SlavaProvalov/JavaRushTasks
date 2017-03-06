package com.javarush.task.task13.task1326;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;

/*
Сортировка четных чисел из файла

1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
*/
/*
* D:\JAVA\JavaRushIdeaPlugin\JavaRushTasks\2.JavaCore\src\com\javarush\task\task13\task1326\FileWithNumbersToRead
* */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));


        while (bufferedReader.ready()) {
            int num = Integer.parseInt(bufferedReader.readLine());
            list.add(num);
        }
        ArrayList<Integer> sortedList = sort(list);

        for (Integer integer : sortedList) {
            System.out.println(integer);
        }
        reader.close();
        bufferedReader.close();

    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int min = list.get(i);
            int index = i;
            for (int j = i; j < list.size(); j++) {
                int temp = list.get(j);
                if (temp < min) {
                    min = temp;
                    index = j;
                }
            }
            list.set(index, list.get(i));
            list.set(i, min);
            if (min % 2 == 0) {
                result.add(min);
            }
        }
        return result;
    }
}
