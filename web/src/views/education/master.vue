<template>
  <div class="master">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="masterContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/education' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/education/master' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="masterAside">
        <div class="masterAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="masterAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="masterAsideItem"
              v-for="(menuItem, menuIndex) in menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <span>
                <img
                  src="../../assets/images/background/asideSubtitle.png"
                  alt=""
                />
                {{ menuItem.name }}
              </span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="masterDetail">
        <div class="masterTitle">
          {{ pageItem.subTitle }}
        </div>
        <div class="masterItemContent">
          <div
            class="masterItem"
            v-for="(detailItem, detailIndex) in courses"
            :key="detailIndex"
          >
            <div class="masterItemCourse">
              <img src="../../assets/images/background/list.png" alt="" />
              {{ detailItem.courseName }}
            </div>
            <div class="masterItemTeacher">{{ detailItem.teacher }}</div>
          </div>
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
        subTitle: "研究生教学",
        home: "首页",
      },
      englishItem: {
        allTitle: "Education",
        subTitle: "master",
        home: "home",
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
        start: 0,
        end: 100,
        languageType: this.$store.getters.getLanguageType,
        type: "master",
      };
      await getCourseURL(params).then((res) => {
        this.courses = res.data;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .master {
    width: 100%;
  }
  .masterContent {
    width: 85%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 15px;
  }
  .breadCrumb {
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
    margin-bottom: 15px;
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

  .masterAside {
    width: 20%;
    padding-right: 30px;
  }

  .masterAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .masterAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .masterAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .masterAsideContent {
    width: 100%;
  }
  /* 去除侧边栏自带的边框 */
  .el-menu {
    border: none !important;
  }
  /* 去除侧边导航自带的边距 */
  .el-menu-item {
    padding: 0 !important;
  }
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    color: #fff !important;
    font-weight: bold;
    background-color: #4b74bb;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    color: #fff;
    font-weight: bold;
    background-color: #4b74bb;
  }

  .masterAsideItem {
    position: relative;
    width: 100%;
    height: 46px;
    line-height: 46px;
    font-size: 18px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }
  /* 最后一个侧边栏没有下划线 */
  .masterAsideItem:last-child {
    border-bottom: none;
  }
  .masterAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .masterAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .masterDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
    margin-bottom: 1rem;
  }
  .masterTitle {
    width: 100%;
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }
  .masterItemContent {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  .masterItem {
    width: 49%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    border-bottom: 1px dashed #b2b2b2;
  }
  .masterItemCourse {
    width: 70%;
    text-align: left;
    font-size: 1.8rem;
    line-height: 3.5rem;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .masterItemCourse img {
    width: 15px;
    height: 15px;
  }
  .masterItemTeacher {
    min-width: 120px;
    text-align: right;
    font-size: 1.8rem;
    line-height: 3.5rem;
    color: #b2b2b2;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .master {
    width: 100%;
  }
  .masterContent {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }

  .masterAside {
    order: 1;
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
  .masterAsideTitle span img {
    display: none;
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
  }
  .masterAsideItem span img {
    display: none;
  }
  .breadCrumb {
    order: 2;
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
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
  .masterDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 29rem - 139px);
    margin-bottom: 1rem;
  }
  .masterTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .masterItemContent {
    width: 100%;
  }
  .masterItem {
    display: flex;
    flex-direction: row;
    width: 100%;
    border-bottom: 1px dashed #b2b2b2;
  }

  .masterItemCourse {
    width: 70%;
    text-align: left;
    font-size: 1.8rem;
    line-height: 3.5rem;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .masterItemCourse img {
    width: 10px;
    height: 10px;
  }
  .masterItemTeacher {
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.8rem;
    line-height: 3.5rem;
    color: #b2b2b2;
  }
}
</style>
