#  学生选课管理系统前端

**作者:vv   持续更新中**

## 介绍

这个一个采用了SpringBoot2 + Vue3 + Ts 的学生选课系统的**个人学习练手小项目**    拥有管理员、学生、教师三种角色。

这部分只是前端代码，后端仓库地址：https://gitee.com/ccw-ccw/vstudy-backend

## 项目技术点

使用了Vite脚手架，TS组合式语法，Vue3，pinia，arco-design（字节的组件库）,element plus，openapi插件（根据Swagger自动编写 axios 请求）

## 项目开发进度

目前已经完成了登录功能，学生的选课和退课。教师对选课的学生进行评分和编写评语。管理员功能待开发中......

## 功能页面

### 登录：

![image-20250710234232104](https://ccwxiaonaofu.oss-cn-shanghai.aliyuncs.com/image-20250710234232104.png)

### 学生页面首页

![image-20250710234324192](https://ccwxiaonaofu.oss-cn-shanghai.aliyuncs.com/image-20250710234324192.png)

### 学生选课页面

![image-20250710234351038](https://ccwxiaonaofu.oss-cn-shanghai.aliyuncs.com/image-20250710234351038.png)

### 教师评分系统

![image-20250710234429980](https://ccwxiaonaofu.oss-cn-shanghai.aliyuncs.com/image-20250710234429980.png)

## 运行:

node版本为20.19.0

> npm install vue
>
> npm install vue-router
>
> npm install pinia
>
> npm install pinia-plugin-persistedstate
>
> npm install --save-dev @arco-design/web-vue
>
> npm install openapi-typescript-codegen -D
>
> npm install element-plus
>
> npm install @element-plus/icons-vue
>
> npm install axios
>
> npm install
>
> npm run dev

