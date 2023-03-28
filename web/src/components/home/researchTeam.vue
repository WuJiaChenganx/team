<template>
  <div class="researchTeam">
    <div class="researchTitle">
      <div class="left-title">{{ pageItem.title }}</div>
      <a class="title-more" @click="goTo('team/profile')"
        >{{ pageItem.more }} >></a
      >
    </div>
    <div id="swiper-member">
      <!-- 如果没有的话就不显示 -->
      <div class="swiper-container" v-if="teamCover.length">
        <div class="swiper-wrapper">
          <div
            class="swiper-slide"
            v-for="(teamItem, teamItemIndex) in teamCover"
            :key="teamItemIndex"
            @click="gotoDetail(teamItem)"
          >
            <div class="memberBox">
              <div class="member-img">
                <img :src="teamItem.picUrl" @error="setDefaultImage" />
              </div>
              <div class="member-name">{{ teamItem.name }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// 引入JS部分
import Swiper from "swiper";
// 引入css部分
import "swiper/css/swiper.min.css";
import { getHomeMember } from "@/api/api";
// 设置默认缺失的图片
import defaultImage from "@/assets/images/member/default.png";
export default {
  data() {
    return {
      teamCover: [],
      pageItem: {},
      chineseItem: { title: "研究队伍", more: "更多" },
      englishItem: { title: "Team", more: "more" },
    };
  },
  created() {
    this.getTeamCoverList();
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
    async getTeamCoverList() {
      let params = {};
      await getHomeMember(params).then((res) => {
        this.teamCover = res.data;
      });
      new Swiper(".swiper-container", {
        // 最后一张和第一张无缝衔接
        loop: true,
        // 自动播放
        autoplay: {
          delay: 1500,
        },
        // 间距%2的轮播图宽度
        spaceBetween: "2%",
        // 一次显示几张照片,可以设置成auto,然后在css中设置swiper-slide的宽度
        // slidesPerView: this.teamCover.length,
        slidesPerView: "auto",
        // 每一次移动的时候移动1张
        slidesPerGroup: 1,
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
    gotoDetail(teamItem) {
      if (teamItem.memberType == "teacher") {
        // 跳转不覆盖页面
        window.open(teamItem.pageUrl, "_blank");
      } else {
        this.$router.push({
          name: "成员详情",
          path: "/team/memberInfo",
          query: {
            id: teamItem.id,
          },
        });
      }
    },
    // 设置默认缺失的图片
    setDefaultImage(e) {
      e.target.src = defaultImage;
    },
  },
};
</script>
<style scoped>
/* PC端 */
@media screen and (min-width: 1000px) {
  .researchTeam {
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  .researchTitle {
    padding-bottom: 13px;
    margin-bottom: 25px;
    position: relative;
    overflow: hidden;
  }
  .researchTitle::before {
    width: 163px;
    height: 39px;
    bottom: 0;
    left: 0;
    top: -2px;
    background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
      left center;
  }

  .researchTitle::before,
  .researchTitle::after {
    position: absolute;
    content: "";
  }
  .left-title {
    display: inline-block;
    font-size: 26px;
    line-height: 26px;
    font-style: italic;
    color: #0055a2;
    font-weight: bold;
    width: 100%;
    text-align: left;
  }
  .researchTitle .title-more {
    position: absolute;
    right: 0;
    bottom: 0;
    display: inline-block;
    color: #7db0cb;
    font-size: 16px;
    line-height: 18px;
    cursor: pointer;
  }
  .researchTitle::after {
    top: 0;
    left: 160px;
    right: 0;
    height: 4px;
    background: #deecf9;
  }
  /* 轮播图css */
  .swiper-container {
    width: 100%;
  }
  /* 去掉最后一张图片的右浮动 */
  .swiper-slide:last-child {
    margin-right: 0;
  }
  .swiper-slide {
    /* 宽度15%有6个,间隔2%在js的swiper中设置好了(且间隔有5个)*/
    width: 15%;
    text-align: center;
    font-size: 1.8rem;
    background: #fff;
  }

  .memberBox {
    display: flex;
    flex-direction: column;
    cursor: pointer;
    overflow: hidden;
  }

  .memberBox .member-img {
    overflow: hidden;
    margin-bottom: 1rem;
  }

  .member-img img {
    /* 高度自适应 */
    width: 80%;
    height: 15rem;
  }
  .member-img:hover img {
    transform: scale(1.05);
    transition: all 0.5s;
  }
  .member-name {
    font-size: 1.5rem;
    color: #444444;
    text-align: center;
    font-weight: bold;
  }

  .memberBox:hover .member-name {
    color: #0055a2;
  }
}

/* 移动端 */
@media screen and (max-width: 1000px) {
  .researchTeam {
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  .researchTitle {
    padding-bottom: 13px;
    margin-bottom: 25px;
    position: relative;
    overflow: hidden;
  }
  .researchTitle::before {
    width: 163px;
    height: 39px;
    bottom: 0;
    left: 0;
    top: -2px;
    background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
      left center;
  }

  .researchTitle::before,
  .researchTitle::after {
    position: absolute;
    content: "";
    z-index: -1;
  }
  .left-title {
    display: inline-block;
    font-size: 20px;
    line-height: 26px;
    font-style: italic;
    color: #0055a2;
    font-weight: bold;
    width: 100%;
    text-align: left;
  }
  .researchTitle .title-more {
    position: absolute;
    right: 0;
    bottom: 0;
    display: inline-block;
    color: #7db0cb;
    font-size: 16px;
    line-height: 18px;
    cursor: pointer;
  }
  .researchTitle::after {
    top: 0;
    left: 160px;
    right: 0;
    height: 4px;
    background: #deecf9;
  }
  /* 轮播图css */
  .swiper-container {
    width: 100%;
  }
  /* 去掉最后一张图片的右浮动 */
  .swiper-slide:last-child {
    margin-right: 0;
  }
  .swiper-slide {
    /* 宽度15%有6个,间隔2%在js的swiper中设置好了(且间隔有5个)*/
    width: 15%;
    text-align: center;
    font-size: 1.8rem;
    background: #fff;
  }

  .memberBox {
    display: flex;
    flex-direction: column;
    cursor: pointer;
    overflow: hidden;
  }
  .memberBox .member-img {
    overflow: hidden;
    margin-bottom: 1rem;
  }
  .member-img img {
    /* 高度自适应 */
    width: 80%;
    height: 8rem;
  }
  .member-name {
    font-size: 1.5rem;
    color: #444444;
    text-align: center;
    font-weight: bold;
  }

  .memberBox:hover .member-img img {
    transform: scale(1.1);
    transition: all 0.5s;
  }
  .memberBox:hover .member-name {
    color: #0055a2;
  }
}
</style>
