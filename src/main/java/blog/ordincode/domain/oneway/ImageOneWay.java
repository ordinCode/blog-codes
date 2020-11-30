package blog.ordincode.domain.oneway;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageOneWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String name;

    public ImageOneWay() {
    }

    public ImageOneWay(String name) {
        this.name = name;
    }

    public Long getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
