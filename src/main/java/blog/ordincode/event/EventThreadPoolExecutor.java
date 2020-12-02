package blog.ordincode.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventThreadPoolExecutor {
    public static final int MAX_CORE = Runtime.getRuntime().availableProcessors();

    private final ExecutorService threadPoolExecutor;

    public EventThreadPoolExecutor() {
        this.threadPoolExecutor = Executors.newFixedThreadPool(MAX_CORE);
    }

    public void submit(Runnable runnable) {
        threadPoolExecutor.submit(runnable);
    }
}
