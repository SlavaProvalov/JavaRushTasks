package com.javarush.task.task18.task1826;

import java.io.*;
/* 
Шифровка

Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.
*/

public class Solution {
    public static void main(String[] args) {
        try {
            if (args[0].equals("-e")) {
                encrypt(args[1], args[2]);
            } else if (args[0].equals("-d")) {
                decrypt(args[1], args[2]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* String fileIn = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\fileIn";
        String fileOut = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\fileOut";
        String resultFile = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\resultFile";
        try {
            System.out.println("Crypting file");
            encrypt(fileIn, fileOut);
            System.out.println("Decrypting file");
            decrypt(fileOut, resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    private static void encrypt(String fileIn, String fileOut) throws IOException {
        if (fileIn != null && !fileIn.isEmpty()) {
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                byte encryptedData = (byte) ((data ^ 13) + 1);
                fileOutputStream.write(encryptedData);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }

    }

    private static void decrypt(String fileIn, String fileOut) throws IOException {
        if (fileIn != null && fileOut != null) {
            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                byte decryptedData = (byte) ((data - 1) ^ 13);
                fileOutputStream.write(decryptedData);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

}
