package ThreadCreation;

import java.util.ArrayList;
import java.util.List;

public class ThreadCreationDemo {
    public static void main(String [] args ){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //code that will run in a new thread
                System.out.println("We are now in thread "+ Thread.currentThread().getName() );
            }
        });

        System.out.println("We are in thread:  " + Thread.currentThread().getName() + " before starting a new thread ");
        thread.start();// JVM will create a new thread
        System.out.println("We are in thread:  " + Thread.currentThread().getName() + " after starting a new thread ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
