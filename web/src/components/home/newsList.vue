<template>
  <!-- 消息列表 -->
  <el-card class="box-card" shadow="never">
    <div slot="header" class="clearfix">
      <span class="text">新闻快讯</span>
      <!-- <div>更多</div> -->
      <span class="more">更多</span>
    </div>
    <div class="news">
      <!-- 添加设置跳转功能 -->
      <div class="news-row" style="cursor: pointer">
        <div class="news-date">
          <div>18</div>
          <div>2021.11</div>
        </div>
        <div class="news-title">课题组张恒聪同学荣获硕士奖</div>
      </div>
      <div class="news-row" style="cursor: pointer">
        <div class="news-date">
          <div>18</div>
          <div>2021.11</div>
        </div>
        <div class="news-title">课题组张恒聪同学荣获硕士奖</div>
      </div>
      <div class="news-row" style="cursor: pointer">
        <div class="news-date">
          <div>18</div>
          <div>2021.11</div>
        </div>
        <div class="news-title">课题组张恒聪同学荣获硕士奖</div>
      </div>
      <div class="news-row" style="cursor: pointer">
        <div class="news-date">
          <div>18</div>
          <div>2021.11</div>
        </div>
        <div class="news-title">课题组张恒聪同学荣获硕士奖</div>
      </div>
    </div>
  </el-card>
</template>

<style scoped>
.box-card {
  background-color: #deecf9;
}
.clearfix {
  /* 移动到第0行出现小手 */
  cursor: pointer;
}
.clearfix .text {
  font-size: 22px;
  font-weight: bold;
  color: #003266;
  line-height: 28px;
  float: left;
}
.clearfix .more {
  float: right;
  font-size: 14px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.news {
  display: flex;
  flex-direction: column;
  height: 340px;
}
.news-row {
  margin-bottom: 10px;
}
/* 时间框 */
.news-row .news-date {
  float: left;
  width: 58px;
  height: 58px;
  background: #008cd6;
  border-radius: 2px;
  margin-right: 15px;
  /* 时间数字的颜色 */
  color: #ffffff;
  font-family: Arial;
  line-height: 22px;
  font-size: 12px;
  text-align: center;
  padding-top: 11px;
}
/* 就是日期中有个要变大 */
.news-row .news-date div:first-child {
  font-size: 30px;
  font-weight: bold;
}
/* 文字部分 */
.news-row .news-title {
  font-size: 17px;
  color: #0055a2;
  display: -webkit-box;
  overflow: hidden;
  height: 69px;
  line-height: 30px;
  font-weight: bold;
}
</style>



