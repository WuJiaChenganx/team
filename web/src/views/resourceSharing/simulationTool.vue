<template>
  <div class="simulationTool">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="simulationToolContent">
      <div class="simulationToolAside">
        <div class="simulationToolAsideTitle">仿真工具</div>
        <div class="simulationToolAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="simulationToolAsideItem"
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
      <div class="simulationToolDetail">
        <div class="simulationToolTitle">
          <div class="title">仿真工具</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/resource/simulationTool' }"
                >仿真工具</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="simulationToolItem">
          <div
            class="simulationTool-row"
            v-for="(detailItem, detailIndex) in showPageContent"
            :key="detailIndex"
          >
            <div class="simulationTool-base">
              <i class="el-icon-notebook-1"></i>
              <div class="simulationTool-name">
                {{ detailItem.detail }}
              </div>
            </div>
            <div class="simulationTool-time">{{ detailItem.time }}</div>
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
      currentMenu: "仿真工具",
      Menu: [
        { name: "仿真工具", path: "/resource/simulationTool" },
        { name: "数据集", path: "/resource/dataSet" },
      ],
      showAllContent: [
        { detail: "仿真工具1", time: "2000-06-25" },
        { detail: "仿真工具2", time: "2000-06-25" },
        { detail: "仿真工具3", time: "2000-06-25" },
        { detail: "仿真工具4", time: "2000-06-25" },
        { detail: "仿真工具5", time: "2000-06-25" },
        { detail: "仿真工具6", time: "2000-06-25" },
        { detail: "仿真工具7", time: "2000-06-25" },
        { detail: "仿真工具8", time: "2000-06-25" },
        { detail: "仿真工具9", time: "2000-06-25" },
        { detail: "仿真工具10", time: "2000-06-25" },
        { detail: "仿真工具11", time: "2000-06-25" },
        { detail: "仿真工具12", time: "2000-06-25" },
        { detail: "仿真工具13", time: "2000-06-25" },
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
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
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
  .simulationTool {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .simulationToolContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .simulationToolAside {
    width: 25%;
  }
  .simulationToolAsideTitle {
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
  .simulationToolAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .simulationToolDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .simulationToolTitle {
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
  .simulationToolItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }

  .simulationTool-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .simulationTool-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .simulationTool-name {
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
  .simulationTool {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .simulationToolContent {
    display: flex;
    flex-direction: column;
  }

  .simulationToolAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .simulationToolAsideTitle {
    display: none;
  }
  .simulationToolAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .simulationToolDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .simulationToolTitle {
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
  .simulationToolItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }

  .simulationTool-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .simulationTool-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .simulationTool-name {
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
