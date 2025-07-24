<script setup lang="ts">
import {RouterView} from 'vue-router'
import router from "@/router";
import {useUserStore} from "@/stores/user.ts";
const userStore = useUserStore();

if (userStore.loginUser.userId === 0) {
  router.push("/login");
}

</script>

<template id="app">
  <RouterView/>
</template>

<style scoped>
#app {
  height: 100%;
}
</style>
