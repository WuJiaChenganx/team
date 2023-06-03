<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="title">{{ pageItem.title }}</div>
      <p></p>
    </div>
    <div class="academicTrendDetail animation" data-aos="fade-up">
      <div class="futureAcademicTrend">
        <div class="futureTitle">
          <div class="futureTitleName">
            <img src="../../assets/images/background/trend.png" alt="" />
            <span>预告</span>
          </div>
          <div class="futureMore" @click="goTo('/activity/academy')">更多+</div>
        </div>
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
        <div class="pastTitle">
          <div class="pastTitleName">
            <img src="../../assets/images/background/trend.png" alt="" />
            <span>回顾</span>
          </div>
          <div class="pastMore" @click="goTo('/activity/academy')">更多+</div>
        </div>
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
    margin-bottom: 20px;
    position: relative;
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

  .academicTrendDetail {
    width: 100%;
  }
  .futureAcademicTrend {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 1rem;
  }

  .futureTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    margin-bottom: 0.5rem;
  }
  .futureTitleName {
    display: flex;
    flex-direction: row;
    background: #4b74bb;
    font-weight: bold;
    font-size: 1.8rem;
    border: 1px solid transparent;
    color: #fff;
    width: 10rem;
    height: 4rem;
  }
  .futureTitleName img {
    width: 3rem;
    height: 3rem;
    margin-top: 3px;
    padding: 0 1rem;
    line-height: 4rem;
  }
  .futureTitleName span {
    line-height: 4rem;
  }
  .futureMore {
    cursor: pointer;
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.6rem;
    height: 4rem;
    line-height: 4rem;
    color: #444;
  }
  .futureMore:hover {
    color: #0055a2;
  }
  .futureItem {
    width: 50%;
    display: flex;
    flex-direction: column;
    padding-right: 10px;
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
    -webkit-line-clamp: 2;
    line-clamp: 2;
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
    display: flex;
    width: 100%;
    flex-direction: row;
    margin-bottom: 0.5rem;
  }
  .pastTitleName {
    display: flex;
    flex-direction: row;
    background: #4b74bb;
    font-weight: bold;
    font-size: 1.8rem;
    border: 1px solid transparent;
    color: #fff;
    width: 10rem;
    height: 4rem;
  }
  .pastTitleName img {
    width: 3rem;
    height: 3rem;
    margin-top: 3px;
    padding: 0 1rem;
    line-height: 4rem;
  }
  .pastTitleName span {
    line-height: 4rem;
  }
  .pastMore {
    cursor: pointer;
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.6rem;
    height: 4rem;
    line-height: 4rem;
    color: #444;
  }
  .pastMore:hover {
    color: #0055a2;
  }
  .pastItem {
    width: 50%;
    display: flex;
    flex-direction: column;
    padding-right: 10px;
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
    -webkit-line-clamp: 2;
    line-clamp: 2;
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
/* 移动端 */
@media screen and (max-width: 1000px) {
  .academicTrend {
    width: 100%;
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

  .academicTrendDetail {
    display: flex;
    flex-direction: column;
  }
  .futureAcademicTrend {
    width: 100%;
    display: flex;
    flex-direction: column;
  }
  .futureTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    margin-bottom: 1rem;
  }
  .futureTitleName {
    display: flex;
    flex-direction: row;
    background: #4b74bb;
    font-weight: bold;
    font-size: 1.8rem;
    border: 1px solid transparent;
    color: #fff;
    width: 80px;
    height: 30px;
  }
  .futureTitleName img {
    width: 20px;
    height: 20px;
    margin-top: 3px;
    padding: 0 10px;
    line-height: 30px;
  }
  .futureTitleName span {
    line-height: 30px;
  }
  .futureMore {
    cursor: pointer;
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.6rem;
    height: 30px;
    line-height: 30px;
    color: #444;
  }
  .futureMore:hover {
    color: #0055a2;
  }

  .futureItem {
    width: 100%;
    margin-bottom: 5px;
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
    flex-direction: column;
  }
  .pastTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    margin-bottom: 1rem;
  }
  .pastTitleName {
    display: flex;
    flex-direction: row;
    background: #4b74bb;
    font-weight: bold;
    font-size: 1.8rem;
    border: 1px solid transparent;
    color: #fff;
    width: 80px;
    height: 30px;
  }
  .pastTitleName img {
    width: 20px;
    height: 20px;
    margin-top: 3px;
    padding: 0 10px;
    line-height: 30px;
  }
  .pastTitleName span {
    line-height: 30px;
  }
  .pastMore {
    cursor: pointer;
    flex: 1 1 auto;
    text-align: right;
    font-size: 1.6rem;
    height: 30px;
    line-height: 30px;
    color: #444;
  }
  .pastMore:hover {
    color: #0055a2;
  }
  .pastItem {
    width: 100%;
    margin-bottom: 5px;
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
