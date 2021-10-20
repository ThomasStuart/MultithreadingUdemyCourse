package ThreadCoordination;


public class ThreadInterruptEx1 {

    public static void main(String[] args){
        Thread thread = new Thread(new BlockingTask() );

        thread.start();

        thread.interrupt();// in order to stop the thread from running when main stops we need this line
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e ){
                System.out.println("Exiting blocking thread");
            }
        }
    }


}
