package Lessons.lesson1;

import Lessons.lesson1.animals.Cat;
import Lessons.lesson1.animals.Dog;

public class lesson1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Bobik","black",4);
        Cat cat = new Cat("Cleo","white",4);

        cat.info();
        cat.voice();
        dog.info();
        dog.voice();

        System.out.println(cat);


    }
}
