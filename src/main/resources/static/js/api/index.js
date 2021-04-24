import { utils } from "../utils/utils.js";

export const api = {
  getWithJson(path) {
    return requestWithJson(path);
  },
  postWithJson(path, data) {
    return requestWithJson(path, METHOD.POST(data));
  },
  postApi(path, data) {
    return requestWithJson(path, METHOD.POST(data));
  },
  deleteMethod(path) {
    return requestWithJson(path, METHOD.DELETE());
  },
};

const requestWithJson = (path, config) =>
  fetch(path, config).then((res) =>
    res.json().then((json) => {
      utils.validateResponse(json);
      return json;
    })
  );

const METHOD = {
  POST(data) {
    return {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        ...data,
      }),
    };
  },
  DELETE() {
    return {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    };
  },
};
