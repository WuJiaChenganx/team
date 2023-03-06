<template>
  <!-- 消息列表 -->
  <el-card class="box-card" shadow="never">
    <div slot="header" class="clearfix">
      <span class="text">新闻快讯</span>
      <!-- <div>更多</div> -->
      <span class="more" @click="goTo('/activity/newFlash')">更多</span>
    </div>
    <div class="news">
      <div
        class="news-row"
        style="cursor: pointer"
        v-for="newsItem in newsList"
        :key="newsItem.id"
        @click="gotoDetail(newsItem)"
      >
        <div class="news-date">
          <div>{{ newsItem.day }}</div>
          <div>{{ newsItem.date }}</div>
        </div>
        <div class="news-title">{{ newsItem.title }}</div>
      </div>
    </div>
  </el-card>
</template>
<script>
export default {
  data() {
    return {
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "课题组0同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "冯洋老师荣获钱伟长中文信息处理科学技术奖-汉王青年创新奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "课题组2同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          day: "18",
          date: "2023-03",
          title: "课题组3同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
      // 所有的新闻
      newsAllList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "课题组0同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "课题组1同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          day: "18",
          date: "2023-03",
          title: "课题组2同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          day: "18",
          date: "2023-03",
          title: "课题组3同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 4,
          day: "18",
          date: "2023-03",
          title: "课题组4同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 5,
          day: "18",
          date: "2023-03",
          title: "课题组5同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 6,
          day: "18",
          date: "2023-03",
          title: "课题组6同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 7,
          day: "18",
          date: "2023-03",
          title: "课题组7同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 8,
          day: "18",
          date: "2023-03",
          title: "课题组8同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 9,
          day: "18",
          date: "2023-03",
          title: "课题组9同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 10,
          day: "18",
          date: "2023-03",
          title: "课题组10同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 11,
          day: "18",
          date: "2023-03",
          title: "课题组11同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 12,
          day: "18",
          date: "2023-03",
          title: "课题组12同学荣获硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
      ],
    };
  },
  created() {
    // let params = {
    //   start: 1,
    //   end: 5,
    // };
    // this.$http.get("/api/teamWeb/home/news", { params }).then((response) => {
    //   // 用箭头函数可以继承this如果用回调函数的话需要在外面用that把this保存起来
    //   // this.newsAllList = response.data.data[0];
    //   // console.log(this.newsAllList[0]);
    //   console.log(response.data.data);
    // });
  },
  methods: {
    gotoDetail(item) {
      this.$router.push({
        path: "/activity/newFlashDetail",
        name: "新闻快讯详情",
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
.box-card {
  background-color: #deecf9;
}
.clearfix {
  /* 移动到第0行出现小手 */
  cursor: pointer;
}
.clearfix .text {
  font-size: 22px;
  font-weight: bold;
  color: #003266;
  line-height: 28px;
  float: left;
}
.clearfix .more {
  float: right;
  font-size: 14px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.news {
  display: flex;
  flex-direction: column;
  height: 340px;
}
.news-row {
  margin-bottom: 10px;
}
/* 时间框 */
.news-row .news-date {
  float: left;
  width: 58px;
  height: 58px;
  background: #008cd6;
  border-radius: 2px;
  margin-right: 30px;
  /* 时间数字的颜色 */
  color: #ffffff;
  font-family: Arial;
  line-height: 22px;
  font-size: 12px;
  text-align: center;
  padding-top: 11px;
}
/* 就是日期中有个要变大 */
.news-row .news-date div:first-child {
  font-size: 30px;
  font-weight: bold;
}
/* 文字部分 */
.news-row .news-title {
  font-size: 20px;
  color: #0055a2;
  display: -webkit-box;
  /* 两行直接省略 */
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  /* overflow: hidden; */
  height: 69px;
  font-weight: bold;
  word-wrap: break-word;
  word-break: break-all;
  text-align: left;
}
</style>
