<template>
  <div class="noticeAndResearch">
    <div class="notice">
      <div class="notice-title-box">
        <div class="notice-title">通知公告</div>
        <a class="title-more" @click="goTo('/activity/notice')">更多 +</a>
      </div>
      <div class="notice-content-box">
        <div
          class="noticeItem"
          v-for="noticeItem in noticeList"
          :key="noticeItem.id"
          style="cursor: pointer"
          @click="gotoDetail(noticeItem)"
        >
          <div class="notice-date">
            {{ noticeItem.date }}-{{ noticeItem.day }}
          </div>
          <div class="notice-thing">
            {{ noticeItem.title }}
          </div>
        </div>
      </div>
    </div>
    <div class="research">
      <div class="research-title-box">
        <div class="research-title">研究专题</div>
      </div>
      <div class="research-content-box">
        <div class="researchItem">
          <div class="researchTheme researchTheme1">研究专题一</div>
        </div>
        <div class="researchItem">
          <div class="researchTheme researchTheme2">研究专题二</div>
        </div>
        <div class="researchItem">
          <div class="researchTheme researchTheme3">研究专题三</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 要展示的公告信息
      noticeList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
      // 所有的公告
      noticeALLList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 4,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 5,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
    };
  },
  methods: {
    gotoDetail(item) {
      this.$router.push({
        path: "/activity/noticeDetail",
        name: "通知公告详情",
        // 用query传参,在地址栏后面加东西如 ?id=1这种跟在网址后面
        query: {
          // 传参数的时候注意将对象转化成字符串并且加密,在接收端使用解析
          // 如果不这样做的话就会导致,刷新一下传参的东西解析不了
          item: encodeURIComponent(JSON.stringify(item)),
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
.notice {
  width: 100%;
  height: 280px;
  margin-bottom: 15px;
  border: 1px solid #d1e4f0;
  border-radius: 4px;
  border-top: none;
}
.notice-title-box {
  padding: 12px 20px 12px 15px;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.notice-title-box::before,
.notice-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.notice-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.notice-title-box::after {
  top: 0px;
  bottom: 0;
  left: 161px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.notice-title-box .notice-title {
  text-align: left;
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
  color: #fff;
}
.notice-title-box .title-more {
  float: right;
  position: absolute;
  right: 0;
  bottom: 0;
  color: #7db0cb;
  line-height: 18px;
}
/* 文本信息居中 */
.notice-content-box {
  overflow: hidden;
  height: 195px;
  width: 350px;
  margin: 0 auto;
}
.noticeItem {
  display: block;
  font-size: 15px;
  line-height: 22px;
}
.noticeItem:hover .notice-date {
  color: #333333;
}
.noticeItem:hover .notice-thing {
  color: #008cd6;
}
.noticeItem .notice-date {
  float: left;
  color: #008cd6;
  margin-right: 10px;
}
.noticeItem .notice-thing {
  float: left;
  /* 最多两行,超出两行的直接省略 */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  color: #333333;
  font-size: 17px;
}

.research {
  width: 100%;
  height: 280px;
  border: 1px solid #d1e4f0;
  border-radius: 4px;
  border-top: none;
}
.research-title-box {
  padding: 12px 20px 12px 15px;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.research-title-box::before,
.research-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.research-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.research-title-box::after {
  top: 0px;
  bottom: 0;
  left: 161px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.research-title-box .research-title {
  text-align: left;
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
  color: #fff;
}

.research-content-box {
  overflow: hidden;
  height: 195px;
  width: 350px;
  margin: 0 auto;
}
.researchItem {
  display: block;
  height: 56px;
  margin-bottom: 9px;
  background-size: cover !important;
}
.researchTheme1 {
  background: url(../../assets/images/background/zryy-yjzt1.png) no-repeat
    center center;
}
.researchTheme2 {
  background: url(../../assets/images/background/zryy-yjzt2.png) no-repeat
    center center;
}
.researchTheme3 {
  margin-bottom: 0;
  background: url(../../assets/images/background/zryy-yjzt3.png) no-repeat
    center center;
}
.researchTheme {
  border-radius: 3px;
  font-size: 21px;
  font-weight: bold;
  color: #fff;
  line-height: 56px;
  text-align: center;
  height: 56px;
}
</style>
