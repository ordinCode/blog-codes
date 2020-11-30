package blog.ordincode.domain.oneway;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class ProductOneWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<ImageOneWay> images;

    public ProductOneWay() {
    }

    public ProductOneWay(String name, List<ImageOneWay> images) {
        this.name = name;
        this.images = images;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public List<ImageOneWay> getImages() {
        return images;
    }
}
