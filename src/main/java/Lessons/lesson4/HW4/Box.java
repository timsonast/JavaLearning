package Lessons.lesson4.HW4;

import java.util.ArrayList;


public class Box <T extends Fruit> {
    private ArrayList<T> fruitBox;

    public Box(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public float getWeight(){
        float sum = 0.0f;
        for (T box : fruitBox) {
            sum += box.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> another){
        return this.getWeight() == another.getWeight();
    }

    public void pourFruit(Box<T> another){
        for (T box : fruitBox) {
            another.getFruitBox().add(box);
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitBox=" + fruitBox +
                '}';
    }
}


