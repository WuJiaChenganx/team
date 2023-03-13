<template>
  <div class="friendlyLink">
    <div class="link-title-box">
      <div class="link-title">友情链接</div>
      <a class="title-more">更多 +</a>
    </div>
    <div id="friend-content-box">
      <ul class="link-ul">
        <li>
          <a
            href="http://www.cs.zjut.edu.cn/html/index.html"
            title="浙江工业大学计算机学院"
            class="link-a"
            target="_blank"
          >
            浙江工业大学计算机学院
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
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
.link-ul {
  /* min-height: 176px; */
}
.link-ul li {
  list-style: none;
  margin-bottom: 0.6rem;
}
.link-ul li:last-child {
  margin-bottom: 0;
}
.link-a {
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
.link-a::before {
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
