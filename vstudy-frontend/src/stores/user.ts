import {ref, computed, reactive} from 'vue'
import {defineStore} from 'pinia'
import router from "@/router";
import path from "node:path";

export const useUserStore = defineStore('user', () => {
    const loginUser = ref({
        userId: 0,
        token: "",
        role: "",
    })
    const userInfo = ref({
        avatar: "",
        classId: "",
        college: "",
        name: "",
        profile: "",
        role: "",
        userId: "",
    })

    /**
     * 将获取的用户信息存储到loginUser对象中
     * @param data
     */
    const setLoginUser = (data: any) => {
        loginUser.value = data;
    };

    /**
     * 根据userId获取用户信息存入userInfo
     */
    const setUserInfoById = (data: any) => {
        userInfo.value = data;
    };

    // 退出时清除用户信息
    const clearUserInfo = () => {
        window.localStorage.clear()
        router.push({path: "/"})
    }


    return {
        loginUser,
        userInfo,
        setLoginUser,
        setUserInfoById,
        clearUserInfo,
    }

}, {persist: true,})
