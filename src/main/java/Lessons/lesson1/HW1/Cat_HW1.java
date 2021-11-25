package Lessons.lesson1.HW1;

public class Cat_HW1 extends Animal_HW1{

    public Cat_HW1(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if(distance > 200){
            System.out.println("Кот не сможет столько пробежать");
        }else{
            System.out.println(getName() + " пробежал " + distance + "м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("кот не умеет плавать!");
    }
}
