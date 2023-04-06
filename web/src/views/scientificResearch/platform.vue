<template>
  <div class="platform">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="platformContent">
      <div class="platformAside">
        <div class="platformAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="platformAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="platformAsideItem"
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
      <div class="platformDetail">
        <div class="platformTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item
                :to="{ path: '/scientificResearch/platform' }"
                >{{ pageItem.platform }}</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="platformItem">
          <div
            class="detailItem"
            v-for="(platformItem, platformItemIndex) in platforms"
            :key="platformItemIndex"
          >
            <div class="detailItemTitle">{{ platformItem.InfoTitle }}</div>
            <div class="detailItemInfo">{{ platformItem.InfoDetail }}</div>
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
        allTitle: "科研概况",
        subTitle: "科研平台",
        home: "首页",
        platform: "科研平台",
      },
      englishItem: {
        allTitle: "Research",
        subTitle: "Platform",
        home: "home",
        platform: "Platform",
      },
      menu: [],
      menuZH: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
      ],
      menuEN: [
        { name: "Direction", path: "/scientificResearch/direction" },
        { name: "Project", path: "/scientificResearch/project" },
        { name: "Platform", path: "/scientificResearch/platform" },
      ],
      platforms: [
        {
          InfoTitle: "超宽带纳米网络技术实验室",
          InfoDetail:
            "与电磁纳米网络和太赫兹通信的倡导者（美国东北大学Dr. Josep Miquel Jornet 教授）进行了长期的交流与合作，并与其研究团队建立了长期的合作关系，并联合上海交通大学密西根学院韩充副教授与申请人所在浙江工业大学计算机科学与技术学院共建“超宽带纳米网络技术实验室”，共享实验室所有的实验条件、科研设备和科研数据。",
        },
        {
          InfoTitle: "跨尺度智能感知”联合重点实验室",
          InfoDetail:
            "与浙江大学医学院附属邵逸夫医院胸外科主任何正富主任医师团队、浙江工业大学化学工程学院朱艺涵教授团队（电镜中心主任）、西安电子科技大学生物材料与信息转化 BIT 吕锐婵教授团队密切合作，共建浙江工业大学前沿交叉科学研究院“跨尺度智能感知”联合重点实验室（共享浙江工业大学电镜中心科研设备 6000 多万元）。",
        },
        {
          InfoTitle: " 浙工大-九阳智慧家电联合重点实验室",
          InfoDetail:
            "同时联合行业龙头企业建立两个首席科学家工作站，多个校企研发中心和人才培养基地，入选教育部“智能感知与系统”工程中心，与九阳股份建立“浙工大-九阳智慧家电联合重点实验室。",
        },
        {
          InfoTitle: " 浙工大-海康智联智能网联重点实验室",
          InfoDetail:
            "与浙江海康智联科技有限公司联合组建“浙工大-海康智联智能网联重点实验室”。",
        },
        {
          InfoTitle:
            " 浙江省人工智能领域 JMRH 协同创新中心和浙江省 JMRH（国防科技）成果转化中心",
          InfoDetail:
            "与浙江省委 JMRH办共建浙江省人工智能领域 JMRH 协同创新中心和浙江省 JMRH（国防科技）成果转化中心。",
        },
      ],
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
  .platform {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .platformContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .platformAside {
    width: 25%;
  }
  .platformAsideTitle {
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
  .platformAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .platformDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .platformTitle {
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .platformItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .detailItemTitle {
    color: #153c87;
    font-weight: bold;
    font-size: 2.5rem;
    padding: 0.5rem 0;
  }
  .detailItemInfo {
    margin-top: 1rem;
    text-indent: 2em;
    line-height: 3.5rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .platform {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .platformContent {
    display: flex;
    flex-direction: column;
  }

  .platformAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .platformAsideTitle {
    display: none;
  }
  .platformAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .platformDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .platformTitle {
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .platformItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 3rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .detailItemTitle {
    color: #153c87;
    font-weight: bold;
    font-size: 2.5rem;
    padding: 0.5rem 0;
  }
  .detailItemInfo {
    margin-top: 1rem;
    text-indent: 2em;
    line-height: 3.5rem;
  }
}
</style>
