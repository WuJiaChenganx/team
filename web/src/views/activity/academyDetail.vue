<template>
  <div class="academyDetailBackground">
    <div class="academyDetail">
      <div class="academyDetailTitle">
        <div class="title">学术动态</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/academy' }"
              >学术动态</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/academyDetail' }"
              >学术动态详情</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="academyDetailContent">
        <div class="academyTitle">{{ academyDetail.title }}</div>
        <div class="academyInfo">{{ academyDetail.detail }}</div>
        <div
          class="academyPhoto"
          v-for="imgUrl in academyDetail.picUrl"
          :key="imgUrl"
        >
          <img :src="imgUrl" alt="" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getActivityDetail } from "@/api/api";
export default {
  data() {
    return {
      academyDetail: {},
    };
  },
  created() {
    this.getAcademyDetail(this.$route.query.id);
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getAcademyDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
      };
      await getActivityDetail(params).then((res) => {
        this.academyDetail = res.data;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .academyDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }

  .academyDetail {
    width: 75%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyDetailTitle {
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
  .academyDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .academyTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    padding: 2rem;
  }
  .academyInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }
  .academyPhoto {
    padding-bottom: 1rem;
  }
  .academyPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 50%;
  }
}

/* 移动端  */
@media screen and (max-width: 1000px) {
  .academyDetailBackground {
    background: #eef7fe;
  }
  .academyDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .academyDetailTitle {
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
  .academyDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .academyTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2rem;
    text-align: center;
    padding: 2rem;
  }
  .academyInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }

  .academyPhoto {
    padding-bottom: 2rem;
  }
  .academyPhoto img {
    /* 只设置宽/高另外一个等比例缩放 */
    width: 50%;
  }
}
</style>
