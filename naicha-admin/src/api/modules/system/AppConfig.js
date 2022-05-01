import request from '@/utils/axiosRequest.js'


// 获取小程序的所有配置信息
export function getAppConfig(){
  return request({
    url: "/api-system/config" ,
    method: "get"
  })
}


// 修改配置信息
export function updateAppConfig(appConfig) {
  return request({
    url: "/api-system/config",
    method: "put",
    data: appConfig
  })
}

