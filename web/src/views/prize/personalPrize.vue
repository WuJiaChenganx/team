<template>
  <div class="personalPrize">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="personalPrizeContent">
      <div class="personalPrizeAside">
        <div class="personalPrizeAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="personalPrizeAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="personalPrizeAsideItem"
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
      <div class="personalPrizeDetail">
        <div class="personalPrizeTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/paper/personalPrize' }">{{
                pageItem.personalPrize
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="personalPrizeItem">
          <div
            class="detailItem"
            v-for="(detailItem, detailIndex) in personalPrizes"
            :key="detailIndex"
          ></div>
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
        allTitle: "成果荣誉",
        subTitle: "个人荣誉",
        home: "首页",
        personalPrize: "个人荣誉",
      },
      englishItem: {
        allTitle: "Achievement",
        subTitle: "Person",
        home: "home",
        personalPrize: "person-prize",
      },
      menu: [],
      menuZH: [
        { name: "团队荣誉", path: "/prize/teamPrize" },
        { name: "个人荣誉", path: "/prize/personalPrize" },
        { name: "项目获奖", path: "/prize/projectPrize" },
      ],
      menuEN: [
        { name: "team-prize", path: "/prize/teamPrize" },
        { name: "person-prize", path: "/prize/personalPrize" },
        { name: "project-award", path: "/prize/projectPrize" },
      ],
      personalPrizes: [],
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
  .personalPrize {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 29rem);
  }

  .personalPrizeContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .personalPrizeAside {
    width: 255px;
    margin-right: 20px;
  }

  .personalPrizeAsideTitle {
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
  .personalPrizeAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .personalPrizeAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .personalPrizeDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    min-height: calc(100vh - 29rem - 6rem);
  }

  .personalPrizeTitle {
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
  /* 设置块和分页的距离 */
  .personalPrizeItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }

  .detailItem {
    padding: 10px;
    width: 50%;
    display: flex;
    flex-direction: row;
    box-sizing: border-box;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .personalPrizeAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .personalPrizeAsideTitle {
    font-size: 20px;
    padding: 10px;
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
  .personalPrizeDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .personalPrizeTitle {
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
  /* 设置块和分页的距离 */
  .personalPrizeItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }

  .detailItem {
    width: 100%;
    padding: 10px 0;
    display: flex;
    flex-direction: row;
    box-sizing: border-box;
  }
}
</style>
