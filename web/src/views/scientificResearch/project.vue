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
              {{ projectItem.id }}. 项目名称: {{ projectItem.projectName }}
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
            <div class="detailItemProjectInfo">
              项目简介: {{ projectItem.projectInfo }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
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
      projects: [
        {
          id: 1,
          projectName: "无线网络性能分析、优化与保障研究",
          responser: "姚信威",
          projectType: "基金委-杰出青年科学基金项目",
          time: "2016-2021",
          projectInfo:
            "本项目将以物联网为背景，研究以能量为中心的无源网络体系结构中的关键科学问题，例如外部能量的建模、弱能量下的节点设计、弱能量下的计算、弱能量下的路由和数据融合、弱能量下的节点定位和跟踪、弱能量下的深度感知等;并在此基础之上，建立由无源节点组成的新型网络体系结构。",
        },
        {
          id: 2,
          projectName: "跨域协同的多模态高效感知与增强智能",
          responser: "姚信威",
          projectType: "基金委-应急项目",
          time: "2018-2022",
          projectInfo:
            "本项目着重解决相关的数据共享交易中的三个核心科学问题：1）数据标记体系和权限管理，2）面向需求的可信安全数据共享机制和计算模式，3）面向参与实体的信誉管理和追责。项目拟构建数据资产的标记、确权模型和理论，研究适合大数据共享交易环节的安全高效共享计算方法，建立对参与实体的信誉管理和追责机制和方法，构建安全可信的数据共享与计算的基础理论体系，并搭建应用验证示范平台。",
        },
        {
          id: 3,
          projectName: "大数据共享与交易中的数据安全可信研究 ",
          responser: "姚信威",
          projectType: "基金委-重点项目",
          time: "2022-2023",
          projectInfo:
            "本项目着重解决相关的数据共享交易中的三个核心科学问题：1）数据标记体系和权限管理，2）面向需求的可信安全数据共享机制和计算模式，3）面向参与实体的信誉管理和追责。项目拟构建数据资产的标记、确权模型和理论，研究适合大数据共享交易环节的安全高效共享计算方法，建立对参与实体的信誉管理和追责机制和方法，构建安全可信的数据共享与计算的基础理论体系，并搭建应用验证示范平台。",
        },
      ],
    };
  },
  created() {},
  methods: {},
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
}
</style>
