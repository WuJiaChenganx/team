<template>
  <!-- 轮播图 -->
  <div>
    <el-carousel
      :interval="4000"
      indicator-position="outside"
      class="photo"
      height="41rem"
    >
      <el-carousel-item v-for="(item, index) in imgArr" :key="index">
        <img :src="item" alt="" />
        <!-- 之后可以加图片注释和跳转功能 -->
        <!-- <a>{{ item }}</a> -->
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imgArr: [
        require("../../assets/images/activity/00.jpg"),
        require("../../assets/images/activity/01.jpg"),
        require("../../assets/images/activity/02.jpg"),
        require("../../assets/images/activity/03.jpg"),
        require("../../assets/images/activity/04.jpg"),
        require("../../assets/images/activity/05.jpg"),
        require("../../assets/images/activity/06.jpg"),
        require("../../assets/images/activity/07.jpg"),
        require("../../assets/images/activity/08.jpg"),
      ],
    };
  },
  methods: {},
};
</script>
<style>
.el-carousel__item a {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}
.el-carousel__item img {
  width: 100%;
  height: 100%;
}
</style>
