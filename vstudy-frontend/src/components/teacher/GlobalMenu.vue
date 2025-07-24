<template>
  <div>
    <a-menu
        :style="{ width: '200px', height: '100%' }"
        :default-open-keys="['0']"
        :default-selected-keys="['0']"
        :selected-keys="selectedKeys"
    >
      <a-menu-item style="padding-left: 30px; font-size: 20px">课 程 列 表</a-menu-item>

      <a-menu-item
          v-for="(course, index) in courseList"
          :key="`course_${index}`"
          @click="handleClick(course,index)"
          style="padding-left: 30px"
      >
        {{ course.courseName }}
      </a-menu-item>
    </a-menu>

  </div>
</template>


<script setup lang="ts">
//接受父传来的组件


import {ref, watch} from "vue";

const props = defineProps<{ courseList: any[] }>();
const selectedKeys = ref<string[]>([]);

const emit = defineEmits<{
  (e: 'selectCourse', num: number): void
}>()

// 可选的点击事件处理
const handleClick = (course: any, index: number) => {
  selectedKeys.value = [`course_${index}`];
  emit('selectCourse', course.courseId);
};

watch(() => props.courseList, (newVal) => {
  if (newVal.length > 0) {
    handleClick(newVal[0], 0);

  }
});

</script>

<style scoped>

/* 隐藏 Arco 的子菜单箭头 */
:deep(.arco-icon-down) {
  display: none !important;
}
</style>