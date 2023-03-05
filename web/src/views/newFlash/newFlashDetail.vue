<template>
  <!-- 新闻列表 -->
  <div>
    <newFlashDetail></newFlashDetail>
  </div>
</template>

<script>
import newFlashDetail from "../../components/newFlash/newFlashDetail.vue";
export default {
  data: function () {
    return {};
  },
  created: function () {},
  mounted: function () {},
  components: {
    // 注册组件
    newFlashDetail,
  },
};
</script>
<style></style>
