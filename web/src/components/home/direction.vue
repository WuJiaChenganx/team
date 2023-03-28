<template>
  <div class="direction">
    <div class="directionTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/scientificResearch/direction')"
        >{{ pageItem.more }} >></a
      >
    </div>
    <div class="directionItem">
      <div class="direction-item">
        <div class="direction-img">
          <img src="../../assets/images/direction/AIot.png" alt="" />
        </div>
        <!-- 遮罩 -->
        <div class="mask">智联网</div>
      </div>
      <div class="direction-item">
        <div class="direction-img">
          <img src="../../assets/images/direction/wiseCommunity.png" alt="" />
        </div>
        <!-- 遮罩 -->
        <div class="mask">智慧社区</div>
      </div>
      <div class="direction-item">
        <div class="direction-img">
          <img src="../../assets/images/direction/coordination.png" alt="" />
        </div>
        <!-- 遮罩 -->
        <div class="mask">多智能体协同</div>
      </div>
    </div>
  </div>
</template>
<script>
import { getAcademyURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: { title: "研究方向", more: "更多" },
      englishItem: { title: "Direction", more: "more" },
    };
  },
  created() {
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
  }
  .directionItem {
    display: flex;
    flex-direction: row;
    width: 100%;
    justify-content: space-between;
  }
  .direction-item {
    width: 32%;
    height: 350px;
    margin-bottom: 25px;
    border: 1.5px solid #dfdfdf;
    position: relative;
  }
  .direction-img {
    width: 100%;
    height: 100%;
  }
  .direction-img img {
    width: 100%;
    height: 100%;
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
/* 移动端 */
@media screen and (max-width: 1000px) {
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
