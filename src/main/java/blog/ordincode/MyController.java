package blog.ordincode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private ThreadPoolTaskExecutor myExecutor;

    @GetMapping("/task")
    public String task() {
        for (int i = 1; i <= 6; i++) {
            final int number = i;
            myExecutor.execute(
                    () -> {
                        try {
                            job(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        return "end";
    }

    private void job(int i) throws InterruptedException {
        System.out.println("job start " + i);
        Thread.sleep(15000);
        System.out.println("job end " + i);
    }
}
