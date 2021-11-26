package blog.ordincode.service;

import blog.ordincode.entity.Human;
import blog.ordincode.entity.HumanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HumanHandlerTest {
    @Autowired
    private HumanHandler humanHandler;

    @Autowired
    private HumanRepository humanRepository;

    @DisplayName("")
    @Test
    void name() {
        Human born = Human.born();
        Human savedHuman = humanRepository.save(born);

        humanHandler.liveLife(savedHuman.getId());

        Human human = humanRepository.findAll().get(0);
        Assertions.assertThat(human.getAge()).isEqualTo(4);
        Assertions.assertThat(human.getHeight()).isEqualTo(40);
    }
}
