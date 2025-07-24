<template>
  <div style="display: flex;height: 100vh;flex-direction: column;overflow: hidden;">
    <GlobalHeader/>

    <div style="height: 100%; padding: 50px 100px 50px 100px;">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="courseId" label="课程号" align="center"/>
        <el-table-column prop="courseName" label="课程名称" align="center"/>
        <el-table-column prop="courseClassroom" label="教室" align="center"/>
        <el-table-column prop="courseType" label="课程类型" align="center"/>
        <el-table-column prop="courseWeek" label="学时" align="center"/>
        <el-table-column prop="courseCollege" label="课程学院" align="center"/>
        <el-table-column prop="courseScore" label="学分" align="center"/>
        <el-table-column prop="studentId" label="学号" align="center"/>
        <el-table-column prop="studentName" label="学生姓名" align="center"/>
        <el-table-column prop="teacherName" label="任课老师" align="center"/>
        <el-table-column prop="mark" label="分数" align="center"/>
        <el-table-column prop="gradePoint" label="绩点" align="center"/>
      </el-table>
    </div>

    <GlobalFooter/>


  </div>


</template>

<script setup lang="ts">

import GlobalHeader from "@/components/GlobalHeader.vue";
import GlobalFooter from "@/components/GlobalFooter.vue";
import {onMounted, ref} from "vue";
import {
  CourseControllerService,
  CourseMarkControllerService,
  StudentControllerService,
  TeacherControllerService
} from "../../../generated";
import {useUserStore} from "@/stores/user.ts";

const tableData = ref([
  {
    courseId: "",
    courseName: "",
    courseClassroom: "",
    courseType: "",
    courseWeek: "",
    courseCollege: "",
    courseScore: "",
    studentId: "",
    studentName: "",
    mark: "",
    teacherName: "",
    gradePoint: ""
  }
])


const userStore = useUserStore();
onMounted(async () => {
  //先获取当前学号的已选课程信息
  const res = await CourseMarkControllerService.getByStudentIdUsingGet(userStore.loginUser.userId)
  if (res.code === '200') {
    //提取出每一项的courseId,查出具体的课程信息
    const enrichedData = await Promise.all(res.data.map(async (item: any) => {
      const courseInfoRes = await CourseControllerService.getCourseByCourseIdUsingGet(item.courseId);
      const teacherName = (await TeacherControllerService.getTeacherNameByTeacherIdUsingGet(courseInfoRes.data.teacherId)).data
      const studentName = (await StudentControllerService.getStudentByStudentIdUsingGet(item.studentId)).data.name
      console.log(courseInfoRes)
      const gradePoint = Math.round(courseInfoRes.data.courseScore * (item.mark / 100.0) * 100) / 100;
      return {
        ...item,
        ...courseInfoRes.data,
        teacherName: teacherName,
        studentName: studentName,
        gradePoint: gradePoint ? gradePoint : "未判分",
      }
    }))

    tableData.value = enrichedData
    console.log(tableData.value)
  }


})


</script>

<style scoped>

</style>