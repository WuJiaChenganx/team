<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
      <a class="more" @click="goTo('/activity/academy')"
        >{{ pageItem.more }} >></a
      >
    </div>
    <div class="academicTrendDetail animation" data-aos="fade-up">
      <div class="leftAcademicTrend">
        <div class="leftTitle"><span>动态回顾</span></div>
        <div
          class="leftItem animation"
          data-aos="fade-up"
          :data-aos-delay="delayTime[leftIndex]"
          v-for="(leftAcademyItem, leftIndex) in academyPastList"
          :key="leftIndex"
          @click="gotoDetail(leftAcademyItem.id)"
        >
          <div class="leftImg">
            <img :src="leftAcademyItem.picUrl[0]" />
          </div>
          <div class="leftText">
            <div class="title-box">{{ leftAcademyItem.title }}</div>
            <div class="detail-box">
              {{ leftAcademyItem.detail }}
            </div>
          </div>
        </div>
      </div>
      <div class="rightAcademicTrend">
        <div class="rightTitle"><span>活动预告</span></div>
        <div
          class="rightItem"
          v-for="(rightItem, rightIndex) in academyFutureList"
          :key="rightIndex"
        >
          <span>{{ rightItem.date }}-{{ rightItem.day }}</span>
          <div>
            {{ rightItem.title }}
          </div>
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
      chineseItem: { title: "学术动态", more: "更多" },
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
        start: 0,
        end: 4,
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
    cursor: pointer;
  }
  .academicTrendDetail {
    display: flex;
    flex-direction: row;
    width: 100%;
  }
  .leftAcademicTrend {
    width: 50%;
    display: flex;
    flex-direction: column;
    margin-right: 10px;
  }
  .leftTitle {
    font-size: 20px;
    text-align: left;
  }
  .leftTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/done.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }
  .leftItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-top: 12px;
    cursor: pointer;
  }

  .leftImg {
    width: 20%;
    height: 10rem;
  }
  .leftImg img {
    max-width: 100%;
    height: 100%;
    box-sizing: border-box;
    border: 1.5px solid #dfdfdf;
  }
  .leftItem:hover img {
    transform: scale(1.05);
    transition: all 1s;
  }
  .leftText {
    flex: 1 0 70%;
    box-sizing: border-box;
    padding: 0 20px;
  }

  .leftItem:hover .title-box {
    color: #ff2400;
  }
  .title-box {
    display: inline-block;
    font-size: 16px;
    line-height: 26px;
    color: #0055a2;
    font-weight: bold;
    width: 100%;
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
    -webkit-line-clamp: 3;
    line-clamp: 3;
    -webkit-box-orient: vertical;
  }

  .rightAcademicTrend {
    width: 50%;
    display: flex;
    flex-direction: column;
    margin-right: 10px;
  }
  .rightTitle {
    font-size: 20px;
    text-align: left;
  }
  .rightTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/upcoming.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }

  .rightItem {
    margin: 10px 0;
  }
  .rightItem span {
    color: #666;
    font-size: 16px;
    padding-right: 20px;
    border-right: 1px solid #c2c2c2;
    line-height: 20px;
    float: left;
  }

  .rightItem div {
    color: #666;
    font-size: 16px;
    padding-left: 20px;
    line-height: 20px;
    float: left;
  }
}
/* 移动端 大尺寸*/
@media screen and (min-width: 500px) and (max-width: 1000px) {
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
  .leftAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-right: 10px;
  }
  .leftTitle {
    font-size: 20px;
    text-align: left;
  }
  .leftTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/done.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }
  .leftItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-top: 12px;
    cursor: pointer;
  }

  .leftImg {
    width: 50%;
    height: 200px;
  }
  .leftImg img {
    max-width: 100%;
    height: 100%;
    box-sizing: border-box;
    border: 1.5px solid #dfdfdf;
  }
  .leftItem:hover img {
    transform: scale(1.05);
    transition: all 1s;
  }
  .leftText {
    flex: 1 0 70%;
    box-sizing: border-box;
    padding: 0 20px;
  }

  .title-box {
    text-align: left;
    color: #0055a2;
    font-size: 24px;
    line-height: 30px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .detail-box {
    color: #909090;
    font-size: 22px;
    line-height: 30px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 5;
    overflow: hidden;
  }
  .rightAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-top: 10px;
  }
  .rightTitle {
    font-size: 20px;
    text-align: left;
  }
  .rightTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/upcoming.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }

  .rightItem {
    margin: 10px 0;
  }
  .rightItem span {
    color: #666;
    font-size: 16px;
    padding-right: 20px;
    border-right: 1px solid #c2c2c2;
    line-height: 20px;
    float: left;
  }

  .rightItem div {
    color: #666;
    font-size: 16px;
    padding-left: 20px;
    line-height: 20px;
    float: left;
  }
}
/* 移动端 小尺寸*/
@media screen and (max-width: 500px) {
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
    margin: 15px auto;
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
  .leftAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-right: 10px;
  }
  .leftTitle {
    font-size: 20px;
    text-align: left;
  }
  .leftTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/done.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }
  .leftItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-top: 12px;
    cursor: pointer;
  }

  .leftImg {
    width: 30%;
    height: 80px;
  }
  .leftImg img {
    max-width: 100%;
    height: 100%;
    box-sizing: border-box;
    border: 1.5px solid #dfdfdf;
  }
  .leftItem:hover img {
    transform: scale(1.05);
    transition: all 1s;
  }
  .leftText {
    flex: 1 0 70%;
    box-sizing: border-box;
    padding: 0 20px;
  }

  .title-box {
    text-align: left;
    color: #0055a2;
    font-size: 14px;
    line-height: 18px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .detail-box {
    color: #909090;
    font-size: 14px;
    line-height: 18px;
    text-align: left;
    word-wrap: break-word;
    word-break: break-all;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }
  .rightAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-top: 10px;
  }
  .rightTitle {
    font-size: 20px;
    text-align: left;
  }
  .rightTitle::before {
    content: "";
    display: inline-block; /* 将伪元素设置为行内块元素 */
    vertical-align: middle; /* 垂直居中对齐 */
    width: 30px; /* 伪元素宽度 */
    height: 30px; /* 伪元素高度 */
    background-image: url("../../assets/images/activity/upcoming.png");
    background-size: contain; /* 等比例缩小 */
    background-repeat: no-repeat;
    background-position: center center; /* 图片居中 */
    margin-right: 10px; /* 可选，为伪元素和文字之间留出一定的间隔 */
  }

  .rightItem {
    margin: 10px 0;
  }
  .rightItem span {
    color: #666;
    font-size: 16px;
    padding-right: 20px;
    border-right: 1px solid #c2c2c2;
    line-height: 20px;
    float: left;
  }

  .rightItem div {
    color: #666;
    font-size: 16px;
    padding-left: 20px;
    line-height: 20px;
    float: left;
  }
}
</style>
