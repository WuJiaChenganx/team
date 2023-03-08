<template>
  <div class="teacher">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="teacherContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu
            :default-active="this.$route.path"
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
            {{ currentMenu }}
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > {{ title }} >{{ currentMenu }}
          </div>
        </div>
        <a
          class="detailItem"
          style="cursor: pointer; text-decoration: none"
          href="http://www.homepage.zjut.edu.cn/yxw/"
          target="_blank"
        >
          <div class="memberImg">
            <img src="../../assets/images/teacherPhoto/yxw.jpg" />
          </div>
          <div class="memberInfo">姚信威 教授</div>
        </a>
        <a
          class="detailItem"
          style="cursor: pointer; text-decoration: none"
          href="http://www.homepage.zjut.edu.cn/qiangli/"
          target="_blank"
        >
          <div class="memberImg">
            <img src="../../assets/images/teacherPhoto/lq.jpg" />
          </div>
          <div class="memberInfo">李强 讲师</div>
        </a>
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
.teacher {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.teacherContent {
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

.detailItem {
  float: left;
  padding: 10px;
  width: 200px;
  height: auto;
}

.detailItem img {
  width: 200px;
  height: 230px;
}

.detailItem .memberInfo {
  width: 100%;
  padding: 10px 0;
}
</style>
