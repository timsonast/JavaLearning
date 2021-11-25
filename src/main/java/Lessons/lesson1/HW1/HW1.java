package Lessons.lesson1.HW1;

public class HW1 {
    public static void main(String[] args) {
        Animal_HW1[] animal = {
            new Cat_HW1("Barsik"),
            new Dog_HW1("Bobik"),
            new Tiger_HW1("ryzhik")
        };

        animal[0].run(150);
        animal[0].swim(10);
        animal[1].run(100);
        animal[1].swim(5);
        animal[2].run(50);
        animal[2].swim(15);

        System.out.println(Animal_HW1.count);

    }
}
