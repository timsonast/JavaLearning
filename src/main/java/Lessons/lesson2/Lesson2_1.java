package Lessons.lesson2;

public class Lesson2_1 {

    class Inner{
        int innerValue;

        public Inner(int innerValue) {
            this.innerValue = innerValue;
        }

        public void innerMethod(){
            System.out.println(innerValue);
            System.out.println(outerValue);
        }
    }

    int outerValue;

    public void outerMethod(){
        System.out.println(outerValue);
    }

    public static void main(String[] args) {

    }
}
