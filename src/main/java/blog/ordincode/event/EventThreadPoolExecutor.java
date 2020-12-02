package blog.ordincode.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EventThreadPoolExecutor {
    public static final int maxCore = Runtime.getRuntime().availableProcessors();

    private final ExecutorService threadPoolExecutor;
    private final Semaphore semaphore = new Semaphore(maxCore);

    public EventThreadPoolExecutor() {
        this.threadPoolExecutor = Executors.newFixedThreadPool(maxCore);
    }

    public void submit(Runnable runnable) {
        try {
            semaphore.acquire();
            threadPoolExecutor.submit(() -> execute(runnable));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void execute(Runnable runnable) {
        runnable.run();
        semaphore.release();
    }
}
