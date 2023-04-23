<template>
  <div class="direction" data-aos="fade-up">
    <div class="directionTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/scientificResearch/direction')"
        >{{ pageItem.more }} >></a
      >
    </div>
    <div class="directionItem">
      <div
        class="direction-item"
        v-for="(item, index) in directions"
        :key="index"
        @click="goTo('/scientificResearch/direction')"
      >
        <div class="direction-title"></div>
        <div class="direction-content">
          <div class="direction-img">
            <img :src="item.picUrl" alt="" />
          </div>
          <div class="direction-profile"></div>
        </div>

        <!-- 遮罩 -->
        <!-- <div class="mask">{{ item.title }}</div> -->
      </div>
    </div>
  </div>
</template>
<script>
import AOS from "aos";
import "aos/dist/aos.css";
export default {
  data() {
    return {
      directions: [
        // {
        //   picUrl: require("../../assets/images/direction/AIot.png"),
        //   title: "智联网",
        // },
        // {
        //   picUrl: require("../../assets/images/direction/wiseCommunity.png"),
        //   title: "智慧社区",
        // },
        // {
        //   picUrl: require("../../assets/images/direction/coordination.png"),
        //   title: "多智能体协同",
        // },
        {
          id: 1008,
          detail:
            "随着纳米技术和微电子技术的不断发展，微观世界领域的物联网智能感知与通信技术及其前所未有的应用场景具有极其重大的价值与战略意义。虽然纳米机器人的潜在用途非常广泛，并具有巨大的战略意义，然而受纳米器件的体积大小、感知能力、计算能力、存储能力、能量供应等物理因素制约，单个纳米器件（机器人）只能执行一些十分简单的任务（如计算、感知、数据存贮和驱动等）。因此，在人体健康应用场景下，如何释放单个纳米机器人的应用潜能，允许纳米机器人之间相互协作，共享和融合信息，扩展单个纳米机器人在复杂性和操作性等方面的能力，即构建高可靠性的人体移动电磁纳米机器人网络。该特殊的人体移动电磁纳米机器人网络（统称：纳米物联网或纳米网络）的基础网络理论和关键通信技术就是本方向的重点研究内容，具体包括基于太赫兹频段的人体纳米网络同信道干扰模型和调制解调机制，人体移动纳米网络的动态拓扑结构及能量模型，能量受限环境下的纳米网络MAC协议，以及能耗均衡的中继协议。课题申请人在电磁纳米网络和物联网方面已有10余年的研究基础，积累了一系列的研究成果，获得省部级奖7项，获得2020杭州市十大青年科技英才、2020杭州市钱江特聘专家、2020浙江省高校领军人才等称号团队在该领域累计获得相关科研项目10多项、发表学术论文50余篇、发明专利20多件、学术专著4部、入选科创之江百人会ZAIL100。团队在该领域累计获得相关科研项目10多项、发表学术论文50余篇、发明专利20多件、学术专著4部。 ",
          picUrl:
            "http://121.43.183.119:6250/resource/picture/AIot9909bae4.png",
          title: "微观尺度——纳米网络",
        },
        {
          id: 1033,
          detail:
            "近年来，在新一代人工智能发展背景下，物联网智能化应用不断落地，促进了智能物联网（Artificial Intelligence of Things, AIoT）的诞生，“万物互联”开始向“万物智联”演进。当前，AIoT已经快速融入国家重大需求和民生的各个领域，不仅促进了智能工厂、智慧城市、自动驾驶等领域快速发展，而且成为传统行业智能化升级的最佳途径。智能物联网以人工智能、边缘计算、物联网等技术的深度融合为基础，在感知、通信、计算和应用中通过人工智能技术赋能，是一种具有更高灵活性、自组织性、自适应性的物联网系统。",
          picUrl:
            "http://121.43.183.119:6250/resource/picture/wiseCommunity.png",
          title: "宏观尺度——智能物联网",
        },
      ],
      pageItem: {},
      chineseItem: { title: "研究方向", more: "更多" },
      englishItem: { title: "Direction", more: "more" },
      delayTime: [0, 250, 500],
    };
  },
  created() {
    // 在 mounted 钩子中初始化 AOS
    AOS.init({
      offset: 100, // 触发动画的位置距离窗口底部的距离
      duration: 1000, // 动画持续时间
    });
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
/* .animation {
  opacity: 0;
  transform: translateY(50px);
  transition: all 0.8s ease-in-out;
} */
/* PC端 */
@media screen and (min-width: 1000px) {
  .direction {
    width: 100%;
    background-color: #ffffff;
  }
  .directionTitle {
    margin-bottom: 40px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 30px auto;
    font-size: 33px;
    color: #0055a2;
  }
  .directionTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .directionTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 20px;
    position: absolute;
    bottom: 20px;
    right: 30px;
    cursor: pointer;
  }
  .directionItem {
    display: flex;
    flex-direction: row;
    width: 100%;
    justify-content: space-between;
  }
  .direction-item {
    width: 32%;
    margin-bottom: 25px;
    border: 1.5px solid #dfdfdf;
    position: relative;
    cursor: pointer;
    overflow: hidden;
  }
  .direction-img {
    width: 100%;
    height: 100%;
  }
  .direction-img img {
    max-width: 100%;
    height: 100%;
    box-sizing: border-box;
    border: 1.5px solid #dfdfdf;
  }

  .direction-img:hover img {
    transform: scale(1.05);
    transition: all 0.5s;
  }
  .mask {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    text-align: left;
    color: #fff;
    height: 42px;
    line-height: 42px;
    font-size: 15px;
    text-align: center;
    font-weight: bold;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }
}
/* 移动端 大尺寸*/
@media screen and (min-width: 500px) and (max-width: 1000px) {
  .directionTitle {
    margin-bottom: 20px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 20px auto;
    font-size: 24px;
    color: #0055a2;
  }
  .directionTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .directionTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 16px;
    position: absolute;
    bottom: 20px;
    right: 0;
  }
  .directionItem {
    display: flex;
    flex-direction: column;
  }
  .direction-item {
    width: 100%;
    margin-bottom: 10px;
    border: 1.5px solid #dfdfdf;
    position: relative;
  }
  .direction-img {
    width: 100%;
  }
  .direction-img img {
    width: 100%;
    max-height: 450px;
    margin-bottom: 10px;
    overflow: hidden;
  }
  .mask {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    text-align: left;
    color: #fff;
    height: 42px;
    line-height: 42px;
    font-size: 15px;
    text-align: center;
    font-weight: bold;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }
}
/* 移动端 小尺寸*/
@media screen and (max-width: 500px) {
  .directionTitle {
    margin-bottom: 20px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 20px auto;
    font-size: 24px;
    color: #0055a2;
  }
  .directionTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .directionTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 16px;
    position: absolute;
    bottom: 20px;
    right: 0;
  }
  .directionItem {
    display: flex;
    flex-direction: column;
  }
  .direction-item {
    width: 100%;
    margin-bottom: 10px;
    border: 1.5px solid #dfdfdf;
    position: relative;
  }
  .direction-img {
    width: 100%;
  }
  .direction-img img {
    width: 100%;
    max-height: 180px;
    margin-bottom: 10px;
    overflow: hidden;
  }
  .mask {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    text-align: left;
    color: #fff;
    height: 42px;
    line-height: 42px;
    font-size: 15px;
    text-align: center;
    font-weight: bold;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
  }
}
</style>
