package blog.ordincode.web.dto;

import blog.ordincode.entity.member.model.Member;

public class MemberDto {
    private String nickName;
    private String password;

    public MemberDto() {
    }

    public Member toMember() {
        return new Member(nickName, password);
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}
