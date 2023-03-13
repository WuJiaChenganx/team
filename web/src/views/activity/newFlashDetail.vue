<template>
  <div class="newFlashDetailBackground">
    <div class="newFlashDetail">
      <div class="newFlashDetailTitle">
        <div class="title">新闻快讯</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/newFlash' }"
              >新闻快讯</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/newFlashDetail' }"
              >新闻快讯详情</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="newFlashDetailContent">
        <div class="newFlashTitle">{{ newsList.title }}</div>
        <div class="newFlashInfo">{{ newsList.detail }}</div>
        <div class="newFlashPhoto">
          <img :src="newsList.picUrl" alt="" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      title: "新闻快讯",
      currentMenu: "新闻详情",
      newsList: {},
      // newsList: {
      //   id: 0,
      //   day: "18",
      //   date: "2023-03",
      //   title: "课题组0同学荣获硕士奖",
      //   detail:
      //     "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
      //   picUrl: require("../../assets/images/activity/00.jpg"),
      // },
    };
  },
  created() {
    this.newsList = JSON.parse(decodeURIComponent(this.$route.query.item));
  },
};
</script>
<style scoped>
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
  .newFlashDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .newFlashTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    font-weight: bold;
    text-align: center;
    padding: 2rem;
  }
  .newFlashInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }
  .newFlashPhoto {
    padding-bottom: 2rem;
  }
  .newFlashPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
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
  .newFlashDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .newFlashTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
    padding: 2rem;
  }
  .newFlashInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }

  .newFlashPhoto {
    padding-bottom: 2rem;
  }
  .newFlashPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
  }
}
</style>
