<template>
  <div class="newFlashDetailBackground">
    <div class="newFlashDetail">
      <div class="newFlashDetailTitle">
        <div class="title">新闻快讯</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/newFlash' }"
              >新闻快讯</el-breadcrumb-item
            >
            <el-breadcrumb-item :to="{ path: '/activity/newFlashDetail' }"
              >新闻快讯详情</el-breadcrumb-item
            >
          </el-breadcrumb>
        </div>
      </div>
      <div class="newFlashDetailContent">
        <div class="newFlashTitle">{{ newsFlashDetail.title }}</div>
        <div
          class="newFlashDetailItem"
          v-for="(newFlashItem, newFlashItemIndex) in newsFlashDetail.detail"
          :key="newFlashItemIndex"
        >
          <div class="newFlashInfo">{{ newFlashItem.text }}</div>
          <div
            :class="newFlashItem.picUrl.length == 1 ? 'photoBox1' : 'photoBox2'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in newFlashItem.picUrl"
              :key="imgUrlIndex"
            >
              <img :src="imgUrl" />
            </div>
          </div>
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
      newsFlashDetail: {},
    };
  },
  created() {
    this.getNewFlashDetail(this.$route.query.id);
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getNewFlashDetail(id) {
      // 从上一个路由获取的参数
      let params = {
        id: id,
      };
      await getActivityDetail(params).then((res) => {
        this.newsFlashDetail = res.data;
      });
    },
  },
};
</script>
<style lang="scss" scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .newFlashDetailBackground {
    padding: 3rem 0;
    background: #eef7fe;
  }
  .newFlashDetail {
    width: 75%;
    /* 内容里面缩进 */
    padding: 0 3rem;
    margin: 0 auto;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .newFlashDetailTitle {
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
  .newFlashDetailContent {
    min-height: 600px;
    padding-bottom: 2rem;
  }
  .newFlashTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2.5rem;
    text-align: center;
    padding: 2rem;
  }
  .newFlashInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }
  .photoBox1 {
    width: 100%;
    padding-bottom: 1rem;
    img {
      width: 65%;
    }
  }

  .photoBox2 {
    width: 100%;
    padding-bottom: 1rem;
    display: flex;
    flex-direction: row;
    justify-content: center;
    div {
      width: 45%;
      margin-right: 2rem;
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
}

/* 移动端  */
@media screen and (max-width: 1000px) {
  .newFlashDetailBackground {
    background: #eef7fe;
  }
  .newFlashDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }
  .newFlashDetailTitle {
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
  .newFlashDetailContent {
    min-height: 450px;
    padding-bottom: 2rem;
  }
  .newFlashTitle {
    color: #0055a2;
    line-height: 3rem;
    font-size: 2rem;
    text-align: center;
    padding: 2rem;
  }
  .newFlashInfo {
    word-wrap: break-word;
    word-break: break-all;
    text-align: left;
    line-height: 3rem;
    font-size: 1.6rem;
    text-indent: 2em;
    padding-bottom: 2rem;
  }

  .photoBox1 {
    width: 100%;
    padding-bottom: 1rem;
    img {
      width: 60%;
    }
  }

  .photoBox2 {
    width: 100%;
    padding-bottom: 1rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    div {
      width: 49%;
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
