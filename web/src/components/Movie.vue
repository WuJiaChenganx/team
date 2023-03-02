<template>
  <!-- vue2需要一个根组件包括含所有的标签 -->
  <div>
    <h1>{{ joke + "我是无敌" }}</h1>
    <br />
    <br />
    <!-- <h1>{{ title }}</h1> -->
    <!-- <span>{{ rating }}</span> -->
    <!-- <button @click="fun">点击收藏</button> -->
  </div>
</template>

<script>
// 导出
export default {
  name: "Movie",
  // props表示的title和rating用来接收其他组件传进来的值(用于父子组件传值)
  props: ["joke", "rating"],
  data: function () {
    return {
      //   joke: "金刚狼",
    };
  },
  // 生命周期函数,created在创建的时候会自动调用
  created: function () {
    console.log("movie组件被创建了");
  },
  methods: {
    fun() {
      alert("收藏成功");
    },
  },
};
</script>