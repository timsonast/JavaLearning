package Lessons.lesson2;

public enum Month {
    JANUARY(1,"Январь", 31),
    FEBRUARY(2,"Февраль",28),
    MARCH(3,"Март",31),
    APRIL(4,"Апрель",30),
    MAY(5,"Май",31),
    JUNE(6,"Июнь",30),
    JULY(7,"Июль",31),
    AUGUST(8,"Август",31),
    SEPTEMBER(9,"Сентябрь",30),
    OCTOBER(10,"Октябрь",31),
    NOVEMBER(11,"Ноябрь",30),
    DECEMBER(12,"Декабрь",31);

    private int number;
    private String monthRussianName;
    private int day;

    public int getDay() {
        return day;
    }

    public String getMonthRussianName() {
        return monthRussianName;
    }

    public int getNumber() {
        return number;
    }

    Month(int number, String monthRussianName, int day) {
        this.number = number;
        this.monthRussianName = monthRussianName;
        this.day = day;
    }
}
