<template>
  <div class="direction animation" data-aos="fade-up">
    <div class="directionTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/scientificResearch/direction')"
        >{{ pageItem.more }}
      </a>
    </div>
    <div class="directionItem">
      <div
        class="direction-item animation"
        data-aos="fade-up"
        :data-aos-delay="delayTime[index]"
        v-for="(item, index) in directions"
        :key="index"
        @click="goTo('/scientificResearch/direction')"
      >
        <div class="direction-img">
          <img :src="item.picUrl" alt="" />
        </div>
        <!-- 遮罩 -->
        <div class="mask">{{ item.title }}</div>
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
        {
          picUrl: require("../../assets/images/direction/AIot.png"),
          title: "智联网",
        },
        {
          picUrl: require("../../assets/images/direction/wiseCommunity.png"),
          title: "智慧社区",
        },
        {
          picUrl: require("../../assets/images/direction/coordination.png"),
          title: "多智能体协同",
        },
      ],
      pageItem: {},
      chineseItem: { title: "研究方向", more: "more" },
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
.animation {
  opacity: 0;
  transform: translateY(50px);
  transition: all 0.8s ease-in-out;
}
/* PC端 */
@media screen and (min-width: 1000px) {
  .direction {
    width: 65%;
    margin: 0 auto;
    background-color: #ffffff;
  }
  .directionTitle {
    font-size: 18px;
    margin-bottom: 20px;
    position: relative;
  }
  .title {
    width: 164px;
    margin: 20px auto;
    font-size: 18px;
    color: #0055a2;
  }
  .directionTitle p {
    width: 164px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .directionTitle p:before {
    width: 50px;
    height: 5px;
    position: absolute;
    left: 57px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #333;
    font-size: 14px;
    position: absolute;
    bottom: 28px;
    right: 10px;
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
    font-size: 20px;
    margin-bottom: 10px;
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
