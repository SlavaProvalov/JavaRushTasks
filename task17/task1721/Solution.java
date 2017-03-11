package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            readAndWriteFile(fileName1, allLines);
            readAndWriteFile(fileName2, forRemoveLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution sol = new Solution();
        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    private static void readAndWriteFile(String fileName, List<String> whereToWrite) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (reader.ready()) {
            whereToWrite.add(reader.readLine());
        }
    }

    public synchronized void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
           /* int count = 0;
            for (String line : forRemoveLines) {
                if (allLines.contains(line)) {
                    count++;
                }
            }
            if (count == 0) {*/
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}
//}
