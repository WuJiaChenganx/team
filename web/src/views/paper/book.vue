<template>
  <div class="book">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="bookContent">
      <div class="bookAside">
        <div class="bookAsideTitle">{{ pageItem.allTitle }}</div>
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
      <div class="bookDetail">
        <div class="bookTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/paper/book' }">{{
                pageItem.book
              }}</el-breadcrumb-item>
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
              {{ detailItem.number }}. 书籍名称: {{ detailItem.title }}
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
            :page-size="3"
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
import { getBookURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "论文论著",
        subTitle: "出版专著",
        home: "首页",
        book: "出版专著",
      },
      englishItem: {
        allTitle: "Publication",
        subTitle: "Book",
        home: "home",
        book: "Book",
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
      books: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getBookList();
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
    async getBookList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 3,
        end: this.current_index * 3,
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
    margin-top: 2.5rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.8rem;
  }
  .detailItemBookName {
    color: #0055a2;
    font-weight: bold;
    font-size: 2rem;
  }
  .detailItemBookCover {
    margin-top: 1rem;
    width: 100%;
  }
  .detailItemBookCover img {
    width: 20rem;
    height: 25rem;
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
    margin-top: 2.5rem;
    text-align: left;
    line-height: 3rem;
    font-size: 1.8rem;
  }
  .detailItemBookName {
    color: #0055a2;
    font-weight: bold;
  }
  .detailItemBookCover {
    margin-top: 1rem;
    width: 100%;
  }
  .detailItemBookCover img {
    width: 20rem;
    height: 25rem;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
</style>
