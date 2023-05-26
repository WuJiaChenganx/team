<template>
  <div class="profile">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="profileContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/team' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/team/profile' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="profileAside">
        <div class="profileAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="profileAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="profileAsideItem"
              v-for="(menuItem, menuIndex) in menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <span>
                <img
                  src="../../assets/images/background/asideSubtitle.png"
                  alt=""
                />
                {{ menuItem.name }}
              </span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="profileDetail">
        <div class="profileTitle">
          {{ pageItem.subTitle }}
        </div>

        <div class="teamProfileTitle">{{ profile.title }}</div>
        <div class="teamProfile">
          {{ profile.info1 }}
        </div>
        <div class="teamProfile">
          {{ profile.info2 }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "团队概况",
        subTitle: "团队简介",
        home: "首页",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Profile",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "顾问", path: "/team/consultor" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      menuEN: [
        { name: "Profile", path: "/team/profile" },
        { name: "Consultor", path: "/team/consultor" },
        { name: "Teacher", path: "/team/teacher" },
        { name: "Doctor", path: "/team/doctor" },
        { name: "Master", path: "/team/master" },
        { name: "Graduate", path: "/team/graduate" },
      ],
      profile: {
        title: '"群智感知与协同"高水平研究团队',
        info1:
          '重视团队建设，以国家重大战略需求为导向，以解决"卡脖子"问题为主要目标，为推动我国网络强国战略提供技术支撑和保障。团队成员现有全职老师6人，教授2人，副教授2人，讲师2人，博士研究生和硕士研究生30余人，外聘兼职人员多人。将在现有人员基础上，计划进一步吸纳更多知名院校的青年教师、博士后和研究生，最终打造成一支老中青、校内校外结合的一流协同创新研究团队，取得国际一流的科研成果。通过指导学术参与科研项目、独立承担学术研究课题和开展学术讨论等方式，提高学生的独立研究能力和沟通能力，培养一流青年计算机人才。预计每年都向学术界输送高水平博士，向学术界及业界输送计算机专业硕士及优秀本科生。',
        info2:
          "鼓励团队学生进行学术交流，支持学生前往国内外顶级学府继续深造，提升学生自身能力的同时传播团队的学术思想和理念，进一步提高团队在人工智能领域的影响力。团队建设与人才培养相辅相成，预计构建一支兼具高水平人才、高影响力的学术团队。通过对重大科研学术成果进行必要的物质和精神奖励。设立专门学术专区和场地，以物联网、人工智能等为基础，多学科交叉，深入浅出进行研究，实现多学科融合创新发展。营造科学民主、开放创新的学术环境，以及和谐团结、友爱互助、奋进拼搏的文化氛围，提升团队的凝聚力、执行力和创新能力，提倡“共商、共建、共享”的团队氛围，积极主动融入到服务国家战略和区域经济社会发展，培养“顶天立地”的高质量人才。",
      },
    };
  },

  created() {
    this.changUI();
  },
  methods: {
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.menu = this.menuZH;
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.menu = this.menuEN;
        this.pageItem = this.englishItem;
      }
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .profile {
    width: 100%;
  }
  .profileContent {
    width: 85%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 15px;
  }
  .breadCrumb {
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
    margin-bottom: 15px;
  }
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }

  .profileAside {
    width: 20%;
    padding-right: 30px;
  }

  .profileAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .profileAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .profileAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .profileAsideContent {
    width: 100%;
  }
  /* 去除侧边栏自带的边框 */
  .el-menu {
    border: none !important;
  }
  /* 去除侧边导航自带的边距 */
  .el-menu-item {
    padding: 0 !important;
  }
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    color: #fff !important;
    font-weight: bold;
    background-color: #4b74bb;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    color: #fff;
    font-weight: bold;
    background-color: #4b74bb;
  }

  .profileAsideItem {
    position: relative;
    width: 100%;
    height: 46px;
    line-height: 46px;
    font-size: 18px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }
  /* 最后一个侧边栏没有下划线 */
  .profileAsideItem:last-child {
    border-bottom: none;
  }
  .profileAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .profileAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .profileDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .profileTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }
  .teamProfileTitle {
    height: 4.5rem;
    width: 100%;
    margin: 1rem 0;
    background-size: cover !important;
    background: url(../../assets/images/background/title-bg.png) no-repeat;
    font-weight: bold;
    line-height: 4.5rem;
    padding-left: 2.5rem;
    font-size: 2rem;
    text-align: left;
    color: #404040;
  }
  .teamProfile {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .profile {
    width: 100%;
  }
  .profileContent {
    display: flex;
    flex-direction: column;
  }

  .profileAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .profileAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .profileAsideTitle span img {
    display: none;
  }
  /* 菜单横向排列 */
  .el-menu {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    width: 100%;
    background-color: rgba(0, 0, 0, 0) !important;
  }

  .el-menu-item {
    padding: 0 !important;
    border: 1px solid #ccc;
    width: 30%;
    line-height: 36px;
    height: 40px;
    margin: 0 1.6% 15px;
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
    background-color: #fff;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
  }
  .profileAsideItem span img {
    display: none;
  }
  .breadCrumb {
    order: 2;
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
  }
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  .profileDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 29rem - 139px);
  }
  .profileTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .teamProfileTitle {
    height: 4.5rem;
    width: 100%;
    margin: 1rem 0;
    background-size: cover !important;
    background: url(../../assets/images/background/title-bg.png) no-repeat;
    font-weight: bold;
    line-height: 4.5rem;
    padding-left: 1.5rem;
    font-size: 2rem;
    text-align: left;
    color: #404040;
  }
  .teamProfile {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
}
</style>
