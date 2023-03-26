<template>
  <div class="profile">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="profileContent">
      <div class="profileAside">
        <div class="profileAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="projectAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="profileAsideItem"
              v-for="(menuItem, menuIndex) in menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span>{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="profileDetail">
        <div class="profileTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/profile' }">{{
                pageItem.profile
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="profiles">
          <div class="detail">
            <div class="profile-title">{{ profile.title }}</div>
            <div class="profile-info">{{ profile.info1 }}</div>
            <div class="profile-info">{{ profile.info2 }}</div>
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
      pageItem: {},
      chineseItem: {
        allTitle: "团队概况",
        subTitle: "团队简介",
        home: "首页",
        profile: "团队简介",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Profile",
        home: "home",
        profile: "Profile",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      menuEN: [
        { name: "Profile", path: "/team/profile" },
        { name: "Teacher", path: "/team/teacher" },
        { name: "Doctor", path: "/team/doctor" },
        { name: "Master", path: "/team/master" },
        { name: "Graduate", path: "/team/graduate" },
      ],
      profile: {
        title: "群智感知与协同”高水平研究团队",
        info1:
          "重视团队建设，以国家重大战略需求为导向，以解决卡脖子问题为主要目标，为推动我国网络强国战略提供技术支撑和保障。团队成员现有全职老师 6人，教授2人，副教授2人，讲师2人，博士研究生和硕士研究生30余人，外聘兼职人员多人。将在现有人员基础上，计划进一步吸纳更多知名院校的青年教师、博士后和研究生，最终打造成一支老中青、校内校外结合的一流协同创新研究团队，取得国际一流的科研成果。通过指导学术参与科研项目、独立承担学术研究课题和开展学术讨论等方式，提高学生的独立研究能力和沟通能力，培养一流青年计算机人才。预计每年都向学术界输送高水平博士，向学术界及业界输送计算机专业硕士及优秀本科生。",
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
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .profileContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .profileAside {
    width: 25%;
  }
  .profileAsideTitle {
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
  .profileAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .profileDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .profileTitle {
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

  .profiles {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detail {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .profile-title {
    color: #153c87;
    font-weight: bold;
    font-size: 2.5rem;
    padding: 0.5rem 0;
  }
  .profile-info {
    margin-top: 1rem;
    text-indent: 2em;
    line-height: 3.5rem;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .profile {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .profileContent {
    display: flex;
    flex-direction: column;
  }

  .profileAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .profileAsideTitle {
    display: none;
  }
  .profileAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .profileDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .profileTitle {
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

  .profiles {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detail {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .profile-title {
    color: #153c87;
    font-weight: bold;
    font-size: 2.5rem;
    padding: 0.5rem 0;
  }
  .profile-info {
    margin-top: 1rem;
    text-indent: 2em;
    line-height: 3.5rem;
  }
}
</style>
