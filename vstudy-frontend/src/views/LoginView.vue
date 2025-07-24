<template>
  <div id="login">
    <div class="login-container">
      <div style="width: 400px ;background-color: orange">
        <el-form :model="form" class="login-box">
          <div style="font-size: 30px;text-align: center;margin-bottom: 20px;font-weight: bolder">登 录</div>
          <el-form-item>
            <el-input prefix-icon="user" v-model="form.userId" placeholder="请输入账号"/>
          </el-form-item>
          <el-form-item>
            <el-input prefix-icon="lock" type="password" v-model="form.password" placeholder="请输入密码"/>
          </el-form-item>
          <el-form-item>
            <el-select v-model="form.role" placeholder="请选择用户类型">
              <el-option label="学生" value="student"/>
              <el-option label="教师" value="teacher"/>
              <el-option label="管理员" value="admin"/>
            </el-select>
            <el-button type="primary" @click="onSubmit" style="margin-top: 20px;width: 100%">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">
import {reactive} from 'vue'
import {
  AdminControllerService,
  StudentControllerService,
  TeacherControllerService,
  UserControllerService
} from "../../generated";
import router from "@/router";
import {useUserStore} from "@/stores/user.ts";
import message from "@arco-design/web-vue/es/message";

const form = reactive({
  userId: '',
  password: '',
  role: '',
})

const userStore = useUserStore();

const onSubmit = async () => {
  const res = await UserControllerService.loginUsingPost(form);
  if (res.code === "200") {
    userStore.setLoginUser(res.data);
    const userId = userStore.loginUser.userId
    console.log("登录成功用户信息：", userStore.loginUser);
    if (res.data.role === 'student') {
      const studentRes = await StudentControllerService.getStudentByStudentIdUsingGet(userId);
      userStore.setUserInfoById(studentRes.data);
      console.log("用户信息: " + userStore.userInfo);
      await router.push({path: "/student", replace: true});
    } else if (res.data.role === 'teacher') {
      const studentRes = await TeacherControllerService.getTeacherByTeacherIdUsingGet(userId);
      userStore.setUserInfoById(studentRes.data);
      console.log("用户信息: " + userStore.userInfo);
      await router.push({path: "/teacher", replace: true});
    } else if (res.data.role === 'admin') {
      const studentRes = await AdminControllerService.getAdminByAdminIdUsingGet(userId);
      userStore.setUserInfoById(studentRes.data);
      console.log("用户信息: " + userStore.userInfo);
      await router.push({path: "/admin", replace: true});
    }
    console.log(userStore.loginUser.token)

  } else {
    message.error("登录失败," + res.msg);
  }
}

</script>

<style scoped>

.login-container {
  min-height: 100vh;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

.login-box {
  margin: 40px;
}

</style>