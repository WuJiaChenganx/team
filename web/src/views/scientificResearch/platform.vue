<template>
  <div class="resourceSharing">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="resourceContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="contentItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span slot="title">{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="details">
        <div class="detailTitle">
          <div class="currentTitle">
            {{ currentMenu }}
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > {{ title }} >{{ currentMenu }}
          </div>
        </div>
        <div
          class="detailItem"
          v-for="platformItem in platforms"
          :key="platformItem.id"
        >
          <div class="platformTitle">{{ platformItem.InfoTitle }}</div>
          <div class="platformDetail">{{ platformItem.InfoDetail }}</div>
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
      currentMenu: "科研平台",
      Menu: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      platforms: [
        {
          id: 1,
          InfoTitle: " 全国重点实验室：处理器芯片全国重点实验室",
          InfoDetail:
            "处理器芯片全国重点实验室为中国科学院计算技术研究所按照科技部要求，在原计算机体系结构国家重点实验室基础上，以计算所为依托单位重组建设的国家重点实验室。中国科大作为国重实验室的科教融合共建单位，在中国科大校本部设立“处理器芯片全国重点实验室（中国科大）”，与计算所共同培养处理器芯片人才，深化所校合作，利用双方优势资源，开展深度科教融合，支撑相关学科建设。",
        },
        {
          id: 2,
          InfoTitle: " 全国重点实验室：科学数据技术与系统全国重点实验室(筹建)",
          InfoDetail:
            "随着科学研究的深入与数据的爆炸性增长，新生产环境、新生产资料、新生产工具这三大核心要素的基础理论与技术体系面临巨大挑战，迫切需要开展系统级创新，构建面向新科研范式的数字底座，在此背景下，以中国科学技术大学和中国科学院计算机网络信息中心为依托单位、中国科学院计算技术研究所共同筹建科学数据技术与系统全国重点实验室，汇聚中国科大的算法基础理论优势，网络中心的系统平台与应用优势以及计算所的计算芯片与设备优势，依托重大科技基础设施，推进科学数据技术与系统创新，打造创新科研范式，提升产业竞争力并最终为国家战略服务。",
        },
        {
          id: 3,
          InfoTitle: "省部级实验室：中科院无线光电通信重点实验室",
          InfoDetail:
            "中国科学院无线光电通信重点实验室成立于2014年，是中国科学院正式批准成立的省部级重点实验室。实验室挖掘从电磁波到光波波段多波段频谱资源，进行多种载波的无线光电通信器件、智能协同多模态光电传输技术、网络体系架构与新型业务应用研究。实验室目前拥有大量的无线通信测试仪、分析仪器、频谱仪、高速示波器等，经过多年在无线通信、智能物联网、数据理解和共享领域的前沿理论和实验研究，已积累了丰厚的理论与技术基础，并取得众多高水平科研成果，包括无线光通信、宽带移动通信、定位导航、软件定义智能物联网、数据共享与交易系统等。",
        },
        {
          id: 4,
          InfoTitle: "省部级实验室：计算与通讯软件安徽省重点实验室",
          InfoDetail:
            " 计算与通讯软件安徽省重点实验室是安徽省信息科技领域第一个由高校和企业合作共建的省级重点实验室，2005年批准筹建，依托单位为中国科学技术大学，共建单位为科大讯飞股份有限公司和科大国创软件股份有限公司。实验室围绕国家和安徽省IT领域的中长期战略规划和实际应用需求开展工作，主要研究方向包括软件共性技术、智能物联网、网络与信息安全、科学与工程计算、语音处理和通讯软件等，旨在建成面向计算与通讯领域的核心技术源头、开放共享平台和产学研示范基地。",
        },
      ],
    };
  },
  created() {},
  methods: {},
};
</script>
<style scoped>
.resourceSharing {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.resourceContent {
  padding-top: 20px;
  width: 75%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.aside {
  width: 25%;
  height: auto;
  padding: 0 15px;
  float: left;
}

.asideTitle {
  background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat
    center;
  border-radius: 6px;
  background-size: cover !important;
  font-weight: bold;
  color: #fff;
  font-size: 22px;
  line-height: 30px;
  height: 30px;
  padding: 20px 30px;
  margin-bottom: 10px;
}

.asideContent {
  height: auto;
  border: 1px solid #eee;
}

.currentTitle {
  float: left;
  color: #333333;
  font-weight: bold;
  font-size: 25px;
}

.contentItem {
  font-weight: bold;
  font-size: 20px;
  text-align: left;
  cursor: pointer;
  padding: 0 20px;
  border-bottom: 1px solid #eee;
}

.el-menu-item.is-active {
  background: #008cd6 !important;
}

.details {
  float: left;
  position: relative;
  padding: 0 15px;
  width: 75%;
  height: auto;
  background-color: #fff;
  border: 1px solid #dfdfdf;
  padding-bottom: 150px;
}

.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
}

.detailItem {
  word-wrap: break-word;
  word-break: break-all;
  width: 100%;
  height: auto;
  margin-top: 30px;
  text-align: left;
}
.platformTitle {
  color: #153c87;
  font-weight: bold;
  font-size: 16px;
  font-family: 宋体, simsun;
  margin-bottom: 20px;
}
.platformDetail {
  text-indent: 2em;
}
</style>
