package Lessons.lesson2.HW2;

public class Treadmill implements Obstacle {

    private int length;



    Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if(contestant.run(length)){
            System.out.println(contestant.toString() + " пробежал дистанцию!");
            return true;
        }else{
            System.out.println(contestant.toString() + " не пробежал дистанцию");
            return false;
        }

    }
}
