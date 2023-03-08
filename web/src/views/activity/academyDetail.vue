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
