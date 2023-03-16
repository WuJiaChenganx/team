<template>
  <div class="profile">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="profileContent">
      <div class="profileAside">
        <div class="profileAsideTitle">团队概况</div>
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
              v-for="(menuItem, menuIndex) in Menu"
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
          <div class="title">团队简介</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/team/profile' }"
                >团队简介</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="profileItem">
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "团队概况",
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

  .profileItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    line-height: 3rem;
    font-size: 1.6rem;
    margin-top: 1.5rem;
    text-align: left;
    text-indent: 2em;
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

  .profileItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }

  .detailItem {
    word-wrap: break-word;
    word-break: break-all;
    line-height: 3rem;
    margin-top: 1.5rem;
    font-size: 1.6rem;
    text-align: left;
    text-indent: 2em;
  }
}
</style>
