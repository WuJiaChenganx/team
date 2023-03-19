<template>
  <div class="news">
    <!-- 轮播图 -->
    <div class="newsPhoto">
      <el-carousel :interval="4000" indicator-position="outside" height="40rem">
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
    <div class="newsList">
      <div class="newsListTitle">
        <div class="left-title">新闻快讯</div>
        <a class="title-more" @click="goTo('/activity/newFlash')">更多+</a>
      </div>
      <div class="newsListContent">
        <div
          class="news-row"
          v-for="(newsItem, newsItemIndex) in newsList"
          :key="newsItemIndex"
          @click="gotoDetail(newsItem.id)"
        >
          <div class="news-date">
            <div>{{ newsItem.day }}</div>
            <div>{{ newsItem.date }}</div>
          </div>
          <div class="news-title">{{ newsItem.title }}</div>
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
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [],
    };
  },
  created() {
    this.getNewFlashList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getNewFlashList() {
      let params = {
        // 定义参数
        start: 0,
        end: 5,
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
    flex-direction: row;
    justify-content: space-between;
  }
  /* 轮播图 */
  .newsPhoto {
    width: 56%;
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
    height: 3rem;
    line-height: 3rem;
    text-indent: 2em;
    font-weight: bold;
  }
  .el-carousel__item img {
    width: 100%;
    height: 100%;
  }
  /* 新闻列表 */
  .newsList {
    width: 42%;
    padding: 0 1rem;
    box-sizing: border-box;
  }
  .newsListTitle {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding-bottom: 2rem;
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
  }
  .newsListContent {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 35rem;
  }
  .news-row {
    cursor: pointer;
    height: 6rem;
    display: flex;
    flex-direction: row;
  }
  /* 时间框 */
  .news-date {
    width: 6rem;
    height: 6rem;
    margin-right: 1.5rem;
    background: #008cd6;
    border-radius: 0.6rem;
    /* 时间数字的颜色 */
    color: #ffffff;
    font-size: 1rem;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  /* 就是日期中有个要变大 */
  .news-row .news-date div:first-child {
    font-size: 2rem;
    font-weight: bold;
  }
  .news-title {
    width: 70%;
    flex: 1 1 auto;
    font-size: 1.5rem;
    color: #0055a2;
    display: -webkit-box;
    /* 两行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    font-weight: bold;
    text-align: left;
  }
}

/* 移动端 */
@media screen and (max-width: 1000px) {
  /* 轮播图 */
  .newsPhoto {
    width: 90%;
    padding-top: 2rem;
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
    height: 2.5rem;
    line-height: 2.5rem;
    text-indent: 1em;
    font-weight: bold;
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
  .newsList {
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
    height: 8rem;
    display: flex;
    flex-direction: row;
  }
  /* 时间框 */
  .news-date {
    width: 8rem;
    height: 8rem;
    margin-right: 1.5rem;
    background: #008cd6;
    border-radius: 6px;
    /* 时间数字的颜色 */
    color: #ffffff;
    font-size: 1rem;
    font-weight: bold;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  /* 就是日期中有个要变大 */
  .news-row .news-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  .news-title {
    width: 70%;
    flex: 1 1 auto;
    font-size: 2rem;
    color: #0055a2;
    display: -webkit-box;
    /* 两行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    font-weight: bold;
    text-align: left;
  }
}
</style>
