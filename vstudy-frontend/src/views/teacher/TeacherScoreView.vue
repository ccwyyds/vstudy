<template>
  <div style="display: flex; flex-direction: column;height: 100vh;overflow: hidden">
    <GlobalHeader/>
    <div style="flex: 1; display: flex;overflow: hidden">
      <div>
        <GlobalMenu :course-list="courseList" @selectCourse="handleCourseSelect"/>
      </div>
      <div style="overflow-y: auto;width: 100%">
        <GlobalTable :courseScore-list="courseScoreList"/>
      </div>
    </div>


  </div>
</template>

<script setup lang="ts">

import GlobalHeader from "@/components/GlobalHeader.vue";
import GlobalTable from "@/components/teacher/GlobalTable.vue";
import GlobalMenu from "@/components/teacher/GlobalMenu.vue";
import {useUserStore} from "@/stores/user.ts";
import {
  CourseControllerService,
  CourseMarkControllerService,
  StudentControllerService,
} from "../../../generated";
import {onMounted, ref} from "vue";

//获取当前教师的所教课程
const userStore = useUserStore();
const courseList = ref([]);
const courseScoreList = ref([
  {
    studentId: "",
  }
]);

onMounted(async () => {
  const res1 = await CourseControllerService.getCourseByTeacherIdUsingGet(userStore.loginUser.userId)
  courseList.value = res1.data
})

const handleCourseSelect = async (courseId: number) => {
  const res2 = await CourseMarkControllerService.getCourseMarkByCourseMarkIdUsingGet(courseId);
  const courseName = (await CourseControllerService.getCourseByCourseIdUsingGet(courseId)).data.courseName;

  courseScoreList.value = await Promise.all(
      res2.data.map(async (item: any) => {
            const studentName = (await StudentControllerService.getStudentByStudentIdUsingGet(item.studentId)).data.name;
        console.log(item)
            return {
              courseName: courseName,
              studentName: studentName,
              ...item,       // 保留原有字段
            }
          }
      ));
  console.log(courseScoreList.value)

}


</script>


<style scoped>


</style>