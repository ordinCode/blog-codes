import { api } from "../index.js";

export const MemberApi = {
  async join(data) {
    return api.postWithJson("/member", data);
  },
  async login(data) {
    return api.postWithJson("/login", data);
  },
};
