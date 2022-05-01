/**
 * 权限树 授权的时候使用 细粒度
 id: 'title',
 label: 'title',
 children: 'children'

 permission作为key
 */
const permissionTree = [
  {
    title: '应用管理',
    permission: "system:app", // 仅仅是作为key控制下视图
    children: [
      {
        title: '用户管理',
        permission: 'system:user', // 仅仅是作为key控制下视图
        children: [
          {
            title: '添加用户',
            permission: "system:user:add" // 真正可以添加到数据库的权限值
          },
          {
            title: '删除用户',
            permission: "system:user:delete"
          },
          {
            title: '修改用户',
            permission: "system:user:update"
          },
          {
            title: '查看用户',
            permission: "system:user:list"
          }
        ]
      },
      {
        title: '商品管理',
        permission: 'system:goods',
        children: [
          {
            title: '添加商品',
            permission: "system:goods:add"
          },
          {
            title: '删除商品',
            permission: "system:goods:delete"
          },
          {
            title: '更新商品',
            permission: "system:goods:update"
          },
          {
            title: '查看商品',
            permission: "system:goods:list"
          }
        ]
      },
      {
        title: '商品种类管理',
        permission: 'system:goodsCategory',
        children: [
          {
            title: '添加商品种类',
            permission: "system:goodsCategory:add"
          },
          {
            title: '删除商品种类',
            permission: "system:goodsCategory:delete"
          },
          {
            title: '更新商品种类',
            permission: "system:goodsCategory:update"
          },
          {
            title: '查看商品种类',
            permission: "system:goodsCategory:list"
          }
        ]
      },
      {
        title: '订单管理',
        permission: 'system:order',
        children: [
          {
            title: '更新订单',
            permission: "system:order:update"
          },
          {
            title: '查看订单',
            permission: "system:order:list"
          }
        ]
      }
    ]
  },
  {
    title: '系统监控',
    permission: "system:monitor",
    children: [
      {
        title: '定时任务',
        children: [
          {
            title: '查看定时任务',
            permission: "system:timingTask:list"
          }
        ]
      }
    ]
  },
  {
    title: '系统管理',
    permission: "system:admin",
    children: [
      {
        title: '系统配置',
        children: [
          {
            title: '修改配置',
            permission: "system:config:update"
          }
        ]
      },
      {
        title: '管理员管理',
        children: [
          {
            title: '添加管理员',
            permission: "system:sysUser:add"
          },
          {
            title: '删除管理员',
            permission: "system:sysUser:delete"
          },
          {
            title: '更新管理员',
            permission: "system:sysUser:update"
          },
          {
            title: '查看管理员',
            permission: "system:sysUser:list"
          }
        ]
      },
      {
        title: '角色管理',
        children: [
          {
            title: '添加角色',
            permission: "system:role:add"
          },
          {
            title: '删除角色',
            permission: "system:role:delete"
          },
          {
            title: '更新角色',
            permission: "system:role:update"
          },
          {
            title: '查看角色',
            permission: "system:role:list"
          }
        ]
      }
    ]
  }

]

export default permissionTree
