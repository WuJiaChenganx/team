<template>
  <div class="newFlashDetailBackground">
    <div class="newFlashDetail">
      <div class="newFlashDetailTitle">
        <div class="title">{{ pageItem.title }}</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">{{
              pageItem.home
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/newFlash' }">{{
              pageItem.newFlashList
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/newFlashDetail' }">{{
              pageItem.newFlashDetail
            }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="newFlashDetailContent">
        <div class="titleContent">
          <div class="newFlashTitle">
            {{ newsFlashDetail.title }}
          </div>
          <div>
            <span class="publicationDate">
              {{ pageItem.publicationDate }}{{ newsFlashDetail.date }}-{{
                newsFlashDetail.day
              }}
            </span>
            <span class="pageView"
              >{{ pageItem.pageView }}{{ newsFlashDetail.pageView }}</span
            >
          </div>
        </div>
        <div
          class="newFlashDetailItem"
          v-for="(newFlashItem, newFlashItemIndex) in newsFlashDetail.detail"
          :key="newFlashItemIndex"
        >
          <div class="newFlashInfo">
            {{ newFlashItem.text }}
          </div>
          <div
            v-if="newFlashItem.picUrl.length"
            :class="newFlashItem.picUrl.length == 2 ? 'photoBox2' : 'photoBox1'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in newFlashItem.picUrl"
              :key="imgUrlIndex"
            >
              <img :src="imgUrl" />
            </div>
          </div>
        </div>
        <div class="newFlashUrl" v-if="newsFlashDetail.url">
          相关报道:
          <a
            :href="newsFlashDetail.url"
            style="text-decoration: none; color: #034ea1"
            target="_blank"
            v-text="newsFlashDetail.url"
          ></a>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getActivityDetail } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        title: "新闻快讯",
        home: "首页",
        newFlashList: "新闻列表",
        newFlashDetail: "新闻详情",
        publicationDate: "发布时间: ",
        pageView: "浏览量: ",
      },
      englishItem: {
        title: "News",
        home: "Home",
        newFlashList: "News List",
        newFlashDetail: "News Detail",
        publicationDate: "Publication Date: ",
        pageView: "Views: ",
      },
      newsFlashDetail: {},
    };
  },
  created() {
    this.getNewFlashDetail(this.$route.query.id);
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
    async getNewFlashDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
        languageType: this.$store.getters.getLanguageType,
      };
      await getActivityDetail(params).then((res) => {
        this.newsFlashDetail = res.data;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .newFlashDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .newFlashDetail {
    width: 75%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .newFlashDetailTitle {
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
  .newFlashDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .newFlashTitle {
    margin-top: 25px;
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    margin: 2rem;
  }
  .publicationDate {
    font-size: 16px;
    margin: 10px 0;
    display: inline-block;
    margin-right: 10px;
    color: #999;
  }
  .pageView {
    font-size: 16px;
    margin: 10px 0;
    display: inline-block;
    color: #999;
  }
  .newFlashInfo {
    font-family: "宋体", SimSun, STSong, sans-serif;
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
    text-indent: 2em;
    padding-bottom: 5px;
  }
  .photoBox1 {
    width: 100%;
    padding-bottom: 1rem;
    img {
      width: 65%;
    }
  }

  .photoBox2 {
    width: 100%;
    padding-bottom: 1rem;
    display: flex;
    flex-direction: row;
    justify-content: center;
    div {
      width: 45%;
      margin-right: 2rem;
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
  .newFlashUrl {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
    text-indent: 2em;
    margin-top: 10px;
  }
}

/* 移动端  */
@media screen and (max-width: 1000px) {
  .newFlashDetailBackground {
    background: #eef7fe;
  }
  .newFlashDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .newFlashDetailTitle {
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
  .newFlashDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .newFlashTitle {
    color: #0055a2;
    line-height: 24px;
    font-size: 16px;
    text-align: center;
    padding: 1rem;
  }
  .publicationDate {
    font-size: 14px;
    margin: 5px 0;
    display: inline-block;
    margin-right: 10px;
    color: #999;
  }
  .pageView {
    font-size: 14px;
    margin: 5px 0;
    display: inline-block;
    color: #999;
  }
  .newFlashInfo {
    font-family: "宋体", SimSun, STSong, sans-serif;
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 24px;
    font-size: 16px;
    text-indent: 1.5em;
    padding-bottom: 5px;
  }

  .photoBox1 {
    width: 100%;
    padding-bottom: 1rem;
    img {
      width: 60%;
    }
  }

  .photoBox2 {
    width: 100%;
    padding-bottom: 1rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    div {
      width: 49%;
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
  .newFlashUrl {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
    text-indent: 1em;
    margin-top: 5px;
  }
}
</style>
