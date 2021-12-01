package Lessons.lesson2.HW2;

public class Robot implements Contestant {

    private int maxRunningDistance;
    private int maxJumpHeight;

    Robot(){
        this.maxRunningDistance = 1000;
        this.maxJumpHeight = 50;
    }


    @Override
    public boolean jump(int distance) {
        if(distance < 0){
            System.out.println(this.toString() + " не умеет закапываться под землю");
            return false;
        }else if(distance >= maxJumpHeight){
            System.out.println("Высота " + distance + "не по плечу" + this.toString());
            return false;
        }else{
            System.out.println(this.toString() + "отлично справился с высотой");
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
            System.out.println(this.toString() + " отлично справился с дистанцией");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
