<template>
  <div>
    <div class="firstContainer">
      <div class="firstContainerContent">
        <news class="news"></news>
      </div>
    </div>
    <div class="secondContainer">
      <div class="secondContainerContent">
        <academicTrend class="academicTrend"></academicTrend>
      </div>
    </div>
    <div class="thirdContainer">
      <div class="thirdContainerContent">
        <direction class="direction"></direction>
      </div>
    </div>
    <div class="lastContainer">
      <div class="lastAllContent">
        <div class="last-left">
          <researchTeam class="researchTeam"></researchTeam>
        </div>
        <div class="last-right">
          <friendlyLink class="friendlyLink"></friendlyLink>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import AOS from "aos";
// import "aos/dist/aos.css";
import friendlyLink from "./friendlyLink.vue";
import researchTeam from "./researchTeam.vue";
import notice from "./notice.vue";
import resourceSharing from "./resourceSharing.vue";
import news from "./news.vue";
import academicTrend from "./academicTrend.vue";
import direction from "./direction.vue";
export default {
  name: "home",
  components: {
    news,
    academicTrend,
    notice,
    resourceSharing,
    researchTeam,
    friendlyLink,
    academicTrend,
    direction,
  },
  data() {
    return {};
  },
  mounted() {
    // AOS.init({
    //   offset: 250,
    //   duration: 800, // 动画持续时间
    //   easing: "ease-in-out",
    // });
  },

  methods: {},
};
</script>
<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
// .animation {
//   opacity: 0;
//   transform: translateY(50px);
//   transition: all 0.5s ease-in-out;
// }

/* PC端  */
@media screen and (min-width: 1000px) {
  /* 新闻背景蓝色 */
  .firstContainer {
    background: #deecf9;
  }
  /* 新闻居中放内容 */
  .firstContainer .firstContainerContent {
    padding: 2rem 0;
    width: 75%;
    margin: 0 auto;
  }

  .secondContainer .secondContainerContent {
    width: 80%;
    box-sizing: border-box;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .thirdContainer .thirdContainerContent {
    width: 80%;
    box-sizing: border-box;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  /* 我是最后一个容器 */
  .lastContainer {
    margin-bottom: 2rem;
  }
  .lastContainer .lastAllContent {
    width: 80%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .last-left {
    width: 68%;
  }
  .last-right {
    width: 30%;
  }
  .researchTeam {
    width: 100%;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .friendlyLink {
    width: 100%;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .firstContainer {
    background: #deecf9;
  }
  .firstContainer .firstContainerContent {
    display: block;
    margin-bottom: 0.2rem;
  }

  .secondContainer .secondContainerContent {
    display: block;
    margin-bottom: 0.2rem;
  }

  .academicTrend {
    width: 100%;
    padding: 15px;
    margin-bottom: 0.2rem;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .thirdContainer .thirdContainerContent {
    display: block;
    margin-bottom: 0.2rem;
  }
  .direction {
    width: 100%;
    padding: 15px;
    margin-bottom: 0.2rem;
    border-radius: 4px;
    box-sizing: border-box;
  }
  /* 我是最后一个容器 */
  .lastContainer .lastAllContent {
    display: block;
    margin-bottom: 0.2rem;
  }
  .last-left {
    width: 100%;
  }
  .last-right {
    width: 100%;
  }
  .researchTeam {
    width: 100%;
    padding: 15px;
    margin-bottom: 0.2rem;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .friendlyLink {
    margin: 15px;
    margin-bottom: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
}
</style>
