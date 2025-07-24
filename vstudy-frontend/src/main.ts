import './assets/main.css'
import {createApp} from 'vue'

import App from './App.vue'
import router from './router'
import {createPinia} from "pinia";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import ArcoVue from '@arco-design/web-vue';
import '@arco-design/web-vue/dist/arco.css';
import {OpenAPI} from "../generated";
import {useUserStore} from "@/stores/user.ts";
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import { Icon } from '@arco-design/web-vue';

const app = createApp(App)
const pinia = createPinia()

app.use(pinia)
app.use(ArcoVueIcon);
app.use(router)
app.use(ArcoVue);
app.use(ElementPlus)
app.use(Icon)
pinia.use(piniaPluginPersistedstate)
app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}


