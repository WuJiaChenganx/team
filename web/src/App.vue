<template>
  <!-- 这里的ID是绑定下面的css用的 -->
  <div id="app">
    <!-- 固定头 -->
    <!-- <header class="header">
      <navigationBar></navigationBar>
    </header> -->
    <router-view></router-view>
    <!-- 固定尾 -->
    <!-- <footer class="footer">
      <myFooter></myFooter>
    </footer> -->
  </div>
</template>

<script>
import navigationBar from "./components/navigationBar.vue";
import myFooter from "./components/myFooter.vue";
// 导入组件
export default {
  name: "app",
  components: {},
  data() {
    return {
      navigationBar,
      myFooter,
    };
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
