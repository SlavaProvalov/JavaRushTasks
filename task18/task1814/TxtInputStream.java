package com.javarush.task.task18.task1814;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileInputStream;

import java.io.IOException;

/* 
UnsupportedFileName

Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        StringBuilder builder = new StringBuilder();
        String[] chars = fileName.split("");
        for (int i = chars.length - 4; i < chars.length; i++) {
            builder.append(chars[i]);
        }
        if (!builder.toString().equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {

    }
}

