<template>
  <div class="book">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="bookContent">
      <div class="bookAside">
        <div class="bookAsideTitle">出版专著</div>
        <div class="bookAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#fff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="bookAsideItem"
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
      <div class="bookDetail">
        <div class="bookTitle">
          <div class="title">出版专著</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/paper/book' }"
                >出版专著</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="bookItem">
          <div
            class="book-row"
            v-for="(detailItem, detailIndex) in showPageContent"
            :key="detailIndex"
          >
            <div class="book-base">
              <i class="el-icon-notebook-1"></i>
              <div class="book-name">
                {{ detailItem.detail }}
              </div>
            </div>
            <div class="book-time">{{ detailItem.time }}</div>
          </div>
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
      currentMenu: "出版专著",
      Menu: [
        { name: "发表论文", path: "/paper/paper" },
        { name: "授权专利", path: "/paper/patent" },
        { name: "出版专著", path: "/paper/book" },
      ],
      showAllContent: [
        { detail: "书本1", time: "2000-06-25" },
        { detail: "书本2", time: "2000-06-25" },
        { detail: "书本3", time: "2000-06-25" },
        { detail: "书本4", time: "2000-06-25" },
        { detail: "书本5", time: "2000-06-25" },
        { detail: "书本6", time: "2000-06-25" },
        { detail: "书本7", time: "2000-06-25" },
        { detail: "书本8", time: "2000-06-25" },
        { detail: "书本9", time: "2000-06-25" },
        { detail: "书本10", time: "2000-06-25" },
        { detail: "书本11", time: "2000-06-25" },
        { detail: "书本12", time: "2000-06-25" },
        { detail: "书本13", time: "2000-06-25" },
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
/* PC端  */
@media screen and (min-width: 1000px) {
  .book {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .bookContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .bookAside {
    width: 25%;
  }
  .bookAsideTitle {
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
  .bookAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .bookDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .bookTitle {
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
  /* 设置块和分页的距离 */
  .bookItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }

  .book-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .book-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .book-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 3rem;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .book {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .bookContent {
    display: flex;
    flex-direction: column;
  }

  .bookAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .bookAsideTitle {
    display: none;
  }
  .bookAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .bookDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .bookTitle {
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
  /* 设置块和分页的距离 */
  .bookItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }

  .book-row {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    cursor: pointer;
    padding: 1.5rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .book-base {
    display: flex;
    flex-direction: row;
    font-size: 3rem;
    line-height: 3rem;
  }
  .book-name {
    text-align: left;
    margin-left: 0.5rem;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #333333;
    height: 3rem;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
}
/* .book {
  padding: 3rem 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
}

.bookContent {
  width: 75%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.bookAside {
  width: 25%;
  display: flex;
  flex-direction: column;
}

.asideTitle {
  background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
  border-radius: 0.6rem;
  background-size: cover !important;
  font-weight: bold;
  color: #fff;
  font-size: 2.2rem;
  line-height: 3rem;
  height: 3rem; */
/* 扩充背景 */
/* padding: 2rem 3rem; */
/* 下面的子菜单距离 */
/* margin-bottom: 1rem;
}

.asideContent {
  border: 1px solid #eee;
} */

/* .title {
  float: left;
  color: #333333;
  font-weight: bold;
  font-size: 25px;
}

.breadCrumb {
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

.bookDetail {
  float: left;
  position: relative;
  padding: 0 15px;
  width: 73%;
  height: 520px;
  background-color: #fff;
  border: 1px solid #dfdfdf;
  padding-bottom: 30px;
}

.bookTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
}

.book-row {
  position: relative;
  width: 100%;
  box-sizing: border-box;
  height: 40px;
  padding: 10px;
  padding-left: 20px;
  border-bottom: 1px solid #dfdfdf;
}

.book-row::before {
  position: absolute;
  content: "";
  width: 6px;
  height: 6px;
  background: #0055a2;
  border-radius: 50%;
  left: 7px;
  top: 20px;
}

.book-profile {
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

.book-time {
  float: right;
} */

.paging {
  /* position: absolute; */
  /* 起点移动到了参照物的50%位置 */
  /* left: 50%;
  bottom: 3px; */
  /* 上面注释掉的可以用下面的来替代 位移宽度和高度的一半*/
  /* transform: translate(-50%, 0); */
}
</style>
