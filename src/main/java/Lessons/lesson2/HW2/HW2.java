package Lessons.lesson2.HW2;

import java.util.ArrayList;
import java.util.List;

public class HW2 {

    public static void main(String[] args) {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(200));
        obstacles.add(new Wall(10));
        obstacles.add(new Treadmill(50));

        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Cat());
        contestants.add(new Robot());
        contestants.add(new Human());

        for(Contestant contestant : contestants){
            for(Obstacle obstacle : obstacles){
                if(!obstacle.contest(contestant)) break;
            }
        }
    }
}
