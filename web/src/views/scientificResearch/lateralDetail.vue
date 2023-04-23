<template>
  <div class="projectDetailBackground">
    <div class="projectDetail">
      <div class="projectDetailTitle">
        <div class="title">{{ pageItem.title }}</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">{{
              pageItem.home
            }}</el-breadcrumb-item>
            <el-breadcrumb-item
              :to="{ path: '/scientificResearch/lateralProject' }"
              >{{ pageItem.project }}</el-breadcrumb-item
            >
            <el-breadcrumb-item
              :to="{ path: '/scientificResearch/lateralDetail' }"
              >{{ pageItem.projectDetail }}</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="projectDetailContent">
        <div class="titleContent">
          <div class="projectTitle">
            {{ projectDetail.title }}
          </div>
          <div>
            <span class="publicationDate">
              {{ pageItem.publicationDate }}{{ projectDetail.date }}-{{
                projectDetail.day
              }}
            </span>
            <span class="pageView"
              >{{ pageItem.pageView }}{{ projectDetail.pageView }}</span
            >
          </div>
        </div>
        <div
          class="projectDetailItem"
          v-for="(projectItem, projectItemIndex) in projectDetail.detail"
          :key="projectItemIndex"
        >
          <div class="projectInfo">
            {{ projectItem.text }}
          </div>
          <div
            v-if="projectItem.picUrl.length"
            :class="projectItem.picUrl.length == 2 ? 'photoBox2' : 'photoBox1'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in projectItem.picUrl"
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
import { getProjectDetail } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        title: "科研项目",
        home: "首页",
        project: "横向项目",
        projectDetail: "项目详情",
        publicationDate: "发布时间: ",
        pageView: "浏览量: ",
      },
      englishItem: {
        title: "Project",
        home: "Home",
        project: "Project List",
        projectDetail: "Project Detail",
        publicationDate: "Publication Date: ",
        pageView: "Views: ",
      },
      projectDetail: {},
    };
  },
  created() {
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
    async getProjectDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        projectId: id,
        languageType: this.$store.getters.getLanguageType,
      };
      await getProjectDetail(params).then((res) => {
        this.projectDetail = res.data;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .projectDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }

  .projectDetail {
    width: 75%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .projectDetailTitle {
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
  .projectDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .projectTitle {
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
  .projectInfo {
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
  .projectDetailBackground {
    background: #eef7fe;
  }
  .projectDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .projectDetailTitle {
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
  .projectDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .titleContent {
    margin-bottom: 10px;
    border-bottom: 1px solid #dfdfdf;
  }
  .projectTitle {
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
  .projectInfo {
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
