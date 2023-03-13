<template>
  <div class="teacher">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="teacherContent">
      <div class="teacherAside">
        <div class="teacherAsideTitle">导师</div>
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
      <div class="teacherDetail">
        <div class="teacherTitle">
          <div class="title">导师</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/team/teacher' }"
                >导师</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="teacherItem">
          <a
            class="detailItem"
            href="http://www.homepage.zjut.edu.cn/yxw/"
            target="_blank"
          >
            <div class="detailItemImg">
              <img src="../../assets/images/teacherPhoto/yxw.jpg" />
            </div>
            <div class="detailItemInfo">姚信威 教授</div>
          </a>
          <a
            class="detailItem"
            href="http://www.homepage.zjut.edu.cn/qiangli/"
            target="_blank"
          >
            <div class="detailItemImg">
              <img src="../../assets/images/teacherPhoto/lq.jpg" />
            </div>
            <div class="detailItemInfo">李强 讲师</div>
          </a>
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
      currentMenu: "导师",
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      Info: [
        {
          id: 1,
          name: "姚信威",
          title: "教授",
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
        },
        {
          id: 3,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
        },
        {
          id: 4,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
        },
        {
          id: 5,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
        },
        {
          id: 6,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
        },
        {
          id: 7,
          name: "李强",
          title: "教授",
          picUrl: require("../../assets/images/activity/01.jpg"),
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
  .teacher {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
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
    padding: 1rem;
    width: 20rem;
  }

  .detailItem img {
    height: 23rem;
  }

  .detailItem .detailItemInfo {
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
