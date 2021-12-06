package Lessons.Lesson6.HW6;

import java.util.Arrays;

public class HW6 {
    public static void main(String[] args) {
        oneThreadTask();
        twoThreadTask();

    }

    public static void oneThreadTask(){
        final int ARRAY_LENGTH = 1_000_000;
        float[]arr = new float[ARRAY_LENGTH];

        Arrays.fill(arr,1.0f);

        long time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }
    public static void twoThreadTask(){
        final int ARRAY_LENGTH = 1_000_000;
        final int HALF_ARRAY_LENGTH = ARRAY_LENGTH / 2;

        float[]arr = new float[ARRAY_LENGTH];
        Arrays.fill(arr,1.0f);

        long time = System.currentTimeMillis();

        float[] leftArray = new float[HALF_ARRAY_LENGTH];
        float[] rightArray = new float[HALF_ARRAY_LENGTH];

        System.arraycopy(arr,0,leftArray,0,HALF_ARRAY_LENGTH);
        System.arraycopy(arr,HALF_ARRAY_LENGTH,rightArray,0,HALF_ARRAY_LENGTH);

        Thread leftThread = new Thread(() -> {
            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = (float)(leftArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        Thread rightThread = new Thread(() -> {
            for (int i = 0, j = HALF_ARRAY_LENGTH; i < rightArray.length; i++,j++) {
                rightArray[i] = (float)(rightArray[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                        Math.cos(0.4f + j / 2));
            }
        });

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftArray,0,arr,0,HALF_ARRAY_LENGTH);
        System.arraycopy(rightArray,0,arr,HALF_ARRAY_LENGTH,HALF_ARRAY_LENGTH);
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }
}
