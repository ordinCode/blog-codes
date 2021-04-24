<template>
  <div id="app">
    <h1>점진적으로 프레임워크로 개발하기 - vue</h1>
    <div class="nav">
      <ul>
        <li><a class="nav-item" href="/">홈</a></li>
        <li><a class="nav-item" href="/login">로그인</a></li>
        <li><a class="nav-item" href="/join">회원가입</a></li>
      </ul>
    </div>
    <router-view />
  </div>
</template>

<style lang="stylus">
html body {
  background-color: #faf0de;
}

h1,
h2 {
  text-align: center;
}

ul {
  list-style: none;
}

li {
  margin-left: 15px;
  margin-top: 5px;
}

a {
  text-decoration: none;
  color: cornflowerblue;
}

.nav {
  border-right: darkgray solid 1px;
  width: 150px;
  margin-right: 20px;
  float: left;
}

.nav-item {
  font-size: 20px;
}
</style>
