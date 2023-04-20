<template>
  <div class="curriculum">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="curriculumContent">
      <div class="curriculumAside">
        <div class="curriculumAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="curriculumAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="curriculumAsideItem"
              v-for="(menuItem, menuIndex) in menu"
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
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item
                :to="{ path: '/scientificResearch/curriculum' }"
                >{{ pageItem.curriculum }}</el-breadcrumb-item
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
      pageItem: {},
      chineseItem: {
        allTitle: "教学育人",
        subTitle: "课程教学",
        home: "首页",
        curriculum: "课程教学",
      },
      englishItem: {
        allTitle: "Education",
        subTitle: "Curriculum",
        home: "home",
        curriculum: "Curriculum",
      },
      menu: [],
      menuZH: [{ name: "课程教学", path: "/education/curriculum" }],
      menuEN: [{ name: "Curriculum", path: "/education/curriculum" }],
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
  created() {
    this.changUI();
  },
  methods: {
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.menu = this.menuZH;
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.menu = this.menuEN;
        this.pageItem = this.englishItem;
      }
    },
  },
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
    width: 255px;
    margin-right: 20px;
  }
  .curriculumAsideTitle {
    width: 255px;
    height: 78px;
    line-height: 78px;
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 24px;
  }
  .curriculumAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .curriculumAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .curriculumDetail {
    flex: 1 1 auto;
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
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    font-weight: bold;
    background-color: #fff;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    font-weight: bold;
    color: #034ea1;
    background: #eee;
  }

  .curriculumItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .detailItemCourseType {
    font-size: 2.5rem;
    font-weight: bold;
  }
  .detailItemCourseProfile {
    padding: 0.5rem 0;
    font-size: 2rem;
  }
  .detailItemCourseName {
    text-indent: 2em;
    font-size: 2rem;
    padding: 0.5rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .curriculumAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }

  .curriculumAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  /* 菜单横向排列 */
  .el-menu {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    width: 100%;
    background-color: rgba(0, 0, 0, 0) !important;
  }

  .el-menu-item {
    padding: 0 !important;
    border: 1px solid #ccc;
    width: 30%;
    line-height: 36px;
    height: 40px;
    margin: 0 1.6% 15px;
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
    background-color: #fff;
  }
  .el-icon-sunny {
    display: none;
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
    padding: 10px 0;
    border-bottom: 1px solid #dfdfdf;
  }

  .title {
    color: #333333;
    font-weight: bold;
    font-size: 20px;
    line-height: 30px;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
  }
  .curriculumItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .detailItemCourseType {
    font-size: 2.5rem;
    font-weight: bold;
    padding: 0.5rem 0;
  }
  .detailItemCourseProfile {
    padding: 0.8rem 0;
    font-size: 2.4rem;
  }
  .detailItemCourseName {
    text-indent: 2em;
    font-size: 2.2rem;
    padding: 0.8rem 0;
  }
}
</style>
