import request from '@/utils/axiosRequest.js'

export function getAllSysUsers(){
  return request({
    url: "/api-system/sysUser/list",
    method: "get"
  })
}

// 添加管理员
export function addSysUser(user) {
  return request({
    url: "/api-system/sysUser/",
    method: "post",
    data: user
  })
}

// 更新管理员
export function updateSysUser(user) {
  return request({
    url: "/api-system/sysUser",
    method: "put",
    data: user
  })
}

// 批量删除管理员
export function deleteSysUsers(sysUserIds) {
  return request({
    url: "/api-system/sysUser/batch",
    method: "delete",
    data: sysUserIds
  })
}

// 更新账号激活状态
export function updateStatus(sysUserId, status) {
  return request({
    url: "/api-system/sysUser/status/" + sysUserId + "/" + status,
    method: "put"
  })
}

// 重置密码
export function resetPassword(sysUserId){
  return request({
    url: "/api-system/sysUser/resetPassword/" + sysUserId,
    method: "put"
  })
}


// 设置角色
export function setRole(userId, roleId){
  return request({
    url: "/api-system/sysUser/role/" + userId + "/" + roleId,
    method: "put"
  })
}
