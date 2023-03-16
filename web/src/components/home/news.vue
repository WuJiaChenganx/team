<template>
  <div class="news">
    <!-- 轮播图 -->
    <div class="newsPhoto">
      <el-carousel
        :interval="4000"
        indicator-position="outside"
        class="photo"
        height="40rem"
      >
        <el-carousel-item
        v-for="(newsItem,newsItemIndex) in newsList"
          :key="newsItemIndex"
          @click.native="goTo('/activity/newFlash')"
          style="cursor: pointer"
        >
          <img :src="newsItem.picUrl" alt="" />
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
          style="cursor: pointer"
          v-for="(newsItem,newsItemIndex) in newsList"
          :key="newsItemIndex"
          @click="gotoDetail(newsItem)"
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
export default {
  data() {
    return {
      // 要展示的新闻信息(加载前还要处理过)
      newsList: [
        {
          day: "18",
          date: "2023-03",
          title: "课题组李泽康同学荣获国家奖学金硕士奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/activity1.png"),
        },
        {
          day: "18",
          date: "2023-03",
          title: "冯洋老师荣获钱伟长中文信息处理科学技术奖",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/activity2.png"),
        },
        {
          day: "18",
          date: "2023-03",
          title: "NLP课题组2021年中央广播电视塔秋游行",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/activity3.png"),
        },
        {
          day: "18",
          date: "2023-03",
          title: "NLP课题组举行2020年年会",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/activity4.png"),
        },
        {
          day: "18",
          date: "2023-03",
          title: "NLP课题组2021年春游记",
          detail:
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          picUrl: require("../../assets/images/activity/activity5.png"),
        },
      ],
    };
  },
  created() {},
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
  .el-carousel__item img {
    width: 100%;
    height: 100%;
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
    -webkit-line-clamp: 2;
    overflow: hidden;
    font-weight: bold;
    text-align: left;
  }
}
</style>
