package Lessons.lesson4.HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static <T>ArrayList<T> convertToList(T[]array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
