<template>
  <!-- 科研方向 -->
  <div>
    <researchDirection></researchDirection>
  </div>
</template>

<script>
import researchDirection from "../../components/scientificResearch/direction.vue";
export default {
  data: function () {
    return {};
  },
  created: function () {},
  components: {
    // 注册组件
    researchDirection,
  },
};
</script>
<style></style>
