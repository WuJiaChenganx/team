<template>
  <div>
    <div class="header">
      <div class="headerContent">
        <div class="leftBox">
          <div class="headerLogo">
            <logo></logo>
          </div>
          <div class="text">
            <div class="chineseName">群智感知与协同研究组</div>
            <div class="englishName">Crowdsensing and Coordination</div>
          </div>
        </div>
        <div class="rightBox">
          <div class="languageBtn">
            <span>
              <a
                href="http://www.cs.zjut.edu.cn/html/index.html"
                target="_blank"
                style="text-decoration: none"
                >学院主页
              </a>
            </span>
            |
            <span @click="changeLanguage('Chinese')">中文</span> |
            <span @click="changeLanguage('English')">English</span>
          </div>
          <div class="pageView">浏览量: {{ pageView }}</div>
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
import { getHomePageViewURL } from "@/api/api";
export default {
  data() {
    return {
      pageView: "",
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
            // 路由还需要改过(英文版内容还没有添加)
            {
              title: "横向项目",
              path: "/scientificResearch/lateralProject",
            },
            // 路由还需要改过(英文版内容还没有添加)
            { title: "纵向项目", path: "/scientificResearch/verticalProject" },
            { title: "科研平台", path: "/scientificResearch/platform" },
          ],
        },
        {
          title: "成果荣誉",
          path: "/prize",
          subMenu: [
            { title: "科技成果", path: "/prize/prize" },
            { title: "团队荣誉", path: "/prize/honour" },
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
          title: "教育教学",
          path: "/education",
          subMenu: [
            { title: "本科生教育", path: "/education/undergraduate" },
            { title: "研究生教育", path: "/education/master" },
            { title: "教学成果", path: "/education/achievements" },
          ],
        },
        {
          title: "团队成员",
          path: "/team",
          subMenu: [
            { title: "团队简介", path: "/team/profile" },
            { title: "顾&nbsp;&nbsp;&nbsp;&nbsp;问", path: "/team/consultor" },
            { title: "导&nbsp;&nbsp;&nbsp;&nbsp;师", path: "/team/teacher" },
            { title: "博士生", path: "/team/doctor" },
            { title: "研究生", path: "/team/master" },
            { title: "毕业生", path: "/team/graduate" },
          ],
        },
        {
          title: "交流合作",
          path: "/cooperation",
          subMenu: [
            { title: "国内交流", path: "/cooperation/domestic" },
            { title: "国际交流", path: "/cooperation/international" },
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
            {
              title: "lateral-project",
              path: "/scientificResearch/lateralProject",
            },
            {
              title: "vertical-project",
              path: "/scientificResearch/verticalProject",
            },
            { title: "Platform", path: "/scientificResearch/platform" },
          ],
        },
        {
          title: "Prize",
          path: "/prize",
          subMenu: [
            { title: "prize", path: "/prize/prize" },
            {
              title: "honour",
              path: "/prize/honour",
            },
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
          title: "Education",
          path: "/education",
          subMenu: [
            { title: "Undergraduate", path: "/education/undergraduate" },
            { title: "Graduate", path: "/education/graduate" },
            { title: "Achievements", path: "/education/achievements" },
          ],
        },
        {
          title: "Snapshot",
          path: "/team",
          subMenu: [
            { title: "Profile", path: "/team/profile" },
            { title: "Consultor", path: "/team/consultor" },
            { title: "Teacher", path: "/team/teacher" },
            { title: "Doctor", path: "/team/doctor" },
            { title: "Master", path: "/team/master" },
            { title: "Graduate", path: "/team/graduate" },
          ],
        },
        {
          title: "Cooperation",
          path: "/cooperation",
          subMenu: [
            { title: "Domestic", path: "/cooperation/domestic" },
            // 路由还需要改过(英文版内容还没有添加)
            { title: "International", path: "/cooperation/international" },
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
    // async和await用于同步,就是按顺序执行
    async getPageView() {
      await getHomePageViewURL().then((res) => {
        this.pageView = res.data;
      });
    },
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
    this.getPageView();
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
  height: 10rem;
  display: flex;
  // 子元素垂直居中
  align-items: center;
  background-size: cover !important;
  background: url(../../assets/images/background/headBg.jpg) no-repeat top
    center;
  // background: #0a3f8d;
}
/* PC端 */
@media screen and (min-width: 1000px) {
  .headerContent {
    width: 65%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .leftBox {
    display: flex;
    flex-direction: row;
    text-align: center;
  }
  .headerLogo {
    width: 9rem;
  }
  .text {
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
  }
  .chineseName {
    font-size: 2.4rem;
    font-family: cursive;
  }
  .englishName {
    font-size: 1.6rem;
    font-family: cursive;
  }
  .rightBox {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .languageBtn {
    width: 100%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 2.5rem;
    color: #fff;
  }
  .pageView {
    width: 100%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 2.5rem;
    color: #fff;
  }

  /* 导航栏 */
  .navBackground {
    height: 4rem;
    background-color: #0055a2;
  }

  .nav {
    margin: 0 auto;
    width: 100%;
    height: 4rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .navItem {
    cursor: pointer;
    width: 12.5%;
    height: 4rem;
    overflow: hidden;
  }

  .navTitle {
    /* 水平对齐 */
    text-align: center;
    /* 垂直对齐 */
    line-height: 4rem;
    font-size: 1.8rem;
    font-weight: bold;
    color: #fff;
  }

  .navItem:hover {
    width: 12.5%;
    background-color: #008cd6;
  }

  .subNav {
    /* 隐藏元素 */
    cursor: pointer;
    width: 12.5%;
    font-size: 1.8rem;
    font-weight: bold;
    color: #fff;
    background-color: #0055a2;
  }

  .navItem:hover .subNav {
    position: absolute;
    z-index: 9999;
    .subNavItem {
      max-height: 4rem;
      line-height: 4rem;
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
    justify-content: space-around;
  }
  .leftBox {
    display: flex;
    flex-direction: row;
    text-align: center;
    margin-right: 5px;
  }
  .headerLogo {
    width: 8rem;
  }
  .text {
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
  }
  .chineseName {
    font-size: 2.4rem;
    font-family: cursive;
  }
  .englishName {
    font-size: 1.6rem;
    font-family: cursive;
  }
  .rightBox {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .languageBtn {
    width: 100%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 2.5rem;
    color: #fff;
  }
  .pageView {
    width: 100%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 2.5rem;
    color: #fff;
  }
  /* 导航栏 */
  .navBackground {
    height: 4rem;
    background-color: #0055a2;
  }

  .nav {
    margin: 0 auto;
    width: 100%;
    height: 4rem;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }

  .navItem {
    flex: 1 1 auto;
  }

  .navTitle {
    /* 水平对齐 */
    text-align: center;
    /* 垂直对齐 */
    line-height: 4rem;
    font-size: 1rem;
    font-weight: bold;
    color: #fff;
  }

  /* 隐藏子菜单元素 */
  .subNav {
    display: none;
  }
}
</style>
