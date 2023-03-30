<template>
  <div class="teacher">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="teacherContent">
      <div class="teacherAside">
        <div class="teacherAsideTitle">{{ pageItem.allTitle }}</div>
        <div class="teacherAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="teacherAsideItem"
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
      <div class="teacherDetail">
        <div class="teacherTitle">
          <div class="title">{{ pageItem.subTitle }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/team/teacher' }">{{
                pageItem.teacher
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="teacherItem">
          <div
            class="detailItem"
            v-for="(memberItem, index) in teacherCover"
            :key="index"
            @click="gotoDetail(memberItem)"
          >
            <div class="detailItemImg">
              <img :src="memberItem.picUrl" @error="setDefaultImage" />
            </div>
            <div class="detailItemInfo">
              {{ memberItem.name }} {{ memberItem.title }}
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
        subTitle: "导师",
        home: "首页",
        teacher: "导师",
      },
      englishItem: {
        allTitle: "Snapshot",
        subTitle: "Teacher",
        home: "home",
        teacher: "Teacher",
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
      teacherCover: [],
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
        memberType: "teacher",
        languageType: this.$store.getters.getLanguageType,
      };
      await getMemberCover(params).then((res) => {
        this.teacherCover = res.data;
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
  .teacher {
    padding: 3rem 0;
    box-sizing: border-box;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
    min-height: calc(100vh - 35.762rem);
  }

  .teacherContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .teacherAside {
    width: 25%;
  }
  .teacherAsideTitle {
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
  .teacherAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .teacherDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
    min-height: calc(100vh - 35.762rem - 6rem);
  }

  .teacherTitle {
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

  .teacherItem {
    display: flex;
    flex-direction: row;
    justify-content: center;
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
    height: 15rem;
    width: 11rem;
  }
  .detailItemInfo {
    padding: 1rem 0;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .teacher {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .teacherContent {
    display: flex;
    flex-direction: column;
  }

  .teacherAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .teacherAsideTitle {
    display: none;
  }
  .teacherAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .teacherDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .teacherTitle {
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

  .teacherItem {
    display: flex;
    flex-direction: column;
    padding: 2rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
  }

  .detailItem img {
    height: 23rem;
  }

  .detailItem .detailItemInfo {
    padding: 1rem 0;
  }
}
</style>
