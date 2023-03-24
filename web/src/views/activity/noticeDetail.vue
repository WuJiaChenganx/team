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
        <div class="noticeTitle">{{ noticeDetail.title }}</div>
        <div class="noticeInfo">{{ noticeDetail.detail }}</div>
        <div
          class="noticePhoto"
          v-for="imgUrl in noticeDetail.picUrl"
          :key="imgUrl"
        >
          <img :src="imgUrl" alt="" />
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
        noticeDetail: "详情",
      },
      englishItem: {
        title: "Notices",
        home: "Home",
        noticeList: "Notices List",
        noticeDetail: "Notice Detail",
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
      };
      await getActivityDetail(params).then((res) => {
        this.noticeDetail = res.data;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .noticeDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .noticeDetail {
    width: 75%;
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
  .noticeTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    padding: 2rem;
  }
  .noticeInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }
  .noticePhoto {
    padding-bottom: 2rem;
  }
  .noticePhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
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
  .noticeTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2rem;
    text-align: center;
    padding: 2rem;
  }
  .noticeInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }

  .noticePhoto {
    padding-bottom: 2rem;
  }
  .noticePhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
  }
}
</style>
