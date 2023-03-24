<template>
  <div class="direction">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="directionContent">
      <div class="directionAside">
        <div class="directionAsideTitle">{{ pageItem.allTitle }}</div>
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
      <div class="directionDetail">
        <div class="directionTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item
                :to="{ path: '/scientificResearch/direction' }"
                >{{ pageItem.direction }}</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="directionItem">
          <div
            class="detailItem"
            v-for="(directionItem, directionItemIndex) in directions"
            :key="directionItemIndex"
          >
            <div class="detailItemTitle">
              ({{ directionItemIndex + 1 }}) {{ directionItem.title }}
            </div>
            <div class="detailItemInfo">{{ directionItem.info }}</div>
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
        subTitle: "科研方向",
        home: "首页",
        direction: "科研方向",
      },
      englishItem: {
        allTitle: "Research",
        subTitle: "Direction",
        home: "home",
        direction: "Direction",
      },
      menu: [],
      menuZH: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      menuEN: [
        { name: "Direction", path: "/scientificResearch/direction" },
        { name: "Project", path: "/scientificResearch/project" },
        { name: "Platform", path: "/scientificResearch/platform" },
        { name: "Curriculum", path: "/scientificResearch/curriculum" },
      ],
      directions: [
        {
          title: "微观尺度——纳米物联网",
          info: " 随着纳米技术和微电子技术的不断发展，微观世界领域的物联网智能感知与通信技术及其前所未有的应用场景具有极其重大的价值与战略意义。虽然纳米机器人的潜在用途非常广泛，并具有巨大的战略意义，然而受纳米器件的体积大小、感知能力、计算能力、存储能力、能量供应等物理因素制约，单个纳米器件（机器人）只能执行一些十分简单的任务（如计算、感知、数据存贮和驱动等）。因此，在人体健康应用场景下，如何释放单个纳米机器人的应用潜能，允许纳米机器人之间相互协作，共享和融合信息，扩展单个纳米机器人在复杂性和操作性等方面的能力，即构建高可靠性的人体移动电磁纳米机器人网络。该特殊的人体移动电磁纳米机器人网络（统称：纳米物联网或纳米网络）的基础网络理论和关键通信技术就是本方向的重点研究内容，具体包括基于太赫兹频段的人体纳米网络同信道干扰模型和调制解调机制，人体移动纳米网络的动态拓扑结构及能量模型，能量受限环境下的纳米网络MAC协议，以及能耗均衡的中继协议。本方向的研究对于微观动态环境下的人体纳米机器人网络具有重要的理论研究价值，对未来人体医学健康诊疗等场景具有重要的实际应用价值。",
        },
        {
          title: "宏观尺度——智能感知与计算",
          info: "实为提升多模态智能物联融合感知与计算能力，推动物联网感知相关技术的进一步发展与应用，1）拟研究基于多模数据语义框架的语义理解与智能抽取方法，针对多模数据的共性特征，设计针对结构化或非结构化多源原始数据的语义框架自适应定义方法与自动拓展机制，将语义框架定义抽象为马尔可夫决策过程，设计基于逆强化学习的语义框架构建模型，将领域先验知识结合到奖励函数学习过程中。在框架构建的基础上，设计针对多模数据的特征抽取与表达方法，实现数据的统一描述与表示。2）在多模数据语义定义与特征发现的基础上，拟利用多模态数据本身的特征及对应的应用，挖掘不同模态数据的重要程度，进而提升多模态数据的融合表达与共同学习能力。设计一种具有一定通用性和可解释性的多模态融合框架。3）拟针对多模态数据的分析任务，研究相关大规模知识库的构建，包括知识表示、实体对齐、数据异常修复等。进而通过将知识库整合进统一语义表述框架，实现多模数据与外部知识的无缝融合，从而获得更为精确的结果。",
        },
        {
          title: "宏观尺度——交通运输碳排放智能感知与协同控制",
          info: "研发交通运行碳排放智能监测系统，重点突破出行方式与运输结构的优化、多模式交通网络实时在线碳排放监测与低碳导向的智能管控等关键技术，实现成果在城市交通、公路货运等行业的示范应用。1）拟提出构建“云-边-端”结构化分布式的路侧多形态智能感知架构，利用部署在路侧及路面的摄像机和雷达以及高精度称重装置对交通运行车辆的车牌、类型、重量、位置、速度及流量等信息进行实时、动态、精准、全息感知，进而研发交通运行碳排放智能监测系统；2）基于“云-边-端”架构的智能监测系统采集的多模态交通运输车辆数据，研究基于深度学习方法构建“单车级-路径级-区域级”的多尺度碳排放计算模型，即基于车辆个性化数据的单个车辆碳排放的计算模型、基于车辆运行路径的碳排放计算模型和基于路段的区域碳排放计算模型。结合车辆实时行驶特征属性和碳排放监测数据构建训练数据，对单个车辆碳排放进行测算；基于单车碳排放量计算模型，结合机动车在不同等级道路上的，分析交通流量状况对机动车碳排放的影响，对车辆运行路径的碳排放进行测算；进一步基于路段的检测数据构建区域短时碳排放计算模型。3）结合交通运输碳排放深度学习模型，构建涵盖微观-中观-宏观多尺度碳排放计算评估体系和计算方法，打造面向超大规模交通网络的实时在线碳排放计算平台，实现实时、精准、高效的碳排放计算和管理，同时突破出行方式与运输结构优化并实现低碳导向的智能管控。",
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
    margin-top: 2rem;
  }
  .detailItemTitle {
    color: #0055a2;
    font-weight: bold;
    font-size: 2rem;
    text-align: left;
    margin-bottom: 1rem;
  }
  /* 文字和图片的距离 */
  .detailItemInfo {
    line-height: 3rem;
    font-size: 1.8rem;
    text-align: left;
    text-indent: 2em;
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
    margin-top: 0.5rem;
  }
  .detailItemTitle {
    color: #0055a2;
    font-weight: bold;
    font-size: 2rem;
    text-align: left;
    margin-bottom: 1rem;
  }
  /* 文字和图片的距离 */
  .detailItemInfo {
    line-height: 3rem;
    font-size: 1.8rem;
    text-align: left;
    text-indent: 2em;
  }
}
</style>
