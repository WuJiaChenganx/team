<template>
  <div class="friendlyLink">
    <div class="link-title-box">
      <div class="link-title">{{ pageItem.title }}</div>
      <a class="title-more">{{ pageItem.more }} >></a>
    </div>
    <div class="link-content-box">
      <div class="links">
        <a
          href="http://www.cs.zjut.edu.cn/html/index.html"
          class="linkUrl"
          target="_blank"
          >{{ pageItem.officialWebsite }}
        </a>
        <a
          href="http://www.soft.zjut.edu.cn/index.do"
          class="linkUrl"
          target="_blank"
          >{{ pageItem.eSpace }}
        </a>
        <a href="http://www.news.zjut.edu.cn/" class="linkUrl" target="_blank">
          {{ pageItem.officialNews }}
        </a>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        title: "友情链接",
        more: "更多",
        officialWebsite: "计算机学院官网",
        eSpace: "E度空间",
        officialNews: "工大要闻",
      },
      englishItem: {
        title: "Links",
        more: "more",
        officialWebsite: "Officials",
        eSpace: "E-Space",
        officialNews: "Official-News",
      },
    };
  },
  created() {
    this.changUI();
  },
  methods: {
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.pageItem = this.englishItem;
      }
    },
  },
};
</script>
<style scoped>
.friendlyLink {
  display: flex;
  flex-direction: column;
  height: 100%;
}
.link-title-box {
  padding: 12px 20px 12px 15px;
  margin-bottom: 20px;
  position: relative;
  overflow: hidden;
}
.link-title-box::before,
.link-title-box::after {
  position: absolute;
  content: "";
  z-index: -1;
  height: 50px;
}
.link-title-box::before {
  width: 162px;
  top: 0;
  bottom: 0;
  left: 0;
  background: url(../../assets/images/background/zryy-r-title1.png) no-repeat
    left center;
}
.link-title-box::after {
  top: 0px;
  bottom: 0;
  left: 162px;
  right: 0;
  background: url(../../assets/images/background/zryy-r-title2.png) no-repeat
    top center;
  background-size: 100% 50px !important;
}
.link-title {
  text-align: left;
  font-size: 20px;
  font-weight: bold;
  color: #ffffff;
}
.title-more {
  position: absolute;
  right: 5px;
  bottom: 0;
  display: inline-block;
  color: #7db0cb;
  font-size: 16px;
  line-height: 18px;
  cursor: pointer;
}
.links {
  padding: 2rem;
  box-sizing: border-box;
}
.linkUrl {
  margin-bottom: 1rem;
  /* 去掉a标签自带的格式 */
  text-decoration: none;
  display: block;
  font-size: 17px;
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
  top: 6px;
  background: url(../../assets/images/background/zryy-link-icon.png) no-repeat
    center center;
}
</style>
