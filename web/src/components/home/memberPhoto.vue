<template>
  <div id="swiper-member">
    <div class="swiper-container" v-if="photoURL.length">
      <div class="swiper-wrapper">
        <div class="swiper-slide" v-for="item in photoURL" :key="item">
          <!-- 可以加跳转 -->
          <div style="cursor: pointer" class="memberBox">
            <div class="member-img">
              <img :src="item" />
            </div>
            <div class="member-name">张民</div>
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
export default {
  data() {
    return {
      photoURL: [
        require("../../assets/images/member/00.jpg"),
        require("../../assets/images/member/01.jpg"),
        require("../../assets/images/member/02.jpg"),
        require("../../assets/images/member/03.jpg"),
        require("../../assets/images/member/04.jpg"),
        require("../../assets/images/member/05.jpg"),
        require("../../assets/images/member/06.jpg"),
        require("../../assets/images/member/07.jpg"),
        require("../../assets/images/member/08.jpg"),
        require("../../assets/images/member/09.jpg"),
        require("../../assets/images/member/10.jpg"),
      ],
    };
  },
  // 从后端拿数据
  created() {},
  mounted() {
    new Swiper(".swiper-container", {
      // 最后一张和第一张无缝衔接
      loop: true,
      // 自动播放
      autoplay: {
        delay: 1000,
      },
      // 间距15px
      spaceBetween: 15,
      // 一次显示7张照片
      slidesPerView: 7,
      // 每一次移动的时候移动1张
      slidesPerGroup: 1,
    });
  },
};
</script>
<style>
.swiper-container {
  height: 184px;
}
/* 去掉最后一张图片的右浮动 */
.swiper-slide:last-child {
  margin-right: 0;
}

.memberBox .member-name {
  font-size: 20px;
  color: #444444;
  line-height: 22px;
  text-align: center;
  font-weight: bold;
}
.memberBox .member-img {
  width: 110px;
  height: 132px;
  overflow: hidden;
  margin-bottom: 10px;
}
.memberBox .member-img img {
  width: 110px;
  height: 132px;
}
.memberBox:hover .member-img img {
  transform: scale(1.1);
  transition: all 0.5s;
}
.memberBox:hover .member-name {
  color: #0055a2;
}
</style>>
