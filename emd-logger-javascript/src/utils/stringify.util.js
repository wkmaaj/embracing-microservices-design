import { configure } from "safe-stable-stringify"

/**
 * @author wkmaaj
 * @param {number} maximumDepth
 */
export default (maximumDepth) =>
  configure({
    bigint: true,
    maximumDepth,
  })
