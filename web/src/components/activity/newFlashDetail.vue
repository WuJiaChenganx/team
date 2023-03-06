<template>
  <div class="backgroundBox">
    <div class="content">
      <div class="contentTitle">
        <div class="indexTitle">{{ title }}</div>
        <div class="indexPosition">
          您当前的位置: 首页 > {{ title }}> {{ currentMenu }}
        </div>
      </div>
      <div class="thing">
        <div class="thingTitle">{{ newsList.title }}</div>
        <div class="thingContent">{{ newsList.detail }}</div>
        <div class="personPhoto">
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
.backgroundBox {
  height: auto;
  padding: 30px 0;
  background: #eef7fe;
}
.content {
  width: 75%;
  height: auto;
  margin: 0 auto;
  padding: 0 30px 20px;
  background-color: #fff;
  border: 1px solid #dfdfdf;
}
.contentTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
  margin-bottom: 20px;
}
.indexTitle {
  float: left;
  color: #333333;
  font-weight: bold;
  font-size: 25px;
}
.indexPosition {
  float: right;
  color: #999999;
  font-size: 15px;
}
.thing {
  padding-bottom: 50px;
}
.thingTitle {
  color: #0055a2;
  line-height: 30px;
  font-size: 26px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 20px;
}
.thingContent {
  word-wrap: break-word;
  word-break: break-all;
  width: 100%;
  height: auto;
  text-align: left;
  line-height: 30px;
  font-size: 16px;
  text-indent: 2em;
  padding-bottom: 10px;
}
.personPhoto {
  width: 100%;
  height: auto;
}
.personPhoto img {
  height: 250px;
  width: 200px;
}
</style>
