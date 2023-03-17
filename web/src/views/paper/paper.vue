<template>
  <div class="paper">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="paperContent">
      <div class="paperAside">
        <div class="paperAsideTitle">论文论著</div>
        <div class="paperAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="paperAsideItem"
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
      <div class="paperDetail">
        <div class="paperTitle">
          <div class="title">发表论文</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/paper/paper' }"
                >发表论文</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="paperItem">
          <div
            class="paper-row"
            v-for="(detailItem, detailIndex) in showPageContent"
            :key="detailIndex"
          >
            <div class="paper-base">
              <i class="el-icon-notebook-1"></i>
              <div class="paper-name">
                {{ detailItem.title }}
              </div>
            </div>
            <div class="paper-time">{{ detailItem.date }}</div>
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
import { getPaperURL } from "@/api/api";
export default {
  data() {
    return {
      title: "论文论著",
      currentMenu: "出版专著",
      Menu: [
        { name: "发表论文", path: "/paper/paper" },
        { name: "授权专利", path: "/paper/patent" },
        { name: "出版专著", path: "/paper/book" },
      ],
      showAllContent: [
        {
          title: "专利1",
          date: "2023-03-07",
          url: " ",
          keywords: "",
        },
        {
          title:
            "DRL-Based Offloading for Computation Delay Minimization in Wireless-Powered Multi-access Edge Computing",
          date: "2023",
          url: "",
        },
        {
          title: "Nighttime Image Dehazing Based on Point Light Sources",
          date: "2022-12-20",
          url: "",
        },
        {
          title:
            "Multi-hop Deflection Routing Algorithm Based on Reinforcement Learning for Energy-Harvesting Nanonetworks",
          date: "2022-01",
          url: "",
        },
        {
          title:
            "Gold nanostars combined with the searched antibody for targeted oral squamous cell carcinoma therapy",
          date: "2022",
          url: "",
        },
      ],
      showPageContent: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {},
  methods: {},
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .paper {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .paperContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .paperAside {
    width: 25%;
  }
  .paperAsideTitle {
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
  .paperAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .paperDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .paperTitle {
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
  .paperItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }

  .paper-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .paper-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .paper-name {
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
  .paper {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .paperContent {
    display: flex;
    flex-direction: column;
  }

  .paperAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .paperAsideTitle {
    display: none;
  }
  .paperAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .paperDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .paperTitle {
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
  .paperItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }

  .paper-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .paper-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .paper-name {
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
