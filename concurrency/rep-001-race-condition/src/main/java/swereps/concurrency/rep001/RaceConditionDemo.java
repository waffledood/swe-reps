package swereps.concurrency.rep001;

public class RaceConditionDemo {
    private static final int THREADS = 2;
    private static final int INCREMENTS_PER_THREAD = 100_000;

    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();
        Thread[] workers = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread worker : workers) {
            worker.start();
        }

        for (Thread worker : workers) {
            worker.join();
        }

        int expected = THREADS * INCREMENTS_PER_THREAD;

        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + counter.getCount());
    }
}
