package Lessons.lesson1.HW1;

public class Animal_HW1 {
    public static int count = 0;
    private int distance;
    private String name;

    public Animal_HW1(String name) {
        this.name = name;
        Animal_HW1.count++;
    }

    public String getName() {
        return name;
    }

    public void swim(int distance){
        this.distance = distance;
        System.out.println(name + " проплыл " + distance + "м");

    }

    public void run(int distance){
        this.distance = distance;
        System.out.println(name + " пробежал " + distance + "м");
    }
}
