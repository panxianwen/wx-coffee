import systemRouters from "../../router/systemRouters.js";
import router from "../../router/index";

function hasPermission(permissions, needPermission) {
  let hasPermissionFlag = false;
  permissions.forEach(permission => {
    if (permission.startsWith(needPermission))
      hasPermissionFlag = true;
  })
  return hasPermissionFlag;
}

/**
 * 递归过滤系统路由表，返回符合用户角色权限的路由表
 * @param routes 所有路由表
 * @param perms
 */
function filterAsyncRouter(routes, perms) {
  const res = []
  routes.forEach(route => {
    if (route.children) {
      route.children = filterAsyncRouter(route.children, perms) // 递归处理孩子节点
      if (route.children && route.children.length > 0) {
          res.push(route)
      }
    } else {
      if(route.permission){ // 需要其中一个权限
        if(hasPermission(perms, route.permission)){
          res.push(route);
        }
      }else {
        res.push(route)
      }
    }
  })

  return res
}

const systemMenu = {
  state: {
    systemMenus: [], // 后台菜单
  },
  getters: {
    systemMenus: state => state.systemMenus
  },
  mutations: {
    setSystemMenus(state, systemMenu) {
      state.systemMenus = systemMenu;
    }
  },
  actions: {
    generateSystemMenus({commit}, permissions) { // 生成菜单栏(路由表)  eg:permissions=["system:sysUser:list]
      console.log("[生成菜单栏]  [用户权限]", permissions)

      if (permissions.includes('*')) {
        commit("setSystemMenus", systemRouters)
        router.addRoutes(systemRouters)
        console.log("超级管理员 所有路由表", systemRouters);
      } else {
        let routers = filterAsyncRouter(systemRouters, permissions);
        commit("setSystemMenus", routers)
        router.addRoutes(routers) // 动态添加可访问路由表
        console.log("添加菜单路由表", routers);
      }
    }
  }
}

export default systemMenu
