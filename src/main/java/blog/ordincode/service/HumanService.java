package blog.ordincode.service;

import blog.ordincode.entity.Human;
import blog.ordincode.entity.HumanRepository;
import blog.ordincode.exception.AccidentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HumanService {
    private final HumanRepository humanRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void passOneYear(Long humanId) {
        Human human = humanRepository.findById(humanId).get();
        human.growOld();
        human.growHeight();
    }
}
