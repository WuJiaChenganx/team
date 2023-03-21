<template>
  <div>
    <div class="firstContainer">
      <!-- 内容展示 -->
      <div class="firstContainerContent">
        <news class="news"></news>
      </div>
    </div>
    <div class="secondContainer">
      <div class="secondAllContent">
        <div class="second-left">
          <academicTrend class="academicTrend"></academicTrend>
        </div>
        <div class="second-right">
          <notice class="notice"></notice>
          <resourceSharing class="resourceSharing"></resourceSharing>
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
import friendlyLink from "./friendlyLink.vue";
import researchTeam from "./researchTeam.vue";
import academicTrend from "./academicTrend.vue";
import notice from "./notice.vue";
import resourceSharing from "./resourceSharing.vue";
import news from "./news.vue";
export default {
  name: "home",
  components: {
    news,
    academicTrend,
    notice,
    resourceSharing,
    researchTeam,
    friendlyLink,
  },
  data() {
    return {};
  },
  created() {},
  methods: {},
};
</script>
<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
}

/* PC端  */
@media screen and (min-width: 1000px) {
  /* 新闻背景蓝色 */
  .firstContainer {
    background: #deecf9;
    margin-bottom: 2rem;
  }
  /* 新闻居中放内容 */
  .firstContainer .firstContainerContent {
    padding: 2rem 0;
    width: 75%;
    margin: 0 auto;
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
    display: flex;
    flex-direction: column;
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
    /* PC端设置首页通知的最大高度这样好对齐 */
    max-height: 36rem;
    overflow: hidden;
    width: 100%;
    padding: 2rem;
    border: 1px solid #d1e4f0;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 1rem;
  }
  .resourceSharing {
    /* PC端设置首页资源共享自动拉伸占领空白的位置 */
    flex: 1 1 auto;
    overflow: hidden;
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
    align-items: stretch;
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
  .firstContainer {
    background: #deecf9;
  }
  .firstContainer .firstContainerContent {
    display: block;
    margin-bottom: 0.2rem;
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
  .resourceSharing {
    /* PC端设置首页资源共享自动拉伸占领空白的位置 */
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
