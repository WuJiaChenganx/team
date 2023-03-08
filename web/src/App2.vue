<template>
  <!-- 这里的ID是绑定下面的css用的 -->
  <div id="app">
    <!-- <div class="ad"><img alt="Vue logo" src="./assets/logo.png" /></div> -->

    <!-- 自定义组件 -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <div>
      <!-- <Movie
          v-for="movie in movies"
          :key="movie.id"
          :title="movie.title"
          :rating="movie.rating"
        ></Movie> -->
      <!-- <Movie v-for="(joke, index) in movies" :key="index" :joke="joke"></Movie> -->
    </div>
    <navigation></navigation>
  </div>
</template>

<script>
// 导入组件
import navigation from "./components/indexComponent/navigation.vue";
export default {
  name: "App",
  data: function () {
    return {
      movies: [
        // { id: 1, title: "金刚狼1", rating: 8.5 },
        // { id: 2, title: "金刚狼2", rating: 8.6 },
        // { id: 3, title: "金刚狼3", rating: 8.7 },
        // { id: 4, title: "金刚狼4", rating: 8.8 },
      ],
    };
  },
  // 生命周期函数,created在创建的时候会自动调用
  created: function () {
    console.log("App组件被创建了");
    let params = {
      start: 1,
      end: 5,
    };
    // this.$http.get("/api/teamWeb/home/news").then((response) => {
    //   // 用箭头函数可以继承this如果用回调函数的话需要在外面用that把this保存起来
    //   this.movies = response.data.data;
    //   console.log(this.movies[0]);
    // });
    this.$http.get("/api/teamWeb/home/news", { params }).then((response) => {
      // 用箭头函数可以继承this如果用回调函数的话需要在外面用that把this保存起来
      this.movies = response.data.data;
      console.log(this.movies[0]);
    });
    // this.$http
    //   .get("https://autumnfish.cn/api/joke/list?num=6")
    //   .then((response) => {
    //     // 用箭头函数可以继承this如果用回调函数的话需要在外面用that把this保存起来
    //     this.movies = response.data.data;
    //   });
  },
  // 和created差不多,mounted只是在挂载(渲染)的时候调用
  mounted: function () {
    // console.log("App被挂载完毕");
  },
  components: {
    // 注册组件
    navigation,
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
