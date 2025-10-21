package lesson11.task2;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



@Getter
@Setter
public class SimpleThreadPool {

    private int sizeThread;
    private volatile boolean exit;
    private final Queue<Runnable> tasks = new LinkedList<>();
    private List<WorkerThread> workers = new ArrayList<>();


    public SimpleThreadPool(int sizeThread) {
        this.sizeThread = sizeThread;
        for (int i = 0; i < sizeThread; i++) {
            var worker = new WorkerThread();
            tasks.add(worker);
            worker.start();
        }
    }

    public void submit(
        Runnable task
    ) {
        tasks.offer(task);
    }

    public void shutdown() {
        exit = true;
        synchronized (tasks) {
            tasks.notifyAll();
        }
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (tasks) {
                    while (tasks.isEmpty() && !exit) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            currentThread().interrupt();
                            return;
                        }
                    }
                    if (exit && tasks.isEmpty()) return;
                    task = tasks.poll();
                }

                try {
                    assert task != null;
                    task.run();
                } catch (RuntimeException e) {
                    System.err.println(getName() + " error: " + e.getMessage());
                }
            }
        }
    }
}
