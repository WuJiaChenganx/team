<template>
  <div class="book">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="bookContent">
      <div class="bookAside">
        <div class="bookAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="bookAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
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
            <div class="detailItemBookCover">
              <img :src="detailItem.pictureUrl" alt="" />
            </div>
            <div class="detailItemBookContent">
              <div class="detailItemBookName">
                {{ detailItem.title }}
              </div>
              <div class="detailItemBookTime">
                出版日期: {{ detailItem.date }}
              </div>
              <div class="detailItemBookAuthor">
                作者: {{ detailItem.author }}
              </div>

              <div class="detailItemBookUrl" v-if="detailItem.url">
                <a
                  :href="detailItem.url"
                  style="text-decoration: none; color: #034ea1"
                  target="_blank"
                  >购买链接</a
                >
              </div>
            </div>
          </div>
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
        allTitle: "论文著作",
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
        start: 0,
        end: 6,
        languageType: this.$store.getters.getLanguageType,
      };
      await getBookURL(params).then((res) => {
        this.books = res.data;
      });
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
    width: 255px;
    margin-right: 20px;
  }

  .bookAsideTitle {
    width: 255px;
    height: 78px;
    line-height: 78px;
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 24px;
  }
  .bookAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .bookAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .bookDetail {
    flex: 1 1 auto;
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
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    font-weight: bold;
    background-color: #fff;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    font-weight: bold;
    color: #034ea1;
    background: #eee;
  }
  /* 设置块和分页的距离 */
  .bookItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }

  .detailItem {
    padding: 10px;
    width: 50%;
    display: flex;
    flex-direction: row;
    box-sizing: border-box;
  }
  .detailItemBookCover {
    margin-right: 10px;
  }
  .detailItemBookCover img {
    width: 9rem;
    height: 13rem;
  }
  .detailItemBookContent {
    flex: 1 1 auto;
  }
  .detailItemBookName {
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #0055a2;
    font-weight: bold;
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .detailItemBookTime {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .detailItemBookAuthor {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .detailItemBookUrl {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .bookAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .bookAsideTitle {
    font-size: 20px;
    padding: 10px;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
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

  .el-icon-sunny {
    display: none;
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
    padding: 10px 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 20px;
    line-height: 30px;
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
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
  }
  /* 设置块和分页的距离 */
  .bookItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }

  .detailItem {
    width: 100%;
    padding: 10px 0;
    display: flex;
    flex-direction: row;
    box-sizing: border-box;
  }
  .detailItemBookCover {
    margin-right: 10px;
  }
  .detailItemBookCover img {
    width: 11rem;
    height: 14rem;
  }
  .detailItemBookContent {
    flex: 1 1 auto;
  }
  .detailItemBookName {
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #0055a2;
    font-weight: bold;
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }

  .detailItemBookTime {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .detailItemBookAuthor {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .detailItemBookUrl {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
}
</style>
