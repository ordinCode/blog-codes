package blog.ordincode.repository;

import blog.ordincode.domain.bothway.ProductBothWay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import java.util.List;

public interface ProductBothWayRepository extends JpaRepository<ProductBothWay, Long> {
    @Query("select distinct p from ProductBothWay p join fetch p.images")
    List<ProductBothWay> findAllFetch();

    @Transactional
    @Modifying
    @Query("delete from ProductBothWay p where p.productId in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}
