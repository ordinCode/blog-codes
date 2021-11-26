package blog.ordincode.service;

import blog.ordincode.entity.Human;
import blog.ordincode.entity.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class HumanHandler {
    private final HumanService humanService;

    @Transactional
    public void liveLife(Long humanId) {
        System.out.println("call liveLife");
        IntStream.rangeClosed(1, 3).boxed()
                .forEach(x -> humanService.passOneYear(humanId));
    }
}
