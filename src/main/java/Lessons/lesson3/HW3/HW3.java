package Lessons.lesson3.HW3;

public class HW3 {
    public static int arraySum(String[][] arr) {
        if(arr.length !=4){
            throw new MyArraySizeException("неверный размер массива");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length !=4){
                throw new MyArraySizeException("неверный размер массива");
            }
        }
        int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try{
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j,arr);
                    }

                }
            }
            return sum;

    }
    public static void main(String[] args) {
        String [][] arr = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };
        System.out.println(arraySum(arr));

    }
}
