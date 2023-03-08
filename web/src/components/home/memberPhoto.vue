<template>
  <div id="swiper-member">
    <!-- 如果没有的话就不显示 -->
    <div class="swiper-container" v-if="studentAllInfo.length">
      <div class="swiper-wrapper">
        <div class="swiper-slide" v-for="item in studentAllInfo" :key="item.id">
          <!-- 可以加跳转 -->
          <div style="cursor: pointer" class="memberBox">
            <div class="member-img">
              <img :src="item.picUrl" />
            </div>
            <div class="member-name">{{ item.name }}</div>
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
      studentAllInfo: [
        {
          id: 1,
          name: "张恒聪1",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "机器翻译、自然语言处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 2,
          name: "马云1",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 3,
          name: "马化腾1",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 4,
          name: "赵云2",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 5,
          name: "赵云1",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
        {
          id: 6,
          name: "赵云1",
          title: "硕士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/activity/00.jpg"),
        },
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
      // 一次显示几张照片
      slidesPerView: this.studentAllInfo.length,
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
</style>
>
