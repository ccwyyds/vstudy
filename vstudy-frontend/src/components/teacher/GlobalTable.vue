<template>
  <div style="height: 100% ; padding: 50px 100px 50px 100px;">

    <el-table :data="filteredCourseScoreList" style="width: 100%" border="border">

      <el-table-column label="学生" prop="studentName" align="center"/>
      <el-table-column label="课程" prop="courseName" align="center"/>
      <el-table-column label="分数" prop="mark" align="center">
        <template #default="{ row }">
          <el-input
              v-model="row.mark"
              type="number"
              placeholder="请输入分数"
              style="width: 150px"
              @blur="() => updateScore(row)"
              @keyup.enter.native="handleEnter(row, $event)"
              ref="inputRefs"
              :input-style="{ color: row.mark < 60 ? 'red' : '' }"
          />
        </template>
      </el-table-column>
      <el-table-column label="评语" prop="comment" align="center">
        <template #default="{ row }">
          <el-input
              v-model="row.comment"
              type="textarea"
              placeholder="请输入评语"
              style="width: 300px"
              @blur="() => updateScore(row)"
              @keyup.enter.native="handleEnter(row, $event)"
              ref="inputRefs"
          />
        </template>
      </el-table-column>


    </el-table>

  </div>
</template>

<script setup lang="ts">
import {computed, ref, watch} from 'vue';
import {CourseMarkControllerService} from '../../../generated';
import {useSearchStore} from "@/stores/search.ts";
import {onBeforeRouteLeave} from "vue-router";

const res = defineProps<{ courseScoreList: any[] }>();


const userSearch = useSearchStore();

// 全局搜索
const filteredCourseScoreList = computed(() =>
    res.courseScoreList.filter(
        (data) => {
          const keyword = userSearch.keyword.toLowerCase();
          return (
              !keyword ||
              data.studentName.toLowerCase().includes(keyword) ||
              data.courseName.toLowerCase().includes(keyword) ||
              (data.comment && data.comment.toLowerCase().includes(keyword))
          );
        }
    )
)
// 跳转页面自动清空关键字
onBeforeRouteLeave(() => {
  userSearch.keyword = ''
})


const inputRefs = ref([]);
//回车键修改成绩
const handleEnter = (row: any, event: KeyboardEvent) => {
  updateScore(row); // 执行更新逻辑
  (event.target as HTMLInputElement).blur(); // 手动触发失焦
};


// 更新成绩方法：失焦后调用
const updateScore = async (row: any) => {
  const num = Number(row.score);
  if (isNaN(num)) {
    row.score = '';
    return;
  }


  // 限制范围（可选）
  if (num > 100) row.score = 100;
  if (num < 0) row.score = 0;

  // 构造对象
  const courseMark = {
    courseId: row.courseId,
    studentId: row.studentId,
    mark: row.mark,
    comment: row.comment || '',
  };

  try {
    const res = await CourseMarkControllerService.updateCourseMarkUsingPut(courseMark);
    console.log('更新成功', res);
  } catch (err) {
    console.error('更新失败', err);
  }
};
</script>

<style scoped>
.el-sub-menu.is-opened > .el-sub-menu__title .el-sub-menu__icon-arrow {
  display: none;
}

.el-sub-menu > .el-sub-menu__title .el-sub-menu__icon-arrow {
  display: none;
}

</style>