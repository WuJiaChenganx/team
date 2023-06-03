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
      <div id="swiper-member">
        <!-- 如果没有的话就不显示 -->
        <div class="swiper-container" v-if="newsList.length">
          <div class="swiper-wrapper">
            <div
              class="swiper-slide"
              v-for="(newsItem, newsItemIndex) in newsList"
              :key="newsItemIndex"
              @click="gotoDetail(newsItem.id)"
              v-if="newsItem.picUrl[0]"
            >
              <img :src="newsItem.picUrl[0]" alt="" v-if="newsItem.picUrl[0]" />
              <div class="mask">{{ newsItem.title }}</div>
            </div>
          </div>
          <!-- 下一个箭头 -->
          <div class="swiper-button-prev swiper-button-white"></div>
          <!-- 上一个箭头 -->
          <div class="swiper-button-next swiper-button-white"></div>
        </div>
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
// 引入JS部分
import Swiper from "swiper";
// 引入css部分
import "swiper/css/swiper.min.css";
import { getNewFlashURL } from "@/api/api";
export default {
  data() {
    return {
      // height: "30rem",
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [],
      pageItem: {},
      chineseItem: { title: "新闻快讯", more: "更多+" },
      englishItem: { title: "News", more: "more" },
    };
  },
  created() {
    this.getNewFlashList();
    this.changUI();
  },
  methods: {
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
        start: 0,
        end: 8,

        languageType: this.$store.getters.getLanguageType,
      };
      await getNewFlashURL(params).then((res) => {
        this.newsList = res.data;
      });
      new Swiper(".swiper-container", {
        // 最后一张和第一张无缝衔接
        loop: true,
        // 自动播放
        autoplay: {
          delay: 1500,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        // 一次显示几张照片,可以设置成auto,然后在css中设置swiper-slide的宽度
        slidesPerView: 1,
        // 每一次移动的时候移动1张
        slidesPerGroup: 1,
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
    width: 100%;
    display: flex;
    flex-direction: row;
  }
  /* 轮播图css */
  #swiper-member {
    width: 50%;
    cursor: pointer;
  }

  .swiper-slide img {
    width: 100%;
    /* 修改完比例记得注释 */
    height: 45rem;
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
    font-size: 18px;
    text-indent: 2em;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }

  .newsListContent {
    display: flex;
    width: 50%;
    margin-left: 20px;
    flex-direction: column;
    justify-content: space-between;
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
    top: 15px;
    left: 0;
    width: 8px;
    height: 8px;
    border-radius: 4px;
    background-color: #000;
  }

  .news-title {
    height: 4rem;
    line-height: 4rem;
    flex: 1 1 auto;
    font-size: 2rem;
    color: #030f39;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    text-align: left;
  }
  /* 时间框 */
  .news-date {
    min-width: 120px;
    height: 4rem;
    line-height: 4rem;
    font-size: 2rem;
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
    margin-bottom: 2rem;
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
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  /* 轮播图css */
  #swiper-member {
    width: 100%;
  }

  .swiper-slide img {
    width: 100%;
    /* 修改完比例记得注释 */
    height: 35rem;
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
