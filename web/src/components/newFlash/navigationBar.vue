<template>
  <div>
    <div class="header">
      <div class="headerContent">
        <div class="headerLogo">
          <logo></logo>
        </div>
        <div class="text">
          <div style="font-size: 35px; margin-bottom: 20px">
            群智感知与协同研究组
          </div>
          <div>浙江工业大学计算机学院重点实验室</div>
        </div>
      </div>
    </div>

    <div class="navBackground">
      <!-- 导航栏 -->
      <div class="nav">
        <div
          v-for="(item, index) in navigation"
          :key="index"
          class="navItem"
          @click="goTo(item.path)"
          style="cursor: pointer"
        >
          <span>{{ item.title }}</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import logo from "./logo.vue";
export default {
  name: "navigationBar",
  data() {
    return {
      navigation: [
        { title: "首页", path: "/home" },
        { title: "新闻快讯", path: "/newFlash" },
        { title: "论文论著", path: "/footer" },
        { title: "科研教学", path: "/footer" },
        { title: "团队概况", path: "/footer" },
        { title: "资源共享", path: "/footer" },
      ],
    };
  },
  components: {
    logo,
  },
  methods: {
    goTo(path) {
      this.$router.push({
        path: path,
      });
    },
  },
};
</script>
<style scoped>
.header {
  /* 背景图以及图片还需要更新 */
  background: url(../../assets/images/background/headBackground.jpg) no-repeat
    center top;
  background-size: cover !important;
  /* padding: 30px 0; */
}
.headerContent {
  width: 100%;
  height: 260px;
}
.headerContent .text {
  text-align: left;
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-size: 30px;
  color: #0055a2;
  height: 260px;
  font-weight: bold;
}
.headerLogo {
  float: left;
  margin-left: 200px;
  height: 200px;
  width: 300px;
}

.navBackground {
  height: 50px;
  background-color: #0055a2;
}
.nav {
  margin: 0 auto;
  width: 80%;
  height: 50px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.navItem {
  width: 10%;
}

.navItem span {
  /* 1.变成块,使得设置的宽高生效 */
  display: block;
  /* 2.盒子模型 */
  width: 100%;
  height: 100%;
  /* 3.文字 */
  /* 水平对齐 */
  text-align: center;
  /* 垂直对齐 */
  line-height: 50px;
  color: #fff;
}

.navItem:hover {
  background-color: #008cd6;
}
</style>