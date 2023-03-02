<template>
  <div class="noticeAndResearch">
    <div class="notice">
      <div class="notice-title-box">
        <div class="notice-title">通知公告</div>
        <a href="//nlp.ict.ac.cn/yqlj/" class="title-more">更多 +</a>
      </div>
      <div class="notice-content-box">
        <div class="noticeItem">
          <div class="notice-date">[ 2020-06-10 ]</div>
          <div class="notice-thing">
            中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事
          </div>
        </div>
        <div class="noticeItem">
          <div class="notice-date">[ 2020-06-10 ]</div>
          <div class="notice-thing">
            中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事
          </div>
        </div>
        <div class="noticeItem">
          <div class="notice-date">[ 2020-06-10 ]</div>
          <div class="notice-thing">
            中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事中科院计算所自然语言处理组招聘启事
          </div>
        </div>
      </div>
    </div>
    <div class="research">
      <div class="research-title-box">
        <div class="research-title">研究专题</div>
      </div>
      <div class="research-content-box">
        <div class="researchItem">
          <div class="researchTheme researchTheme1">研究专题一</div>
        </div>
        <div class="researchItem">
          <div class="researchTheme researchTheme2">研究专题二</div>
        </div>
        <div class="researchItem">
          <div class="researchTheme researchTheme3">研究专题三</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
.notice {
  width: 100%;
  height: 280px;
  margin-bottom: 15px;
  border: 1px solid #d1e4f0;
  border-radius: 4px;
  border-top: none;
}
.notice-title-box {
  padding: 12px 20px 12px 15px;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.notice-title-box::before,
.notice-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.notice-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.notice-title-box::after {
  top: 0px;
  bottom: 0;
  left: 161px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.notice-title-box .notice-title {
  text-align: left;
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
  color: #fff;
}
.notice-title-box .title-more {
  float: right;
  position: absolute;
  right: 0;
  bottom: 0;
  color: #7db0cb;
  line-height: 18px;
}
/* 文本信息居中 */
.notice-content-box {
  overflow: hidden;
  height: 195px;
  width: 350px;
  margin: 0 auto;
}
.noticeItem {
  display: block;
  font-size: 15px;
  line-height: 22px;
}
.noticeItem:hover .notice-date {
  color: #333333;
}
.noticeItem:hover .notice-thing {
  color: #008cd6;
}
.noticeItem .notice-date {
  float: left;
  color: #008cd6;
  margin-right: 10px;
}
.noticeItem .notice-thing {
  float: left;
  /* 最多两行,超出两行的直接省略 */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  color: #333333;
  font-size: 17px;
}

.research {
  width: 100%;
  height: 280px;
  border: 1px solid #d1e4f0;
  border-radius: 4px;
  border-top: none;
}
.research-title-box {
  padding: 12px 20px 12px 15px;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.research-title-box::before,
.research-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.research-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.research-title-box::after {
  top: 0px;
  bottom: 0;
  left: 161px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.research-title-box .research-title {
  text-align: left;
  font-size: 22px;
  font-weight: bold;
  line-height: 26px;
  color: #fff;
}

.research-content-box {
  overflow: hidden;
  height: 195px;
  width: 350px;
  margin: 0 auto;
}
.researchItem {
  display: block;
  height: 56px;
  margin-bottom: 9px;
  background-size: cover !important;
}
.researchTheme1 {
  background: url(../../assets/images/background/zryy-yjzt1.png) no-repeat
    center center;
}
.researchTheme2 {
  background: url(../../assets/images/background/zryy-yjzt2.png) no-repeat
    center center;
}
.researchTheme3 {
  margin-bottom: 0;
  background: url(../../assets/images/background/zryy-yjzt3.png) no-repeat
    center center;
}
.researchTheme {
  border-radius: 3px;
  font-size: 21px;
  font-weight: bold;
  color: #fff;
  line-height: 56px;
  text-align: center;
  height: 56px;
}
</style>