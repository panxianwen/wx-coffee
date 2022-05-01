import router from '../../router/index'
import {getUserInfo, login} from "../../api/AuthController";

const user = {
  state: {
    userInfo: null,
    permissions: [],
    token: null
  },
  // 能保证获取到最新的值 eg: ...mapGetters(['userInfo']) this.$store.getters.userInfo
  getters: {
    userInfo: state => state.userInfo,
    token: state => state.token,
    permissions: state => state.permissions
  },
  // 调用方法 this.$store.commit("mutationName", data);
  mutations: {
    setToken(state, token){
      state.token = token;
    },
  },
  // 调用方法 this.$store.dispatch("actionName", data);
  actions: {
    loginByToken({commit, state, dispatch}, token) {
      console.log("[通过本地缓存的令牌登录]", token);
      commit("setToken", token);
      getUserInfo().then(result => {
        state.userInfo = result.data;

        dispatch("generateSystemMenus", result.data.permissions); // 生成菜单路由表
        router.push({redirect: true, path: '/index'});
      }).catch(() => {
        window.localStorage.removeItem("token");
      })
    },
    // 用户登录
    login({commit, state, dispatch}, requestUser) {
      login(requestUser).then(result => {
        state.userInfo = result.data;
        commit("setToken", result.data.token);
        window.localStorage.setItem('token', result.data.token);
        window.localStorage.setItem("loginUser", JSON.stringify(requestUser));

        dispatch("generateSystemMenus", result.data.permissions); // 生成菜单路由表
        router.push({redirect: true, path: '/index'});
      })
    },
    logout: ({commit, state}) => {
      commit("setToken");
      state.userInfo = null;
      window.localStorage.removeItem('token')
      router.push({redirect: true, path: '/'})
    }
  }
}

export default user
