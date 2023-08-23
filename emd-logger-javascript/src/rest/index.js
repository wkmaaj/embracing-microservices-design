import axiosClient from "./axios.client.js"

export default async (
  method,
  url,
  headers,
  request,
  isClientBrowser = false,
  additionalConfig = {},
) => {
  let response = {}
  try {
    const { data, status } = await axiosClient(
      method,
      url,
      headers,
      request,
      isClientBrowser,
      additionalConfig,
    )
    response = { data, status }
  } catch (error) {
    // TODO - add error log capture of error
    throw error
  }
  return response
}
