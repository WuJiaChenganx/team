<template>
  <div class="researchTeam">
    <div class="left-title-box">
      <div class="left-title">研究队伍</div>
      <a @click="goTo('team/master')" class="title-more">更多 +</a>
    </div>
    <div id="swiper-member">
      <!-- 如果没有的话就不显示 -->
      <div class="swiper-container" v-if="studentAllInfo.length">
        <div class="swiper-wrapper">
          <div
            class="swiper-slide"
            v-for="item in studentAllInfo"
            :key="item.id"
            @click="gotoDetail(item)"
          >
            <!-- 可以加跳转 -->
            <div class="memberBox">
              <div class="member-img">
                <img :src="item.picUrl" />
              </div>
              <div class="member-name">{{ item.name }}</div>
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
    console.log();
    if (document.documentElement.clientWidth >= 1000) {
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
    } else {
      new Swiper(".swiper-container", {
        // 最后一张和第一张无缝衔接
        loop: true,
        // 自动播放
        autoplay: {
          delay: 1000,
        },
        // 一次显示几张照片
        slidesPerView: 1,
        // 每一次移动的时候移动1张
        slidesPerGroup: 1,
      });
    }
  },
  methods: {
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
    gotoDetail(item) {
      this.$router.push({
        path: "/team/studentInfo",
        name: "学生详情",
        // 用query传参,在地址栏后面加东西如 ?id=1这种跟在网址后面
        query: {
          // 传参数的时候注意将对象转化成字符串并且加密,在接收端使用解析
          // 如果不这样做的话就会导致,刷新一下传参的东西解析不了
          item: encodeURIComponent(JSON.stringify(item)),
        },
      });
    },
  },
};
</script>
<style scoped>
.left-title-box {
  width: 100%;
  height: 3.8rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 2rem;
}
.left-title {
  text-align: left;
  font-size: 2.2rem;
  font-weight: bold;
  color: #003266;
}
.title-more {
  text-align: right;
  color: #7db0cb;
  font-size: 1.4rem;
  line-height: 1.8rem;
  cursor: pointer;
}

/* PC端 */
@media screen and (min-width: 1000px) {
  /* 轮播图css */
  .swiper-container {
    height: 12rem;
  }
  /* 去掉最后一张图片的右浮动 */
  .swiper-slide:last-child {
    margin-right: 0;
  }

  .memberBox {
    display: flex;
    width: 7rem;
    flex-direction: column;
    justify-content: space-between;
    cursor: pointer;
  }
  .memberBox .member-img {
    height: 8rem;
    overflow: hidden;
    margin-bottom: 1rem;
  }
  .member-img img {
    width: 100%;
    height: 100%;
  }
  .memberBox .member-name {
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
/* 移动端 */
@media screen and (max-width: 1000px) {
  /* 轮播图css */
  .swiper-container {
    height: 18rem;
  }

  .memberBox {
    display: flex;
    width: 11rem;
    flex-direction: column;
    justify-content: space-between;
    cursor: pointer;
    margin: 0 auto;
  }
  .memberBox .member-img {
    height: 13rem;
    overflow: hidden;
    margin-bottom: 1rem;
  }
  .member-img img {
    width: 100%;
    height: 100%;
  }
  .memberBox .member-name {
    font-size: 2rem;
    color: #444444;
    text-align: center;
    font-weight: bold;
  }
}
</style>
