<template>
  <div class="direction">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="directionContent">
      <div class="directionAside">
        <div class="directionAsideTitle">科研教学</div>
        <div class="directionAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="directionAsideItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span>{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="directionDetail">
        <div class="directionTitle">
          <div class="title">科研方向</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item
                :to="{ path: '/scientificResearch/direction' }"
                >科研方向</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="directionItem">
          <div
            class="detailItem"
            v-for="directionItem in directions"
            :key="directionItem.id"
          >
            <div class="detailItemInfo">{{ directionItem.Info }}</div>
            <div class="detailItemImg">
              <img :src="directionItem.picUrl" alt="" />
            </div>
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
/* PC端  */
@media screen and (min-width: 1000px) {
  .direction {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .directionContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .directionAside {
    width: 25%;
  }
  .directionAsideTitle {
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 2rem;
    line-height: 3rem;
    height: 3rem;
    padding: 2rem 3rem;
    margin-bottom: 0.5rem;
  }
  .directionAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .directionDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .directionTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .directionItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  /*每个item之间的上边距 */
  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 1.5rem;
  }
  /* 文字和图片的距离 */
  .detailItemInfo {
    line-height: 3rem;
    font-size: 2rem;
    text-align: left;
    text-indent: 2em;
    margin-bottom: 1rem;
  }
  .detailItemImg {
    padding-bottom: 0.5rem;
  }
  .detailItemImg img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .direction {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .directionContent {
    display: flex;
    flex-direction: column;
  }

  .directionAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .directionAsideTitle {
    display: none;
  }
  .directionAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .directionDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .directionTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .directionItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  /*每个item之间的上边距 */
  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 1.5em;
  }
  /* 文字和图片的距离 */
  .detailItemInfo {
    line-height: 3rem;
    font-size: 2rem;
    text-align: left;
    text-indent: 2em;
    margin-bottom: 1rem;
  }
  .detailItemImg {
    padding-bottom: 0.5rem;
  }
  .detailItemImg img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 80%;
  }
}
</style>
