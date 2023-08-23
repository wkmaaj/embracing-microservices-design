import { pino } from "pino"

const getConfig = () => ({
  publicRuntimeConfig: { BASE_PATH: "", LOG_LEVEL: "trace" },
})
const { publicRuntimeConfig } = getConfig()

/**
 * In Typescript, the return type is pino.Logger
 */
export default (
  name,
  restClient,
  stringify,
  httpConstants,
  isClientLogger,
  urlContextPath,
) =>
  pino({
    browser: isClientLogger
      ? {
          write: (o) => stringify(o.msg),
          transmit: {
            level: publicRuntimeConfig?.LOG_LEVEL ?? "warn",
            send: (level, logEvent) =>
              restClient(
                httpConstants.methods.post,
                `${publicRuntimeConfig.BASE_PATH}${urlContextPath}`,
                httpConstants.headers.standard,
                {
                  name,
                  level,
                  timestamp: new Date(),
                  log: logEvent.messages[0],
                },
              ),
          },
        }
      : {},
    level: publicRuntimeConfig?.LOG_LEVEL ?? "warn",
    formatters: {
      level: (label) => ({ level: label }),
    },
    timestamp: () => `,"TimeStamp":"${new Date(Date.now()).toISOString()}"`,
    base: {
      /**
       * An object consisting of key-value pairs to be added as child loggers to each log line.
       * If not set, then nothing is added.
       *
       * @example
       * [2023-07-07 20:41:54.039 +0900] DEBUG (LoggerName): Some action or event occurred and was logged
       * env: "EnvironmentName"
       */
      name,
    },
  })
