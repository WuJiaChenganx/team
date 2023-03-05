<template>
  <!-- 团队简介 -->
  <div>
    <teamProfile></teamProfile>
  </div>
</template>

<script>
import teamProfile from "../../components/team/profile.vue";
export default {
  data: function () {
    return {};
  },
  created: function () {},
  components: {
    // 注册组件
    teamProfile,
  },
};
</script>
<style></style>
