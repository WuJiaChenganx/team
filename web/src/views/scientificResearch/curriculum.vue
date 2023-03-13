<template>
  <div class="curriculum">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="curriculumContent">
      <div class="curriculumAside">
        <div class="curriculumAsideTitle">课程教学</div>
        <div class="curriculumAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="curriculumAsideItem"
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
      <div class="curriculumDetail">
        <div class="curriculumTitle">
          <div class="title">课程教学</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item
                :to="{ path: '/scientificResearch/curriculum' }"
                >课程教学</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="curriculumItem">
          <div
            class="detailItem"
            v-for="(courseItem, index) in courses"
            :key="courseItem.courseType"
          >
            <!-- 课程类型:本科生/研究生 -->
            <div class="detailItemCourseType">
              {{ index + 1 }}. {{ courseItem.courseType }}
            </div>
            <!-- 教学简介 -->
            <div class="detailItemCourseProfile">{{ courseItem.profile }}</div>
            <div
              v-for="courseListItem in courseItem.courseList"
              :key="courseListItem.id"
            >
              <div class="detailItemCourseName">
                {{ courseListItem.id }}. {{ courseListItem.courseName }}
              </div>
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
      currentMenu: "课程教学",
      Menu: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      courses: [
        {
          courseType: " 本科生教学",
          profile:
            "主讲:《人工智能导论》、《Principles of Computer Networks》(《计算机网络原理》留学生)、《计算机网络原理》、《无线传感器网络》",
          courseList: [
            {
              id: 1,
              courseName:
                "教育部2018年第一批产学合作协同育人项目，“基于Python的程序设计课程教学改革”，2019.02-2020.02，项目负责人，排名：1/4；",
            },
            {
              id: 2,
              courseName:
                "浙江工业大学校级教学改革项目，“物联网工程专业国际化人才培养模式的创新与实践”，2015.08-2016.12，项目负责人，排名1/6；",
            },
            {
              id: 3,
              courseName:
                "2018全国高校计算机教育大会优秀论文奖，“面向国际化人才培养的物联网工程专业课程体系改革探索-以浙江工业大学为例”，2018.04，教育部高等学校计算机类专业教学指导委员会，排名：1/4；",
            },
          ],
        },
        {
          courseType: " 研究生教学",
          profile:
            "主讲:《人工智能及其应用》、《Principles and Design of Wireless Sensor Networks》",
          courseList: [
            {
              id: 1,
              courseName:
                "浙江省“十四五”研究生课程思政示范课程，“人工智能及其应用”，2022.12，项目负责人，1/6；",
            },
            {
              id: 2,
              courseName:
                "浙江工业大学校级研究生核心课程建设项目，“人工智能及其应用”，2022.11-2023.12，项目负责人，1/4；",
            },
          ],
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
  .curriculum {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .curriculumContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .curriculumAside {
    width: 25%;
  }
  .curriculumAsideTitle {
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
  .curriculumAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .curriculumDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .curriculumTitle {
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

  .curriculumItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    line-height: 3rem;
    margin-top: 1.5rem;
    text-align: left;
  }
  .detailItemCourseType {
    font-size: 2rem;
    font-weight: bold;
  }
  .detailItemCourseProfile {
    font-size: 1.8rem;
  }
  .detailItemCourseName {
    text-indent: 2em;
    font-size: 1.6rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .curriculum {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .curriculumContent {
    display: flex;
    flex-direction: column;
  }

  .curriculumAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .curriculumAsideTitle {
    display: none;
  }
  .curriculumAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .curriculumDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .curriculumTitle {
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

  .curriculumItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    line-height: 3rem;
    margin-top: 1.5rem;
    text-align: left;
  }
  .detailItemCourseType {
    font-size: 2rem;
    font-weight: bold;
  }
  .detailItemCourseProfile {
    font-size: 1.8rem;
  }
  .detailItemCourseName {
    text-indent: 2em;
    font-size: 1.6rem;
  }
}
</style>
