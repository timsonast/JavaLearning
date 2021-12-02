package Lessons.lesson3;

import java.io.IOException;
import java.net.ServerSocket;

public class Lesson3 {
    public static void main(String[] args) {
        try{
            int x = 10 / 0;
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(8189);
        } catch (IOException e){
            e.printStackTrace();
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
