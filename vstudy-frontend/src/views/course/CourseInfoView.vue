<template>
  <div style="display:flex ;height: 100vh; overflow: hidden;flex-direction: column">
    <GlobalHeader/>
    <div style="display: flex;margin: 20px;height: 100% ;width: 100%" >
      <el-collapse>
        <div style="display:flex; margin: 20px;">
          <el-collapse-item  v-for="(course ,index) in courseList " :key="index" :title="course.courseName" >
            <div style="display: flex;">
              <el-descriptions title="课程信息" number="3" direction="vertical" label-width="150px"  >
                <el-descriptions-item label="课程编号">{{ course.courseId }}</el-descriptions-item>
                <el-descriptions-item label="课程名字">{{ course.courseName }}</el-descriptions-item>
                <el-descriptions-item label="教师姓名">{{ course.teacherId }}</el-descriptions-item>
                <el-descriptions-item label="上课地点">{{ course.courseClassroom }}</el-descriptions-item>
                <el-descriptions-item label="课程类型">{{ course.courseType }}</el-descriptions-item>
                <el-descriptions-item label="课程学时">{{ course.courseWeek }}</el-descriptions-item>
                <el-descriptions-item label="所属院系">{{ course.courseCollege }}</el-descriptions-item>
                <el-descriptions-item label="课程分数">{{ course.courseScore }}</el-descriptions-item>
              </el-descriptions>
            </div>
          </el-collapse-item>
        </div>
      </el-collapse>
    </div>

    <GlobalFooter/>
  </div>
</template>

<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
import GlobalFooter from "@/components/GlobalFooter.vue";
import {CourseControllerService, CourseMarkControllerService, TeacherControllerService} from "../../../generated";
import {useUserStore} from "@/stores/user.ts";
import {onMounted, ref} from "vue";

const userStore = useUserStore();
const courseList = ref([
  {
    courseId: "",
    courseName: "",
    teacherId: "",
    courseClassroom: "",
    courseType: "",
    courseWeek: "",
    courseCollege: "",
    courseScore: "",
  }
])

//已选课程
const fetchAlreadyCourses = async () => {
  // 1. 先查已选课程列表
  const res = await CourseMarkControllerService.getByStudentIdUsingGet(userStore.loginUser.userId)
  // console.log(res)
  if (res.code === "200") {
    // 2. 再查每个课程的详情
    courseList.value = await Promise.all(
        res.data.map(async (item: any) => {
          const courseRes = await CourseControllerService.getCourseByCourseIdUsingGet(item.courseId)
          const teacherRes = await TeacherControllerService.getTeacherNameByTeacherIdUsingGet(courseRes.data.teacherId)
          return {
            ...courseRes.data, // 展开课程详情
            teacherId: teacherRes.data,
            ...item,       // 保留原有字段
          }
        })
    )
    console.log(courseList.value);
  }
}

//先查已选课程
onMounted(() => {
  console.log('组件挂载完成！')
  fetchAlreadyCourses();
})

</script>

<style scoped>

</style>