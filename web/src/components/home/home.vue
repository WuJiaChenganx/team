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
      <div class="lastContainerContent">
        <friendlyLink class="friendlyLink"> </friendlyLink>
      </div>
    </div>
  </div>
</template>

<script>
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
  mounted() {},

  methods: {},
};
</script>
<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}
// @media screen (min-width: 1200px) .container {
//   width: 1170px;
// }
// @media (min-width: 992px) .container {
//   width: 970px;
// }
// @media (min-width: 768px) .container {
//   width: 750px;
// }
/* PC端  */
@media screen and (min-width: 1000px) {
  .firstContainerContent {
    width: 80%;
    margin: 0 auto;
  }

  .secondContainerContent {
    width: 80%;
    margin: 0 auto;
  }

  .thirdContainerContent {
    width: 80%;
    margin: 0 auto;
  }

  // 修改之后
  .lastContainer {
    width: 100%;
    background-color: #ccc;
  }
  .friendlyLink {
    height: 100px;
    width: 80%;
    margin: 0 auto;
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
    padding: 15px;
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

  .lastContainer {
    width: 100%;
    background-color: #ccc;
  }
  .friendlyLink {
    // width: 90%;
    height: 50px;
    // margin: 0 auto;
  }
}
</style>
