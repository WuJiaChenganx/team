<template>
  <div class="achievements">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="achievementsContent">
      <div class="achievementsAside">
        <div class="achievementsAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="achievementsAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="achievementsAsideItem"
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
      <div class="achievementsDetail">
        <div class="achievementsTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/education/achievements' }">{{
                pageItem.achievements
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="achievementsItem">
          <div class="titleBackground">学生竞赛</div>
          <div class="introduction">
            作为毕业设计导师累计培养本科毕业生30多人，作为指导老师指导浙江工业大学计算机学院机器人队参加国家级赛事并获得国家一等奖9次，国家二等奖13次，累计输送保研（直博、海外直博）学生20多人。
          </div>
          <div class="competitionTable">
            <el-table :data="tableData" border style="width: 99%">
              <el-table-column prop="name" label="比赛名称"></el-table-column>
              <el-table-column prop="student" label="项目负责人及成员">
              </el-table-column>
              <el-table-column prop="grade" label="等级"> </el-table-column>
              <el-table-column prop="teacher" label="指导老师">
              </el-table-column>
            </el-table>
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
        allTitle: "教育教学",
        subTitle: "成果",
        home: "首页",
        achievements: "教学成果",
      },
      englishItem: {
        allTitle: "Education",
        subTitle: "achievements",
        home: "home",
        achievements: "achievements",
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
      tableData: [
        {
          id: 18,
          grade: "二等奖",
          name: "2022中国机器人大赛暨RoboCup机器人世界杯中国赛-机器人先进视觉赛-3D识别项目",
          teacher: "邱杰凡、姚信威",
          student: "丰泽辉、陈翰墨、杨正一、孙辰赫、盛嘉、屠恒彦、姜易臻",
        },
        {
          id: 20,
          grade: "一等奖",
          name: "2021中国机器人大赛机器人先进视觉赛-工业测量项目",
          teacher: "姚信威",
          student: "童文韬、沈根行、张宇健、刘硕、张扬、徐子艺、申屠琦超",
        },
        {
          id: 19,
          grade: "一等奖",
          name: "2021中国机器人大赛机器人先进视觉赛-3D识别项目",
          teacher: "姚信威",
          student: "刘硕、张扬、徐子艺、申屠琦超、童文韬、沈根行、张宇健",
        },
        {
          id: 23,
          grade: "三等奖",
          name: "2020年中国机器人大赛足球机器人RoboCup小型组",
          teacher: "姚信威",
          student: "赵雨舟、何海煜、孙博航、王炜博等",
        },
        {
          id: 21,
          grade: "冠军/一等奖",
          name: "2020年中国机器人大赛机器人先进视觉赛-3D识别项目",
          teacher: "姚信威",
          student: "陈兴迪、林泽、朱叙行、丁晨俊、杨振鑫等",
        },
        {
          id: 22,
          grade: "冠军/一等奖",
          name: "2020年中国机器人大赛机器人先进视觉赛-3D测量项目",
          teacher: "姚信威",
          student: "陈兴迪、林泽、朱叙行、丁晨俊、杨振鑫等",
        },
        {
          id: 25,
          grade: "冠军/一等奖",
          name: "2019中国机器人大赛先进视觉3D识别项目",
          teacher: "姚信威",
          student: "洪佳升、潘律翰、朱启月",
        },
        {
          id: 24,
          grade: "冠军/一等奖",
          name: "2019中国机器人大赛先进视觉3D测量项目",
          teacher: "姚信威",
          student: "洪佳升、潘律翰",
        },
        {
          id: 26,
          grade: "优胜奖",
          name: "2019RoboCup机器人世界杯中国赛",
          teacher: "姚信威",
          student: "王诗毅、俞淦、陈茵、王宇鹏、黄益明、郑铁驰、王炜博、王金泽",
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
  .achievements {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .achievementsContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .achievementsAside {
    width: 255px;
    margin-right: 20px;
  }
  .achievementsAsideTitle {
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
  .achievementsAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .achievementsAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .achievementsDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .achievementsTitle {
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

  .achievementsItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .titleBackground {
    height: 4.5rem;
    margin: 1rem 0;
    background-size: cover !important;
    background: url(../../assets/images/background/title-bg.png) no-repeat;
    font-weight: bold;
    line-height: 4.5rem;
    padding-left: 2.5rem;
    font-size: 1.8rem;
    text-align: left;
    color: #404040;
  }
  .introduction {
    padding-left: 2.5rem;
    font-size: 1.6rem;
    font-weight: 400;
    color: #404040;
    line-height: 34px;
    text-align: left;
  }
  .competitionTable {
    margin-top: 1rem;
    padding-left: 2.5rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .achievementsAside {
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

  .achievementsDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .achievementsTitle {
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
  .achievementsItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .titleBackground {
    height: 4.5rem;
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
  .introduction {
    padding-left: 1.5rem;
    font-size: 2rem;
    font-weight: 400;
    color: #404040;
    line-height: 34px;
    text-align: left;
  }
  .competitionTable {
    margin-top: 1rem;
  }
}
</style>
