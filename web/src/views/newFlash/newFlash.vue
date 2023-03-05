<template>
  <!-- 新闻列表 -->
  <div>
    <newFlash></newFlash>
  </div>
</template>

<script>
import newFlash from "../../components/newFlash/newFlash.vue";
export default {
  data: function () {
    return {};
  },
  created: function () {},
  mounted: function () {},
  components: {
    // 注册组件
    newFlash,
  },
};
</script>
<style></style>
