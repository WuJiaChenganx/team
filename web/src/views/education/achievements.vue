<template>
  <div class="achievements">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="achievementsContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/education' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/education/achievements' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="achievementsAside">
        <div class="achievementsAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="achievementsAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="achievementsAsideItem"
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
      <div class="achievementsDetail">
        <div class="achievementsTitle">{{ pageItem.subTitle }}</div>
        <div class="studentAchievementsTitle">学生竞赛</div>
        <div class="studentAchievementsProfile">
          {{ studentAchievementsProfile }}
        </div>
        <div class="studentAchievementsTable">
          <el-table :data="studentAchievements" border>
            <el-table-column prop="name" label="比赛名称"></el-table-column>
            <el-table-column prop="student" label="项目负责人及成员">
            </el-table-column>
            <el-table-column prop="grade" label="等级"> </el-table-column>
            <el-table-column prop="teacher" label="指导老师"> </el-table-column>
          </el-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getStudentAwardURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "教育教学",
        subTitle: "教学成果",
        home: "首页",
      },
      englishItem: {
        allTitle: "Education",
        subTitle: "achievements",
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
      studentAchievementsProfile: "",
      studentAchievements: [],
    };
  },
  created() {
    this.getAchievementList();
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
    async getAchievementList() {
      let params = {
        languageType: this.$store.getters.getLanguageType,
      };
      await getStudentAwardURL(params).then((res) => {
        this.studentAchievements = res.data;
        this.studentAchievementsProfile = res.summarize;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .achievements {
    width: 100%;
  }
  .achievementsContent {
    width: 85%;
    margin: 0 auto;
    display: flex;
    flex-achievements: row;
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

  .achievementsAside {
    width: 20%;
    padding-right: 30px;
  }

  .achievementsAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .achievementsAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .achievementsAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .achievementsAsideContent {
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

  .achievementsAsideItem {
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
  .achievementsAsideItem:last-child {
    border-bottom: none;
  }
  .achievementsAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .achievementsAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .achievementsDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .achievementsTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }

  .studentAchievementsTitle {
    height: 4.5rem;
    width: 100%;
    margin: 1rem 0;
    background-size: cover !important;
    background: url(../../assets/images/background/title-bg.png) no-repeat;
    font-weight: bold;
    line-height: 4.5rem;
    padding-left: 2.5rem;
    font-size: 2rem;
    text-align: left;
    color: #404040;
  }
  .studentAchievementsProfile {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
  .studentAchievementsTable {
    width: 100%;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .achievements {
    width: 100%;
  }
  .achievementsContent {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }

  .achievementsAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .achievementsAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .achievementsAsideTitle span img {
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
  .achievementsAsideItem span img {
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
  .achievementsDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 36rem - 112px);
  }
  .achievementsTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }

  .studentAchievementsTitle {
    height: 4.5rem;
    width: 100%;
    margin: 1rem 0;
    background-size: cover !important;
    background: url(../../assets/images/background/title-bg.png) no-repeat;
    font-weight: bold;
    line-height: 4.5rem;
    padding-left: 1.5rem;
    font-size: 2rem;
    text-align: left;
    color: #404040;
  }
  .studentAchievementsProfile {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
  .studentAchievementsTable {
    width: 100%;
  }
}
</style>
