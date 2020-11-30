package blog.ordincode.repository;

import blog.ordincode.domain.oneway.ProductOneWay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOneWayRepository extends JpaRepository<ProductOneWay, Long> {
}
