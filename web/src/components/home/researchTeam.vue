<template>
  <div class="researchTeam">
    <div class="researchTeamTitle">
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
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
      // 间距%2的轮播图宽度
      spaceBetween: "2%",
      // 一次显示几张照片,可以设置成auto,然后在css中设置swiper-slide的宽度
      // slidesPerView: this.studentAllInfo.length,
      slidesPerView: "auto",
      // 每一次移动的时候移动1张
      slidesPerGroup: 1,
    });
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
