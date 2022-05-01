<script>
import { mapMutations } from 'vuex';
export default {
	methods: {
		...mapMutations(['login'])
	},
	onLaunch: function() {
		// let setting
		// uni.getSetting({
		// 	withSubscriptions: true,
		// 	success(res) {
		// 		setting = res
		// 		uni.setStorage("setting", setting)
		// 		console.log(res.authSetting);
		// 		// res.authSetting = {
		// 		//   "scope.userInfo": true,
		// 		//   "scope.userLocation": true
		// 		// }
		// 		console.log(res.subscriptionsSetting);
		// 		// res.subscriptionsSetting = {
		// 		//   mainSwitch: true, // 订阅消息总开关
		// 		//   itemSettings: {   // 每一项开关
		// 		//     SYS_MSG_TYPE_INTERACTIVE: 'accept', // 小游戏系统订阅消息
		// 		//     SYS_MSG_TYPE_RANK: 'accept'
		// 		//     zun-LzcQyW-edafCVvzPkK4de2Rllr1fFpw2A_x0oXE: 'reject', // 普通一次性订阅消息
		// 		//     ke_OZC_66gZxALLcsuI7ilCJSP2OJ2vWo2ooUPpkWrw: 'ban',
		// 		//   }
		// 		// }
				
		// 	}
		// });
	},
	onShow: function() {
		console.log('App Show');
	},
	onHide: function() {
		console.log('App Hide');
	}
};
</script>

<style lang="scss">
/*每个页面公共css */
@import '~@/static/style/app.scss';
</style>
