<template>
  <div class="news">
    <div class="newsTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/activity/newFlash')">{{
        pageItem.more
      }}</a>
    </div>
    <div class="newsContent">
      <!-- 轮播图 -->
      <div class="newsPhoto">
        <el-carousel
          :interval="4000"
          indicator-position="outside"
          :height="height"
        >
          <el-carousel-item
            v-for="(newsItem, newsItemIndex) in newsList"
            :key="newsItemIndex"
            @click.native="gotoDetail(newsItem.id)"
            class="newsPhotoItem"
          >
            <img :src="newsItem.picUrl[0]" alt="" />
            <!-- 遮罩 -->
            <div class="mask">{{ newsItem.title }}</div>
          </el-carousel-item>
        </el-carousel>
      </div>
      <!-- 消息列表 -->
      <div class="newsListContent">
        <div
          class="news-row"
          v-for="(newsItem, newsItemIndex) in newsList"
          :key="newsItemIndex"
          @click="gotoDetail(newsItem.id)"
        >
          <span class="dot"></span>
          <div class="news-title">{{ newsItem.title }}</div>
          <div class="news-date">[{{ newsItem.date }}-{{ newsItem.day }}]</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getNewFlashURL } from "@/api/api";
export default {
  data() {
    return {
      height: "30rem",
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [],
      pageItem: {},
      chineseItem: { title: "新闻快讯", more: "more" },
      englishItem: { title: "News", more: "more" },
    };
  },
  created() {
    this.getNewFlashList();
    this.changUI();
    this.changePhotoHeight();
  },
  methods: {
    changePhotoHeight() {
      if (
        /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
          navigator.userAgent
        )
      ) {
        this.height = "35rem";
      } else {
        this.height = "30rem";
      }
    },
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.pageItem = this.englishItem;
      }
    },
    // async和await用于同步,就是按顺序执行
    async getNewFlashList() {
      let params = {
        // 定义参数
        // start: 0,
        // end: 5,
        start: 1,
        end: 8,

        languageType: this.$store.getters.getLanguageType,
      };
      await getNewFlashURL(params).then((res) => {
        this.newsList = res.data;
      });
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/activity/newFlashDetail",
        name: "新闻快讯详情",
        query: {
          id: id,
          languageType: this.$store.getters.getLanguageType,
        },
      });
    },
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
  },
};
</script>
<style scoped>
/* PC端 */
@media screen and (min-width: 1000px) {
  .news {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  .newsTitle {
    font-size: 18px;
    margin-bottom: 20px;
    position: relative;
  }
  .title {
    width: 164px;
    margin: 20px auto;
    font-size: 18px;
    color: #0055a2;
  }
  .newsTitle p {
    width: 164px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .newsTitle p:before {
    width: 50px;
    height: 5px;
    position: absolute;
    left: 57px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #333;
    font-size: 14px;
    position: absolute;
    bottom: 28px;
    right: 10px;
    cursor: pointer;
  }
  .newsContent {
    display: flex;
    flex-direction: row;
  }
  /* 轮播图 */
  .newsPhoto {
    width: 800px;
  }
  .newsPhotoItem {
    cursor: pointer;
  }
  .mask {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    text-align: left;
    color: #fff;
    height: 42px;
    line-height: 42px;
    font-size: 15px;
    text-indent: 2em;
    font-weight: bold;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }
  .el-carousel__item img {
    width: 100%;
    height: 100%;
  }
  .newsListContent {
    display: flex;
    flex: 1 1 auto;
    margin-left: 50px;
    flex-direction: column;
    justify-content: space-between;
    height: 30rem;
  }
  .news-row {
    cursor: pointer;
    display: flex;
    flex-direction: row;
  }
  .dot {
    position: relative;
    padding-left: 15px;
  }
  .dot::before {
    content: "";
    position: absolute;
    top: 6px;
    left: 0;
    width: 6px;
    height: 6px;
    background-color: #000;
  }

  .news-title {
    height: 2rem;
    line-height: 2rem;
    width: 70%;
    flex: 1 1 auto;
    font-size: 1.5rem;
    color: #030f39;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    font-weight: bold;
    text-align: left;
  }
  /* 时间框 */
  .news-date {
    font-size: 1.5rem;
    color: #999;
  }
}

/* 移动端 */
@media screen and (max-width: 1000px) {
  .news {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  .newsTitle {
    font-size: 20px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 20px auto;
    font-size: 24px;
    color: #0055a2;
  }
  .newsTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .newsTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 16px;
    position: absolute;
    bottom: 20px;
    right: 0;
  }
  .newsContent {
    display: flex;
    flex-direction: column;
  }
  /* 轮播图 */
  .newsPhoto {
    width: 90%;
    padding-top: 20px;
    margin: 0 auto;
  }
  .newsPhotoItem {
    cursor: pointer;
  }
  .mask {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    text-align: left;
    color: #fff;
    height: 42px;
    line-height: 42px;
    font-size: 15px;
    text-indent: 1em;
    font-weight: bold;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }
  .el-carousel__item img {
    width: 100%;
    height: 100%;
  }
  /* 去除轮播图下面横向滚动条 */
  .el-scrollbar__wrap {
    overflow-x: hidden;
  }
  /* 新闻列表 */
  /* .newsList {
    padding: 1rem;
    box-sizing: border-box;
  }
  .newsListTitle {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding-bottom: 2rem;
    border-bottom: 1px solid #c5e7ff;
  }
  .left-title {
    font-size: 2rem;
    font-weight: bold;
    color: #003266;
  }
  .title-more {
    color: #7db0cb;
    font-size: 1.6rem;
    cursor: pointer;
  } */
  .newsListContent {
    margin-top: 1rem;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 45rem;
  }
  .news-row {
    cursor: pointer;
    display: flex;
    flex-direction: row;
  }
  .dot {
    position: relative;
    padding-left: 15px;
  }
  .dot::before {
    content: "";
    position: absolute;
    top: 6px;
    left: 0;
    width: 6px;
    height: 6px;
    background-color: #000;
  }
  /* 时间框 */
  /* .news-date {
    width: 8rem;
    height: 8rem;
    margin-right: 1.5rem;
    background: #008cd6;
    border-radius: 6px;
    /* 时间数字的颜色 */
  /* color: #ffffff;
    font-size: 1rem;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    justify-content: center;
  } */
  .news-title {
    width: 70%;
    flex: 1 1 auto;
    font-size: 1.8rem;
    color: #030f39;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    font-weight: bold;
    text-align: left;
  }
  /* 时间框 */
  .news-date {
    font-size: 1.8rem;
    color: #999;
  }
}
</style>
