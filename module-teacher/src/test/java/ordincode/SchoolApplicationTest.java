package ordincode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolApplicationTest {
    @Autowired
    private MomService momService;

    @DisplayName("name")
    @Test
    void name() {
        momService.callTheTeacher();
    }
}