import pinoConfig from "./pino.config.js"

/**
 * Logs the stringified representation of a JSON object and returns the object
 * back to the caller of the function in order to be able to be interjected
 * into a function call and, in an intercepting type fashion, log the parameters
 * being passed to the called function.
 *
 * @author wkmaaj
 * @example
 *  const foo = (bar) => {
 *      // bar is logged before being passed to doSomething
 *      doSomething(logger(bar));
 * }
 */
export default (
  name,
  restClient,
  compose,
  stringify,
  appConstants,
  httpConstants,
  isClientLogger,
  urlContextPath,
) => {
  const logger = pinoConfig(
    name,
    restClient,
    stringify,
    httpConstants,
    isClientLogger,
    urlContextPath,
  )

  return {
    trace: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.trace(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
    debug: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.debug(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
    info: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.info(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
    warn: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.warn(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
    error: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.error(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
    fatal: (
      obj,
      msg = "",
      asString = false,
      indentationSpacing = appConstants.stringify.indentationSpacing,
      maximumDepth = appConstants.stringify.maximumDepth,
    ) => {
      logger.fatal(
        ...compose(obj, msg, asString, indentationSpacing, maximumDepth),
      )
      return obj
    },
  }
}
