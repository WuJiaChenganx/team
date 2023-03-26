<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/activity/academy')"
        >{{ pageItem.more }} >></a
      >
    </div>
    <div class="academicTrendItem">
      <div
        class="academicTrend-item"
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
    padding: 20px 0;
    background-color: #ffffff;
  }
  .academicTitle {
    margin-bottom: 40px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 30px auto;
    font-size: 33px;
    color: #0055a2;
  }
  .academicTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .academicTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 20px;
    position: absolute;
    bottom: 20px;
    right: 30px;
  }
  .academicTrendItem {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  .academicTrend-item {
    width: 49%;
    margin-bottom: 25px;
    display: flex;
    flex-direction: row;
    border: 1px solid #dfdfdf;
  }

  .academicTrend-img {
    width: 50%;
  }
  .academicTrend-img img {
    max-width: 100%;
    height: 100%;
  }
  .academicTrend-text {
    width: 50%;
    box-sizing: border-box;
    padding: 0 20px;
  }
  .title-box {
    color: #414141;
    font-size: 16px;
    margin-top: 10px;
    margin-bottom: 20px;
    line-height: 28px;
    overflow: hidden;
    text-align: left;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    line-clamp: 1;
    -webkit-box-orient: vertical;
  }
  .detail-box {
    color: #666666;
    font-size: 14px;
    line-height: 24px;
    overflow: hidden;
    text-align: left;
    display: -webkit-box;
    -webkit-line-clamp: 7;
    line-clamp: 7;
    -webkit-box-orient: vertical;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .academicTitle {
    margin-bottom: 40px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 30px auto;
    font-size: 24px;
    color: #0055a2;
  }
  .academicTitle p {
    width: 276px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .academicTitle p:before {
    width: 74px;
    height: 5px;
    position: absolute;
    left: 101px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #0055a2;
    font-size: 16px;
    position: absolute;
    bottom: 25px;
    right: 0;
  }
  .academicTrendItem {
    display: flex;
    flex-direction: column;
  }
  .academicTrend-item {
    width: 100%;
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
  }

  .academicTrend-img {
    width: 100%;
  }
  .academicTrend-img img {
    width: 100%;
    max-height: 180px;
    margin-bottom: 10px;
    overflow: hidden;
  }
  .academicTrend-text {
    width: 100%;
    box-sizing: border-box;
  }
  .title-box {
    text-align: left;
    color: #0055a2;
    font-size: 17px;
    line-height: 23px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .detail-box {
    color: #909090;
    font-size: 13px;
    line-height: 19px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
}
</style>
