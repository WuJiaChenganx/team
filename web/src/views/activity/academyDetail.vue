<template>
  <div class="academyDetailBackground">
    <div class="academyDetail">
      <div class="academyDetailTitle">
        <div class="title">学术动态</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/academy' }"
              >学术动态</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/academyDetail' }"
              >学术动态详情</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="academyDetailContent">
        <div class="academyTitle">{{ newsList.title }}</div>
        <div class="academyInfo">{{ newsList.detail }}</div>
        <div class="academyPhoto">
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
      title: "学术动态",
      currentMenu: "学术动态详情",
      newsList: {},
      // newsList: {
      //   id: 0,
      //   day: "18",
      //   date: "2023-03",
      //   title: "NLP组在EMNLP 2022会议上顺利举办讲习班",
      //   profile:
      //     "2022年12月，实验室题为《Non-Autoregressive Models for Fast Sequence Generation》的tutorial讲习班在EMNLP 2022会议上顺利举办。",
      //   detail: [
      //     "神经网络模型在新数据集上训练时，通常会逐渐遗忘旧数据集上学到的知识，在持续学习中的这种现象被称为灾难性遗忘。",
      //     "然而，我们发现即使模型始终在同一数据集上训练，灾难性遗忘现象仍然存在，具体表现为模型对新接触的样本关注更多、对较早接触的样本关注更少，我们把这种在训练样本上的不均衡问题称为“非均衡训练”。通过实验验证，我们发现非均衡训练问题在神经网络模型广泛存在，在机器翻译任务上尤其严重。通过进一步分析，我们揭示了在机器翻译上广泛使用的检查点平均技术与非均衡训练问题的联系，并确认了非均衡训练问",
      //     "题会对模型性能造成影响。为缓解这一问题，我们提出了互补在线知识蒸馏技术，通过对数据集的互补切分来保证教师模型始终与学生模型互补，从而使模型能够均匀地从所有训练样本中学习。在多个机器翻译任务上的实验表明，我们的方法成功地缓解了非均衡训练问题，取得了显著的性能提升。",
      //   ],
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
  .academyDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .academyDetail {
    width: 75%;
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
  .academyDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .academyTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    font-weight: bold;
    text-align: center;
    padding: 2rem;
  }
  .academyInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }
  .academyPhoto {
    padding-bottom: 2rem;
  }
  .academyPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
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
  .academyDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .academyTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
    padding: 2rem;
  }
  .academyInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }

  .academyPhoto {
    padding-bottom: 2rem;
  }
  .academyPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
  }
}
</style>
