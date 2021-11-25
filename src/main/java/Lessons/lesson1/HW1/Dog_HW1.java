package Lessons.lesson1.HW1;

public class Dog_HW1 extends Animal_HW1{

    public Dog_HW1(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if(distance > 500){
            System.out.println("Собака не сможет столько пробежать");
        }else{
            System.out.println(getName() + " пробежал " + distance + "м");
        }
    }

    @Override
    public void swim(int distance) {
        if(distance > 10){
            System.out.println("Собака не сможет столько проплыть");
        }else{
            System.out.println(getName() + " проплыл " + distance + "м");
        }
    }
}
