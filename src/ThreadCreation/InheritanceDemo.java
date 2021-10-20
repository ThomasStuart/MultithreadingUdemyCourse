package ThreadCreation;

public class InheritanceDemo {
    public static void main(String[] args ){
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run(){
            // code that executes a new thread
            System.out.println("Hello from " + Thread.currentThread().getName() );
        }
    }
}
