<template>
  <!-- 轮播图 -->
  <div>
    <el-carousel
      :interval="4000"
      indicator-position="outside"
      class="photo"
      height="40rem"
    >
      <el-carousel-item
        v-for="(item, index) in imgArr"
        :key="index"
        @click.native="goTo('/activity/newFlash')"
        style="cursor: pointer"
      >
        <img :src="item" alt="" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imgArr: [
        require("../../assets/images/activity/activity1.png"),
        require("../../assets/images/activity/activity2.png"),
        require("../../assets/images/activity/activity3.png"),
        require("../../assets/images/activity/activity4.png"),
        require("../../assets/images/activity/activity5.png"),
      ],
    };
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
  },
};
</script>
<style scoped>
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
