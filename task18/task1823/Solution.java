package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (reader.ready()) {
            String s = reader.readLine();
            if (s.equals("exit")) {
                break;
            }
            ReadThread thread = new ReadThread(s);
            thread.start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileInputStream fileInputStream = null;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
            fileInputStream = new FileInputStream(fileName);
        }

        @Override
        public void run() {
            try {
                Map<Integer, Integer> countBytes = new HashMap<>();
                int max = 0;
                Integer index = 0;
                while (fileInputStream.available() > 0) {
                    Integer data = fileInputStream.read();
                    countBytes.put(data, countBytes.containsKey(data) ? countBytes.get(data) + 1 : 1);
                    Integer temp = countBytes.get(data);
                    if (temp > max) {
                        max = temp;
                        index = data;
                    }
                }
                resultMap.put(fileName, index);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
