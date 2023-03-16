<template>
  <div class="book">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="bookContent">
      <div class="bookAside">
        <div class="bookAsideTitle">论文论著</div>
        <div class="bookAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#fff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="bookAsideItem"
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
      <div class="bookDetail">
        <div class="bookTitle">
          <div class="title">出版专著</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/paper/book' }"
                >出版专著</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="bookItem">
          <div
            class="detailItem"
            v-for="(detailItem, detailIndex) in books"
            :key="detailIndex"
          >
            <div class="detailItemBookName">
              书籍名称: {{ detailItem.title }}
            </div>
            <div class="detailItemBookTime">
              出版日期: {{ detailItem.date }}
            </div>
            <div class="detailItemBookAuthor">
              作者: {{ detailItem.author }}
            </div>
            <div class="detailItemBookCover">
              <img :src="detailItem.pictureUrl" alt="" />
            </div>
          </div>
        </div>
        <div class="paging">
          <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
          <el-pagination
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :page-size="5"
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
import { getBookURL } from "@/api/paper/book";
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
      books: [
        {
          title:
            "FGOR: Flow-Guided Opportunistic Routing for Intra-body Nanonetworks, IEEE Internet of Things Journal, 2022, DOI: 10.1109/JIOT.20 22. 3182142(中科院1区，JCR Q1区，IF：9.471）",
          author: "Yao, X. W., Chen, Y. W., Wu, Y., Zhao, K., & Jornet, J. M.",
          date: "2022-09-21",
          publisher: null,
          pictureUrl: require("../../assets/images/book/book1.jpg"),
        },
        {
          title:
            "Joint Optimization of Latency and Energy Consumption for Mobile Edge Computing Based Proximity Detection in Road Networks”, China Communications, 2022",
          author: "Zhao, T., Liu, Y., Shou, G., & Yao, X",
          date: "2022-04-19",
          publisher: null,
          pictureUrl: require("../../assets/images/book/book2.jpg"),
        },
        {
          title: "智能解密：智能+场景应用案例解析",
          author: "姚信威",
          date: "2021-04-01",
          publisher: null,
          pictureUrl: require("../../assets/images/book/book3.jpg"),
        },
        {
          title: "电磁纳米网络-基础理论及关键技术",
          author: "姚信威",
          date: "2021-01-01",
          publisher: null,
          pictureUrl: require("../../assets/images/book/book3.jpg"),
        },
        {
          title: "未来服务——生活服务业的科技化变革",
          author: "姚信威",
          date: "2021-01-01",
          publisher: null,
          pictureUrl: require("../../assets/images/book/book3.jpg"),
        },
      ],
      // 需要展示页面数据
      showPageContent: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getBookList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getBookList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 5,
        end: this.current_index * 5,
      };
      await getBookURL(params).then((res) => {
        this.books = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getBookList();
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .book {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .bookContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .bookAside {
    width: 25%;
  }
  .bookAsideTitle {
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
  .bookAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .bookDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .bookTitle {
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
  .bookItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    width: 100%;
    height: auto;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.8rem;
    font-weight: bold;
  }
  .detailItemBookName {
    font-size: 2rem;
  }
  .detailItemBookCover {
    margin-top: 1rem;
    width: 100%;
  }
  .detailItemBookCover img {
    width: 50%;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .book {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .bookContent {
    display: flex;
    flex-direction: column;
  }

  .bookAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .bookAsideTitle {
    display: none;
  }
  .bookAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .bookDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .bookTitle {
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
  .bookItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    width: 100%;
    height: auto;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.8rem;
    font-weight: bold;
  }
  .detailItemBookName {
    font-size: 2rem;
  }
  .detailItemBookCover {
    margin-top: 1rem;
    width: 100%;
  }
  .detailItemBookCover img {
    width: 100%;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
