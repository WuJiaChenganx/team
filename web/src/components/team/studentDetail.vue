<template>
  <div class="studentDetail">
    <!-- default-active表示是当前选中的菜单的index 当menuItem中的index和default-active设置的相同时对应的,menu就会亮-->
    <div class="studentDetailContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu
            :default-active="activeMenu"
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
            {{ studentInfo.title }}
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > {{ title }} >{{ studentInfo.title }}
          </div>
        </div>
        <div class="basicInfo">
          <div class="basicLeft">
            <div class="studentName">
              {{ studentInfo.name }}
            </div>
            <div class="studentEmail">
              <!-- &nbsp;&nbsp;&nbsp;&nbsp; -->
              <span style="font-weight: bold; padding-right: 10px"
                >邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span
              >
              {{ studentInfo.email }}
            </div>
            <div class="studentDirection">
              <span style="font-weight: bold; padding-right: 10px"
                >研究方向:</span
              >{{ studentInfo.direction }}
            </div>
          </div>
          <div class="basicRight">
            <img :src="studentInfo.picUrl" alt="" />
          </div>
        </div>
        <div class="educationBackground">
          <div class="educationBackgroundTitle">教育背景</div>
          <div
            class="educationItem"
            v-for="(educationItem, educationIndex) in studentInfo.education"
            :key="educationIndex"
          >
            {{ educationItem.time }} {{ educationItem.experience }}
          </div>
        </div>
        <div class="paperList">
          <div class="paperListTitle">论文列表</div>
          <div
            class="paperItem"
            v-for="(paperItem, paperIndex) in studentInfo.paperList"
            :key="paperIndex"
          >
            {{ paperItem.paper }}
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
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      activeMenu: this.$route.path,
      studentInfo: {},
      // studentInfo: {
      //   id: 1,
      //   name: "张恒聪",
      //   title: "博士研究生",
      //   email: "zhangshaolei20z@ict.ac.cn",
      //   direction: "机器翻译、自然语言处理",
      //   education: [
      //     { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
      //     {
      //       time: "2020-present",
      //       experience: "中科院计算技术研究所,博士在读",
      //     },
      //   ],
      //   paperList: [
      //     {
      //       id: 1,
      //       paper:
      //         "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
      //     },
      //     {
      //       id: 2,
      //       paper:
      //         "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
      //     },
      //   ],
      //   picUrl: require("../../assets/images/activity/00.jpg"),
      // },
    };
  },
  created() {
    this.studentInfo = JSON.parse(decodeURIComponent(this.$route.query.item));
    if (this.studentInfo.title == "博士研究生") {
      this.activeMenu = "/team/doctor";
    } else if (this.studentInfo.title == "硕士研究生") {
      this.activeMenu = "/team/master";
    } else if (this.studentInfo.title == "毕业生") {
      this.activeMenu = "/team/graduate";
    }
    console.log(this.studentInfo);
  },
};
</script>
<style scoped>
.studentDetail {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.studentDetailContent {
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
  padding-bottom: 100px;
}

.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
  margin-bottom: 20px;
}
.basicInfo {
  height: 230px;
  width: 100%;
}
.basicLeft {
  float: left;
  height: 230px;
  width: 75%;
  overflow: hidden;
  color: #666666;
  padding: 55px 30px 30px 50px;
  background: #dbeeff;
  box-sizing: border-box;
  font-size: 18px;
  color: #0055a2;
  line-height: 24px;
  text-align: left;
}

.studentName {
  margin-bottom: 17px;
  font-size: 28px;
  font-weight: bold;
  line-height: 30px;
}

.studentEmail {
  margin-bottom: 10px;
}
.studentDirection {
  margin-bottom: 10px;
}
.basicRight {
  margin-left: 10px;
  float: left;
}
/* 图片尺寸固定 */
.basicRight img {
  width: 200px;
  height: 230px;
}
.educationBackground {
  height: auto;
  width: 100%;
  margin-bottom: 10px;
}
.educationBackgroundTitle {
  text-align: left;
  padding: 30px 0 20px;
  border-bottom: 1px solid #dfdfdf;
  color: #333333;
  font-weight: bold;
  font-size: 18px;
  margin-bottom: 20px;
}
.educationItem {
  text-align: left;
  font-size: 16px;
  line-height: 30px;
}

.paperList {
  height: auto;
  width: 100%;
}
.paperListTitle {
  text-align: left;
  padding: 20px 0;
  border-bottom: 1px solid #dfdfdf;
  color: #333333;
  font-weight: bold;
  font-size: 18px;
  margin-bottom: 20px;
}
.paperItem {
  text-align: left;
  font-size: 16px;
  line-height: 30px;
}
</style>
