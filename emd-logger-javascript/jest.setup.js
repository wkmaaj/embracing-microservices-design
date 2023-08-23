import "@testing-library/jest-dom/extend-expect"

global.crypto = {
  getRandomValues: (arr) => require("crypto").randomBytes(arr.length),
}
