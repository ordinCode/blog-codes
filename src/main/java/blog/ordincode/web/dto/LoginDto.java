package blog.ordincode.web.dto;

public class LoginDto {
    private String nickName;
    private String password;
    private String token;

    public LoginDto() {
    }

    public LoginDto(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
