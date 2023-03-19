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
          <a
            class="detailItem"
            v-for="(detailItem, detailIndex) in papers"
            :key="detailIndex"
            :href="detailItem.url"
            target="_blank"
          >
            <div class="detailItemPaperName">
              论文名称: {{ detailItem.title }}
            </div>
            <div class="detailItemPaperKeyWord">
              关键词: {{ detailItem.keyword }}
            </div>
            <div class="detailItemPaperDate">
              发表日期: {{ detailItem.date }}
            </div>
            <div class="detailItemPaperDetail">
              摘要: {{ detailItem.detail }}
            </div>
          </a>
        </div>
        <div class="paging">
          <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
          <el-pagination
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :page-size="15"
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
      papers: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getPaperList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getPaperList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 15,
        end: this.current_index * 15,
      };
      await getPaperURL(params).then((res) => {
        this.papers = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getPaperList();
    },
  },
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
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    display: block;
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 2.5rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-decoration: none;
    color: black;
  }
  .detailItemPaperName {
    color: #0055a2;
    font-weight: bold;
    font-size: 2rem;
  }
  .detailItem:hover .detailItemPaperKeyWord {
    font-weight: bold;
  }
  .detailItem:hover .detailItemPaperDate {
    font-weight: bold;
  }
  .detailItem:hover .detailItemPaperDetail {
    font-weight: bold;
  }
  .detailItemPaperDetail {
    font-weight: normal;
    /* 显示3行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
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
    padding-bottom: 2rem;
    min-height: 450px;
  }

  .detailItem {
    display: block;
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 2.5rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-decoration: none;
    color: black;
  }
  .detailItemPaperName {
    color: #0055a2;
    font-size: 2rem;
    font-weight: bold;
  }
  .detailItemPaperDetail {
    font-weight: normal;
    /* 显示3行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
