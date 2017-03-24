package com.javarush.task.task18.task1820;

/* 
Округление чисел

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = null;
        String fileIn, fileOut;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileIn = reader.readLine();
            fileOut = reader.readLine();

            fileInputStream = new FileInputStream(fileIn);
            fileOutputStream = new FileOutputStream(fileOut);

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            char[] chars = new char[buffer.length];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) buffer[i];
            }
            String bufferString = String.valueOf(chars);
            String[] strings = bufferString.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (!strings[i].equals("")) {
                    double temp = Double.parseDouble(strings[i]);
                    stringBuilder.append(Math.round(temp)).append(" ");
                }
            }
            String result = stringBuilder.toString();
            byte[] b = result.getBytes();
            fileOutputStream.write(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
