import { HTTP_CONSTANTS } from "../../../src/constants"
import { stringify } from "../../../src/utils"
import composeUtil from "../../../src/utils/compose.util"

describe("compose.util unit tests", () => {
  test("expected return array to contain one element", async () => {
    const msg = "asString=true"
    const res = composeUtil(HTTP_CONSTANTS, msg, stringify(), true, 2)
    expect(res.length).toBe(1)
    expect(typeof res[0]).toEqual("string")
  })

  test("expected return array to contain two elements", async () => {
    const msg = "asString=false"
    const res = composeUtil(HTTP_CONSTANTS, msg, stringify(), false, 2)
    expect(res.length).toBe(2)
    expect(typeof res[0]).toEqual("string")
    expect(res[1]).toEqual(msg)
  })
})
