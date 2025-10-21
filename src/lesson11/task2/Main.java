package lesson11.task2;

import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(4);
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            pool.submit(() -> {
                System.out.println(
                    currentThread().getName() + " doing: task " + taskNumber
                );
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    currentThread().interrupt();
                }
            });
        }
        pool.shutdown();
    }
}
