<template>
  <div class="master">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="masterContent">
      <div class="masterAside">
        <div class="masterAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="masterAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="masterAsideItem"
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
      <div class="masterDetail">
        <div class="masterTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/master' }">{{
                pageItem.master
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="masterItem">
          <div
            class="detailItem"
            v-for="(memberItem, index) in studentCover"
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
        subTitle: "硕士生",
        home: "首页",
        master: "硕士生",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Master",
        home: "home",
        master: "Master",
      },
      menu: [],
      menuZH: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
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
    this.getMemberCoverList();
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
    async getMemberCoverList() {
      let params = {
        start: 0,
        end: 100,
        memberType: "master",
        languageType: this.$store.getters.getLanguageType,
      };
      await getMemberCover(params).then((res) => {
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
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .masterContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .masterAside {
    width: 25%;
  }
  .masterAsideTitle {
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
  .masterAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .masterDetail {
    min-height: 600px;
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .masterTitle {
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

  .masterItem {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    padding: 3rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
    width: 20%;
    box-sizing: border-box;
    padding: 1rem;
  }
  .detailItemImg {
    width: 100%;
  }
  .detailItem img {
    height: 13.5rem;
    width: 9rem;
  }

  .detailItemInfo {
    padding: 1rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .master {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .masterContent {
    display: flex;
    flex-direction: column;
  }

  .masterAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .masterAsideTitle {
    display: none;
  }
  .masterAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .masterDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .masterTitle {
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

  .masterItem {
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
