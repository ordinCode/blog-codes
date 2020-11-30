package blog.ordincode.domain.bothway;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImageBothWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductBothWay productBothWay;

    public ImageBothWay() {
    }

    public ImageBothWay(String name) {
        this.name = name;
    }

    public Long getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public ProductBothWay getProductBothWay() {
        return productBothWay;
    }

    public void setProductBothWay(ProductBothWay productBothWay) {
        this.productBothWay = productBothWay;
    }
}
