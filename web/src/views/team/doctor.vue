<template>
  <div class="doctor">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="doctorContent">
      <div class="doctorAside">
        <div class="doctorAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="doctorAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="doctorAsideItem"
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
      <div class="doctorDetail">
        <div class="doctorTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/doctor' }">{{
                pageItem.doctor
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div v-for="(item, index) in studentCover" :key="index">
          <div class="subTitle">{{ item.title }}级博士生</div>
          <div class="doctorItem">
            <div
              class="detailItem"
              v-for="(memberItem, index) in item.memberInfo"
              :key="index"
              @click="gotoDetail(memberItem.id)"
            >
              <div class="detailItemImg">
                <img :src="memberItem.picUrl" @error="setDefaultImage" />
              </div>
              <div class="detailItemInfo">
                {{ memberItem.comeInDate }}级 {{ memberItem.name }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getStudentCover } from "@/api/api";
// 设置默认缺失的图片
import defaultImage from "@/assets/images/member/default.png";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "团队概况",
        subTitle: "博士生",
        home: "首页",
        doctor: "博士生",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Doctor",
        home: "home",
        doctor: "Doctor",
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
      studentCover: [],
    };
  },
  created() {
    this.getStudentList();
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
    async getStudentList() {
      let params = {
        start: 0,
        end: 100,
        memberType: "doctor",
        languageType: this.$store.getters.getLanguageType,
      };
      await getStudentCover(params).then((res) => {
        this.studentCover = res.data;
      });
    },
    // 设置默认缺失的图片
    setDefaultImage(e) {
      e.target.src = defaultImage;
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/team/memberInfo",
        name: "成员详情",
        query: {
          id: id,
        },
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .doctor {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 35.762rem);
  }

  .doctorContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .doctorAside {
    width: 25%;
  }
  .doctorAsideTitle {
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
  .doctorAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .doctorDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    min-height: calc(100vh - 35.762rem - 6rem);
  }

  .doctorTitle {
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

  .doctorItem {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    padding: 3rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
    flex: 0 0 calc(20% - 10px); /* 每个元素占据20%的宽度，同时减去10px的margin-right */
    margin-right: 10px; /* 设置右外边距 */
    box-sizing: border-box;
  }
  /* 取消最后一个元素的右外边距 */
  .detailItem:last-child {
    margin-right: 0;
  }

  .detailItemImg {
    width: 100%;
  }
  .detailItem img {
    width: 70%;
  }

  .detailItem .detailItemInfo {
    padding: 1rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .doctor {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .doctorContent {
    display: flex;
    flex-direction: column;
  }

  .doctorAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .doctorAsideTitle {
    display: none;
  }
  .doctorAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .doctorDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .doctorTitle {
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

  .doctorItem {
    display: flex;
    flex-direction: column;
    padding: 2rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
    margin-bottom: 2rem;
  }

  .detailItem img {
    width: 20rem;
    height: 23rem;
  }

  .detailItem .detailItemInfo {
    padding: 1rem 0;
  }
}
</style>
