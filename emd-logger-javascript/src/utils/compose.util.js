/**
 * @author wkmaaj
 * @param {any} obj
 * @returns
 */
const sanitizeAuditEvent = (obj) => {
  if (obj.err && obj.err.config) {
    let { err, ...rest } = obj
    let { config, e } = err
    let { url, method, ...conf } = config
    return {
      ...rest,
      err: {
        ...e,
        config: {
          url: config.url,
          method: config.method,
          additional: {
            ...conf,
          },
        },
      },
    }
  }
  return obj
}

/**
 * @author wkmaaj
 * @param {any} obj
 * @param {(obj:any, replacer?: any, indentationSpacing?: number) => string} stringify
 * @param {number} indentationSpacing
 * @returns
 */
const isAuditEvent = (obj, stringify, indentationSpacing) =>
  stringify(sanitizeAuditEvent(obj), null, indentationSpacing)

/**
 * @author wkmaaj
 * @param {any} obj
 * @param {string} msg
 * @param {(obj:any, replacer?: any, indentationSpacing?: number) => string} stringify
 * @param {boolean} asString
 * @param {number} indentationSpacing
 * @returns
 */
export default (obj, msg, stringify, asString, indentationSpacing) => {
  if (asString) {
    return [
      `${msg ? `${msg}: ` : ""}${
        typeof obj === "string"
          ? obj
          : stringify(obj, null, indentationSpacing)
      }`,
    ]
  } else {
    return [isAuditEvent(obj, stringify, indentationSpacing), msg]
  }
}
