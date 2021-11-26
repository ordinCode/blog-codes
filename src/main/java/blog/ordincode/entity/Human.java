package blog.ordincode.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer age;
    private Integer height;

    //1살 10cm의 키를 가지고 태어난다.
    public static Human born() {
        return new Human(null, 1, 10);
    }

    //1살 나이를 먹는다.
    public void growOld() {
        this.age++;
    }

    //10cm 성장한다.
    public void growHeight() {
        this.height += 10;
    }
}
