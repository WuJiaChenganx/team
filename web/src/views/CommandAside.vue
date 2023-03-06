<template>
  <!-- 侧边菜单栏使用 -->
  <div>
    <el-menu :default-active="this.$route.path" router>
      <!-- <el-submenu index="2"> -->
      <el-menu-item index="/home">我的题目</el-menu-item>
      <el-menu-item index="/myexam">我的试卷</el-menu-item>
      <el-menu-item index="/myrepo">我的试卷库</el-menu-item>
      <el-menu-item index="/mytest">我的考试记录</el-menu-item>
      <!-- </el-submenu> -->
    </el-menu>
  </div>
</template>
