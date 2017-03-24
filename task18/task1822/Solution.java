package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла

Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id — int.
productName — название товара, может содержать пробелы, String.
price — цена, double.
quantity — количество, int.

Информация по каждому товару хранится в отдельной строке.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        int id = Integer.parseInt(args[0]);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (fileReader.ready()) {
            String product = fileReader.readLine();
            String[] productData = product.split(" ");
            int productId = Integer.parseInt(productData[0]);
            if (productId == id) {
                StringBuilder productName = new StringBuilder();
                for (int i = 1; i < productData.length - 2; i++) {
                    productName.append(productData[i]);
                    if (i < (productData.length - 3)) {
                        productName.append(" ");
                    }
                }
                double price = Double.parseDouble(productData[productData.length - 2]);
                int quantity = Integer.parseInt(productData[productData.length - 1]);
                System.out.println(productId + " " + productName + " " + price + " " + quantity);
            }
        }
        fileReader.close();
    }
}
