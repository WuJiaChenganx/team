<template>
  <div class="simulationTool">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="simulationToolContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/resource' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/resource/simulationTool' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="simulationToolAside">
        <div class="simulationToolAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="simulationToolAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="simulationToolAsideItem"
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
      <div class="simulationToolDetail">
        <div class="simulationToolTitle">
          {{ pageItem.subTitle }}
        </div>
        <div class="simulationToolItem"></div>
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
        allTitle: "资源共享",
        subTitle: "仿真工具",
        home: "首页",
      },
      englishItem: {
        allTitle: "Resource",
        subTitle: "Tool",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "仿真工具", path: "/resource/simulationTool" },
        { name: "数据集", path: "/resource/dataSet" },
      ],
      menuEN: [
        { name: "Tool", path: "/resource/simulationTool" },
        { name: "Dataset", path: "/resource/dataSet" },
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
  .simulationTool {
    width: 100%;
  }
  .simulationToolContent {
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

  .simulationToolAside {
    width: 20%;
    padding-right: 30px;
  }

  .simulationToolAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .simulationToolAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .simulationToolAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .simulationToolAsideContent {
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

  .simulationToolAsideItem {
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
  .simulationToolAsideItem:last-child {
    border-bottom: none;
  }
  .simulationToolAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .simulationToolAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .simulationToolDetail {
    flex: 1 1 auto;
    min-height: calc(100vh - 29rem - 58px);
  }

  .simulationToolTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }

  .simulationToolItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .simulationTool {
    width: 100%;
  }
  .simulationToolContent {
    display: flex;
    flex-direction: column;
  }

  .simulationToolAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .simulationToolAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .simulationToolAsideTitle span img {
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
  .simulationToolAsideItem span img {
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
  .simulationToolDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 29rem - 139px);
  }
  .simulationToolTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
}
</style>
