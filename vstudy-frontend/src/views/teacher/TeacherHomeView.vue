<template>
  <div id="teacherHome">
    <a-layout style="height: 100%;">
      <a-layout-header>
        <GlobalHeader/>
      </a-layout-header>
      <a-layout>
        <a-layout-content>
          <div class="box">
            <div style="color: #181818;font-size: 25px;padding:30px 0 0 20px">最近访问</div>
            <button class="button1" style="margin-left: 35px">教务系统</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>


            <div style="color: #181818;font-size: 25px;padding:30px 0 0 20px">功能模块</div>
            <router-link to="/teacherScore">
              <button class="button1" style="margin-left: 35px">选课学生</button>
            </router-link>
            <router-link to="/courseInfo">
              <button class="button1">课程信息</button>
            </router-link>

            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>
            <button class="button1" style="margin-left: 35px">网络课程</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>

            <div style="color: #181818;font-size: 25px;padding:30px 0 0 20px">快捷入口</div>
            <button class="button1" style="margin-left: 35px">教务系统</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>
            <button class="button1">网络课程</button>
          </div>
        </a-layout-content>
        <a-layout-sider style="width: 300px">
          <div id="globalSide">
            <div class="userBasicInfo">
              <div class="avatar-container">
                <img src="@/assets/avatar.jpg" alt="头像" class="avatar">
              </div>
              <div class="info">
                姓名: {{ userInfo.name }} <br><br>
                工号:{{userInfo.teacherId}}
              </div>
              <div class="logout">
                <button class="logout-btn" @click="logout">登 出</button>
              </div>
            </div>
          </div>

          <div class="detailInfo">
            <div style="text-align: center ;font-size: 16px; padding:10px 0 0 0">个人详情</div>
            <p style="margin-left: 20px">学院: {{ userInfo.college }}</p>
            <p style="margin-left: 20px">班级: {{ userInfo.classId }}</p>
            <a-divider style="margin:0 0 10px 0"/>
            <div class="personalIntroduction">
              <div style="font-size: 16px ; text-align: center;margin-bottom: 5px">个人介绍</div>
              <div class="personalIntroduction-content">
                {{userInfo.profile }}
              </div>
            </div>


          </div>

          <div class="notice">
            <div style="text-align: center ;font-size: 16px; padding:10px 0 0 0">消息通知</div>
            <div class="notice_text">
              <icon-exclamation-circle-fill :style="{fontSize:'25px',position: 'relative', top: '5px'} "/>
              <span>1门课程有未读课程通知</span>
            </div>
            <div class="notice_text">
              <icon-exclamation-circle-fill :style="{fontSize:'25px',position: 'relative', top: '5px'} "/>
              <span>1门课程作业尚未完成</span>
            </div>
            <div class="notice_text">
              <icon-exclamation-circle-fill :style="{fontSize:'25px',position: 'relative', top: '5px'} "/>
              <span>1门考试尚未完成</span>
            </div>
            <div class="notice_text">
              <icon-exclamation-circle-fill :style="{fontSize:'25px',position: 'relative', top: '5px'} "/>
              <span>4个系统通知未读</span>
            </div>


          </div>
        </a-layout-sider>
      </a-layout>
      <GlobalFooter/>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
import GlobalFooter from "@/components/GlobalFooter.vue";

import {useUserStore} from "@/stores/user.ts";

import {storeToRefs} from 'pinia'

const userStore = useUserStore()
const {userInfo} = storeToRefs(userStore)

function logout() {
  localStorage.clear();
  userStore.clearUserInfo();
}

</script>

<style scoped>
#teacherHome {
  height: 100vh;
  overflow: hidden;
}

.button1 {
  width: 22%;
  height: 50px;
  margin: 20px 20px 20px 20px;
}


.box {
  background-color: white;
  margin: 30px 30px 0 30px;
  height: 610px;
}

#globalSide {
  position: relative; /* 让子元素绝对定位基于它 */
  margin: 20px;
  background-color: white;
  padding: 10px;

}

.notice_text {
  margin-top: 10px;
}


.notice {
  background-color: white;
  margin: 20px;
  height: 200px;
  color: #181818;
}


.personalIntroduction-content {
  margin: 10px;
  text-indent: 2em;
  font-family: 'Microsoft YaHei', '宋体', SimSun, Arial, sans-serif;
  font-size: 13px; /* 保持原有字号 */
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 7;
  -webkit-box-orient: vertical;
  line-height: 1.6;
}


.detailInfo {
  background-color: white;
  margin: 20px;
  height: 300px;
  color: #181818;
}


.info {
  color: #181818;
  margin-left: 15px;

}


.logout-btn {
  position: absolute;
  right: 0;
  top: 0;
  height: 100%;
  width: 48px; /* 你可以调整宽度 */
  writing-mode: vertical-rl;
  text-orientation: mixed;
  background: #ea9b9b;
  border: none;
  border-radius: 8px 0 0 8px;
  color: #333;
  font-size: 18px;
  cursor: pointer;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  transition: background 0.2s;
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}

.logout-btn:hover {
  background: #e0e0e0;
}


.userBasicInfo {
  display: flex;
  align-items: center;
}

.avatar-container {
  width: 60px;
  height: 60px;
  border-radius: 50%; /* 圆形头像 */
  overflow: hidden; /* 隐藏超出部分 */
}

.avatar {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 保持比例填充 */
}



</style>