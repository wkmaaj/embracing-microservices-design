import logger from "../../src"

describe("logger unit tests", () => {
  test("expected properties present on logger", async () => {
    expect(Object.keys(logger("LoggerUnitTest"))).toEqual([
      "trace",
      "debug",
      "info",
      "warn",
      "error",
      "fatal",
    ])
  })
})
