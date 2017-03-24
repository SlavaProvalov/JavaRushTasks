package com.javarush.task.task18.task1825;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// TODO
public class Solution {
    private static int maxNumberOfPart = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<File> list = new ArrayList<>();

//----------------TEST---------------------------
//        maxNumberOfPart = 5;
//        list.add(new File("D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part1"));
//        list.add(new File("D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part2"));
//        list.add(new File("D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part5"));


//        list.add(new File("src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part1"));
//        list.add(new File("src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part2"));
//        list.add(new File("src\\com\\javarush\\task\\task18\\task1825\\lion.avi.part5"));
////-------------------------------------------
//      Reading file's names and adding Files to list
        boolean isCorrectPathExist = false;

        String correctFileName = null;
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end") || fileName.isEmpty()) {
                break;
            }
            if (!isCorrectPathExist) {
                correctFileName = fileName;
                isCorrectPathExist = true;
            }
            if (!fileName.substring(0, (fileName.indexOf(".part")))
                    .equals(correctFileName.substring(0, correctFileName.indexOf(".part")))) {
                continue;
            }

            File file = new File(fileName);
            list.add(file);

            Integer partNumber = getPartNumber(fileName);
            if (partNumber > maxNumberOfPart) {
                maxNumberOfPart = partNumber;
            }
        }
        reader.close();


        File fileOut = getFile(correctFileName);  //Creating file to write in

//      Writing data into file in the right order
        recordingFile(list, fileOut);


    }

    private static void recordingFile(List<File> list, File fileOut) throws IOException {
        if (fileOut != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            for (int i = 0; i <= maxNumberOfPart; i++) {
                for (File file : list) {
                    if (getPartNumber(file.getPath()) == i) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] buffer = new byte[fileInputStream.available()];
                        fileInputStream.read(buffer);
                        fileOutputStream.write(buffer);
                        fileInputStream.close();
                    }
                }
            }
            fileOutputStream.close();
        }
    }


    private static Integer getPartNumber(String fileName) {
        String[] fullFileName = fileName.split("\\\\");
        String[] strings = fullFileName[fullFileName.length - 1].split("\\.");
        return Integer.parseInt(strings[strings.length - 1].substring(4));
    }

    private static File getFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return null;
        }
        StringBuilder fileNameSB = new StringBuilder();
        String[] fullFileName = fileName.split("\\\\");
        for (int i = 0; i < fullFileName.length - 1; i++) {
            fileNameSB.append(fullFileName[i]).append("\\\\");
        }
        String[] strings = fullFileName[fullFileName.length - 1].split("\\.");
        for (int i = 0; i < strings.length - 1; i++) {
            fileNameSB.append(strings[i]);
            if (i != strings.length - 2) {
                fileNameSB.append(".");
            }
        }
        return new File(fileNameSB.toString());
    }

}
