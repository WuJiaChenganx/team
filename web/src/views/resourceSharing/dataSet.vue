<template>
  <div class="dataSet">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="dataSetContent">
      <div class="dataSetAside">
        <div class="dataSetAsideTitle">数据集</div>
        <div class="asideContent">
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
              v-for="(menuItem, menuIndex) in Menu"
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
          <div class="title">数据集</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/resource/dataSet' }"
                >数据集</el-breadcrumb-item
              >
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
              <i class="el-icon-notebook-1"></i>
              <div class="dataSet-name">
                {{ detailItem.detail }}
              </div>
            </div>
            <div class="dataSet-time">{{ detailItem.time }}</div>
          </div>
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
export default {
  data() {
    return {
      title: "资源共享",
      currentMenu: "数据集",
      Menu: [
        { name: "仿真工具", path: "/resource/simulationTool" },
        { name: "数据集", path: "/resource/dataSet" },
      ],
      showAllContent: [
        { detail: "数据集1", time: "2000-06-25" },
        { detail: "数据集2", time: "2000-06-25" },
        { detail: "数据集3", time: "2000-06-25" },
        { detail: "数据集4", time: "2000-06-25" },
        { detail: "数据集5", time: "2000-06-25" },
        { detail: "数据集6", time: "2000-06-25" },
        { detail: "数据集7", time: "2000-06-25" },
        { detail: "数据集8", time: "2000-06-25" },
        { detail: "数据集9", time: "2000-06-25" },
        { detail: "数据集10", time: "2000-06-25" },
        { detail: "数据集11", time: "2000-06-25" },
        { detail: "数据集12", time: "2000-06-25" },
        { detail: "数据集13", time: "2000-06-25" },
      ],
      showPageContent: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.total_number = this.showAllContent.length;
    this.showPageContent = this.showAllContent.slice(
      (this.current_index - 1) * 10,
      this.current_index * 10
    );
  },
  methods: {
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.showPageContent = this.showAllContent.slice(
        (val - 1) * 10,
        val * 10
      );
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .dataSet {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  /* 设置块和分页的距离 */
  .dataSetItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }

  .dataSet-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .dataSet-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .dataSet-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 3rem;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .dataSet {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  /* 设置块和分页的距离 */
  .dataSetItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }

  .dataSet-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .dataSet-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .dataSet-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 3rem;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
