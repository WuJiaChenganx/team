<template>
  <div>
    <div class="header">
      <div class="headerContent">
        <div class="headerLogo">
          <logo></logo>
        </div>
        <div class="text">
          <div class="languageBtn">
            <span @click="changeLanguage('Chinese')">Chinese</span> |
            <span @click="changeLanguage('English')">English</span>
          </div>
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
        >
          <div class="navTitle" v-html="item.title" ref="navTitle"></div>
          <div class="subNav">
            <!-- 在点击函数中需要加入stop防止冒泡 -->
            <div
              class="subNavItem"
              v-for="(menu, menuIndex) in item.subMenu"
              :key="menuIndex"
              @click.stop="goTo(menu.path)"
              v-html="menu.title"
            ></div>
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
      navigation: [],
      navigationZH: [
        {
          title: "首页",
          path: "/home",
          subMenu: [],
        },
        {
          title: "科研概况",
          path: "/scientificResearch",
          subMenu: [
            { title: "科研方向", path: "/scientificResearch/direction" },
            { title: "科研项目", path: "/scientificResearch/project" },
            { title: "科研平台", path: "/scientificResearch/platform" },
          ],
        },
        {
          title: "教育育人",
          path: "/education",
          subMenu: [{ title: "课程教学", path: "/education/curriculum" }],
        },
        {
          title: "团队成员",
          path: "/team",
          subMenu: [
            { title: "团队简介", path: "/team/profile" },
            { title: "导&nbsp;&nbsp;&nbsp;&nbsp;师", path: "/team/teacher" },
            { title: "博士生", path: "/team/doctor" },
            { title: "研究生", path: "/team/master" },
            { title: "毕业生", path: "/team/graduate" },
          ],
        },
        {
          title: "论文著作",
          path: "/paper",
          subMenu: [
            { title: "发表论文", path: "/paper/paper" },
            { title: "授权专利", path: "/paper/patent" },
            { title: "出版专著", path: "/paper/book" },
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
      navigationEN: [
        {
          title: "Home",
          path: "/home",
          subMenu: [],
        },
        {
          title: "Research",
          path: "/scientificResearch",
          subMenu: [
            { title: "Direction", path: "/scientificResearch/direction" },
            { title: "Project", path: "/scientificResearch/project" },
            { title: "Platform", path: "/scientificResearch/platform" },
          ],
        },

        {
          title: "Education",
          path: "/education",
          subMenu: [{ title: "Curriculum", path: "/education/curriculum" }],
        },
        {
          title: "Snapshot",
          path: "/team",
          subMenu: [
            { title: "Profile", path: "/team/profile" },
            { title: "Teacher", path: "/team/teacher" },
            { title: "Doctor", path: "/team/doctor" },
            { title: "Master", path: "/team/master" },
            { title: "Graduate", path: "/team/graduate" },
          ],
        },
        {
          title: "Publication",
          path: "/paper",
          subMenu: [
            { title: "Paper", path: "/paper/paper" },
            { title: "Patent", path: "/paper/patent" },
            { title: "Book", path: "/paper/book" },
          ],
        },
        {
          title: "Resource",
          path: "/resource",
          subMenu: [
            { title: "Tool", path: "/resource/simulationTool" },
            { title: "Dataset", path: "/resource/dataSet" },
          ],
        },
      ],
    };
  },
  components: {
    logo,
  },

  methods: {
    keepColor() {
      // DOM 加载完成之后执行该方案
      this.$nextTick(() => {
        var navigation = this.navigationZH;
        var navTitles = this.$refs.navTitle;
        let fullPath = window.location.href;
        // 取地址栏的url后面的部分
        let path = fullPath.substring(fullPath.indexOf("#") + 1);
        for (var i = 0; i < navigation.length; i++) {
          // 在改变颜色之前先刷一遍改为蓝色
          navTitles[i].style.backgroundColor = "#0055A2";
        }
        // 导航模块的长度
        for (var i = 0; i < navigation.length; i++) {
          var subMenu = navigation[i].subMenu;
          for (var j = 0; j < subMenu.length; j++) {
            if (path == subMenu[j].path) {
              navTitles[i].style.backgroundColor = "#008cd6";
            }
          }
          if (path == navigation[i].path) {
            navTitles[i].style.backgroundColor = "#008cd6";
          }
        }
      });
    },
    // 这里更新store里面的东西
    changeLanguage(languageType) {
      // 如果不同将languageType存起来然后通过刷新保存到sessionStorage
      if (this.$store.getters.getLanguageType != languageType) {
        // dispatch调用vuex的action里面的方法
        this.$store.dispatch("updateLanguageType", languageType);
        // 这里刷新一个使得created()里面的函数根据语言重新渲染,实现切换,但是渲染过程中要把state对象保存否则就算之前切换了语言都会失效
        location.reload();
      }
    },
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.navigation = this.navigationZH;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.navigation = this.navigationEN;
      }
    },
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
  },
  created() {
    this.changUI();
  },
  watch: {
    // 地址栏URL的变化就执行颜色改变函数
    $route(to, from) {
      this.keepColor();
    },
  },
};
</script>
<style lang="scss" scoped>
/* 背景图以及图片还需要更新 */
.header {
  background: url(../../assets/images/background/headBackground.jpg) no-repeat;
  background-size: cover !important;
}
/* PC端 */
@media screen and (min-width: 1000px) {
  .headerContent {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
  }
  .text {
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
    font-weight: bold;
  }
  .chineseName {
    font-size: 3rem;
    font-family: cursive;
  }
  .englishName {
    font-size: 2.5rem;
    font-family: cursive;
  }
  .languageBtn {
    font-size: 2rem;
  }
  .headerLogo {
    width: 18rem;
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
    cursor: pointer;
    width: 15%;
    height: 5rem;
    overflow: hidden;
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
    cursor: pointer;
    width: 15%;
    font-size: 1.8rem;
    font-weight: bold;
    color: #fff;
    background-color: #0055a2;
  }

  .navItem:hover .subNav {
    position: absolute;
    z-index: 9999;
    .subNavItem {
      max-height: 5rem;
      line-height: 5rem;
    }
  }
  .subNavItem {
    text-align: center;
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease-out;
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

  .text {
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
    font-weight: bold;
  }
  .chineseName {
    font-size: 3.2rem;
  }
  .englishName {
    font-size: 2.3rem;
  }
  .languageBtn {
    font-size: 2rem;
  }
  .headerLogo {
    width: 18rem;
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
