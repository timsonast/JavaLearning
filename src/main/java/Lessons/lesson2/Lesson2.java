package Lessons.lesson2;

public class Lesson2 {
    static class Human{
        private Transport currentTransport;

        public void drive (Transport transport) {
            transport.start();
            this.currentTransport = transport;
        }

        public void stop(){
        if (currentTransport != null){
            currentTransport.stop();
            currentTransport = null;
        } else {
            System.out.println("А я никуда и не еду");
            }
        }
    }

    static class Car implements Transport {
        @Override
        public void start() {
            System.out.println("Человек поехал на машине");

        }

        @Override
        public void stop() {
            System.out.println("Человек остановил свою машину");
        }
    }

    static class Skateboard implements Transport{
        @Override
        public void start() {
            System.out.println("Человек покатился на скейтборде");
        }

        @Override
        public void stop() {
            System.out.println("Человек остановил свой скейтборд");
        }
    }

    static class Bicycle implements Transport{
        @Override
        public void start() {
            System.out.println("человек начал ехать на велосипед");
        }

        @Override
        public void stop() {
            System.out.println("Человек остановил свой велосипед");
        }
    }


    public static void main(String[] args) {
        Human human = new Human();
        Car car = new Car();
        human.stop();
        human.drive(car);
        human.stop();



        Flyable [] flyables = {
                new Duck(),
                new Airplane()
        };

        for(Flyable f : flyables){
            f.fly();
        }
    }
}
