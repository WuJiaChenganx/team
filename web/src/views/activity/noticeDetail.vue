<template>
  <!-- 公告详情 -->
  <div class="noticeDetailBackground">
    <div class="noticeDetail">
      <div class="noticeDetailTitle">
        <div class="title">{{ pageItem.title }}</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">{{
              pageItem.home
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/notice' }">{{
              pageItem.noticeList
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/noticeDetail' }">{{
              pageItem.noticeDetail
            }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="noticeDetailContent">
        <div class="titleContent">
          <div class="noticeTitle">{{ noticeDetail.title }}</div>
          <div>
            <span class="publicationDate">
              {{ pageItem.publicationDate }}{{ noticeDetail.date }}-{{
                noticeDetail.day
              }}
            </span>
            <span class="pageView"
              >{{ pageItem.pageView }}{{ noticeDetail.pageView }}</span
            >
          </div>
        </div>
        <div
          class="noticeDetailItem"
          v-for="(noticeItem, noticeItemIndex) in noticeDetail.detail"
          :key="noticeItemIndex"
        >
          <div class="noticeInfo">
            {{ noticeItem.text }}
          </div>
          <div
            v-if="noticeItem.picUrl.length"
            :class="noticeItem.picUrl.length == 2 ? 'photoBox2' : 'photoBox1'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in noticeItem.picUrl"
              :key="imgUrlIndex"
            >
              <img :src="imgUrl" />
            </div>
          </div>
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
        title: "通知公告",
        home: "首页",
        noticeList: "新闻列表",
        noticeDetail: "新闻详情",
        publicationDate: "时间: ",
        pageView: "浏览量: ",
      },
      englishItem: {
        title: "Notices",
        home: "Home",
        noticeList: "Notices List",
        noticeDetail: "Notice Detail",
        publicationDate: "Publication Date: ",
        pageView: "Views: ",
      },
      noticeDetail: {},
    };
  },
  created() {
    this.getNoticeDetail(this.$route.query.id);
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
    async getNoticeDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
        languageType: this.$store.getters.getLanguageType,
      };
      await getActivityDetail(params).then((res) => {
        this.noticeDetail = res.data;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .noticeDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .noticeDetail {
    width: 80%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .noticeDetailTitle {
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

  .noticeDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .noticeTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    padding: 2rem;
  }
  .publicationDate {
    font-size: 2rem;
    margin: 10px 0;
    display: inline-block;
    margin-right: 20px;
    color: #999;
  }
  .pageView {
    font-size: 2rem;
    margin: 10px 0;
    display: inline-block;
    margin-right: 20px;
    color: #999;
  }
  .noticeInfo {
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
}

/* 移动端  */
@media screen and (max-width: 1000px) {
  .noticeDetailBackground {
    background: #eef7fe;
  }
  .noticeDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .noticeDetailTitle {
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
  .noticeDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .noticeTitle {
    color: #0055a2;
    line-height: 24px;
    font-size: 16px;
    text-align: center;
    padding: 1rem;
  }
  .publicationDate {
    font-size: 15px;
    margin: 5px 0;
    display: inline-block;
    margin-right: 10px;
    color: #999;
  }
  .pageView {
    font-size: 15px;
    margin: 5px 0;
    display: inline-block;
    color: #999;
  }
  .noticeInfo {
    font-family: "宋体", SimSun, STSong, sans-serif;
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 24px;
    font-size: 16px;
    text-indent: 2em;
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
}
</style>
