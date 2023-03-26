<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="left-title">{{ pageItem.title }}</div>
      <a class="title-more" @click="goTo('/activity/academy')"
        >{{ pageItem.more }} +</a
      >
    </div>
    <div class="academicTrendItem">
      <div
        class="academicTrend-row"
        v-for="(academyItem, index) in academyList"
        :key="index"
        @click="gotoDetail(academyItem.id)"
      >
        <div class="academicTrend-img">
          <img :src="academyItem.picUrl[0]" />
        </div>
        <div class="academicTrend-text">
          <div class="title-box">{{ academyItem.title }}</div>
          <div class="detail-box">
            {{ academyItem.detail }}
          </div>
          <div class="time-box">
            {{ academyItem.date }}-{{ academyItem.day }}
          </div>
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
      academyList: [],
      pageItem: {},
      chineseItem: { title: "学术动态", more: "更多" },
      englishItem: { title: "Academy", more: "more" },
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
        start: 0,
        end: 4,
      };
      await getAcademyURL(params).then((res) => {
        this.academyList = res.data;
      });
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
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
  },
};
</script>
<style scoped>
/* PC端 */
@media screen and (min-width: 1000px) {
  .academicTrend {
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  .academicTitle {
    padding-bottom: 13px;
    margin-bottom: 25px;
    position: relative;
    overflow: hidden;
  }
  .academicTitle::before {
    width: 163px;
    height: 39px;
    bottom: 0;
    left: 0;
    top: -2px;
    background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
      left center;
  }
  .academicTitle::before,
  .academicTitle::after {
    position: absolute;
    content: "";
  }
  .left-title {
    display: inline-block;
    font-size: 20px;
    line-height: 26px;
    font-style: italic;
    color: #003266;
    font-weight: bold;
    width: 100%;
    text-align: left;
  }
  .academicTitle .title-more {
    position: absolute;
    right: 0;
    bottom: 0;
    display: inline-block;
    color: #7db0cb;
    font-size: 16px;
    line-height: 18px;
    cursor: pointer;
  }
  .academicTitle::after {
    top: 0;
    left: 160px;
    right: 0;
    height: 4px;
    background: #deecf9;
  }
  .academicTrendItem {
    cursor: pointer;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  /* 每一行 横着排列 */
  .academicTrend-row {
    display: flex;
    flex-direction: row;
    margin-bottom: 1rem;
  }

  .academicTrend-img {
    /* 固定宽高 */
    height: 15rem;
    width: 18rem;
    margin-right: 2rem;
    box-sizing: border-box;
    overflow: hidden;
    border: 1px solid #eee;
  }
  .academicTrend-img img {
    width: 100%;
    height: 100%;
  }

  .academicTrend-row:hover .academicTrend-img img {
    transform: scale(1.1);
    transition: all 0.5s;
  }

  .academicTrend-row:hover .title-box {
    color: #ff2400;
  }
  .academicTrend-row:hover .time-box {
    color: #0055a2;
  }

  .academicTrend-text {
    width: 70%;
    height: 100%;
    flex: 1 1 auto;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  .title-box {
    text-align: left;
    color: #0055a2;
    font-size: 1.8rem;
    line-height: 2.5rem;
    font-weight: bold;
  }
  /* 中间的profile */
  .detail-box {
    color: #909090;
    font-size: 1.6rem;
    height: 7.5rem;
    line-height: 2.5rem;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    /* 显示3行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
  }
  .time-box {
    text-align: right;
    font-size: 1.6rem;
    line-height: 2.5rem;
    font-family: Arial;
    color: #828282;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .academicTitle {
    padding-bottom: 13px;
    margin-bottom: 25px;
    position: relative;
    overflow: hidden;
  }

  .academicTitle::before {
    width: 163px;
    height: 39px;
    bottom: 0;
    left: 0;
    top: -2px;
    background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
      left center;
  }
  .academicTitle::before,
  .academicTitle::after {
    position: absolute;
    content: "";
    z-index: -1;
  }
  .left-title {
    display: inline-block;
    font-size: 20px;
    line-height: 26px;
    font-style: italic;
    color: #003266;
    font-weight: bold;
    width: 100%;
    text-align: left;
  }
  .academicTitle .title-more {
    position: absolute;
    right: 0;
    bottom: 0;
    display: inline-block;
    color: #7db0cb;
    font-size: 16px;
    line-height: 18px;
    cursor: pointer;
  }
  .academicTitle::after {
    top: 0;
    left: 160px;
    right: 0;
    height: 4px;
    background: #deecf9;
  }
  .academicTrendItem {
    cursor: pointer;
    display: flex;
    flex-direction: column;
  }
  /* 每一行 竖着排列 */
  .academicTrend-row {
    display: flex;
    flex-direction: column;
    margin-bottom: 10px;
  }

  .academicTrend-img {
    width: 100%;
    max-height: 180px;
    margin-bottom: 10px;
    overflow: hidden;
  }
  .academicTrend-img img {
    width: 100%;
    border: 1px solid #eee;
  }

  .academicTrend-row:hover .academicTrend-img img {
    transform: scale(1.1);
    transition: all 0.5s;
  }

  .academicTrend-row:hover .title-box {
    color: #ff2400;
  }
  .academicTrend-row:hover .time-box {
    color: #0055a2;
  }

  .academicTrend-text {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  .title-box {
    text-align: left;
    color: #0055a2;
    font-size: 17px;
    line-height: 23px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  /* 中间的profile */
  .detail-box {
    color: #909090;
    font-size: 13px;
    line-height: 19px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    /* 显示2行 */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
    margin-bottom: 5px;
  }
  .time-box {
    text-align: right;
    font-size: 14px;
    line-height: 1;
    font-family: Arial;
    color: #828282;
  }
}
</style>
