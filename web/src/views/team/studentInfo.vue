<template>
  <div class="studentInfo">
    <!-- default-active表示是当前选中的菜单的index 当menuItem中的index和default-active设置的相同时对应的,menu就会亮-->
    <div class="studentInfoContent">
      <div class="studentInfoAside">
        <div class="studentInfoAsideTitle">学生详情</div>
        <div class="studentInfoAsideContent">
          <el-menu
            :default-active="activeMenu"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="studentInfoAsideItem"
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
      <div class="studentInfoDetail">
        <div class="studentInfoTitle">
          <div class="title">学生详情</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/team/studentInfo' }"
                >学生详情</el-breadcrumb-item
              >
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
                <!-- &nbsp;&nbsp;&nbsp;&nbsp; -->
                <span style="font-weight: bold; padding-right: 1rem"
                  >邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span
                >
                {{ studentInfo.email }}
              </div>
              <div class="studentDirection">
                <span style="font-weight: bold; padding-right: 1rem"
                  >研究方向:</span
                >{{ studentInfo.direction }}
              </div>
            </div>
            <div class="basicRight">
              <img :src="studentInfo.picUrl" @error="setDefaultImage" />
            </div>
          </div>
          <div class="educationBackground">
            <div class="educationBackgroundTitle">教育背景</div>
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
            <div class="paperListTitle">论文列表</div>
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
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      activeMenu: this.$route.path,
      studentInfo: [],
    };
  },
  created() {
    this.getStudentInfo(this.$route.query.id);
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getStudentInfo(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
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
    width: 25%;
  }
  .studentInfoAsideTitle {
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
  .studentInfoAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .studentInfoDetail {
    width: 73%;
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
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }
  .studentInfoItem {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .basicInfo {
    height: 23rem;
    margin-top: 2rem;
    display: flex;
    flex-direction: row;
  }
  .basicLeft {
    height: 100%;
    flex: 1 1 auto;
    padding: 5.5rem 3rem 3rem 5rem;
    background: #dbeeff;
    box-sizing: border-box;
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
    width: 20rem;
    height: 23rem;
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
  .studentInfo {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .studentInfoContent {
    display: flex;
    flex-direction: column;
  }

  .studentInfoAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .studentInfoAsideTitle {
    display: none;
  }
  .studentInfoAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
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
  .studentInfoItem {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .basicInfo {
    height: 23rem;
    margin-top: 2rem;
    width: 100%;
    display: flex;
    flex-direction: row;
  }
  .basicLeft {
    height: 100%;
    flex: 1 1 auto;
    padding: 3rem 0.5rem;
    background: #dbeeff;
    box-sizing: border-box;
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
    width: 20rem;
    height: 23rem;
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
