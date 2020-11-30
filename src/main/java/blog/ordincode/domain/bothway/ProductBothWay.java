package blog.ordincode.domain.bothway;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class ProductBothWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            mappedBy = "productBothWay",
            fetch = FetchType.LAZY)
    private List<ImageBothWay> images;

    public ProductBothWay() {
    }

    public ProductBothWay(String name, List<ImageBothWay> images) {
        this.name = name;
        this.images = images;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public List<ImageBothWay> getImages() {
        return images;
    }

    public void addImage(ImageBothWay imageBothWay) {
        images.add(imageBothWay);
        imageBothWay.setProductBothWay(this);
    }
}
