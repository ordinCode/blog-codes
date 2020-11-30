package blog.ordincode.domain.embed;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImageEm {
    @Column(name = "image_name")
    private String name;

    public ImageEm() {
    }

    public ImageEm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
