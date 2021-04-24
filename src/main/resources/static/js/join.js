import { MemberApi } from "./api/modules/member.js";
import { utils } from "./utils/utils.js";

function Join() {
  const $nickName = document.getElementById("input-nickname");
  const $password = document.getElementById("input-password");
  const $joinButton = document.getElementById("submit-join-button");

  const onClickJoinButton = async () => {
    const params = {
      nickName: $nickName.value,
      password: $password.value,
    };

    try {
      const res = await MemberApi.join(params);
      alert("회원가입 되었습니다.");
    } catch (e) {
      alert(e.message);
    }
  };

  this.init = () => {
    $joinButton.addEventListener("click", onClickJoinButton);
  };
}

const join = new Join();
join.init();
