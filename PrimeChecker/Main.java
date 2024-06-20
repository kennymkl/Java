import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int LIMIT = 10000000; 
    private static final int NUM_THREADS = 128; 
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[NUM_THREADS];
        int chunkSize = LIMIT / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * chunkSize + 2;
            int end = (i == NUM_THREADS - 1) ? LIMIT : start + chunkSize - 1;
            threads[i] = new Thread(new PrimeChecker(start, end));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%d primes were found.\n", primes.size());
        System.out.printf("Execution time: %d ms\n", endTime - startTime);
    }

    private static synchronized void addPrime(int number) {
        primes.add(number);
    }

    private static class PrimeChecker implements Runnable {
        private int start;
        private int end;

        public PrimeChecker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int currentNum = start; currentNum <= end; currentNum++) {
                if (checkPrime(currentNum)) {
                    addPrime(currentNum);
                }
            }
        }

        private boolean checkPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
