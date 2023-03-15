<template>
  <!-- 首页的资源共享 -->
  <div class="resourceSharing">
    <div class="resourceSharing-title-box">
      <div class="resourceSharing-title">资源共享</div>
      <a class="title-more" @click="goTo('/resource/simulationTool')">更多+</a>
    </div>
    <div class="resourceSharing-content-box">
      <div class="linkUrl" @click="goTo('/resource/simulationTool')">
        仿真工具
      </div>
      <div class="linkUrl" @click="goTo('/resource/dataSet')">数据集</div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {
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
.resourceSharing-title-box {
  overflow: hidden;
  margin-bottom: 2rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.resourceSharing-title {
  text-align: left;
  font-size: 2.2rem;
  font-weight: bold;
  color: #003266;
}
.title-more {
  font-size: 1.4rem;
  color: #7db0cb;
  line-height: 1.8rem;
  cursor: pointer;
}
.resourceSharing-content-box {
  overflow: hidden;
  height: auto;
  width: 100%;
}
.linkUrl {
  margin-bottom: 1rem;
  /* 去掉a标签自带的格式 */
  text-decoration: none;
  display: block;
  font-size: 1.7rem;
  color: #333333;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  position: relative;
  padding-left: 20px;
  text-decoration: none;
  text-align: left;
}
/* before伪元素加载元素的最前面且伪元素必须要要有content字段 */
.linkUrl::before {
  position: absolute;
  content: "";
  width: 9px;
  height: 9px;
  left: 0;
  top: 8px;
  background: url(../../assets/images/background/zryy-link-icon.png) no-repeat
    center center;
}
</style>
