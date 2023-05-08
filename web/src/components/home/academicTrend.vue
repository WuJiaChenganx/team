<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/activity/academy')">{{ pageItem.more }}</a>
    </div>
    <div class="academicTrendDetail animation" data-aos="fade-up">
      <div class="futureAcademicTrend">
        <div class="futureTitle">预告</div>
        <div
          class="futureItem animation"
          data-aos="fade-up"
          v-for="(futureAcademyItem, futureIndex) in academyFutureList"
          :key="futureIndex"
          @click="gotoDetail(futureAcademyItem.id)"
        >
          <div class="futureTitleBox">
            <div class="futureItemTitle">{{ futureAcademyItem.title }}</div>
            <span class="futureItemTime">
              {{ futureAcademyItem.date }}-{{ futureAcademyItem.day }}
            </span>
          </div>
          <div class="futureItemDetail">{{ futureAcademyItem.detail }}</div>
        </div>
      </div>
      <div class="pastAcademicTrend">
        <div class="pastTitle">动态回顾</div>
        <div
          class="pastItem animation"
          data-aos="fade-up"
          :data-aos-delay="delayTime[pastIndex]"
          v-for="(pastAcademyItem, pastIndex) in academyPastList"
          :key="pastIndex"
          @click="gotoDetail(pastAcademyItem.id)"
        >
          <div class="pastTitleBox">
            <div class="pastItemTitle">{{ pastAcademyItem.title }}</div>
            <span class="pastItemTime">
              {{ pastAcademyItem.date }}-{{ pastAcademyItem.day }}
            </span>
          </div>
          <div class="pastItemDetail">{{ pastAcademyItem.detail }}</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import AOS from "aos";
import "aos/dist/aos.css";
import { getAcademyURL } from "@/api/api";
export default {
  data() {
    return {
      academyPastList: [],
      academyFutureList: [],
      pageItem: {},
      chineseItem: { title: "学术动态", more: "more" },
      englishItem: { title: "Academy", more: "more" },
      delayTime: [0, 50, 100, 150],
    };
  },
  created() {
    // 在 mounted 钩子中初始化 AOS
    AOS.init({
      offset: 100, // 触发动画的位置距离窗口底部的距离
      duration: 800, // 动画持续时间
    });
    this.getAcademyPastList();
    this.getAcademyFutureList();
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
    async getAcademyPastList() {
      let params = {
        // 定义参数
        // start: 0,
        // end: 4,
        start: 1,
        end: 7,
        languageType: this.$store.getters.getLanguageType,
        DateType: "回顾",
      };
      await getAcademyURL(params).then((res) => {
        this.academyPastList = res.data;
      });
    },
    async getAcademyFutureList() {
      let params = {
        // 定义参数
        start: 0,
        end: 4,
        languageType: this.$store.getters.getLanguageType,
        DateType: "预告",
      };
      await getAcademyURL(params).then((res) => {
        this.academyFutureList = res.data;
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
.animation {
  opacity: 0;
  transform: translateY(50px);
  transition: all 0.8s ease-in-out;
}
/* PC端 */
@media screen and (min-width: 1000px) {
  .academicTrend {
    width: 100%;
  }
  .academicTitle {
    width: 100%;
    font-size: 18px;
    margin-bottom: 10px;
    position: relative;
    background-color: #fff;
  }
  .title {
    width: 164px;
    margin: 0 auto;
    padding: 20px 0;
    font-size: 18px;
    color: #0055a2;
  }
  .academicTitle p {
    width: 164px;
    font-size: 24px;
    border-bottom: 1px solid #0055a2;
    margin: 0 auto;
    position: relative;
  }
  .academicTitle p:before {
    width: 50px;
    height: 5px;
    position: absolute;
    left: 57px;
    top: -2px;
    background: #0055a2;
    display: table;
    content: "";
  }
  .more {
    color: #333;
    font-size: 14px;
    position: absolute;
    bottom: 28px;
    right: calc(17.5% + 10px);
    cursor: pointer;
  }
  .academicTrendDetail {
    width: 65%;
    margin: 0 auto;
  }
  .futureAcademicTrend {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }

  .futureTitle {
    font-size: 18px;
    width: 100%;
    text-align: left;
  }
  .futureTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 24px; /* 伪元素宽度 */
    height: 24px; /* 伪元素高度 */
    background-image: url("../../assets/images/background/upcoming.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }
  .futureItem {
    width: 50%;
    display: flex;
    flex-direction: column;
    padding: 0 10px;
    box-sizing: border-box;
    cursor: pointer;
  }
  .futureTitleBox {
    display: flex;
    flex: row;
  }
  .futureItemTitle {
    width: 75%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 4rem;
    height: 4rem;
    color: #030f39;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    font-weight: bold;
  }
  .futureItemTime {
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.5rem;
    line-height: 4rem;
    height: 4rem;
    color: #999;
  }
  .futureItemDetail {
    color: #666666;
    font-size: 1.4rem;
    line-height: 3rem;
    overflow: hidden;
    text-align: left;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    line-clamp: 3;
    -webkit-box-orient: vertical;
    word-break: break-all;
    padding-bottom: 0.5rem;
    border-bottom: 1.5px solid #dfdfdf;
  }
  .futureItem:hover .futureItemTitle {
    color: #ff2400;
  }
  .futureItem:hover .futureItemTime {
    color: #008cd6;
  }
  .pastAcademicTrend {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }

  .pastTitle {
    font-size: 18px;
    width: 100%;
    text-align: left;
  }
  .pastTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 24px; /* 伪元素宽度 */
    height: 24px; /* 伪元素高度 */
    background-image: url("../../assets/images/background/done.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }

  .pastItem {
    width: 50%;
    display: flex;
    flex-direction: column;
    padding: 0 10px;
    box-sizing: border-box;
    cursor: pointer;
  }
  .pastTitleBox {
    display: flex;
    flex: row;
  }
  .pastItemTitle {
    width: 75%;
    text-align: left;
    font-size: 1.6rem;
    line-height: 4rem;
    height: 4rem;
    color: #0055a2;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    font-weight: bold;
  }
  .pastItemTime {
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.5rem;
    line-height: 4rem;
    height: 4rem;
    color: #999;
  }
  .pastItemDetail {
    color: #666666;
    font-size: 1.4rem;
    line-height: 3rem;
    overflow: hidden;
    text-align: left;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    line-clamp: 3;
    -webkit-box-orient: vertical;
    word-break: break-all;
    padding-bottom: 0.5rem;
    border-bottom: 1.5px solid #dfdfdf;
  }
  .pastItem:hover .pastItemTitle {
    color: #ff2400;
  }
  .pastItem:hover .pastItemTime {
    color: #008cd6;
  }
}
@media screen and (max-width: 1000px) {
  .academicTrend {
    width: 100%;
    background-color: #ffffff;
  }
  .academicTitle {
    margin-bottom: 20px;
    position: relative;
  }
  .title {
    width: 276px;
    margin: 20px auto;
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
    bottom: 20px;
    right: 0;
  }
  .academicTrendDetail {
    display: flex;
    flex-direction: column;
  }
  .futureAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-top: 10px;
  }
  .futureTitle {
    font-size: 2rem;
    text-align: left;
    margin-bottom: 1rem;
  }
  .futureTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 2rem; /* 伪元素宽度 */
    height: 2rem; /* 伪元素高度 */
    background-image: url("../../assets/images/background/upcoming.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }

  .futureItem {
    width: 100%;
    cursor: pointer;
  }

  .futureTitleBox {
    width: 100%;
    word-break: break-all;
    box-sizing: border-box;
  }
  .futureItemTitle {
    text-align: left;
    font-size: 1.8rem;
    line-height: 20px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .futureItemTime {
    display: none;
  }

  .futureItemDetail {
    color: #909090;
    font-size: 1.6rem;
    line-height: 30px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
  }
  .pastAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }
  .pastTitle {
    width: 100%;
    font-size: 2rem;
    text-align: left;
    margin-bottom: 1rem;
  }
  .pastTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 2rem; /* 伪元素宽度 */
    height: 2rem; /* 伪元素高度 */
    background-image: url("../../assets/images/background/done.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }
  .pastItem {
    width: 100%;
    cursor: pointer;
  }

  .pastTitleBox {
    width: 100%;
    word-break: break-all;
    box-sizing: border-box;
  }
  .pastItemTitle {
    text-align: left;
    color: #0055a2;
    font-size: 1.8rem;
    line-height: 20px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .pastItemTime {
    display: none;
  }

  .pastItemDetail {
    color: #909090;
    font-size: 1.6rem;
    line-height: 30px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
  }
}
</style>
