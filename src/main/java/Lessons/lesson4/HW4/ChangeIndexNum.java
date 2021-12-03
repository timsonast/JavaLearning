package Lessons.lesson4.HW4;

import java.util.Arrays;

public class ChangeIndexNum<T extends Number> {
    private T[] obj;


    public ChangeIndexNum(T...obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }


    public void changeIndexMethod(int firstElement, int secondElement, ChangeIndexNum<?> arr) {
        Number[] a = arr.getObj();
        Number c = a[firstElement];
        Number b = a[secondElement];
        a[firstElement] = b;
        a[secondElement] = c;
    }

    @Override
    public String toString() {
        return "ChangeIndexNum{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}
