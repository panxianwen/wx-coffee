import request from '../utils/axiosRequest.js'

// 获取验证码
export function getCode() {
  return request({
    url: '/api-system/auth/code',
    method: 'get'
  })
}

//登录
export function login(requestUser) {
  return request({
    url: '/api-system/auth/login',
    method: 'post',
    data: requestUser
  })
}

// //注册用户
// export function register(username, password) {
//   return request({
//     url: '/api-system/auth/register',
//     method: 'post',
//     data: {
//       username: username,
//       password: password
//     }
//   })
// }

//修改密码
export function updatePassword(oldPassword, newPassword) {
  return request({
    url: '/api-system/auth/password',
    method: 'put',
    data: {
      oldPassword: oldPassword,
      newPassword: newPassword
    }
  })
}

// 获取当前登录的用户信息
export function getUserInfo() {
  return request({
    url: '/api-system/auth/userInfo',
    method: 'get'
  })
}

// 退出登录
export function logout() {
  return request({
    url: '/api-system/auth/logout',
    method: 'delete'
  })
}
