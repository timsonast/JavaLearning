package Lessons.lesson2.HW2;

public class Cat implements Contestant {


    private int maxRunningDistance;
    private int maxJumpHeight;

    Cat(){
        this.maxRunningDistance = 150;
        this.maxJumpHeight = 2;
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
            System.out.println(this.toString() + "отлично справился с высотой");
            return true;
        }

    }

    @Override
    public boolean run(int distance) {
        if(distance < 0){
            System.out.println(this.toString() + " не умеет бегать задом");
            return false;
        }else if(distance >= maxJumpHeight){
            System.out.println("Дистанция " + distance + " не по плечу " + this.toString());
            return false;
        }else{
            System.out.println(this.toString() + "отлично справился с дистанцией");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
