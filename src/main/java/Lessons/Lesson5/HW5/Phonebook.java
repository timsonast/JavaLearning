package Lessons.Lesson5.HW5;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static HashMap<String,String> phoneBook = new HashMap<>();

    public static void addPhoneBook(String surname, String number){
        phoneBook.put(number,surname);
    }
    public static void findSurname(String surname) {
        for(Map.Entry<String,String> hm : phoneBook.entrySet()){
            if(surname.equals( hm.getValue())){
                System.out.println(hm.getValue() + " " + hm.getKey());
            }

        }
    }


}
