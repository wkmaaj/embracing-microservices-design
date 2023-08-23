import axios from "axios"
import http from "http"
import https from "https"
import { HTTP_CONSTANTS } from "../constants/index.js"

const requestConfigOpts = {
  timeout: 300000, // 300,000 ms equals 5 mins
  headers: HTTP_CONSTANTS.headers.standard,
  httpAgent: new http.Agent({ keepAlive: true }),
  httpsAgent: new https.Agent({ keepAlive: true }),
  maxRedirects: 10, // limits the number of allowable HTTP 3xx redirects
}

const axiosBrowserInstance = axios.create(requestConfigOpts)
const axiosExternalApiInstance = axios.create(requestConfigOpts)

function RestClientException(error, showHeaders = false) {
  this.name = "ApiException"
  this.error = {
    ...error,
    ...(() =>
      showHeaders && error?.config?.headers
        ? { headers: error.config.headers }
        : {})(),
  }
}

axiosExternalApiInstance.interceptors.request.use((req) => {
  let headers = {}
  Object.keys(req.headers)
    .filter((headerKey) => headerKey !== "host")
    .forEach((filteredHeaderKey) => {
      headers = {
        ...headers,
        [filteredHeaderKey]: req.headers[filteredHeaderKey],
      }
    })

  req.headers = headers
  // TODO - add trace log capture of req.headers, req.url, and req.data
  return req
})

axiosExternalApiInstance.interceptors.response.use((res) => {
  // TODO - add trace log capture of res.data, res.config.url, res.status
  return res
})

/**
 * Function to asynchronously send data over HTTP using the Axios library.
 * The schema of the response object returned by an Axios call is detailed
 * below. Refer to Axios
 * {@link https://axios-http.com/docs/res_schema res_schema} and
 * {@link https://axios-http.com/docs/handling_errors handling_errors} for
 * more information.
 *
 * @author wkmaaj
 * @example
 *  // Axios Response
 *  {
 *      data: {},
 *      status: number,
 *      statusText: string,
 *      headers: {},
 *      config: {},
 *      request: {}
 *  }
 *
 * @param {string} method
 * @param {string} url
 * @param {{[key:string]: string}} headers
 * @param {{}} data
 * @returns
 */
export default async (
  method,
  url,
  headers,
  data,
  isClientBrowser,
  additionalConfig,
) =>
  (isClientBrowser ? axiosBrowserInstance : axiosExternalApiInstance)
    .request({
      url,
      method,
      headers,
      data,
      ...additionalConfig,
    })
    .catch((error) => {
      let apiError = {}

      if (error.response) {
        // The request was made and the server responded with a status code that falls out of the range of 2xx.
        apiError = {
          status:
            error.response?.data?.error?.status ??
            error.response?.status ??
            error?.status ??
            HTTP_CONSTANTS.statuses.BAD_REQUEST.code,
          message: error.message,
          reason: "Client received error response from server",
          response: {
            status:
              error.response?.data?.error?.status ??
              error.response?.status ??
              error?.status ??
              HTTP_CONSTANTS.statuses.BAD_REQUEST.code,
            ...(() =>
              error?.response?.data ? { data: error.response.data } : {})(),
          },
        }
      } else if (error.request) {
        // The request was made but no response was received
        // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
        // http.ClientRequest in Node.js
        apiError = {
          status: HTTP_CONSTANTS.statuses.REQUEST_TIMEOUT.code,
          message: error.message,
          reason: "Client received NO response from server",
        }
      } else {
        // Something happened in setting up the request that triggered an error
        apiError = {
          status: HTTP_CONSTANTS.statuses.INTERNAL_SERVER_ERROR.code,
          message: error.message,
          reason: "Client encountered an error building the request",
        }
      }

      // TODO - add error log capture of apiError
      throw new RestClientException({
        ...apiError,
        url: error.config.url,
      })
    })
