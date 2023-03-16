<template>
  <!-- 这里的ID是绑定下面的css用的 -->
  <div id="app">
    <div>我是无敌的</div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {},
  // 生命周期函数,created在创建的时候会自动调用
  created: function () {
    console.log("App组件被创建了");
    let params = {
      id: 1,
    };
    this.$http
      .get("/api/teamWeb/teamSurvey/require-detail", { params })
      .then((response) => {
        // 用箭头函数可以继承this如果用回调函数的话需要在外面用that把this保存起来
        console.log(response.data.data);
      });
  },
  // 和created差不多,mounted只是在挂载(渲染)的时候调用
  mounted: function () {
    // console.log("App被挂载完毕");
  },
  components: {
    // 注册组件
  },
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
