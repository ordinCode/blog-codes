package blog.ordincode.repository;

import blog.ordincode.domain.bothway.ImageBothWay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import java.util.List;


public interface ImageBothWayRepository extends JpaRepository<ImageBothWay, Long> {
    @Transactional
    @Modifying
    @Query("delete from ImageBothWay i where i.imageId in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}
