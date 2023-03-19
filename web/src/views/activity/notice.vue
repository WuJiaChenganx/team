<template>
  <!-- 通知公告列表 -->
  <div class="notice">
    <div class="noticeContent">
      <div class="noticeTitle">
        <div class="title">通知公告</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/notice' }"
              >通知公告</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="noticeItem">
        <div
          v-for="(item, index) in noticeList"
          :key="index"
          class="notice-row"
          @click="gotoDetail(item.id)"
        >
          <div class="notice-date">
            <div>{{ item.day }}</div>
            <div>{{ item.date }}</div>
          </div>
          <div class="notice-profile">
            <div class="notice-title">{{ item.title }}</div>
            <div class="notice-thing">
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
</template>
<script>
import { getNoticeURL } from "@/api/api";
export default {
  data() {
    return {
      // 要展示的公告信息
      noticeList: [],
      // 总共公告的数量
      total_number: 10,
      // 当前页面从1开始的这两个属性会在刚开始的时候就更新
      current_index: 1,
    };
  },
  created() {
    this.getNoticeList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getNoticeList() {
      let params = {
        // 定义参数
        start: (this.current_index - 1) * 10,
        end: this.current_index * 10,
      };
      await getNoticeURL(params).then((res) => {
        this.noticeList = res.data;
        this.total_number = res.sum;
      });
    },
    handleCurrentChange(val) {
      // 传入的val是当前页的页码
      this.current_index = val;
      this.getNoticeList();
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/activity/noticeDetail",
        name: "通知公告详情",
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
  .notice {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .noticeContent {
    width: 75%;
    margin: 0 auto;
    padding: 0 3rem;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .noticeTitle {
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
  .noticeItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 600px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .notice-row {
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
  .notice-date {
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
  .notice-row .notice-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  } /* 文字部分 */
  .notice-profile {
    width: 85%;
    height: 80px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .notice-title {
    margin-bottom: 0.5rem;
    font-size: 16px;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
  }
  .notice-thing {
    font-size: 16px;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .notice-row:hover {
    border-bottom: 1px solid #0055a2;
  }
  .notice-row:hover .notice-title {
    color: #0055a2;
  }
  .notice-row:hover .notice-date {
    background-color: #0055a2;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .notice {
    background: #eef7fe;
  }
  .noticeContent {
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .noticeTitle {
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
  .noticeItem {
    display: flex;
    flex-direction: column;
    margin-bottom: 3rem;
    min-height: 450px;
  }
  /* 设置分页和底部的距离 */
  .paging {
    margin-bottom: 3rem;
  }
  .notice-row {
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
  .notice-date {
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
  .notice-row .notice-date div:first-child {
    font-size: 3rem;
    font-weight: bold;
  }
  /* 文字部分 */
  .notice-profile {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
  }
  .notice-title {
    margin-bottom: 0.5rem;
    font-size: 1.6rem;
    font-weight: bold;
    color: #333333;
    text-align: left;
    overflow: hidden;
    transition: all 0.5s;
  }
  .notice-thing {
    font-size: 1rem;
    color: #999999;
    text-align: left;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .notice-row:hover {
    border-bottom: 1px solid #0055a2;
  }
  .notice-row:hover .notice-title {
    color: #0055a2;
  }
  .notice-row:hover .notice-date {
    background-color: #0055a2;
  }
}
</style>
