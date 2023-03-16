<template>
  <div>
    <div class="header">
      <div class="headerContent">
        <div class="headerLogo">
          <logo></logo>
        </div>
        <div class="text">
          <div class="chineseName">群智感知与协同研究组</div>
          <div class="englishName">Crowdsensing and Coordination</div>
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
          <div class="navTitle">{{ item.title }}</div>
          <div class="subNav" style="position: absolute; z-index: 9999">
            <!-- 在点击函数中需要加入stop防止冒泡 -->
            <div
              class="subNavItem"
              v-for="(menu, menuIndex) in item.subMenu"
              :key="menuIndex"
              style="cursor: pointer"
              @click.stop="goTo(menu.path)"
            >
              {{ menu.title }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import logo from "./logo.vue";
export default {
  data() {
    return {
      navigation: [
        {
          title: "首页",
          path: "/home",
        },
        {
          title: "团队动态",
          path: "/activity",
          subMenu: [
            { title: "新闻快讯", path: "/activity/newFlash" },
            { title: "学术动态", path: "/activity/academy" },
            { title: "通知公告", path: "/activity/notice" },
          ],
        },
        {
          title: "论文论著",
          path: "/paper",
          subMenu: [
            { title: "发表论文", path: "/paper/paper" },
            { title: "授权专利", path: "/paper/patent" },
            { title: "出版专著", path: "/paper/book" },
          ],
        },
        {
          title: "科研教学",
          path: "/scientificResearch",
          subMenu: [
            { title: "科研方向", path: "/scientificResearch/direction" },
            { title: "科研项目", path: "/scientificResearch/project" },
            { title: "科研平台", path: "/scientificResearch/platform" },
            { title: "课程教学", path: "/scientificResearch/curriculum" },
          ],
        },
        {
          title: "团队概况",
          path: "/team",
          subMenu: [
            { title: "团队简介", path: "/team/profile" },
            { title: "导师", path: "/team/teacher" },
            { title: "博士生", path: "/team/doctor" },
            { title: "研究生", path: "/team/master" },
            { title: "毕业生", path: "/team/graduate" },
          ],
        },
        {
          title: "资源共享",
          path: "/resource",
          subMenu: [
            { title: "仿真工具", path: "/resource/simulationTool" },
            { title: "数据集", path: "/resource/dataSet" },
          ],
        },
      ],
    };
  },
  components: {
    logo,
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
/* 背景图以及图片还需要更新 */
.header {
  /* background: url(../../assets/images/background/main3_left.png) no-repeat; */
  /* background-size: cover !important; */
}
/* PC端 */
@media screen and (min-width: 1000px) {
  .headerContent {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
  }
  .headerContent .text {
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    font-size: 2rem;
    color: #0055a2;
    font-weight: bold;
  }
  .headerLogo {
    width: 20rem;
  }

  /* 导航栏 */
  .navBackground {
    height: 5rem;
    background-color: #0055a2;
  }

  .nav {
    margin: 0 auto;
    width: 100%;
    height: 5rem;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }

  .navItem {
    width: 15%;
  }

  .navTitle {
    /* 水平对齐 */
    text-align: center;
    /* 垂直对齐 */
    line-height: 5rem;
    font-size: 1.8rem;
    font-weight: bold;
    color: #fff;
  }

  .navItem:hover {
    background-color: #008cd6;
  }

  .navItem .subNav {
    /* 隐藏元素 */
    width: 15%;
    line-height: 5rem;
    font-size: 1.8rem;
    font-weight: bold;
    display: none;
    color: #fff;
    background-color: #0055a2;
  }

  .navItem:hover .subNav {
    display: block;
  }

  .subNavItem {
    height: 5rem;
    text-align: center;
    /* 垂直对齐 */
    line-height: 5rem;
    color: #fff;
  }

  .subNavItem:hover {
    background-color: #008cd6;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .headerContent {
    width: 100%;
    display: flex;
    flex-direction: row;
  }
  .headerLogo {
    width: 20rem;
    margin-right: 2rem;
  }
  .headerContent .text {
    display: flex;
    flex-direction: column;
    justify-content: center;
    font-size: 2rem;
    color: #0055a2;
    font-weight: bold;
  }

  /* 导航栏 */
  .navBackground {
    height: 5rem;
    background-color: #0055a2;
  }

  .nav {
    margin: 0 auto;
    width: 100%;
    height: 5rem;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }

  .navItem {
    width: 15%;
  }

  .navTitle {
    /* 水平对齐 */
    text-align: center;
    /* 垂直对齐 */
    line-height: 5rem;
    font-size: 1rem;
    font-weight: bold;
    color: #fff;
  }

  /* .navItem:hover {
    background-color: #008cd6;
  } */

  .navItem .subNav {
    /* 隐藏元素 */
    /* width: 15%;
    line-height: 5rem;
    font-size: 1rem;
    font-weight: bold; */
    display: none;
    /* color: #fff;
    background-color: #0055a2; */
  }

  /* .navItem:hover .subNav {
    display: block;
  } */

  /* .subNavItem {
    height: 5rem;
    text-align: center; */
  /* 垂直对齐 */
  /* line-height: 5rem;
    color: #fff;
  } */

  /* .subNavItem:hover {
    background-color: #008cd6;
  } */
}
</style>
