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
          v-for="profileItem in profile"
          :key="profileItem.id"
        >
          {{ profileItem.Info }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "团队介绍",
      currentMenu: "团队简介",
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      profile: [
        {
          id: 1,
          Info: "下一代移动计算与数据创新实验室（Lab for Intelligent Networking and Knowledge Engineering, 简称LINKE），由ACM Fellow及杰岀科学家、IEEE Fellow、******李向阳教授和IEEE Fellow、******张燕咏教授引领，团队包括2名******、1名国家基金委杰出青年科学基金获得者、多名国家级四青人才包括基金委优青基金获得者、海外优青基金获得者、中组部青年拔尖人才计划和1名达摩院青橙奖获得者等10多名海内外优秀教师。",
        },
        {
          id: 2,
          Info: "实验室主要面向国际科技前沿、国家重大战略需求、国民经济主战场和人民生命健康进行攻关创新。主要在前沿智能物联网、数据智能、量子计算等领域，从无线通信、移动计算、边缘计算、智能无人系统、数据理解、数据共享、智能学习及隐私保护等方面开展创新性科研和平台建设。实验室当前设有感知智能、 计算智能、数据智能、无人系统和量子计算几个科研小组。",
        },
        {
          id: 3,
          Info: "实验室曾获得中国科技部、工信部、中科院、基金委等多个国家级重大/重点项目支持，包括牵头一项工信部物联网安全重点研发计划、两项科技部人工智能2030重点研发计划、以课题参加的约10项重点研发计划和包括华为、腾讯、阿里、华米、招商银行、蔚来等多个领域知名公司的科研项目支持。实验室一共毕业博士约40多人（博士毕业生中包括7位在美国知名大学、北京大学、浙江大学、北航等担任助理/副/正教授，包括IEEE Fellow、中国基金委杰出青年基金、优秀青年基金、青年长江学者获得者等；其他大部分在世界顶尖公司如谷歌、华为等工作），硕士毕业生大多在行业领军企业工作。团队学生多人到海外高校交流学习，大部分学生在读期间曾经到国内外知名单位企业实习。",
        },
        {
          id: 4,
          Info: "实验室曾获得中国科技部、工信部、中科院、基金委等多个国家级重大/重点项目支持，包括牵头一项工信部物联网安全重点研发计划、两项科技部人工智能2030重点研发计划、以课题参加的约10项重点研发计划和包括华为、腾讯、阿里、华米、招商银行、蔚来等多个领域知名公司的科研项目支持。实验室一共毕业博士约40多人（博士毕业生中包括7位在美国知名大学、北京大学、浙江大学、北航等担任助理/副/正教授，包括IEEE Fellow、中国基金委杰出青年基金、优秀青年基金、青年长江学者获得者等；其他大部分在世界顶尖公司如谷歌、华为等工作），硕士毕业生大多在行业领军企业工作。团队学生多人到海外高校交流学习，大部分学生在读期间曾经到国内外知名单位企业实习。",
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
  padding-bottom: 50px;
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
  text-align: left;
  line-height: 30px;
  font-size: 16px;
  text-indent: 2em;
  padding-bottom: 10px;
}
</style>
