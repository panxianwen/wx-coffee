<!--<template>-->
<!--  <div v-if="currentUser">-->
<!--    <el-card style="width: 700px">-->

<!--      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">-->
<!--        <el-form-item label="更换头像" >-->
<!--          <el-upload-->
<!--                  class="img-upload"-->
<!--                  action="http://212.64.70.126:8888/api/user/avatar"-->
<!--                  :show-file-list="false"-->
<!--                  name="userAvatar"-->
<!--                  :on-success="handleSuccess"-->
<!--                  :before-upload="beforeAvatarUpload" style="float:left">-->
<!--            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过3MB</div>-->
<!--            <img :src="avatarUrl" style="width: 70px;height: 70px;display: block; border-radius: 50%">-->
<!--          </el-upload>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="用户名" prop="username">-->
<!--          <el-input v-model="formData.username" placeholder="ddd" :disabled='true' :style="{width: '100%'}">-->
<!--          </el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="昵称" prop="nickname">-->
<!--          <el-input v-model="formData.nickname" placeholder="请输入昵称" :maxlength="20" :style="{width: '100%'}">-->
<!--          </el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="性别" prop="sex">-->
<!--          <el-radio v-model="formData.sex" label="1">男</el-radio>-->
<!--          <el-radio v-model="formData.sex" label="0">女</el-radio>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="手机" prop="phone">-->
<!--          <el-input v-model="formData.phone" placeholder="请输入手机" :maxlength="11" :style="{width: '100%'}">-->
<!--          </el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="邮箱" prop="email">-->
<!--          <el-input v-model="formData.email" placeholder="请输入邮箱" :style="{width: '100%'}">-->
<!--            <template slot="append">.com</template>-->
<!--          </el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="个性签名" prop="motto">-->
<!--          <el-input type="textarea" v-model="formData.motto" placeholder="请输入个性签名" :maxlength="255"-->
<!--                    :style="{width: '100%'}">-->
<!--          </el-input>-->
<!--        </el-form-item>-->
<!--        <el-button @click="resetForm">重置</el-button>-->
<!--        <el-button type="primary" @click="submitForm">提交</el-button>-->
<!--      </el-form>-->
<!--    </el-card>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--  import {updateSysUser} from '../../api/modules/system/user.js'-->
<!--  import {deepClone} from "@/utils";-->

<!--  export default {-->
<!--    components: {},-->
<!--    props: [],-->
<!--    data() {-->
<!--      return {-->
<!--        currentUser: JSON.parse(window.sessionStorage.getItem('currentUser')), //获取缓存里的数据-->
<!--        avatarUrl: '',-->
<!--        formData: {-->
<!--          username: null,-->
<!--          nickname: null,-->
<!--          sex: 1,-->
<!--          phone: null,-->
<!--          email: null,-->
<!--          motto: null,-->
<!--        },-->
<!--        rules: {-->
<!--          username: [],-->
<!--          nickname: [{-->
<!--            required: true,-->
<!--            message: '请输入昵称',-->
<!--            trigger: 'blur'-->
<!--          }],-->
<!--          sex: [{-->
<!--            required: true,-->
<!--            trigger: 'blur'-->
<!--          }-->
<!--          ],-->
<!--          phone: [-->
<!--            {max: 11, trigger: 'blur'}-->
<!--          ],-->
<!--          email: [],-->
<!--          motto: [],-->
<!--        },-->
<!--        sexOptions: [{-->
<!--          "label": "男",-->
<!--          "value": 1-->
<!--        }, {-->
<!--          "label": "女",-->
<!--          "value": 0-->
<!--        }],-->
<!--      }-->
<!--    },-->
<!--    mounted() {-->
<!--      this.formData = deepClone(this.currentUser)-->
<!--      this.avatarUrl = this.currentUser.avatarUrl-->
<!--    },-->
<!--    methods: {-->
<!--      handleSuccess() { //更换头像-->
<!--        this.$message.success('更换成功')-->
<!--        this.currentUser.avatarUrl = this.avatarUrl-->
<!--        window.sessionStorage.setItem('currentUser', JSON.stringify(this.currentUser)) //更换头像后端也会会另外更新用户-->
<!--        this.avatarUrl = this.avatarUrl + "?" + new Date() //实时更新头像-->
<!--      },-->
<!--      beforeAvatarUpload(file) {-->
<!--        console.log(JSON.stringify(this.currentUser))-->
<!--        if (file.type != 'image/jpeg' && file.type != 'image/png') {-->
<!--          console.log(file.type)-->
<!--          this.$message.error('只能上传图片!');-->
<!--          return false-->
<!--        }-->
<!--        if (file.size / 1024 / 1024 > 3) {-->
<!--          this.$message.error('上传头像图片大小不能超过 3MB!');-->
<!--          return false-->
<!--        }-->
<!--        return true-->
<!--      },-->
<!--      submitForm() {-->
<!--        this.$refs['elForm'].validate(valid => {-->
<!--          if (valid) {-->
<!--            updateUser(this.formData).then(() => {-->
<!--              //要深克隆 更新当前用户对象-->
<!--              window.sessionStorage.setItem('currentUser', JSON.stringify(deepClone(this.formData)))-->
<!--              this.$notify.success('更新成功')-->
<!--            }).catch(() => this.$notify.error("更新失败"))-->
<!--          }-->
<!--        })-->
<!--      },-->
<!--      resetForm() {-->
<!--        this.$refs['elForm'].resetFields()-->
<!--      },-->
<!--    }-->
<!--  }-->

<!--</script>-->
<!--<style>-->
<!--</style>-->


