<template>
  <div class="friendlyLink">
    <div class="link-title-box">
      <div class="link-title">友情链接</div>
      <a class="title-more">更多 +</a>
    </div>
    <div id="link-content-box">
      <div class="links">
        <a
          href="http://www.cs.zjut.edu.cn/html/index.html"
          class="linkUrl"
          target="_blank"
        >
          计算机学院官网
        </a>
        <a
          href="http://www.soft.zjut.edu.cn/index.do"
          class="linkUrl"
          target="_blank"
        >
          E度空间
        </a>
        <a href="http://www.news.zjut.edu.cn/" class="linkUrl" target="_blank">
          工大要闻
        </a>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
.friendlyLink {
  display: flex;
  flex-direction: column;
  height: 100%;
}
.link-title-box {
  overflow: hidden;
  margin-bottom: 2rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.link-title {
  text-align: left;
  font-size: 2.2rem;
  font-weight: bold;
  color: #003266;
}
.title-more {
  font-size: 1.4rem;
  color: #7db0cb;
  line-height: 1.8rem;
  cursor: pointer;
}

.linkUrl {
  margin-bottom: 1rem;
  /* 去掉a标签自带的格式 */
  text-decoration: none;
  display: block;
  font-size: 1.7rem;
  color: #333333;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  position: relative;
  padding-left: 20px;
  text-decoration: none;
  text-align: left;
}
/* before伪元素加载元素的最前面且伪元素必须要要有content字段 */
.linkUrl::before {
  position: absolute;
  content: "";
  width: 9px;
  height: 9px;
  left: 0;
  top: 8px;
  background: url(../../assets/images/background/zryy-link-icon.png) no-repeat
    center center;
}
</style>
