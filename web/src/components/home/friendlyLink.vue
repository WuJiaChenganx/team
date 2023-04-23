<template>
  <div class="friendlyLink">
    <div class="link-box">
      <div class="link-title">{{ pageItem.title }}</div>
      <div class="link-content-box">
        <div class="links">
          <a
            href="http://www.cs.zjut.edu.cn/html/index.html"
            class="linkUrl"
            target="_blank"
            >{{ pageItem.officialWebsite }}
          </a>
          |
          <a
            href="http://www.soft.zjut.edu.cn/index.do"
            class="linkUrl"
            target="_blank"
            >{{ pageItem.eSpace }}
          </a>
          |
          <a
            href="http://www.news.zjut.edu.cn/"
            class="linkUrl"
            target="_blank"
          >
            {{ pageItem.officialNews }}
          </a>
          |
        </div>
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
        title: "友情链接LINKS",
        more: "更多",
        officialWebsite: "计算机学院官网",
        eSpace: "E度空间",
        officialNews: "工大要闻",
      },
      englishItem: {
        title: "友情链接Links",
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
/* PC端  */
@media screen and (min-width: 1000px) {
  .friendlyLink {
    display: flex;
    flex-direction: row;
    /* 子元素对齐 */
    align-items: center;
  }
  .link-box {
    display: flex;
    flex-direction: row;
  }
  .link-title {
    color: #fff;
    font-size: 14px;
    padding: 5px 8px;
    background: #014da1;
  }
  .link-content-box {
    display: flex;
    flex-direction: row;
    /* 子元素对齐 */
    align-items: center;
    margin-left: 10px;
  }
  .links {
    font-size: 15px;
    padding: 0 10px;
    color: #666;
  }
  .linkUrl {
    color: #666;
    text-decoration: none;
  }
}
/* 移动端 */
@media screen and (max-width: 1000px) {
  .friendlyLink {
    display: flex;
    flex-direction: row;
    /* 子元素对齐 */
    align-items: center;
  }
  .link-box {
    display: flex;
    flex-direction: row;
  }
  .link-title {
    margin-left: 10px;
    color: #fff;
    font-size: 10px;
    padding: 5px 6px;
    background: #014da1;
  }
  .link-content-box {
    display: flex;
    flex-direction: row;
    /* 子元素对齐 */
    align-items: center;
    margin-left: 10px;
  }
  .links {
    font-size: 14px;
    padding: 0 10px;
    color: #666;
  }
  .linkUrl {
    color: #666;
    text-decoration: none;
  }
}
</style>
