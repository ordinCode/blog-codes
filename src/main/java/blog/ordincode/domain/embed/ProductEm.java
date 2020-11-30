package blog.ordincode.domain.embed;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

import java.util.List;

@Entity
public class ProductEm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @ElementCollection
    @CollectionTable(name = "image_em",
            joinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "list_idx")
    private List<ImageEm> images;

    public ProductEm() {
    }

    public ProductEm(String name, List<ImageEm> images) {
        this.name = name;
        this.images = images;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public List<ImageEm> getImages() {
        return images;
    }
}
