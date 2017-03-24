package com.javarush.task.task18.task1827;

/* 
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    private static List<String> productList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        if (!args[0].equals("-c")) {
            throw new IllegalArgumentException();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));
        while (fileBufferedReader.ready()) {
            String str = fileBufferedReader.readLine();
            if (!str.isEmpty()) {
                productList.add(str);
            }
        }
        fileBufferedReader.close();

        String id = String.format(("%d"), (maxId() + 1));
        String result = String.format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s", id, args[1], args[2], args[3]);

        productList.add(result);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (String s : productList) {
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.close();

    }

    private static int maxId() {
        int max = 0;
        for (String s : productList) {
            String[] prod = getProduct(s);
            int prodId = Integer.parseInt(prod[0]);
            if (prodId > max) {
                max = prodId;
            }
        }
        return max;
    }

    public static String[] getProduct(String product) {
        if (product == null || product.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] prod = new String[4];
        String id = product.substring(0, 8);
        String productName = product.substring(8, 38);
        String price = product.substring(38, 46);
        String quantity = product.substring(46);
        deleteSpaces(prod, id, 0);
        deleteSpaces(prod, productName, 1);
        deleteSpaces(prod, price, 2);
        deleteSpaces(prod, quantity, 3);
        return prod;
    }

    private static void deleteSpaces(String[] prod, String productName, int index) {
        for (int i = productName.length() - 1; i >= 0; i--) {
            if (productName.charAt(i) != (char) 32) {
                prod[index] = productName.substring(0, i + 1);
                return;
            }
        }
    }
}
