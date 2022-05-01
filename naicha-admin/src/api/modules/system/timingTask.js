import request from '@/utils/axiosRequest.js'

export function doTimingTask(taskMethodName){
  return request({
    url: "/api-system/timingTask/execute/" + taskMethodName,
    method: "get"
  })
}

