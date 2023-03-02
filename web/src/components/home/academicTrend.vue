<template>
  <div class="academicTrend">
    <div class="academicTitle">
      <div class="left-title">学术动态</div>
      <a href="//nlp.ict.ac.cn/yjdw/" class="title-more">更多 +</a>
    </div>

    <div class="academicContent">
      <div class="item-content">
        <div class="img-box">
          <img
            src="//nlp.ict.ac.cn/xsdt/202302/W020230209696876023484.png"
            alt=""
          />
        </div>
        <div class="item-text">
          <div class="title-box">NLP组7篇论文被ACL 2022接收</div>
          <div class="detail-box">
            课题组今年有7篇论文被ACL 2022接收，
            其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The
            60th Annual Meeting of the Association for Computational
            Linguistics，是自然语言处理领域国际顶级会议之一；Findings of
            ACL是ACL 2021引入的在线附属出版物。
          </div>
          <div class="academicDate">2022-12-17</div>
        </div>
      </div>
      <div class="item-content">
        <div class="img-box">
          <img
            src="//nlp.ict.ac.cn/xsdt/202302/W020230209696876023484.png"
            alt=""
          />
        </div>
        <div class="item-text">
          <div class="title-box">NLP组7篇论文被ACL 2022接收</div>
          <div class="detail-box">
            课题组今年有7篇论文被ACL 2022接收，
            其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The
            60th Annual Meeting of the Association for Computational
            Linguistics，是自然语言处理领域国际顶级会议之一；Findings of
            ACL是ACL 2021引入的在线附属出版物。
          </div>
          <div class="academicDate">2022-12-17</div>
        </div>
      </div>
      <div class="item-content">
        <div class="img-box">
          <img
            src="//nlp.ict.ac.cn/xsdt/202302/W020230209696876023484.png"
            alt=""
          />
        </div>
        <div class="item-text">
          <div class="title-box">NLP组7篇论文被ACL 2022接收</div>
          <div class="detail-box">
            课题组今年有7篇论文被ACL 2022接收，
            其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The
            60th Annual Meeting of the Association for Computational
            Linguistics，是自然语言处理领域国际顶级会议之一；Findings of
            ACL是ACL 2021引入的在线附属出版物。
          </div>
          <div class="academicDate">2022-12-17</div>
        </div>
      </div>
      <div class="item-content">
        <div class="img-box">
          <img
            src="//nlp.ict.ac.cn/xsdt/202302/W020230209696876023484.png"
            alt=""
          />
        </div>
        <div class="item-text">
          <div class="title-box">NLP组7篇论文被ACL 2022接收</div>
          <div class="detail-box">
            课题组今年有7篇论文被ACL 2022接收，
            其中6篇论文被ACL主会录用，1篇被findings of ACL录用。ACL全称是The
            60th Annual Meeting of the Association for Computational
            Linguistics，是自然语言处理领域国际顶级会议之一；Findings of
            ACL是ACL 2021引入的在线附属出版物。
          </div>
          <div class="academicDate">2022-12-17</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
.academicTitle {
  width: 100%;
  height: 38px;
  padding-bottom: 0;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}
.academicTitle::before,
.academicTitle::after {
  position: absolute;
  content: "";
  z-index: -1;
}
.academicTitle::before {
  width: 163px;
  height: 39px;
  bottom: 0;
  left: 0;
  top: 0;
  background-color: #fff;
  background: url(../../assets/images/background/zryy-l-title1.png) no-repeat
    left center;
}
.academicTitle::after {
  top: 0px;
  left: 160px;
  right: 0;
  height: 4px;
  background: #deecf9;
}
.academicTitle .left-title {
  float: left;
  font-size: 22px;
  font-weight: bold;
  font-style: italic;
  color: #003266;
  line-height: 26px;
}
.academicTitle .title-more {
  float: right;
  position: absolute;
  right: 0;
  bottom: 0;
  color: #7db0cb;
  line-height: 18px;
}
.academicContent {
  /* 放四个盒子高度为110,margin_bottom为20 */
  height: 520px;
}
/* 每行的宽高 */
.academicContent .item-content {
  height: 110px;
  margin-bottom: 20px;
}
.item-content .img-box {
  float: left;
  width: 168px;
  height: 112px;
  overflow: hidden;
  margin-right: 18px;
  box-sizing: border-box;
}
.item-content .img-box img {
  width: 100%;
  height: 100%;
}
.item-content .img-box {
  border: 1px solid #eee;
}
.item-content:hover .img-box img {
  transform: scale(1.1);
  transition: all 0.5s;
}

.item-content:hover .title-box {
  color: #ff2400;
}
.item-content:hover .academicDate {
  color: #0055a2;
}

.item-text {
  height: 100%;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.item-text .title-box {
  text-align: left;
  font-size: 17px;
  font-weight: bold;
  color: #0055a2;
  line-height: 20px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  margin-bottom: 10px;
}
.item-text .detail-box {
  font-size: 13px;
  color: #909090;
  line-height: 19px;
  text-align: justify;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
  height: 57px;
  margin-bottom: 10px;
}
.item-text .academicDate {
  text-align: right;
  font-size: 14px;
  font-family: Arial;
  color: #828282;
  line-height: 1;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>