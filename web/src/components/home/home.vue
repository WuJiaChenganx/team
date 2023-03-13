<template>
  <div>
    <div class="firstContainer">
      <!-- 内容展示 -->
      <div class="firstAllContent">
        <!-- 图片展示的盒子 -->
        <div class="firstPhotoContent">
          <activityPhoto></activityPhoto>
        </div>
        <div class="firstMessageContent">
          <newsList class="newsList"></newsList>
        </div>
      </div>
    </div>

    <div class="secondContainer">
      <div class="secondAllContent">
        <div class="second-left">
          <!-- hover问题没有解决 -->
          <!-- 放的是学术动态 -->
          <academicTrend class="academicTrend"></academicTrend>
        </div>
        <div class="second-right">
          <notice class="notice"></notice>
        </div>
      </div>
    </div>

    <div class="lastContainer">
      <div class="lastAllContent">
        <div class="last-left">
          <researchTeam class="researchTeam"></researchTeam>
        </div>
        <div class="last-right">
          <!-- 友情链接 -->
          <friendlyLink class="friendlyLink"></friendlyLink>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import newsList from "./newsList.vue";
import friendlyLink from "./friendlyLink.vue";
import researchTeam from "./researchTeam.vue";
import activityPhoto from "./activityPhoto.vue";
import academicTrend from "./academicTrend.vue";
import notice from "./notice.vue";
export default {
  name: "home",
  components: {
    activityPhoto,
    newsList,
    academicTrend,
    notice,
    friendlyLink,
    researchTeam,
  },
  data() {
    return {};
  },
  created() {},
  methods: {},
};
</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
}

.firstContainer {
  background: #deecf9;
}
/* PC端  */
@media screen and (min-width: 1000px) {
  .firstContainer {
    margin-bottom: 2rem;
  }
  .firstContainer .firstAllContent {
    width: 75%;
    height: 100%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .firstContainer > .firstAllContent .firstPhotoContent {
    margin-top: 2rem;
    width: 65%;
  }

  .firstContainer > .firstAllContent .firstMessageContent {
    margin-top: 2rem;
    width: 34%;
  }
  .newsList {
    width: 100%;
    margin-bottom: 1.5rem;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .secondContainer {
    margin-bottom: 2rem;
  }
  .secondContainer .secondAllContent {
    width: 75%;
    margin: 0 auto;
    height: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .second-left {
    width: 65%;
  }
  .second-right {
    width: 33%;
  }
  .academicTrend {
    width: 100%;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .notice {
    width: 100%;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  /* 我是最后一个容器 */
  .lastContainer {
    background: #fff;
    margin-bottom: 2rem;
  }
  .lastContainer .lastAllContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .last-left {
    width: 65%;
  }
  .last-right {
    width: 33%;
  }
  .researchTeam {
    width: 100%;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .friendlyLink {
    width: 100%;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .firstContainer .firstAllContent {
    display: block;
    margin-bottom: 0.2rem;
  }

  .firstContainer > .firstAllContent .firstPhotoContent {
    padding: 2rem 0;
    width: 90%;
    margin: 0 auto;
  }

  .firstContainer > .firstAllContent .firstMessageContent {
    width: 100%;
  }
  .newsList {
    width: 100%;
    padding: 1rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }

  .secondContainer .secondAllContent {
    display: block;
    margin-bottom: 0.2rem;
  }
  .second-left {
    width: 100%;
  }
  .second-right {
    width: 100%;
  }
  .academicTrend {
    width: 100%;
    padding: 1rem;
    margin-bottom: 0.2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .notice {
    width: 100%;
    padding: 1rem;
    margin-bottom: 0.2rem;
    border: 1px solid #d1e4f0;
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
    padding: 1rem;
    margin-bottom: 0.2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
  .friendlyLink {
    width: 100%;
    padding: 1rem;
    margin-bottom: 0.2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
  }
}
</style>
