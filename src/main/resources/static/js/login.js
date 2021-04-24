import { MemberApi } from "./api/modules/member.js";
import { utils } from "./utils/utils.js";

function Login() {
  const $nickName = document.getElementById("nickname");
  const $password = document.getElementById("password");
  const $loginButton = document.getElementById("login-button");

  const onClickLoginButton = async () => {
    const params = {
      nickName: $nickName.value,
      password: $password.value,
    };

    try {
      const res = await MemberApi.login(params);
      localStorage.setItem("app_token", res.data.token);
      alert("로그인 되었습니다.");
    } catch (e) {
      alert(e.message);
    }
  };

  this.init = () => {
    $loginButton.addEventListener("click", onClickLoginButton);
  };
}

const login = new Login();
login.init();
