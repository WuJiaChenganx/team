<template>
  <div class="honour">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="honourContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/prize' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/prize/honour' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="honourAside">
        <div class="honourAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="honourAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="honourAsideItem"
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
      <div class="honourDetail">
        <div class="honourTitle">
          {{ pageItem.subTitle }}
        </div>
        <div class="honourProfile">{{ honourProfile }}</div>
        <div class="honourTable">
          <el-table :data="honours" border>
            <el-table-column prop="award" label="获奖名称"></el-table-column>
            <el-table-column prop="title" label="获奖人"></el-table-column>
            <el-table-column prop="date" label="获奖时间"></el-table-column>
          </el-table>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getPrizeAndHonourURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "成果荣誉",
        subTitle: "团队荣誉",
        home: "首页",
      },
      englishItem: {
        allTitle: "prize & honour",
        subTitle: "Honour",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "科技成果", path: "/prize/prize" },
        { name: "团队荣誉", path: "/prize/honour" },
      ],
      menuEN: [
        { name: "Prize", path: "/prize/prize" },
        { name: "Honour", path: "/prize/honour" },
      ],
      honourProfile: "",
      honours: [],
    };
  },
  created() {
    this.getHonourList();
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
    async getHonourList() {
      let params = {
        languageType: this.$store.getters.getLanguageType,
        start: 0,
        end: 100,
        type: "honor",
      };
      await getPrizeAndHonourURL(params).then((res) => {
        this.honours = res.data;
        this.honourProfile = res.summarize;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .honour {
    width: 100%;
  }
  .honourContent {
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

  .honourAside {
    width: 20%;
    padding-right: 30px;
  }

  .honourAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .honourAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .honourAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .honourAsideContent {
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

  .honourAsideItem {
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
  .honourAsideItem:last-child {
    border-bottom: none;
  }
  .honourAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .honourAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .honourDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .honourTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }

  .honourProfile {
    font-size: 1.6rem;
    line-height: 2.1rem;
    margin-bottom: 1.2rem;
    text-align: left;
  }
  .honourTable {
    width: 100%;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .honour {
    width: 100%;
  }
  .honourContent {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }

  .honourAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .honourAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .honourAsideTitle span img {
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
  .honourAsideItem span img {
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
  .honourDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 36rem - 112px);
  }
  .honourTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .honourProfile {
    font-size: 14px;
    line-height: 20px;
    margin-bottom: 10px;
    text-align: left;
  }
  .honourTable {
    width: 100%;
  }
}
</style>
