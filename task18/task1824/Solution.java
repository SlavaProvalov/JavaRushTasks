package com.javarush.task.task18.task1824;

/* 
Файлы и исключения

Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        String fileName = null;
        try {
            while (true) {
                fileName = reader.readLine();
                fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}
