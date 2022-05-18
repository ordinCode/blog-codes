package blog.ordincode.event;

import blog.ordincode.entity.Subscribe;
import blog.ordincode.repository.SubscribeRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class MemberDeleteEventHandler {
    private final SubscribeRepository subscribeRepository;

    public MemberDeleteEventHandler(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    @Async("threadPoolTaskExecutor")
    @Transactional
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true)
    public void handle(MemberDeleteEvent event) {
        System.out.println("start event handle");
        subscribeRepository.deleteAllByMemberId(event.getMemberId());
        System.out.println("end event handle");
    }
}
