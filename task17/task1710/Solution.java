package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1710.Sex.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c": {
                create(args[1], args[2], args[3]);
                break;
            }

            case "-u": {
                update(args[1], args[2], args[3], args[4]);
                break;
            }

            case "-d": {
                remove(args[1]);
                break;
            }

            case "-i": {
                show(args[1]);
                break;
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
        person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
        person.setBirthDay(inputDateFormat.parse(bd));
    }

    public static void remove(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setBirthDay(null);
        person.setSex(null);
    }

    public static void show(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.println(person.getName() + " " + (person.getSex() == MALE ? "м" : "ж") +
                " " + outputDateFormat.format(person.getBirthDay()));
    }


}
