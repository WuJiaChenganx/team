<template>
  <div class="resourceSharing">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="resourceContent">
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
        <div
          class="detailRow"
          v-for="(detailItem, detailIndex) in showPageContent"
          :key="detailIndex"
        >
          <div class="Info">
            {{ detailItem.detail }}
          </div>
          <div class="Time">{{ detailItem.time }}</div>
        </div>
        <div class="paging">
          <!-- page-size展示的选择每页显示个数的选项,页面变动触发的事件是current-change后面的函数,total表示总共的数量 current-page表示当前页数-->
          <el-pagination
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :page-size="10"
            :total="total_number"
            :current-page="current_index"
          >
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "论文论著",
      currentMenu: "授权专利",
      Menu: [
        { name: "发表论文", path: "/paper/paper" },
        { name: "授权专利", path: "/paper/patent" },
        { name: "出版专著", path: "/paper/book" },
      ],
      showAllContent: [
        { detail: "专利1", time: "2000-06-25" },
        { detail: "专利2", time: "2000-06-25" },
        { detail: "专利3", time: "2000-06-25" },
        { detail: "专利4", time: "2000-06-25" },
        { detail: "专利5", time: "2000-06-25" },
        { detail: "专利6", time: "2000-06-25" },
        { detail: "专利7", time: "2000-06-25" },
        { detail: "专利8", time: "2000-06-25" },
        { detail: "专利9", time: "2000-06-25" },
        { detail: "专利10", time: "2000-06-25" },
        { detail: "专利11", time: "2000-06-25" },
        { detail: "专利12", time: "2000-06-25" },
        { detail: "专利13", time: "2000-06-25" },
      ],
      showPageContent: [],
      // 总共要展示的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.total_number = this.showAllContent.length;
    this.showPageContent = this.showAllContent.slice(
      (this.current_index - 1) * 10,
      this.current_index * 10
    );
  },
  methods: {
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.showPageContent = this.showAllContent.slice(
        (val - 1) * 10,
        val * 10
      );
    },
  },
};
</script>
<style scoped>
.resourceSharing {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.resourceContent {
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
  height: 520px;
  background-color: #fff;
  border: 1px solid #dfdfdf;
  padding-bottom: 30px;
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
  left: 7px;
  top: 20px;
}

.Info {
  width: 70%;
  float: left;
  text-align: left;
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

.paging {
  position: absolute;
  /* 起点移动到了参照物的50%位置 */
  left: 50%;
  bottom: 3px;
  /* 上面注释掉的可以用下面的来替代 位移宽度和高度的一半*/
  transform: translate(-50%, 0);
}
</style>
