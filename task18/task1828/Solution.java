package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//----------------------------TEST-----------------------------
//        String[] args = {"-u", "16", "ndtyndp", "97", "4"};
//        String[] args = {"-d","12"};

//--------------------------------------------------------------
        if (!args[0].equals("-u") && !args[0].equals("-d")) {
            throw new IllegalArgumentException();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (fileName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        reader.close();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));
        while (fileBufferedReader.ready()) {
            list.add(fileBufferedReader.readLine());
        }
        fileBufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        int id = getId(args[1]);
        for (int i = 0; i < list.size(); i++) {
            if (getId(list.get(i)) == id) {
                switch (args[0]) {
                    case "-u": {
                        String s = String.format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s", args[1], args[2], args[3], args[4]);
                        System.out.println(s.length());
                        list.set(i, s);
                        break;
                    }
                    case "-d": {
                        list.remove(i);
                        break;
                    }
                }
            }
            bufferedWriter.write(String.format("%s%n", list.get(i)));
        }
        bufferedWriter.close();


    }


    private static int getId(String product) {
        if (product.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String id;
        if (product.length() > 8) {
            id = product.substring(0, 8);
        } else {
            id = product;
        }
        for (int i = id.length() - 1; i >= 0; i--) {
            if (id.charAt(i) != (char) 32) {
                return Integer.parseInt(id.substring(0, i + 1));
            }
        }
        return -1;
    }
}
