package Lessons.lesson4.HW4;

import java.util.ArrayList;
import java.util.Arrays;

public class HW4 {

    public static void main(String[] args) {
        ChangeIndexNum<Integer> array = new ChangeIndexNum<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        try {
            array.changeIndexMethod(0, 1, array);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println(array.toString());
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> integers = ArrayToList.convertToList(arr);
        System.out.println(integers);

        Box<Apple> appleBox = new Box<>(new ArrayList<>(Arrays.asList(
                new Apple(1.2f),
                new Apple(1.0f))));
        float weightApple = appleBox.getWeight();
        System.out.println(weightApple);

        Box<Apple> appleBox2 = new Box<>(new ArrayList<>(Arrays.asList(
                new Apple(1.2f),
                new Apple(1.0f))));
        if(appleBox.compare(appleBox2)){
            System.out.println("Коробки одинаковые по весу");
        }else{
            System.out.println("Коробки разные по весу");
        }
        Box<Apple> appleBox3 = new Box<>(new ArrayList<>());
        appleBox2.pourFruit(appleBox3);
        System.out.println(appleBox2.toString());
        System.out.println(appleBox3.toString());
    }
}
