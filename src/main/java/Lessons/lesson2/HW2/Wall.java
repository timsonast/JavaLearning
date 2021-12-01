package Lessons.lesson2.HW2;

public class Wall implements Obstacle {

    private int height;



    Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if(contestant.run(height)){
            System.out.println(contestant.toString() + " перепрыгнул препятствие!");
            return true;
        }else{
            System.out.println(contestant.toString() + " не перепрыгнул препятствие!");
            return false;
        }

    }
}
