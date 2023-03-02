<template>
  <div class="friendlyLink">
    <div class="right-title-box">
      <div class="right-title">友情链接</div>
      <a href="//nlp.ict.ac.cn/yqlj/" class="title-more">更多 +</a>
    </div>
    <div id="last-content-box">
      <ul class="link-ul">
        <li>
          <a
            href="//iip.ict.ac.cn/"
            title="智能信息处理重点实验室"
            class="link-a"
            target="_blank"
          >
            智能信息处理重点实验室
          </a>
        </li>

        <li>
          <a
            href="//www.ict.ac.cn/"
            title="计算技术研究所"
            class="link-a"
            target="_blank"
          >
            计算技术研究所
          </a>
        </li>

        <li>
          <a
            href="//www.cas.cn/"
            title="中国科学院"
            class="link-a"
            target="_blank"
          >
            中国科学院
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
.right-title-box {
  padding: 12px 20px 12px 15px;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.right-title-box::before,
.right-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.right-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.right-title-box::after {
  top: 0px;
  bottom: 0;
  left: 161px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.right-title-box .right-title {
  float: left;
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
  color: #ffffff;
  display: inline-block;
}
.right-title-box .title-more {
  float: right;
  position: absolute;
  right: 0;
  bottom: 0;
  color: #7db0cb;
  line-height: 18px;
}
.link-ul {
  padding: 0 22px 18px 22px;
  min-height: 176px;
}
.link-ul li {
  list-style: none;
  margin-bottom: 6px;
}
.link-ul li:last-child {
  margin-bottom: 0;
}
.link-a {
  display: block;
  font-size: 17px;
  color: #333333;
  line-height: 22px;
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