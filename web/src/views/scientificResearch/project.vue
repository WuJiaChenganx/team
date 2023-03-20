<template>
  <div class="project">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="projectContent">
      <div class="projectAside">
        <div class="projectAsideTitle">科研教学</div>
        <div class="projectAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="projectAsideItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span>{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="projectDetail">
        <div class="projectTitle">
          <div class="title">科研平台</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/scientificResearch/project' }"
                >科研平台</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="projectItem">
          <div
            class="detailItem"
            v-for="projectItem in projects"
            :key="projectItem.id"
          >
            <div class="detailItemProjectName">
              {{ projectItem.number }}. 项目名称: {{ projectItem.projectName }}
            </div>
            <div class="detailItemProjectResponser">
              项目负责人: {{ projectItem.responser }}
            </div>
            <div class="detailItemProjectType">
              项目类型: {{ projectItem.projectType }}
            </div>
            <div class="detailItemProjectTime">
              起止时间: {{ projectItem.time }}
            </div>
          </div>
        </div>
        <div class="paging">
          <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
          <el-pagination
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :page-size="10"
            :total="total_number"
            :current-page="current_index"
          >
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getProjectURL } from "@/api/api";
export default {
  data() {
    return {
      title: "科研教学",
      currentMenu: "科研项目",
      Menu: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      projects: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getProjectList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getProjectList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
      };
      await getProjectURL(params).then((res) => {
        this.projects = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getProjectList();
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .project {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .projectContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .projectAside {
    width: 25%;
  }
  .projectAsideTitle {
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 2rem;
    line-height: 3rem;
    height: 3rem;
    padding: 2rem 3rem;
    margin-bottom: 0.5rem;
  }
  .projectAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .projectDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .projectTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .projectItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    width: 100%;
    height: auto;
    margin-top: 3rem;
    text-align: left;
    font-family: 宋体;
    line-height: 3rem;
    font-size: 1.6rem;
    font-weight: bold;
  }
  .detailItemProjectName {
    font-size: 2rem;
  }
  .detailItemProjectInfo {
    font-weight: normal;
  }

  /* 设置分页和底部的距离 */
  .paging {
    margin: 3rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .project {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .projectContent {
    display: flex;
    flex-direction: column;
  }

  .projectAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .projectAsideTitle {
    display: none;
  }
  .projectAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .projectDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .projectTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  .projectItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    font-family: 宋体;
    line-height: 3rem;
    font-size: 1.6rem;
    font-weight: bold;
  }
  .detailItemProjectName {
    font-size: 2rem;
  }
  .detailItemProjectInfo {
    font-weight: normal;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin: 3rem 0;
  }
}
</style>
