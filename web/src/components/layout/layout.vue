<template>
  <el-container>
    <el-header><navigation-bar></navigation-bar></el-header>
    <el-main><router-view></router-view></el-main>
    <el-footer><my-footer></my-footer></el-footer>
  </el-container>
</template>
<script>
import navigationBar from "../navigationBar.vue";
import myFooter from "../myFooter.vue";
export default {
  name: "layout",
  components: {
    myFooter,
    navigationBar,
  },
  data() {
    return {};
  },
};
</script>
<style></style>