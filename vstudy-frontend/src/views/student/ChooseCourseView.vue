<template>
  <div style="display: flex; flex-direction: column; height: 100vh;overflow: hidden">
    <div>
      <GlobalHeader/>
    </div>
    <div style=" overflow: hidden ;height: 100vh">
      <el-container class="layout-container-demo">

        <el-aside width="200px">
          <el-scrollbar>
            <el-menu :default-active="activeTab" @select="handleMenuSelect">
              <el-menu-item index="choose">
                <el-icon>
                  <Reading/>
                </el-icon>
                <span>选课页面</span>
              </el-menu-item>
              <el-menu-item index="already">
                <el-icon>
                  <Reading/>
                </el-icon>
                <span>已选课程</span>
              </el-menu-item>
            </el-menu>
          </el-scrollbar>
        </el-aside>


        <el-main>
          <el-scrollbar>

            <transition name="fade" mode="out-in">
              <div v-if="activeTab === 'choose'" key="choose">
                <el-container>
                  <el-main>
                    <el-scrollbar>
                      <el-table :data="filteredCourseScoreList" size="large">
                        <el-table-column prop="courseId" label="课程号" width="165"/>
                        <el-table-column prop="courseName" label="课程名称" width="165"/>
                        <el-table-column prop="teacherId" label="教师" width="165"/>
                        <el-table-column prop="courseClassroom" label="教室" width="165"/>
                        <el-table-column prop="courseType" label="课程类型" width="165"/>
                        <el-table-column prop="courseWeek" label="学时" width="165"/>
                        <el-table-column prop="courseCollege" label="所属院系" width="165"/>
                        <el-table-column prop="courseScore" label="学分" width="160"/>
                        <el-table-column prop="optionalCount" label="已选人数" width="160"/>
                        <el-table-column prop="selectedCount" label="可选人数" width="160"/>
                        <el-table-column fixed="right" label="选课状态" min-width="120">
                          <template #default="scope">
                            <el-button
                                type="primary"
                                size="small"
                                plain
                                @click="choose(scope.row)"
                            >{{ scope.row.state }}
                            </el-button>
                          </template>
                        </el-table-column>
                      </el-table>

                      <div class="pageButton">
                        <el-pagination
                            background
                            layout="prev, pager, next"
                            :total="chooseTotal"
                            :page-size="pageSize"
                            :current-page="currentPage"
                            @current-change="handlePageChange"
                        />
                      </div>
                    </el-scrollbar>
                  </el-main>
                </el-container>
              </div>

              <div v-else key="already">
                <el-container>
                  <el-main>
                    <el-scrollbar>
                      <el-table :data="filteredCourseScoreList" size="large">
                        <el-table-column prop="courseId" label="课程号" width="165"/>
                        <el-table-column prop="courseName" label="课程名称" width="165"/>
                        <el-table-column prop="teacherId" label="教师" width="165"/>
                        <el-table-column prop="courseClassroom" label="教室" width="165"/>
                        <el-table-column prop="courseType" label="课程类型" width="165"/>
                        <el-table-column prop="courseWeek" label="学时" width="165"/>
                        <el-table-column prop="courseCollege" label="所属院系" width="165"/>
                        <el-table-column prop="courseScore" label="学分" width="160"/>
                        <el-table-column prop="optionalCount" label="已选人数" width="160"/>
                        <el-table-column prop="selectedCount" label="可选人数" width="160"/>
                        <el-table-column fixed="right" label="选课状态" min-width="120">
                          <template #default="scope">
                            <el-button
                                type="primary"
                                size="small"
                                plain
                                @click="choose(scope.row)"
                            >{{ scope.row.state }}

                            </el-button>
                          </template>
                        </el-table-column>
                      </el-table>
                      <div class="pageButton">
                        <el-pagination
                            background
                            layout="prev, pager, next"
                            :total="alreadyTotal"
                            :page-size="pageSize"
                            :current-page="currentPage"
                            @current-change="handlePageChange"
                        />
                      </div>

                    </el-scrollbar>
                  </el-main>
                </el-container>
              </div>


            </transition>
          </el-scrollbar>
        </el-main>


      </el-container>

    </div>
    <div>
      <global-footer/>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {computed, onMounted, ref} from 'vue'
import GlobalHeader from "@/components/GlobalHeader.vue"
import GlobalFooter from "@/components/GlobalFooter.vue"
import {CourseControllerService, CourseMarkControllerService, TeacherControllerService} from "../../../generated"
import {useUserStore} from "@/stores/user.ts";
import router from "@/router";
import {useSearchStore} from "@/stores/search.ts";

const tableData = ref<any[]>([]) // 初始化为空数组
const alreadyTableData = ref([])
const currentPage = ref(1)
const pageSize = ref(10)
const chooseTotal = ref(0)
const alreadyTotal = ref(0)

const userStore = useUserStore();
const activeTab = ref('choose');
const userSearch = useSearchStore();

//全局搜索
const filteredCourseScoreList = computed(() => {
  const keyword = userSearch.keyword?.toLowerCase?.() || ''
  const list = (activeTab.value === "choose" ? tableData.value : alreadyTableData.value) || [] // 防止 tableData.value 为 null
  return Array.isArray(list)
      ? list.filter((data: any) => {
        console.log("过滤中：", data)
        return (
            !keyword ||
            String(data.courseId).toLowerCase().includes(keyword) || // 先转成字符，否则无效
            data.courseName?.toLowerCase?.().includes(keyword) ||
            data.courseType?.toLowerCase?.().includes(keyword) ||
            data.teacherId?.toLowerCase?.().includes(keyword)
        )
      })
      : []


})


//页面跳转
function handleMenuSelect(index: string) {
  activeTab.value = index
  fetchCoursesByPage()
}

// 分页加载函数
const fetchCoursesByPage = async () => {
  const res = await CourseControllerService.pageUsingGet(currentPage.value, pageSize.value)
  if (res.code === "200" && res.data?.records) {
    chooseTotal.value = res.data.total
    tableData.value = await Promise.all(
        res.data.records.map(async (item: any) => {
          const teacherRes = await TeacherControllerService.getTeacherNameByTeacherIdUsingGet(item.teacherId)
          const stateRes = await CourseMarkControllerService.getByStudentIdAndCourseIdUsingGet(item.courseId, userStore.loginUser.userId)
          // console.log(scope.row.courseId)

          //判断状态
          return {
            ...item,
            teacherId: teacherRes.data,
            state: stateRes.data === null ? "选课" : "已选"
          }
        })
    )

  }
}


//已选课程
const fetchAlreadyCourses = async () => {
  // 1. 先查已选课程列表
  const res = await CourseMarkControllerService.pageUsingGet1(currentPage.value, pageSize.value, userStore.loginUser.userId)
  console.log(res)
  if (res.code === "200" && res.data?.records) {
    alreadyTotal.value = res.data.total
    // 2. 再查每个课程的详情
    alreadyTableData.value = await Promise.all(
        res.data.records.map(async (item: any) => {
          const courseRes = await CourseControllerService.getCourseByCourseIdUsingGet(item.courseId)
          const teacherRes = await TeacherControllerService.getTeacherNameByTeacherIdUsingGet(courseRes.data.teacherId)
          return {
            ...courseRes.data, // 展开课程详情
            teacherId: teacherRes.data,
            ...item,       // 保留原有字段
            state: "已选" // 固定是已选
          }
        })
    )
  }
}


// 页码切换时触发
const handlePageChange = (page: number) => {
  currentPage.value = page
  if (activeTab.value === 'choose') {
    fetchCoursesByPage()
  } else if (activeTab.value === 'already') {
    fetchAlreadyCourses()
  }
}

// 页面挂载后自动请求第一页
onMounted(() => {
  console.log('组件挂载完成！')
  fetchCoursesByPage()
  fetchAlreadyCourses()
})

//选课点击事件
async function choose(row: any) {
  if (row.state === "已选") {
    //已选了再次点击就删除
    await CourseMarkControllerService.delUserUsingDelete2(row.courseId, userStore.loginUser.userId)
    await fetchAlreadyCourses()
    row.state = "选课"
  } else {
    await CourseMarkControllerService.addUserUsingPost2({

      courseId: row.courseId,
      studentId: userStore.loginUser.userId
    })
    row.state = "已选"
    await fetchAlreadyCourses()
  }
}


</script>


<style>
.el-sub-menu.is-opened > .el-sub-menu__title .el-sub-menu__icon-arrow {
  display: none;
}

.el-sub-menu > .el-sub-menu__title .el-sub-menu__icon-arrow {
  display: none;
}

.pageButton {
  position: fixed;
  bottom: 300px;
  height: 40px;
  width: 100%;
  margin-left: 1400px;
}

.fade-enter-active, .fade-leave-active {
  transition: opacity 0.3s;
}

.fade-enter-from, .fade-leave-to {
  opacity: 0;
}


</style>