<template>
  <div class="academyDetailBackground">
    <div class="academyDetail">
      <div class="academyDetailTitle">
        <div class="title">{{ pageItem.title }}</div>
        <div class="breadCrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">{{
              pageItem.home
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/academy' }">{{
              pageItem.academyList
            }}</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/activity/academyDetail' }">{{
              pageItem.academyDetail
            }}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <div class="academyDetailContent">
        <div class="academyTitle">{{ academyDetail.title }}</div>
        <div
          class="academyDetailItem"
          v-for="(academyItem, academyItemIndex) in academyDetail.detail"
          :key="academyItemIndex"
        >
          <div class="academyInfo">
            {{ academyItem.text }}
          </div>
          <div
            v-if="academyItem.picUrl.length"
            :class="academyItem.picUrl.length == 2 ? 'photoBox2' : 'photoBox1'"
          >
            <div
              v-for="(imgUrl, imgUrlIndex) in academyItem.picUrl"
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
      pageItem: {},
      chineseItem: {
        title: "学术动态",
        home: "首页",
        academyList: "学术列表",
        academyDetail: "详情",
      },
      englishItem: {
        title: "Academy",
        home: "Home",
        academyList: "Academy List",
        academyDetail: "Academy Detail",
      },
      academyDetail: {},
    };
  },
  created() {
    this.getAcademyDetail(this.$route.query.id);
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
<style lang="scss" scoped>
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
    padding-bottom: 0.5rem;
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
