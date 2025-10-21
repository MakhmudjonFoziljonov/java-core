package lesson11.task1;

import java.util.LinkedList;
import java.util.List;

public class MessageService {
    private final List<String> queue = new LinkedList<>();
    private final Object lock = new Object();

    public void publisher(String message) {
        synchronized (lock) {
            queue.add(message);
            lock.notify();
        }
    }

    public String subscriber() throws InterruptedException {
        String message = null;
        synchronized (lock) {
            while (queue.isEmpty()) {
//                System.out.println(Thread.currentThread().getName() + " waiting for new messages");
                lock.wait();
            }
            message = queue.removeFirst();
        }
        return message;
    }
}
