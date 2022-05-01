import request from '@/utils/axiosRequest.js'

export function getAllRoles(){
  return request({
    url: "/api-system/role/list",
    method: "get"
  })
}

// 获取角色所有权限
export function getPermissionsOfRole(roleId){
  return request({
    url: "/api-system/role/perms/" + roleId,
    method: "get"
  })
}

// 添加角色
export function addRole(user) {
  return request({
    url: "/api-system/role/",
    method: "post",
    data: user
  })
}

// 更新角色
export function updateRole(role) {
  return request({
    url: "/api-system/role",
    method: "put",
    data: role
  })
}

// 批量删除角色
export function deleteRoles(roleIds) {
  return request({
    url: "/api-system/role/batch",
    method: "delete",
    data: roleIds
  })
}

// 修改角色的权限
export function updateRolePermission(userIdAndPermissions){
  return request({
    url: "/api-system/role/permission",
    method: "put",
    data: userIdAndPermissions
  })
}
