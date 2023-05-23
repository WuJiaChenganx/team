<template>
  <div class="master">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="masterContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/team' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/team/master' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="masterAside">
        <div class="masterAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="masterAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="masterAsideItem"
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
      <div class="masterDetail">
        <div class="masterTitle">
          {{ pageItem.subTitle }}
        </div>
        <div
          v-for="(sessionItem, sessionIndex) in studentCover"
          :key="sessionIndex"
        >
          <div class="mastersSession">
            <div class="mastersTitle">{{ sessionItem.title }}级研究生</div>
            <div
              class="mastersItem"
              v-for="(
                detailMasterInfoItem, detailMasterInfoIndex
              ) in sessionItem.memberInfo"
              :key="detailMasterInfoIndex"
              @click="gotoDetail(detailMasterInfoItem.id)"
            >
              <div class="mastersItemImg">
                <img
                  :src="detailMasterInfoItem.picUrl"
                  @error="setDefaultImage"
                />
              </div>
              <div class="mastersItemInfo">
                {{ detailMasterInfoItem.title }}
                <br />
                {{ detailMasterInfoItem.name }}
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
        subTitle: "硕士生",
        home: "首页",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Master",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "顾问", path: "/team/consultor" },
        { name: "导师", path: "/team/teacher" },
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
        memberType: "master",
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
  .master {
    width: 100%;
  }
  .masterContent {
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

  .masterAside {
    width: 20%;
    padding-right: 30px;
  }

  .masterAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .masterAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .masterAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .masterAsideContent {
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

  .masterAsideItem {
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
  .masterAsideItem:last-child {
    border-bottom: none;
  }
  .masterAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .masterAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .masterDetail {
    width: calc(80% - 30px);
    min-height: calc(100vh - 29rem - 58px);
  }

  .masterTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }
  .mastersSession {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
  }
  .mastersTitle {
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
  .mastersItem {
    cursor: pointer;
    text-decoration: none;
    flex: 0 0 calc(12.5% - 10px); /* 每个元素占据12.5%的宽度，同时减去10px的margin-right */
    margin-right: 10px; /* 设置右外边距 */
  }

  .mastersItemImg {
    width: 100%;
  }
  .mastersItemImg img {
    width: 75%;
  }
  .mastersItemInfo {
    padding: 5px 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .master {
    width: 100%;
  }
  .masterContent {
    display: flex;
    flex-direction: column;
  }

  .masterAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .masterAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .masterAsideTitle span img {
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
  .masterAsideItem span img {
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
  .masterDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 29rem - 179px);
  }
  .masterTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }

  .mastersSession {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
  }
  .mastersTitle {
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
  .mastersItem {
    width: 50%;
    display: flex;
    flex-direction: column;
    padding: 2rem 0;
  }
  .mastersItemImg {
    margin: 0 auto;
    width: 20rem;
  }
  .mastersItemImg img {
    width: 70%;
  }
  .mastersItemInfo {
    padding: 5px 0;
  }
}
</style>
