<template>
  <!--用户相关弹框 嵌套到NavMenu里去-->
  <div>
    <div v-if="!userInfo">
      <router-link to="/">
        登录
      </router-link>
    </div>
    <div v-else>
      <el-dropdown :show-timeout=10 :hide-timeout=10
                   placement="right"
                   trigger="click"
                   @command="handleCommand">
        <!--用户信息弹窗开关 下拉菜单-->
        <div>
          <img style="width: 25px; height: 25px; border-radius: 50%"
               src="./default.png" alt="img">
        </div>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command=2>修改密码</el-dropdown-item>
          <el-dropdown-item command=3 divided>退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span style="color: gray; margin-bottom: 10px;font-size: 10px">
          欢迎您，{{userInfo.username ? userInfo.username : ''}} [{{userInfo.roleName}}]
        </span>


      <!--个人信息弹窗-->
      <el-dialog
        :visible="userInfoDialogVisible"
        :before-close="handleClose"
        :center="true"
        width="300px"
        top="10vh"
        :show-close="false">
        <ul style="text-align: center; padding-bottom: 30px">
          <li><img :src="userInfo.avatarUrl"
                   style="width: 70px;height: 70px;display: block; border-radius: 50%; position:relative; top: -30px; margin: 0 auto">
          </li>
          <li>用户名: {{userInfo.username}}</li>
          <li>昵称: {{userInfo.nickname}}</li>
          <li>性别: {{userInfo.sex == 1 ? '男' : '女'}}</li>
          <li>个性签名: {{userInfo.motto}}</li>
          <li>邮箱: {{userInfo.email}}</li>
          <li>手机: {{userInfo.phone}}</li>
        </ul>
      </el-dialog>

      <!--修改密码弹窗-->
      <el-dialog :visible.sync="updatePasswordDialogVisible" width="400px">
        <el-form ref="elForm" :model="updatePasswordForm" :rules="updatePasswordFormRules" size="medium"
                 label-width="100px">
          <el-form-item label="旧密码" prop="oldPassword">
            <el-input v-model="updatePasswordForm.oldPassword" type="password" placeholder="请输入旧密码" :maxlength="18"
                      :style="{width: '100%'}"></el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="newPassword">
            <el-input v-model="updatePasswordForm.newPassword" type="password" placeholder="请输入新密码" :maxlength="18"
                      :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-form>
        <el-button @click="handleClose">取消</el-button>
        <el-button type="primary" @click="handleUpdatePassword">确定</el-button>
      </el-dialog>
    </div>

  </div>
</template>

<script>
  import {updatePassword} from "../../api/AuthController";

  export default {
    data() {
      return {
        userInfo: {},
        userInfoDialogVisible: false,
        updatePasswordDialogVisible: false,

        //修改密码
        updatePasswordForm: {
          oldPassword: '',
          newPassword: '',
        },
        updatePasswordFormRules: {
          oldPassword: [{required: true, pattern: /^\d{6,18}$/, message: "密码格式不正确", trigger: "blur"}],
          newPassword: [{required: true, pattern: /^\d{6,18}$/, message: "密码格式不正确", trigger: "blur"}]
        },
      };
    },
    mounted() {
      this.userInfo = this.$store.getters.userInfo;
    },
    methods: {
      handleClose() {
        this.userInfoDialogVisible = false
        this.updatePasswordDialogVisible = false
      },
      /*下拉菜单处理*/
      handleCommand(command) {
        console.log(command)
        if (command == 1)
          this.userInfoDialogVisible = true
        else if (command == 2)
          this.updatePasswordDialogVisible = true
        else if (command == 3)
          this.logout()
      },
      logout() { //退出登录
        this.$store.dispatch("logout");
      },
      //修改密码
      handleUpdatePassword() {
        this.updatePasswordDialogVisible = false
        const oldPassword = this.updatePasswordForm.oldPassword
        const newPassword = this.updatePasswordForm.newPassword
        updatePassword(oldPassword, newPassword).then(() => {
          this.$notify.success("密码修改成功")
        })
      },
    }
  };
</script>


