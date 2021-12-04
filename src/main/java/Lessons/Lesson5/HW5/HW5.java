package Lessons.Lesson5.HW5;

import java.util.*;

public class HW5 {
    public static void main(String[] args) {
        String [] strings = {"cat","dog","cat","bear","milk","good","dog","spring","java","human","human","gold"};
        Set<String> set = new HashSet<>(new ArrayList<>(Arrays.asList(strings)));
        System.out.println(set);
        HashMap<String, Integer> map = new HashMap<>();

        for (String t : strings) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);

            } else {
                map.put(t, 1);
            }
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Количество повторений слова " + key + " равно " + map.get(key) );
        }



    }
}
