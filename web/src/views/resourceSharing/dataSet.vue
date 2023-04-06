<template>
  <div class="dataSet">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="dataSetContent">
      <div class="dataSetAside">
        <div class="dataSetAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="dataSetAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="dataSetAsideItem"
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
      <div class="dataSetDetail">
        <div class="dataSetTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/resource/dataSet' }">{{
                pageItem.dataSetList
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="dataSetItem">
          <div
            class="dataSet-row"
            v-for="(detailItem, detailIndex) in showPageContent"
            :key="detailIndex"
          >
            <div class="dataSet-base">
              <i class="el-icon-link"></i>
              <div class="dataSet-name">
                {{ detailItem.title }}
              </div>
            </div>
            <div class="dataSet-profile">
              {{ detailItem.detail }}
            </div>
            <div class="dataSet-url">
              <!-- 这个链接可以下载 -->
              <!-- http://localhost:8186/teamWeb/resource/download/file/aaaa.pdf -->
              <!-- :href="detailItem.fileUrl" -->
              <a
                class="el-button el-button--primary el-button--mini"
                style="text-decoration: none"
                :href="detailItem.fileUrl"
                target="_blank"
                >{{ pageItem.download }}</a
              >
            </div>
          </div>
        </div>
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
import { getDataSetURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "资源共享",
        subTitle: "数据集",
        home: "首页",
        dataSetList: "数据集列表",
        download: "下载数据集",
      },
      englishItem: {
        allTitle: "Resource",
        subTitle: "Dataset",
        home: "home",
        dataSetList: "Dataset List",
        download: "download",
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
      // 需要展示页面数据
      showPageContent: [],
      // 总共要展示的数量
      total_number: 0,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getDataSetList();
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
    async getDataSetList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
        languageType: this.$store.getters.getLanguageType,
      };

      await getDataSetURL(params).then((res) => {
        this.showPageContent = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getDataSetList();
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .dataSet {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 35.762rem);
  }

  .dataSetContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .dataSetAside {
    width: 25%;
  }
  .dataSetAsideTitle {
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 2rem;
    line-height: 3rem;
    height: 3rem;
    padding: 2rem 3rem;
    margin-bottom: 0.5rem;
  }
  .dataSetAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }
  .dataSetDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    position: relative;
    min-height: calc(100vh - 35.762rem - 6rem);
  }

  .dataSetTitle {
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  /* 设置块和分页的距离 */
  .dataSetItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
  }

  .dataSet-row {
    display: flex;
    flex-direction: column;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .dataSet-base {
    display: flex;
    flex-direction: row;
    font-size: 2rem;
    line-height: 2rem;
  }
  .dataSet-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 2rem;
    margin-bottom: 1rem;
  }
  .dataSet-profile {
    text-indent: 2em;
    text-align: left;
    font-size: 1.6rem;
    margin-bottom: 1rem;
  }
  .dataSet-url {
    text-align: right;
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
  .dataSet {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 36rem);
  }

  .dataSetContent {
    display: flex;
    flex-direction: column;
  }

  .dataSetAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .dataSetAsideTitle {
    display: none;
  }
  .dataSetAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .dataSetDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    position: relative;
    min-height: calc(100vh - 36rem - 112px);
  }

  .dataSetTitle {
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  /* 设置块和分页的距离 */
  .dataSetItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 350px;
  }

  .dataSet-row {
    display: flex;
    flex-direction: column;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .dataSet-base {
    display: flex;
    flex-direction: row;
    font-size: 2rem;
    line-height: 2rem;
  }
  .dataSet-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 2rem;
    margin-bottom: 1rem;
  }
  .dataSet-profile {
    text-indent: 2em;
    text-align: left;
    font-size: 1.6rem;
    margin-bottom: 1rem;
  }
  .dataSet-url {
    text-align: right;
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
