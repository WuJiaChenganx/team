<template>
  <div class="researchTeam">
    <div class="researchTeamTitle">
      <div class="left-title">{{ pageItem.title }}</div>
      <a @click="goTo('team/profile')" class="title-more"
        >{{ pageItem.more }} +</a
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
      englishItem: { title: "News", more: "more" },
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
          delay: 1000,
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
      this.$router.push({
        name: "成员详情",
        path: "/team/memberInfo",
        query: {
          id,
        },
      });
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
  .researchTeamTitle {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 2rem;
  }
  .left-title {
    font-size: 2rem;
    font-weight: bold;
    color: #003266;
  }
  .researchTeamTitle .title-more {
    color: #7db0cb;
    font-size: 1.6rem;
    cursor: pointer;
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
  }
  .memberBox .member-img {
    overflow: hidden;
    margin-bottom: 1rem;
  }
  .member-img img {
    overflow: hidden;
    /* 高度自适应 */
    width: 80%;
    height: 12.5rem;
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
  .researchTeamTitle {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 2rem;
  }
  .left-title {
    font-size: 2rem;
    font-weight: bold;
    color: #003266;
  }
  .researchTeamTitle .title-more {
    color: #7db0cb;
    font-size: 1.6rem;
    cursor: pointer;
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
  }
  .memberBox .member-img {
    overflow: hidden;
    margin-bottom: 1rem;
  }
  .member-img img {
    /* 高度自适应 */
    width: 100%;
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
