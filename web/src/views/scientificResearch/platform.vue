<template>
  <div class="platform">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="platformContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/scientificResearch' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/scientificResearch/platform' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="platformAside">
        <div class="platformAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="platformAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="platformAsideItem"
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
      <div class="platformDetail">
        <div class="platformTitle">
          {{ pageItem.subTitle }}
        </div>
        <div
          class="platformItem"
          v-for="(detailItem, detailItemIndex) in platforms"
          :key="detailItemIndex"
        >
          <div class="platformItemTitle">{{ detailItem.infoTitle }}</div>
          <div class="platformItemDetail">{{ detailItem.infoDetail }}</div>
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
      },
      englishItem: {
        allTitle: "Research",
        subTitle: "Platform",
        home: "home",
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
          infoTitle: "浙江省可视媒体智能处理技术研究重点实验室",
          infoDetail:
            "浙江省可视媒体智能处理技术研究重点实验室是2011年由省科技厅、省财政厅、省发改委联合发文成立，由浙江工业大学和杭州数字娱乐园有限公司共同建设。由国家级教学名师、国务院政府特殊津贴人员王万良教授、博导担任实验室主任，中科院李未院士担任学术委员会主任。实验室坐落在西湖区杭州数字娱乐产业园三号楼五楼，是一个建立在数字媒体产业集聚区的政、产、学、研紧密结合的创新型省级重点实验室。",
        },
        {
          infoTitle: " 浙江省人工智能领域JMRH协同创新中心",
          infoDetail:
            "浙江省人工智能领域JMRH协同创新中心为浙江省委JMRH发展委员会办公室所领导的六大JMRH协同创新中心之一（2020年6月省委JMR H办与浙江工业大学共建），且一直专注于我省人工智能领域JMRH相关工作（政策研究、军地对接、项目申报、技术研发、产业规划、成果转化、人才培养、服务咨询、产业对接等）。",
        },
        {
          infoTitle: "浙江省国防科工成果转化中心",
          infoDetail:
            "浙江省国防科工成果转化中心为浙江省委JMRH（GFKJ）办（省国防科工办）牵头负责建设和运行管理，按照“政府主导、公益服务、数智赋能、精准服务、军地协同、融合发展”的要求，加快军民两用技术实现高效转化，服务强军兴军和经济高质量发展。",
        },
        {
          infoTitle: " 浙工大-九阳智慧家电联合重点实验室",
          infoDetail:
            "同时联合行业龙头企业建立两个首席科学家工作站，多个校企研发中心和人才培养基地，入选教育部“智能感知与系统”工程中心，与九阳股份建立“浙工大-九阳智慧家电联合重点实验室。",
        },
        {
          infoTitle: " 浙工大-海康智联智能网联重点实验室",
          infoDetail:
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
    width: 100%;
  }
  .platformContent {
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

  .platformAside {
    width: 20%;
    padding-right: 30px;
  }

  .platformAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .platformAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .platformAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .platformAsideContent {
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

  .platformAsideItem {
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
  .platformAsideItem:last-child {
    border-bottom: none;
  }
  .platformAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .platformAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .platformDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .platformTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }
  .platformItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }
  .platformItemTitle {
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
  .platformItemDetail {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .platform {
    width: 100%;
  }
  .platformContent {
    display: flex;
    flex-direction: column;
  }

  .platformAside {
    order: 1;
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
  .platformAsideTitle span img {
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
  .platformAsideItem span img {
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
  .platformDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 36rem - 112px);
  }
  .platformTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .platformItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }
  .platformItemTitle {
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
  .platformItemDetail {
    text-align: left;
    margin: 1rem 0;
    text-indent: 2em;
    font-size: 1.8rem;
    line-height: 3.5rem;
  }
}
</style>
