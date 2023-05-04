<template>
  <div class="master">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="masterContent">
      <div class="masterAside">
        <div class="masterAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="masterAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="masterAsideItem"
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
      <div class="masterDetail">
        <div class="masterTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/educatiopn/master' }">{{
                pageItem.master
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="masterItem">
          <div
            class="detailItem"
            v-for="courseItem in courses"
            :key="courseItem.courseType"
          >
            <div class="courseName">{{ courseItem.courseName }}</div>
            <div class="courseTeacher">{{ courseItem.teacher }}</div>
          </div>
        </div>
        <div class="paging">
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
import { getCourseURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "教育教学",
        subTitle: "课程教学",
        home: "首页",
        master: "研究生教学",
      },
      englishItem: {
        allTitle: "Education",
        subTitle: "Education",
        home: "home",
        master: "master",
      },
      menu: [],
      menuZH: [
        { name: "本科生教学", path: "/education/undergraduate" },
        { name: "研究生教学", path: "/education/master" },
        { name: "教学成果", path: "/education/achievements" },
      ],
      menuEN: [
        { name: "undergraduate", path: "/education/undergraduate" },
        { name: "graduate", path: "/education/master" },
        { name: "achievements", path: "/education/achievements" },
      ],
      // 总共要展示的数量
      total_number: 0,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
      courses: [],
    };
  },
  created() {
    this.getCourseList();
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
    async getCourseList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
        languageType: this.$store.getters.getLanguageType,
        type: "master",
      };
      await getCourseURL(params).then((res) => {
        this.courses = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getCourseList();
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .master {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .masterContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .masterAside {
    width: 255px;
    margin-right: 20px;
  }
  .masterAsideTitle {
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
  .masterAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .masterAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .masterDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .masterTitle {
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

  .masterItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    cursor: pointer;
    display: flex;
    flex-direction: row;
    border-bottom: 1px dashed #b2b2b2;
    padding: 20px 0;
  }
  .detailItem:hover .courseName {
    color: #428bca;
  }
  .courseName {
    height: 2rem;
    line-height: 2rem;
    width: 70%;
    flex: 1 1 auto;
    font-size: 1.6rem;
    color: #333;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    text-align: left;
  }
  .courseTeacher {
    font-size: 1.6rem;
    color: #b2b2b2;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .masterAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }

  .masterAsideTitle {
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

  .masterDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .masterTitle {
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
  .masterItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detailItem {
    cursor: pointer;
    display: flex;
    flex-direction: row;
    border-bottom: 1px dashed #b2b2b2;
    padding: 15px 0;
  }

  .courseName {
    height: 2rem;
    line-height: 2rem;
    width: 70%;
    flex: 1 1 auto;
    font-size: 1.6rem;
    color: #333;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    text-align: left;
  }
  .courseTeacher {
    font-size: 1.6rem;
    color: #b2b2b2;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
