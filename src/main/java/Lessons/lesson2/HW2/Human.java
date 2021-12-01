package Lessons.lesson2.HW2;

public class Human implements Contestant{

    private int maxRunningDistance;
    private int maxJumpHeight;

    Human(){
        this.maxRunningDistance = 15;
        this.maxJumpHeight = 1;
    }


    @Override
    public boolean jump(int distance) {
        if(distance < 0){
            System.out.println(this.toString() + " не умеет закапываться под землю");
            return false;
        }else if(distance >= maxJumpHeight){
            System.out.println("Высота " + distance + " не по плечу " + this.toString());
            return false;
        }else{
            System.out.println(this.toString() + " отлично справился с высотой");
            return true;
        }

    }

    @Override
    public boolean run(int distance) {
        if(distance < 0){
            System.out.println(this.toString() + " не умеет бегать задом");
            return false;
        }else if(distance >= maxRunningDistance){
            System.out.println("Дистанция " + distance + " не по плечу " + this.toString());
            return false;
        }else{
            System.out.println(this.toString() + "отлично справился с дистанцией");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Human";
    }
}
