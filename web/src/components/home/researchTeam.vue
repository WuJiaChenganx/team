<template>
  <div class="left-title-box">
    <div class="left-title">研究队伍</div>
    <a @click="goTo('team/master')" class="title-more">更多 +</a>
  </div>
</template>
<script>
export default {
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
.left-title-box::before,
.left-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
}
.left-title-box::before {
  width: 163px;
  height: 39px;
  bottom: 0;
  left: 0;
  top: 0;
  background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
    left center;
}
.left-title-box::after {
  top: 0px;
  left: 160px;
  right: 0;
  height: 4px;
  background: #deecf9;
}
.left-title-box .left-title {
  float: left;
  font-size: 22px;
  font-weight: bold;
  font-style: italic;
  color: #003266;
  line-height: 26px;
}
.left-title-box .title-more {
  float: right;
  position: absolute;
  right: 0;
  bottom: 0;
  color: #7db0cb;
  line-height: 18px;
}
</style>
