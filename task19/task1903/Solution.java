package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов

Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {
        Smth smth = new Smth("UA", "JavaRush Ltd.", "Ivan", "Ivanov", 38, 501234567);
        IncomeDataAdapter ida = new IncomeDataAdapter(smth);
        System.out.println(ida.getName());
        System.out.println(ida.getCompanyName());
        System.out.println(ida.getCountryName());
        System.out.println(ida.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%2$s, %1$s", data.getContactFirstName(),
                    data.getContactLastName());
        }

        @Override
        public String getPhoneNumber() {
            String ph = String.valueOf(data.getPhoneNumber());
            int cityCode = Integer.parseInt(ph.substring(0, ph.length() - 7));
            String[] number = {ph.substring(ph.length() - 7, ph.length() - 4),
                    ph.substring(ph.length() - 4, ph.length() - 2),
                    ph.substring(ph.length() - 2)};
            return String.format("+%1$d(%2$03d)%3$s-%4$s-%5$s", data.getCountryPhoneCode(), cityCode, number[0], number[1], number[2]);


        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    static class Smth implements IncomeData {
        private String countyCode;
        private String company;
        private String contactFirstName;
        private String contactLastName;
        private int countryPhoneCode;
        private int phoneNumber;

        public Smth(String countyCode, String company, String contactFirstname, String contectLastName, int countryPhoneCode, int phoneNumber) {
            this.countyCode = countyCode;
            this.company = company;
            this.contactFirstName = contactFirstname;
            this.contactLastName = contectLastName;
            this.countryPhoneCode = countryPhoneCode;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String getCountryCode() {
            return countyCode;
        }

        @Override
        public String getCompany() {
            return company;
        }

        @Override
        public String getContactFirstName() {
            return contactFirstName;
        }

        @Override
        public String getContactLastName() {
            return contactLastName;
        }

        @Override
        public int getCountryPhoneCode() {
            return countryPhoneCode;
        }

        @Override
        public int getPhoneNumber() {
            return phoneNumber;
        }
    }
}