package Lessons.lesson4;

public class Lesson4 {
    public static void main(String[] args) {
        GenBox<String> strBox = new GenBox<>("Java");
        GenBox<Integer> intBox1 = new GenBox<>(10);
        GenBox<Integer> intBox2 = new GenBox<>(10);
        int sum = intBox1.getObj() + intBox2.getObj();
        System.out.println(sum);
    }
}
