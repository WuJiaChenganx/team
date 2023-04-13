<template>
  <div class="studentInfo">
    <!-- default-active表示是当前选中的菜单的index 当menuItem中的index和default-active设置的相同时对应的,menu就会亮-->
    <div class="studentInfoContent">
      <div class="studentInfoAside">
        <div class="studentInfoAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="studentInfoAsideContent">
          <el-menu :default-active="activeMenu" router text-color="#000">
            <el-menu-item
              class="studentInfoAsideItem"
              v-for="(menuItem, menuIndex) in menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span v-html="menuItem.name"></span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="studentInfoDetail">
        <div class="studentInfoTitle">
          <div class="title">{{ pageItem.title1 }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/studentInfo' }">{{
                pageItem.profile
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="studentInfoItem">
          <div class="basicInfo">
            <div class="basicLeft">
              <div class="studentName">
                {{ studentInfo.name }}
              </div>
              <div class="studentEmail">
                <span
                  style="font-weight: bold; padding-right: 1rem"
                  v-html="pageItem.email"
                ></span>
                {{ studentInfo.email }}
              </div>
              <div class="studentDirection">
                <span
                  style="font-weight: bold; padding-right: 1rem"
                  v-html="pageItem.direction"
                ></span>
                {{ studentInfo.direction }}
              </div>
            </div>
            <div class="basicRight">
              <img :src="studentInfo.picUrl" @error="setDefaultImage" />
            </div>
          </div>
          <div class="educationBackground">
            <div class="educationBackgroundTitle">
              {{ pageItem.background }}
            </div>
            <div
              class="educationItem"
              v-for="(
                educationItem, educationIndex
              ) in studentInfo.educationList"
              :key="educationIndex"
            >
              {{ educationItem.time }} {{ educationItem.experience }}
            </div>
          </div>
          <div class="paperList">
            <div class="paperListTitle">{{ pageItem.paperList }}</div>
            <div
              class="paperItem"
              v-for="(paperItem, paperIndex) in studentInfo.paperList"
              :key="paperIndex"
            >
              {{ paperIndex + 1 }}. {{ paperItem.name }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getMemberDetail } from "@/api/api";
// 设置默认缺失的图片
import defaultImage from "@/assets/images/member/default.png";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "成员详情",
        title1: "成员信息",
        home: "首页",
        profile: "成员详情",
        email: "邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:",
        direction: "研究方向:",
        background: "履历",
        paperList: "论文列表",
      },
      englishItem: {
        allTitle: "Information",
        title1: "Information",
        home: "home",
        profile: "Detail",
        email: "email:",
        direction: "direction:",
        background: "Experiences",
        paperList: "Paper List",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导&nbsp;&nbsp;&nbsp;&nbsp;师", path: "/team/teacher" },
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
      activeMenu: this.$route.path,
      studentInfo: [],
    };
  },
  created() {
    this.getStudentInfo(this.$route.query.id);
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
    // async和await用于同步,就是按顺序执行
    async getStudentInfo(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
        languageType: this.$store.getters.getLanguageType,
      };
      await getMemberDetail(params).then((res) => {
        this.studentInfo = res.data;
        // 处理侧边菜单的选中问题
        if (this.studentInfo.memberType == "doctor") {
          this.activeMenu = "/team/doctor";
        } else if (this.studentInfo.memberType == "master") {
          this.activeMenu = "/team/master";
        } else if (this.studentInfo.memberType == "graduate") {
          this.activeMenu = "/team/graduate";
        }
      });
    },
    // 设置默认缺失的图片
    setDefaultImage(e) {
      e.target.src = defaultImage;
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .studentInfo {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .studentInfoContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .studentInfoAside {
    width: 255px;
    margin-right: 20px;
  }
  .studentInfoAsideTitle {
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
  .studentInfoAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .studentInfoAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .studentInfoDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .studentInfoTitle {
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
  .studentInfoItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .basicInfo {
    margin-top: 2rem;
    display: flex;
    flex-direction: row;
  }
  .basicLeft {
    flex: 1 1 auto;
    padding: 3rem;
    background: #dbeeff;
    font-size: 1.8rem;
    color: #0055a2;
    text-align: left;
  }
  .studentName {
    margin-bottom: 1.7rem;
    font-size: 2.8rem;
    font-weight: bold;
    line-height: 3rem;
  }
  .studentEmail {
    margin-bottom: 1rem;
  }
  .studentDirection {
    margin-bottom: 1rem;
  }
  .basicRight {
    width: 13rem;
    height: 18rem;
    margin-left: 1rem;
  }
  /* 图片尺寸固定 */
  .basicRight img {
    width: 100%;
    height: 100%;
  }
  .educationBackground {
    width: 100%;
    margin-bottom: 1rem;
  }
  .educationBackgroundTitle {
    text-align: left;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
    color: #333333;
    font-weight: bold;
    font-size: 1.8rem;
    margin-bottom: 2rem;
  }
  .educationItem {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
  .paperList {
    width: 100%;
  }
  .paperListTitle {
    text-align: left;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
    color: #333333;
    font-weight: bold;
    font-size: 1.8rem;
    margin-bottom: 2rem;
  }

  .paperItem {
    text-align: left;
    font-size: 1.6rem;
    line-height: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .studentInfoAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .studentInfoAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  } /* 菜单横向排列 */
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

  .studentInfoDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .studentInfoTitle {
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
  .studentInfoItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .basicInfo {
    margin-top: 2rem;
    display: flex;
    flex-direction: row;
  }
  .basicLeft {
    flex: 1 1 auto;
    padding: 3rem 0.5rem;
    background: #dbeeff;
    font-size: 1.8rem;
    color: #0055a2;
    text-align: left;
  }
  .studentName {
    margin-bottom: 1.7rem;
    font-size: 2.8rem;
    font-weight: bold;
    line-height: 3rem;
  }
  .studentEmail {
    margin-bottom: 1rem;
  }
  .studentDirection {
    margin-bottom: 1rem;
  }
  .basicRight {
    width: 13rem;
    height: 18rem;
    margin-left: 1rem;
  }
  /* 图片尺寸固定 */
  .basicRight img {
    width: 100%;
    height: 100%;
  }

  .educationBackgroundTitle {
    text-align: left;
    padding: 1rem 0;
    border-bottom: 1px solid #dfdfdf;
    color: #333333;
    font-weight: bold;
    font-size: 2rem;
    margin-bottom: 1rem;
  }
  .educationItem {
    text-align: left;
    font-size: 1.8rem;
    line-height: 3rem;
  }

  .paperListTitle {
    text-align: left;
    padding: 1rem 0;
    border-bottom: 1px solid #dfdfdf;
    color: #333333;
    font-weight: bold;
    font-size: 2rem;
    margin-bottom: 1rem;
  }

  .paperItem {
    text-align: left;
    font-size: 1.8rem;
    line-height: 3rem;
  }
}
</style>
