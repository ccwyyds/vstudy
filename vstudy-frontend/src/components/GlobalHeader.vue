<template>
  <div id="globalHeader">
    <div class="logo">
      <img src="../assets/logo2.png">
    </div>
    <div class="fontStyle">
      {{ routeName }}
    </div>
    <div class="globalSearch">
      <a-space direction="vertical" size="large">
        <a-input-search
            v-model="userSearch.keyword"
            :style="{width:'320px'}"
            placeholder="请输入关键词进行搜索"/>
      </a-space>
    </div>
    <div style="padding-right: 50px">
      <a-button type="primary" :href="routePush">
        <template #icon>
          <icon-reply/>
        </template>
        <template #default>返回首页</template>
      </a-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useRoute} from 'vue-router';
import {computed, ref} from 'vue';
import {useUserStore} from "@/stores/user.ts";
import {useSearchStore} from "@/stores/search.ts";

const route = useRoute();
const routeName = computed(() => route.name);

const userStore = useUserStore();
const userSearch = useSearchStore();

const routePush = userStore.loginUser.role;


</script>

<style scoped>

#globalHeader {
  display: flex;
  align-items: center;
  padding: 0 24px;
  /* justify-content 默认是 flex-start，logo 就会靠左 */
  justify-content: space-between;
}

.logo {
  margin-right: 32px; /* 给 logo 和搜索框之间加点距离 */
}

.fontStyle {
  font-size: 50px;
  color: #5454b0;
  font-family: "Adobe 黑体 Std R";
  letter-spacing: 100px;
}


</style>
