<template>
  <div class="platform">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="platformContent">
      <div class="platformAside">
        <div class="platformAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="platformAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
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
        { name: "横向项目", path: "/scientificResearch/lateralProject" },
        { name: "纵向项目", path: "/scientificResearch/verticalProject" },
        { name: "科研平台", path: "/scientificResearch/platform" },
      ],
      menuEN: [
        { name: "Direction", path: "/scientificResearch/direction" },
        {
          name: "lateral-project",
          path: "/scientificResearch/lateralProject",
        },
        {
          name: "vertical-project",
          path: "/scientificResearch/verticalProject",
        },
        { name: "Platform", path: "/scientificResearch/platform" },
      ],
      platforms: [
        {
          InfoTitle: "浙江省可视媒体智能处理技术研究重点实验室",
          InfoDetail:
            "浙江省可视媒体智能处理技术研究重点实验室是2011年由省科技厅、省财政厅、省发改委联合发文成立，由浙江工业大学和杭州数字娱乐园有限公司共同建设。由国家级教学名师、国务院政府特殊津贴人员王万良教授、博导担任实验室主任，中科院李未院士担任学术委员会主任。实验室坐落在西湖区杭州数字娱乐产业园三号楼五楼，是一个建立在数字媒体产业集聚区的政、产、学、研紧密结合的创新型省级重点实验室。",
        },
        {
          InfoTitle: " 浙江省人工智能领域JMRH协同创新中心",
          InfoDetail:
            "浙江省人工智能领域JMRH协同创新中心为浙江省委JMRH发展委员会办公室所领导的六大JMRH协同创新中心之一（2020年6月省委JMR H办与浙江工业大学共建），且一直专注于我省人工智能领域JMRH相关工作（政策研究、军地对接、项目申报、技术研发、产业规划、成果转化、人才培养、服务咨询、产业对接等）。",
        },
        {
          InfoTitle: "浙江省国防科工成果转化中心",
          InfoDetail:
            "浙江省国防科工成果转化中心为浙江省委JMRH（GFKJ）办（省国防科工办）牵头负责建设和运行管理，按照“政府主导、公益服务、数智赋能、精准服务、军地协同、融合发展”的要求，加快军民两用技术实现高效转化，服务强军兴军和经济高质量发展。",
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
    width: 255px;
    margin-right: 20px;
  }
  .platformAsideTitle {
    width: 255px;
    height: 78px;
    line-height: 78px;
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 24px;
  }
  .platformAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .platformAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .platformDetail {
    flex: 1 1 auto;
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
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    font-weight: bold;
    background-color: #fff;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    font-weight: bold;
    color: #034ea1;
    background: #eee;
  }

  .platformItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    margin-top: 1rem;
    text-align: left;
    line-height: 3rem;
    font-size: 2rem;
  }
  .detailItemTitle {
    color: #153c87;
    font-weight: bold;
    font-size: 2.2rem;
    padding: 0.5rem 0;
  }
  .detailItemInfo {
    margin-top: 1rem;
    text-indent: 2em;
    font-size: 2rem;
    line-height: 3.5rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .platformAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .platformAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
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

  .el-icon-sunny {
    display: none;
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
    padding: 10px 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 20px;
    line-height: 30px;
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
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
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
