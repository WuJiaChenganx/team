<template>
  <div class="resourceSharing">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="resourceContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="contentItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span slot="title">{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="details">
        <div class="detailTitle">
          <div class="currentTitle">
            {{ currentMenu }}
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > {{ title }} >{{ currentMenu }}
          </div>
        </div>
        <div
          class="detailItem"
          v-for="directionItem in directions"
          :key="directionItem.id"
        >
          <div class="directionContent">{{ directionItem.Info }}</div>
          <div class="contentImg">
            <img :src="directionItem.picUrl" alt="" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "科研教学",
      currentMenu: "科研方向",
      Menu: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      directions: [
        {
          id: 1,
          Info: " 实验室主要面向国际科技前沿、国家重大战略需求、国民经济主战场和人民生命健康进行攻关创新。主要在前沿智能物联网、智能计算、数据智能、量子计算等领域，从无线通信、移动计算、边缘计算、智能无人系统、数据理解、数据共享、智能学习及隐私保护等方面开展创新性科研和平台建设。",
          picUrl: require("../../assets/images/activity/04.jpg"),
        },
        {
          id: 2,
          Info: "实验室目前设有感知智能、计算智能、数据智能、无人系统和量子计算几个科研小组。感知智能主要研究低功耗智能感知和无源网络，包括新型的跨域多模态感知、低功耗甚至无源的组网与接入技术；计算智能主要研究边缘计算相关的计算理论、方法和技术和和网络安全，包括端边云计算和基于边缘计算的安全和优化；数据智能主要研究数据理解、数据质量评估、数据共享和交易、联邦学习、隐私保护、及相关算法分析和计算理论；无人系统主要研究基于边缘计算的车路协同的无人驾驶系统；量子计算主要研究量子软件和量子计算相关理论和系统，尤其是量子-经典混合计算的理论与平台。",
          picUrl: require("../../assets/images/activity/04.jpg"),
        },
      ],
    };
  },
  created() {},
  methods: {},
};
</script>
<style scoped>
.resourceSharing {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.resourceContent {
  padding-top: 20px;
  width: 75%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.aside {
  width: 25%;
  height: auto;
  padding: 0 15px;
  float: left;
}

.asideTitle {
  background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat
    center;
  border-radius: 6px;
  background-size: cover !important;
  font-weight: bold;
  color: #fff;
  font-size: 22px;
  line-height: 30px;
  height: 30px;
  padding: 20px 30px;
  margin-bottom: 10px;
}

.asideContent {
  height: auto;
  border: 1px solid #eee;
}

.currentTitle {
  float: left;
  color: #333333;
  font-weight: bold;
  font-size: 25px;
}

.contentItem {
  font-weight: bold;
  font-size: 20px;
  text-align: left;
  cursor: pointer;
  padding: 0 20px;
  border-bottom: 1px solid #eee;
}

.el-menu-item.is-active {
  background: #008cd6 !important;
}

.details {
  float: left;
  position: relative;
  padding: 0 15px;
  width: 75%;
  height: auto;
  background-color: #fff;
  border: 1px solid #dfdfdf;
  padding-bottom: 150px;
}

.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
  margin-bottom: 15px;
}

.detailItem {
  word-wrap: break-word;
  word-break: break-all;
  width: 100%;
  height: auto;
  text-align: left;
  line-height: 30px;
  font-size: 16px;
  text-indent: 2em;
}
.contentImg {
  width: 100%;
  height: auto;
  /* 使图片对齐 */
  text-align: center;
}
.contentImg img {
  height: 300px;
  width: 500px;
  padding: 10px 0;
}
</style>
