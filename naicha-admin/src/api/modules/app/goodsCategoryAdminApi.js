import request from '@/utils/axiosRequest.js'


// 所有商品类别
export function getAllGoodsCategoryAdmins(){
  return request({
    url: "/api-system/goodsCategoryAdmin/list",
    method: "get"
  })
}

// 添加
export function addGoodsCategoryAdmin(goodsCategoryAdmin) {
  return request({
    url: "/api-system/goodsCategoryAdmin",
    method: "post",
    data: goodsCategoryAdmin
  })
}

// 更新
export function updateGoodsCategoryAdmin(oldName, goodsCategoryAdmin) {
  return request({
    url: "/api-system/goodsCategoryAdmin/" + oldName,
    method: "put",
    data: goodsCategoryAdmin
  })
}


// 显示或隐藏该类商品
export function updateGoodsCategoryShowStatus(name) {
  return request({
    url: "/api-system/goodsCategoryAdmin/showStatus/" + name,
    method: "put"
  })
}

// 批量删除
export function deleteGoodsCategoryAdmins(id) {
  return request({
    url: "/api-system/goodsCategoryAdmin/" + id,
    method: "delete"
  })
}
