import Vue from "vue";
import VueRouter from "vue-router";
import Login from "@/views/Login";
import IndexPage from "@/views/IndexPage";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: IndexPage,
  },
  {
    path: "/login",
    component: Login,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
