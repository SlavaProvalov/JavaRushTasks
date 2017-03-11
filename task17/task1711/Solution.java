package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1711.Sex.MALE;
import static com.javarush.task.task17.task1711.Sex.FEMALE;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    public static SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int size = args.length - 1;
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 0; i < size; i += 3) {
                        create(args[i + 1], args[i + 2], args[i + 3]);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 0; i < size; i += 4) {
                        update(args[i + 1], args[i + 2], args[i + 3], args[i + 4]);
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 0; i < size; i++) {
                        delete(args[i + 1]);
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 0; i < size; i++) {
                        inform(args[i + 1]);
                    }
                    break;
                }
            }
        }


    }

    public static void create(String name, String sex, String bd) throws ParseException {

        allPeople.add(sex.equals("м") ? Person.createMale(name, inputDateFormat.parse(bd)) :
                Person.createFemale(name, inputDateFormat.parse(bd)));
        System.out.println(allPeople.size() - 1);
    }

    public static void update(String id, String name, String sex, String bd) throws ParseException {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        person.setSex(sex.equals("м") ? MALE : FEMALE);
        person.setBirthDay(inputDateFormat.parse(bd));
    }

    public static void delete(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setBirthDay(null);
        person.setSex(null);
    }

    public static void inform(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.println(person.getName() + " " + (person.getSex() == MALE ? "м" : "ж") +
                " " + outputDateFormat.format(person.getBirthDay()));
    }
}
