<template>
  <div class="international">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="internationalContent">
      <div class="internationalAside">
        <div class="internationalAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="internationalAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="internationalAsideItem"
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
      <div class="internationalDetail">
        <div class="internationalTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item
                :to="{ path: '/cooperation/international' }"
                >{{ pageItem.international }}</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="internationalItem"></div>
        <div class="paging" v-show="total_number">
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
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "交流合作",
        subTitle: "国际交流",
        home: "首页",
        international: "国际交流",
      },
      englishItem: {
        allTitle: "Cooperation",
        subTitle: "International",
        home: "home",
        international: "International",
      },
      menu: [],
      menuZH: [
        { name: "国内交流", path: "/cooperation/domestic" },
        { name: "国际交流", path: "/cooperation/international" },
      ],
      menuEN: [
        { name: "Domestic", path: "/cooperation/domestic" },
        { name: "International", path: "/cooperation/international" },
      ],
      // 需要展示页面数据
      showPageContent: [],
      // 总共要展示的数量
      total_number: 0,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
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
  .international {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 29rem);
  }

  .internationalContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .internationalAside {
    width: 255px;
    margin-right: 20px;
  }
  .internationalAsideTitle {
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
  .internationalAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .internationalAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }
  .internationalDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    position: relative;
    min-height: calc(100vh - 29rem - 6rem);
  }

  .internationalTitle {
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
  .internationalItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
  }

  /* 设置分页和底部的距离 */
  .paging {
    position: absolute;
    left: 50%;
    transform: translate(-50%, 0);
    bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .internationalAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .internationalAsideTitle {
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

  .internationalDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    position: relative;
    min-height: calc(100vh - 36rem - 112px);
  }

  .internationalTitle {
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
  .internationalItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 350px;
  }

  /* 设置分页和底部的距离 */
  .paging {
    position: absolute;
    left: 50%;
    transform: translate(-50%, 0);
    bottom: 3rem;
  }
}
</style>
