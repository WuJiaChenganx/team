<template>
  <div class="consultor">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="consultorContent">
      <div class="consultorAside">
        <div class="consultorAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="consultorAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#000">
            <el-menu-item
              class="consultorAsideItem"
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
      <div class="consultorDetail">
        <div class="consultorTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/consultor' }">{{
                pageItem.consultor
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="subTitle">顾问:</div>
        <div class="consultors">
          <div
            class="consultorItem"
            v-for="(consultorItem, consultorIndex) in consultorCover"
            :key="consultorIndex"
            @click="gotoDetail(consultorItem)"
          >
            <div class="consultorImg">
              <img :src="consultorItem.picUrl" @error="setDefaultImage" />
            </div>
            <div class="consultorInfo">
              <div class="consultorName">{{ consultorItem.name }}</div>
              <div
                class="consultorInfoItem"
                v-for="(
                  consultorInfoItem, consultorInfoIndex
                ) in consultorItem.info"
                :key="consultorInfoIndex"
              >
                <span class="dot"></span>
                {{ consultorInfoItem }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getMemberCover } from "@/api/api";
// 设置默认缺失的图片
import defaultImage from "@/assets/images/member/default.png";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "团队概况",
        subTitle: "顾问",
        home: "首页",
        consultor: "顾问",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "consultor",
        home: "home",
        consultor: "consultor",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "顾&nbsp;&nbsp;&nbsp;&nbsp;问", path: "/team/consultor" },
        { name: "导&nbsp;&nbsp;&nbsp;&nbsp;师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      menuEN: [
        { name: "Profile", path: "/team/profile" },
        { name: "Consultor", path: "/team/consultor" },
        { name: "Teacher", path: "/team/teacher" },
        { name: "Doctor", path: "/team/doctor" },
        { name: "Master", path: "/team/master" },
        { name: "Graduate", path: "/team/graduate" },
      ],
      consultorCover: [],
    };
  },

  created() {
    this.getconsultorCoverList();
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
    async getconsultorCoverList() {
      let params = {
        start: 0,
        end: 100,
        memberType: "consultor",
        languageType: this.$store.getters.getLanguageType,
        memberType: "counselor",
      };
      await getMemberCover(params).then((res) => {
        this.consultorCover = res.data;
      });
    },

    // 设置默认缺失的图片
    setDefaultImage(e) {
      e.target.src = defaultImage;
    },
    gotoDetail(memberItem) {
      window.open(memberItem.pageUrl, "_blank");
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .consultor {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 35.762rem);
  }

  .consultorContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .consultorAside {
    width: 255px;
    margin-right: 20px;
  }
  .consultorAsideTitle {
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
  .consultorAsideContent {
    width: 255px;
    background-color: #f9fbfd;
  }
  .consultorAsideItem {
    height: 52px;
    line-height: 52px;
    font-size: 16px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }

  .consultorDetail {
    flex: 1 1 auto;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    min-height: calc(100vh - 35.762rem - 6rem);
  }

  .consultorTitle {
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
  .subTitle {
    font-size: 20px;
    font-weight: bold;
    color: #444444;
    text-align: left;
    margin: 10px 0;
  }

  .dot {
    position: relative;
    padding-left: 20px;
  }
  .dot::before {
    content: "";
    position: absolute;
    top: 6px;
    left: 0;
    width: 6px;
    height: 6px;
    background-color: #000;
    border-radius: 50%;
  }

  .consultors {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
    margin-bottom: 30px;
  }
  .consultorItem {
    display: flex;
    flex-direction: row;
    width: 100%;
    margin: 5px 0;
    cursor: pointer;
  }
  /* 顾问图片 */
  .consultorImg {
    height: 190px;
    border: 1px solid #ccc;
    margin-right: 10px;
  }
  .consultorImg img {
    width: 100%;
    height: 100%;
  }
  /* 顾问信息 */
  .consultorInfo {
    background: #dbeeff;
    flex: 1 1 auto;
    padding: 0 10px;
    border: 1px solid #ccc;
  }
  .consultorName {
    font-size: 20px;
    text-align: left;
  }
  .consultorInfoItem {
    text-align: left;
    margin: 10px 0;
    font-size: 16px;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .consultorAside {
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .consultorAsideTitle {
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

  .consultorDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .consultorTitle {
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
  .subTitle {
    font-size: 16px;
    font-weight: bold;
    color: #444444;
    text-align: left;
    margin: 10px 0;
  }

  .dot {
    position: relative;
    padding-left: 20px;
  }
  .dot::before {
    content: "";
    position: absolute;
    top: 6px;
    left: 0;
    width: 6px;
    height: 6px;
    background-color: #000;
    border-radius: 50%;
  }
  .consultors {
    display: flex;
    flex-direction: column;
  }
  .consultorItem {
    display: flex;
    flex-direction: row;
    width: 100%;
    margin: 5px 0;
    cursor: pointer;
  }
  /* 顾问图片 */
  .consultorImg {
    height: 165px;
    border: 1px solid #ccc;
    margin-right: 10px;
  }
  .consultorImg img {
    height: 100%;
  }
  /* 顾问信息 */
  .consultorInfo {
    background: #dbeeff;
    flex: 1 1 auto;
    padding: 0 10px;
    border: 1px solid #ccc;
  }
  .consultorName {
    font-size: 20px;
    text-align: left;
  }
  .consultorInfoItem {
    text-align: left;
    margin: 5px 0;
    font-size: 16px;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
}
</style>
