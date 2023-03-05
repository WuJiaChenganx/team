<template>
  <div class="resourceSharing">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="resourceContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu default-active="2" mode="vertical" text-color="#000">
            <el-menu-item
              class="contentItem"
              v-for="(menuItem, index) in Menu"
              :key="index"
              @click="selectByName(menuItem.name)"
            >
              <i class="el-icon-sunny"></i>
              <span slot="title">{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="details">
        <div class="detailTitle">
          <div
            style="
              float: left;
              color: #333333;
              font-weight: bold;
              font-size: 25px;
            "
          >
            <div>{{ currentMenu }}</div>
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > 资源共享 >{{ currentMenu }}
          </div>
        </div>
        <div
          class="detailRow"
          v-for="(detailItem, detailIndex) in showContent"
          :key="detailIndex"
        >
          <div class="Info">
            {{ detailItem.detail }}
          </div>
          <div class="Time">{{ detailItem.time }}</div>
        </div>
      </div>
    </div>
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      title: "资源共享",
      Menu: [{ name: "发表论文" }, { name: "授权专利" }, { name: "出版专著" }],
      allInfo: [
        { name: "发表论文", detail: "我是无敌的1", time: "2000-06-25" },
        { name: "发表论文", detail: "我是无敌的2", time: "2000-06-25" },
        { name: "发表论文", detail: "我是无敌的3", time: "2000-06-25" },
        { name: "授权专利", detail: "我是无敌的4", time: "2000-06-25" },
        { name: "授权专利", detail: "我是无敌的5", time: "2000-06-25" },
        { name: "授权专利", detail: "我是无敌的6", time: "2000-06-25" },
        { name: "出版专著", detail: "我是无敌的7", time: "2000-06-25" },
        { name: "出版专著", detail: "我是无敌的8", time: "2000-06-25" },
        { name: "出版专著", detail: "我是无敌的9", time: "2000-06-25" },
      ],
      currentMenu: "发表论文",
      showContent: [],
    };
  },
  created() {
    this.showContent = this.selectByName(this.currentMenu);
    console.log("执行created");
  },
  methods: {
    selectByName(name) {
      this.currentMenu = name;
      this.showContent = this.allInfo.filter((item) => item.name === name);
    },
  },
};
</script>
<style scoped>
.resourceSharing {
  padding: 30px 0 50px 0;
  background: #eef7fe;
  width: 100%;
  height: 500px;
}
.resourceContent {
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
  background: url(../assets/images/background/zryy-menu-t-bg.png) no-repeat
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
.contentItem {
  cursor: pointer;
  border-bottom: 1px solid #eee;
}
.contentItem:hover {
  background: #dbeeff;
}
.details {
  float: left;
  position: relative;
  padding: 0 15px;
  width: 75%;
  height: 520px;
  background-color: #fff;
}
.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
}
.detailRow {
  position: relative;
  width: 100%;
  box-sizing: border-box;
  height: 40px;
  padding: 10px;
  padding-left: 20px;
  border-bottom: 1px solid #dfdfdf;
}
.detailRow::before {
  position: absolute;
  content: "";
  width: 6px;
  height: 6px;
  background: #0055a2;
  border-radius: 50%;
  left: 0;
  top: 20px;
}
.Info {
  width: 90%;
  float: left;
  text-align: left;
  /* 最多两行,超出两行的直接省略 */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
  overflow: hidden;
  color: #333333;
  font-size: 17px;
}
.Time {
  float: right;
}
</style>

