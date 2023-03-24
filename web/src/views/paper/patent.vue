<template>
  <div class="patent">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="patentContent">
      <div class="patentAside">
        <div class="patentAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="patentAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="patentAsideItem"
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
      <div class="patentDetail">
        <div class="patentTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/paper/patent' }">{{
                pageItem.patent
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="patentItem">
          <div
            class="detailItem"
            v-for="(detailItem, detailIndex) in patents"
            :key="detailIndex"
          >
            <div class="detailItemInfo">
              [ {{ detailItem.number }} ]
              {{ detailItem.title }}
            </div>
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
import { getPatentURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "论文论著",
        subTitle: "授权专利",
        home: "首页",
        patent: "授权专利",
      },
      englishItem: {
        allTitle: "Publication",
        subTitle: "Patent",
        home: "home",
        patent: "Patent",
      },
      menu: [],
      menuZH: [
        { name: "发表论文", path: "/paper/paper" },
        { name: "授权专利", path: "/paper/patent" },
        { name: "出版专著", path: "/paper/book" },
      ],
      menuEN: [
        { name: "Paper", path: "/paper/paper" },
        { name: "Patent", path: "/paper/patent" },
        { name: "Book", path: "/paper/book" },
      ],
      patents: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getPatentList();
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
    async getPatentList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
      };
      await getPatentURL(params).then((res) => {
        this.patents = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getPatentList();
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .patent {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .patentContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .patentAside {
    width: 25%;
  }
  .patentAsideTitle {
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
  .patentAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .patentDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .patentTitle {
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
  .patentItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }

  .detailItem {
    padding: 1rem 0;
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 1rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
    border-bottom: 1px solid #eee;
  }
  .detailItem:hover {
    font-weight: bold;
  }

  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .patent {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .patentContent {
    display: flex;
    flex-direction: column;
  }

  .patentAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .patentAsideTitle {
    display: none;
  }
  .patentAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .patentDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .patentTitle {
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
  .patentItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }

  .detailItem {
    padding: 1rem 0;
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 1rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
    border-bottom: 1px solid #eee;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
