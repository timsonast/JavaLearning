package Lessons.lesson3.HW3;

public class MyArrayDataException extends NumberFormatException {
    private int row;
    private int column;
    private String value;


    public MyArrayDataException(int row, int column, String[][] array) {
        super("в ячейке [" + row + " : " + column + "] " + "внесены некорректные данные данные");
        this.row = row;
        this.column = column;
        this.value = array[row][column];
    }
}
