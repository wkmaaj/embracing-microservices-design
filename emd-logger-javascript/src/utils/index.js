import { APP_CONSTANTS } from "../constants/index.js"
import composeUtil from "./compose.util.js"
import stringifyUtil from "./stringify.util.js"

/**
 * @author wkmaaj
 * @param {any} obj
 * @param {string} msg
 * @param {boolean} asString
 * @param {number} indentationSpacing
 * @param {number} maximumDepth
 * @returns
 */
export const compose = (
  obj,
  msg,
  asString,
  indentationSpacing = APP_CONSTANTS.stringify.indentationSpacing,
  maximumDepth = APP_CONSTANTS.stringify.maximumDepth,
) =>
  composeUtil(
    obj,
    msg,
    stringifyUtil(maximumDepth),
    asString,
    indentationSpacing,
  )

export const stringify = (
  maximumDepth = APP_CONSTANTS.stringify.maximumDepth,
) => stringifyUtil(maximumDepth)
