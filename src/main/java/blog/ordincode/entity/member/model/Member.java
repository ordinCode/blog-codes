package blog.ordincode.entity.member.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private String password;

    public Member() {
    }

    public Member(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public void validatePassword(String password) {
        if (this.password.equals(password)) {
            return;
        }
        throw new IllegalArgumentException("비밀번호를 확인해주세요");
    }

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}
