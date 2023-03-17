<template>
  <!-- 这里的ID是绑定下面的css用的 -->
  <div id="app">
    <navigationBar></navigationBar>
    <router-view> </router-view>
    <myFooter></myFooter>
  </div>
</template>

<script>
import navigationBar from "./components/public/navigationBar.vue";
import myFooter from "./components/public/myFooter.vue";
// 导入组件
export default {
  name: "app",

  data() {
    return {};
  },
  components: {
    // 注册组件
    navigationBar,
    myFooter,
  },
  methods: {},
  created() {},
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
