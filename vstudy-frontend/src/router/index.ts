import {createRouter, createWebHistory} from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import StudentHomeView from "@/views/student/StudentHomeView.vue";
import TeacherHomeView from "@/views/teacher/TeacherHomeView.vue";
import AdminHomeView from "@/views/admin/AdminHomeView.vue";
import ChooseCourseView from "@/views/student/ChooseCourseView.vue";
import {useUserStore} from "@/stores/user.ts";
import TeacherScoreView from "@/views/teacher/TeacherScoreView.vue";
import MarkSearchView from "@/views/student/MarkSearchView.vue";


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'login1',
            component: LoginView,
        },
        {
            path: '/login',
            name: 'login2',
            component: LoginView,
        },
        {
            path: '/student',
            name: '学生教务系统',
            component: StudentHomeView,
            meta: {isAuth: true, title: '学生教务系统', access: "student"}
        },
        {
            path: '/teacher',
            name: '教师工作系统',
            component: TeacherHomeView,
            meta: {isAuth: true, title: '教师工作系统', access: "teacher"}
        },
        {
            path: '/admin',
            name: '管理员控制平台',
            component: AdminHomeView,
            meta: {isAuth: true, title: '管理员控制平台', access: "admin"}
        },
        {
            path: '/chooseCourse',
            name: '学生选课平台',
            component: ChooseCourseView,
            meta: {isAuth: true, title: '学生选课平台', access: "student"}
        },
        {
            path: '/teacherScore',
            name: '教师评分系统',
            component: TeacherScoreView,
            meta: {isAuth: true, title: '教师评分系统', access: "teacher"}
        },
        {
            path: '/markSearch',
            name: '学生分数查询',
            component: MarkSearchView,
            meta: {isAuth: true, title: '学生分数查询平台', access: "student"}
        },
    ],
})


router.beforeEach((to, from, next) => {
    const userStore = useUserStore()
    // 判断目标路由是否需要登录
    if (to.meta.isAuth) {
        console.log("当前所需权限为" + to.meta.access)
        // 判断用户是否已登录（比如有 token）
        if (!userStore.loginUser || !userStore.loginUser.token || (userStore.loginUser.role !== to.meta.access)) {
            next('/login')
            return
        }
    }
    next()
})


export default router
