import loggerConfig from "./config/index.js"
import { APP_CONSTANTS, HTTP_CONSTANTS } from "./constants/index.js"
import restClient from "./rest/index.js"
import { compose, stringify } from "./utils/index.js"

export default (
  name,
  isClientLogger = false,
  urlContextPath = "/api/browser/logs",
) =>
  loggerConfig(
    name,
    restClient,
    compose,
    stringify,
    APP_CONSTANTS,
    HTTP_CONSTANTS,
    isClientLogger,
    urlContextPath,
  )
