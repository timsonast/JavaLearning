package Lessons.lesson4.HW4;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static void intArrayToList(int[]array, List<Integer> integerList){
        for(int i : array){
            integerList.add(i);
        }
    }

    public static void doubleArrayToList(double[] array, List<Double> doubleList){
        for(double d : array){
            doubleList.add(d);
        }
    }

    public static void floatArrayToList(float[]array, List<Float> floatList){
        for(float f : array){
            floatList.add(f);
        }
    }

    public static void stringArrayToList(String[]array, List<String> stringList){
        stringList.addAll(Arrays.asList(array));
    }
}
