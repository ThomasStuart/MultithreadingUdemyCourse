package ThreadCoordination;

import java.math.BigInteger;

/*
     Demo. Even though the interrupt is called in main the LongComputation will not stop running.  In order to stop the
     thread we need to add an if statement in the computation pow function.
 */
public class ThreadInterruptEx2 {

        public static void main(String[] args) {
            Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000")));

            thread.start();
            thread.interrupt();
        }

        private static class LongComputationTask implements Runnable {
            private BigInteger base;
            private BigInteger power;

            public LongComputationTask(BigInteger base, BigInteger power) {
                this.base = base;
                this.power = power;
            }

            @Override
            public void run() {
                System.out.println(base + "^" + power + " = " + pow(base, power));
            }

            private BigInteger pow(BigInteger base, BigInteger power) {
                BigInteger result = BigInteger.ONE;

                for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Prematurely interrupted computation");
                        return BigInteger.ZERO;
                    }
                    result = result.multiply(base);
                }

                return result;
            }
        }
}
