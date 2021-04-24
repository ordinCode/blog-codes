function Utils() {
  this.validateResponse = (res) => {
    if (res.ok) {
      return
    }
    throw res;
  };
}

export const utils = new Utils();
