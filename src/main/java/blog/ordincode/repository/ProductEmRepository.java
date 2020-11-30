package blog.ordincode.repository;

import blog.ordincode.domain.embed.ProductEm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEmRepository extends JpaRepository<ProductEm, Long> {
}
