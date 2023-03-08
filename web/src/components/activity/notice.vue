<template>
  <!-- 通知公告列表 -->
  <div class="backgroundBox">
    <div class="content">
      <div class="contentTitle">
        <div class="indexTitle">{{ currentMenu }}</div>
        <div class="indexPosition">您当前的位置: 首页 > {{ currentMenu }}</div>
      </div>
      <div class="contentItem">
        <div
          v-for="(noticeItem, index) in noticeList"
          :key="index"
          class="news-row"
          style="cursor: pointer"
          @click="gotoDetail(noticeItem)"
        >
          <div class="news-date">
            <div>{{ noticeItem.day }}</div>
            <div>{{ noticeItem.date }}</div>
          </div>
          <div class="news-title">{{ noticeItem.title }}</div>
          <div class="news-thing">
            {{ noticeItem.detail }}
          </div>
        </div>
      </div>
      <div>
        <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
        <el-pagination
          background
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :page-size="5"
          :total="total_number"
          :current-page="current_index"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      currentMenu: "通知公告",
      // 总共公告的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
      // 要展示的公告信息
      noticeList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 0, fileUrl: "" },
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
            { id: 3, fileUrl: "" },
          ],
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
      noticeAllList: [
        {
          id: 0,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 0, fileUrl: "" },
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 1,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
            { id: 3, fileUrl: "" },
          ],
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
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 0, fileUrl: "" },
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 4,
          day: "18",
          date: "2023-03",
          title: "中科院计算所自然语言处理组招聘启事",
          detail: [
            "近日，2021年中国科学院计算技术研究所研究生国家奖学金评选结果正式公布，课题组李泽康同学荣获2021年度国家奖学金硕士奖。本次国家奖学金硕士奖共19人进入答辩，经过激烈角逐，最终评选出13人。李泽康，中科院计算所2019级硕士生，导师冯洋研究员，主要研究方向为自然语言处理、对话系统、多模态表示等。已在ACL，TASLP等自然语言处理顶级会议和顶级期刊上发表多篇论文，并获得国际对话技术比赛DSTC8多模态对话生成赛道冠军，DSTC9交互式对话评估赛道任务一第一名、任务二第三名，也曾作为中国大陆唯一受邀者参加国际对话评估研讨会。",
          ],
          // 放附件
          fileUrls: [
            { id: 1, fileUrl: "" },
            { id: 2, fileUrl: "" },
            { id: 3, fileUrl: "" },
          ],
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
  created() {
    // let id = this.$route.query.id;
    // console.log(id);
    // 其实应该先从后端获取数据将数据传到newsAllList数组里面
    // 创建的时候就会把总共的数目传进来
    this.total_number = this.noticeAllList.length;
    // slice函数包含前面的,不含后面的
    this.noticeList = this.noticeAllList.slice(
      (this.current_index - 1) * 5,
      this.current_index * 5
    );
  },
  methods: {
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.noticeList = this.noticeAllList.slice((val - 1) * 5, val * 5);
    },
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
.contentItem {
  display: flex;
  flex-direction: column;
  height: 625px;
}

.news-row {
  height: 80px;
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #dfdfdf;
  transition: all 0.5s;
}
/* 时间框 */
.news-row .news-date {
  float: left;
  width: 70px;
  height: 70px;
  background: #008cd6;
  border-radius: 6px;
  margin-right: 30px;
  color: #ffffff;
  font-family: Arial;
  line-height: 22px;
  text-align: center;
  padding-top: 16px;
  box-sizing: border-box;
  transition: all 0.5s;
}
/* 就是日期中有个要变大 */
.news-row .news-date div:first-child {
  font-size: 30px;
  font-weight: bold;
}
/* 文字部分 */
.news-row .news-title {
  font-size: 16px;
  font-weight: bold;
  color: #333333;
  line-height: 22px;
  text-align: left;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  margin-bottom: 10px;
  transition: all 0.5s;
}
.news-thing {
  font-size: 14px;
  color: #999999;
  line-height: 24px;
  text-align: left;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  height: 48px;
}
.news-row:hover {
  border-bottom: 1px solid #0055a2;
}
.news-row:hover .news-title {
  color: #0055a2;
}
.news-row:hover .news-date {
  background-color: #0055a2;
}
</style>
