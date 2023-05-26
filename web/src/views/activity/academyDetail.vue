<template>
  <div class="academyDetailBackground">
    <div class="academyDetail">
      <div class="academyDetailTitle">
        <div class="title">{{ pageItem.title }}</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">{{
              pageItem.home
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/academy' }">{{
              pageItem.academyList
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/academyDetail' }">{{
              pageItem.academyDetail
            }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="academyDetailContent">
        <div class="titleContent">
          <div class="academyTitle">
            {{ academyDetail.title }}
          </div>
          <div>
            <span class="publicationDate">
              {{ pageItem.publicationDate }}{{ academyDetail.date }}-{{
                academyDetail.day
              }}
            </span>
            <span class="pageView"
              >{{ pageItem.pageView }}{{ academyDetail.pageView }}</span
            >
          </div>
        </div>
        <div
          class="academyDetailItem"
          v-for="(academyItem, academyItemIndex) in academyDetail.detail"
          :key="academyItemIndex"
        >
          <div class="academyInfo" v-html="academyItem.text"></div>
          <div
            v-if="academyItem.picUrl.length"
            :class="academyItem.picUrl.length == 2 ? 'photoBox2' : 'photoBox1'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in academyItem.picUrl"
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
        title: "学术动态",
        home: "首页",
        academyList: "学术列表",
        academyDetail: "学术详情",
        publicationDate: "时间: ",
        pageView: "浏览量: ",
      },
      englishItem: {
        title: "Academy",
        home: "Home",
        academyList: "Academy List",
        academyDetail: "Academy Detail",
        publicationDate: "Publication Date: ",
        pageView: "Views: ",
      },
      academyDetail: {},
    };
  },
  created() {
    this.getAcademyDetail(this.$route.query.id);
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
    async getAcademyDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
        languageType: this.$store.getters.getLanguageType,
      };
      await getActivityDetail(params).then((res) => {
        this.academyDetail = res.data;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .academyDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }

  .academyDetail {
    width: 80%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyDetailTitle {
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
  .academyDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .academyTitle {
    margin-top: 25px;
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    margin: 2rem;
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
  .academyInfo {
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
  .academyDetailBackground {
    background: #eef7fe;
  }
  .academyDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyDetailTitle {
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
  .academyDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .academyTitle {
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
  .academyInfo {
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
