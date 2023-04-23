<template>
  <div class="academy">
    <div class="academyContent">
      <div class="academyDetail">
        <div class="academyTitle">
          <div class="title">{{ pageItem.title }}</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">{{
                pageItem.home
              }}</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/activity/academy' }">{{
                pageItem.academyList
              }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <div class="academyItem">
          <div
            v-for="(item, index) in academyList"
            :key="index"
            class="academy-row"
            @click="gotoDetail(item.id)"
          >
            <div class="academy-date">
              <div>{{ item.day }}</div>
              <div>{{ item.date }}</div>
            </div>
            <div class="academy-profile">
              <div class="academy-title">{{ item.title }}</div>
              <div class="academy-thing">
                {{ item.detail }}
              </div>
            </div>
          </div>
        </div>
        <div class="paging">
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
import { getAcademyURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        title: "学术动态",
        home: "首页",
        academyList: "学术列表",
      },
      englishItem: {
        title: "Academy",
        home: "Home",
        academyList: "Academy List",
      },
      // 总共要展示的数量
      total_number: 0,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
      // 要展示的新闻信息(加载前还要处理过)
      academyList: [],
    };
  },
  created() {
    this.getAcademyList();
    this.changUI();
  },
  methods: {
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.pageItem = this.englishItem;
      }
    },
    // async和await用于同步,就是按顺序执行
    async getAcademyList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
        languageType: this.$store.getters.getLanguageType,
        DateType: "回顾",
      };
      await getAcademyURL(params).then((res) => {
        this.academyList = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getAcademyList();
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/activity/academyDetail",
        name: "学术动态详情",
        query: {
          id: id,
        },
      });
    },
  },
};
</script>
<style scoped>
/* PC端 */
@media screen and (min-width: 1000px) {
  .academy {
    padding: 3rem 0;
    background-color: #eef7fe;
  }
  .academyContent {
    width: 75%;
    margin: 0 auto;
  }
  .academyDetail {
    width: 100%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .academyTitle {
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
  /* 设置块和分页的距离 */
  .academyItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .academy-row {
    cursor: pointer;
    height: 80px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 20px 0;
    border-bottom: 1px solid #dfdfdf;
    transition: all 0.5s;
  }
  /* 时间框 */
  .academy-date {
    margin-right: 2rem;
    width: 80px;
    height: 80px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #008cd6;
    border-radius: 6px;
    color: #ffffff;
    font-family: Arial;
    text-align: center;
    transition: all 0.5s;
  }
  /* 就是日期中有个要变大 */
  .academy-row .academy-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  /* 文字部分 */
  .academy-profile {
    width: 70%;
    flex: 1 1 auto;
    height: 80px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .academy-title {
    margin-bottom: 0.5rem;
    font-size: 16px;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
    /* 显示1行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .academy-thing {
    font-size: 16px;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .academy-row:hover {
    border-bottom: 1px solid #0055a2;
  }
  .academy-row:hover .academy-title {
    color: #0055a2;
  }
  .academy-row:hover .academy-date {
    background-color: #0055a2;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .academy {
    background: #eef7fe;
  }
  .academyContent {
    display: flex;
    flex-direction: column;
  }
  .academyDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyTitle {
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
  /* 设置块和分页的距离 */
  .academyItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .academy-row {
    cursor: pointer;
    height: 8rem;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
    transition: all 0.5s;
  }
  /* 时间框 */
  .academy-date {
    margin-right: 2rem;
    width: 8rem;
    height: 8rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #008cd6;
    border-radius: 6px;
    color: #ffffff;
    font-family: Arial;
    text-align: center;
    transition: all 0.5s;
  }
  /* 就是日期中有个要变大 */
  .academy-row .academy-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  /* 文字部分 */
  .academy-profile {
    width: 70%;
    flex: 1 1 auto;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .academy-title {
    margin-bottom: 0.5rem;
    font-size: 1.6rem;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
    /* 显示1行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .academy-thing {
    font-size: 1rem;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
}
</style>
