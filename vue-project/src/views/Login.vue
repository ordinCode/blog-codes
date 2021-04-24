<template>
  <div>
    <h2>login page</h2>
    <div>
      <label for="nickname"> 아이디 </label>
      <input id="nickname" v-model="inputNickName" />
      <label for="password"> 비밀번호 </label>
      <input id="password" v-model="inputPassword" />
      <button type="button" id="login-button" @click="login">로그인</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      inputNickName: "",
      inputPassword: "",
    };
  },
  methods: {
    async login() {
      const data = {
        nickName: this.inputNickName,
        password: this.inputPassword,
      };

      try {
        const response = await axios.post("/login", data);
        localStorage.setItem("app_token", response.data.token);
        alert("로그인 되었습니다.");
      } catch (e) {
        alert(e.message);
      }
    },
  },
};
</script>

<style scoped></style>
