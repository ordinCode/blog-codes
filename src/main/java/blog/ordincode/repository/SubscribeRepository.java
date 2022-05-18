package blog.ordincode.repository;

import blog.ordincode.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
    void deleteAllByMemberId(Long memberId);
}
