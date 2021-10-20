package ThreadCreation;

public class ThreadCapabilities {


    public static void main(String [] args ){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //code that will run in a new thread
                System.out.println("We are now in thread "+ Thread.currentThread().getName() );
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority() );
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread:  " + Thread.currentThread().getName() + " before starting a new thread ");
        thread.start();// JVM will create a new thread
        System.out.println("We are in thread:  " + Thread.currentThread().getName() + " after starting a new thread ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ErrorHandling(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //code that will run in a new thread
                throw new RuntimeException("International Exception");
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);


        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName() + e.getMessage() );
            }
        });

        thread.start();

    }
}
