<template>
  <div class="verticalProject">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="verticalProjectContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/scientificResearch' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item
            :to="{ path: '/scientificResearch/verticalProject' }"
            >{{ pageItem.subTitle }}</el-breadcrumb-item
          >
        </el-breadcrumb>
      </div>
      <div class="verticalProjectAside">
        <div class="verticalProjectAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="verticalProjectAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="verticalProjectAsideItem"
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
      <div class="verticalProjectDetail">
        <div class="verticalProjectTitle">
          {{ pageItem.subTitle }}
        </div>
        <div class="verticalProjectTable">
          <el-table :data="projects" border>
            <el-table-column
              prop="projectName"
              label="项目名称"
            ></el-table-column>
            <el-table-column prop="responser" label="项目负责人">
            </el-table-column>
            <el-table-column prop="projectType" label="类型"> </el-table-column>
            <el-table-column prop="time" label="时间"> </el-table-column>
          </el-table>
        </div>
        <div class="paging">
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
import { getProjectURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "科研概况",
        subTitle: "纵向项目",
        home: "首页",
      },
      englishItem: {
        allTitle: "Research",
        subTitle: "vertical-project",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "横向项目", path: "/scientificResearch/lateralProject" },
        { name: "纵向项目", path: "/scientificResearch/verticalProject" },
        { name: "科研平台", path: "/scientificResearch/platform" },
      ],
      menuEN: [
        { name: "Direction", path: "/scientificResearch/direction" },
        {
          name: "lateral-project",
          path: "/scientificResearch/lateralProject",
        },
        {
          name: "vertical-project",
          path: "/scientificResearch/verticalProject",
        },
        { name: "Platform", path: "/scientificResearch/platform" },
      ],
      projects: [],
      // 总共要展示的数量
      total_number: 0,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getProjectList();
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
    // async和await用于同步,就是按顺序执行
    async getProjectList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
        languageType: this.$store.getters.getLanguageType,
        type: "lengthways",
      };
      await getProjectURL(params).then((res) => {
        this.projects = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getProjectList();
    },
    // gotoDetail() {
    //   this.$router.push({
    //     path: "/scientificResearch/verticalDetail",
    //     name: "纵向项目详情",
    //   });
    // },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .verticalProject {
    width: 100%;
  }
  .verticalProjectContent {
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

  .verticalProjectAside {
    width: 20%;
    padding-right: 30px;
  }

  .verticalProjectAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .verticalProjectAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .verticalProjectAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .verticalProjectAsideContent {
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

  .verticalProjectAsideItem {
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
  .verticalProjectAsideItem:last-child {
    border-bottom: none;
  }
  .verticalProjectAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .verticalProjectAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .verticalProjectDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .verticalProjectTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }

  .verticalProjectProfile {
    font-size: 1.6rem;
    line-height: 2.1rem;
    margin-bottom: 1.2rem;
    text-align: left;
  }
  .verticalProjectTable {
    width: 100%;
  }
  .paging {
    margin: 3rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .verticalProject {
    width: 100%;
  }
  .verticalProjectContent {
    display: flex;
    flex-direction: column;
  }

  .verticalProjectAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .verticalProjectAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .verticalProjectAsideTitle span img {
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
  .verticalProjectAsideItem span img {
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
  .verticalProjectDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 36rem - 112px);
  }
  .verticalProjectTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .verticalProjectProfile {
    font-size: 14px;
    line-height: 20px;
    margin-bottom: 10px;
    text-align: left;
  }
  .verticalProjectTable {
    width: 100%;
  }
  .paging {
    margin: 2rem 0;
  }
}
</style>
