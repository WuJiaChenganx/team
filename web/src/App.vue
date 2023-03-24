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
  methods: {
    // 将store中的state对象存到sessionStorage
    saveState() {
      sessionStorage.setItem("state", JSON.stringify(this.$store.state));
    },
  },
  mounted() {
    // 刷新后保存这样可以使得刷新之后的state对象被存起来,然后在store里面设置,如果sessionStorage里面有数据就是刷新是保存的数据,没有的话直接加载初始化的state
    window.addEventListener("unload", this.saveState);
  },
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
