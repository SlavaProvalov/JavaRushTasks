package com.javarush.task.task19.task1917;

/* 
Свой FileWriter

Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.

При записи данных в файл, должен дублировать эти данные на консоль.
*/

import java.io.*;


public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor descriptor) {
        this.fileWriter = new FileWriter(descriptor);

    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.write(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(char[] chars) throws IOException {
        fileWriter.write(chars);
        System.out.print(chars);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        for (int i = off; i < off + len; i++) {
            System.out.print(str.charAt(i));
        }

    }

    public void close() throws IOException {
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {
        String fileIn = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1917\\fileIn";
        String fileOut = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1917\\fileOut";
        FileInputStream inputStream = new FileInputStream(fileIn);
        FileConsoleWriter consoleWriter = new FileConsoleWriter(fileOut);

        while (inputStream.available() > 0) {
            consoleWriter.write(inputStream.read());
        }
        inputStream.close();
        consoleWriter.close();
    }

}
