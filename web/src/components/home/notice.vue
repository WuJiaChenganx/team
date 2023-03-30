<template>
  <!-- 首页的通知公告-->
  <div class="notice">
    <div class="notice-title-box">
      <div class="notice-title">{{ pageItem.title }}</div>
      <a class="title-more" @click="goTo('/activity/notice')"
        >{{ pageItem.more }}+</a
      >
    </div>
    <div class="notice-content-box">
      <div
        class="noticeItem"
        v-for="noticeItem in noticeList"
        :key="noticeItem.id"
        @click="gotoDetail(noticeItem.id)"
      >
        <div class="notice-date">
          {{ noticeItem.date }}-{{ noticeItem.day }}
        </div>
        <div class="notice-thing">
          {{ noticeItem.title }}
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getNoticeURL } from "@/api/api";
export default {
  data() {
    return {
      // 要展示的公告信息
      noticeList: [],
      pageItem: {},
      chineseItem: { title: "通知公告", more: "更多" },
      englishItem: { title: "Notices", more: "more" },
    };
  },
  created() {
    this.getNoticeList();
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
    // async和await用于同步,就是按顺序执行
    async getNoticeList() {
      let params = {
        // 定义参数
        start: 0,
        end: 3,
        languageType: this.$store.getters.getLanguageType,
      };
      await getNoticeURL(params).then((res) => {
        this.noticeList = res.data;
      });
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/activity/noticeDetail",
        name: "通知公告详情",
        query: {
          id: id,
        },
      });
    },
    goTo(path) {
      // 当前不一样就跳转
      if (this.$route.path !== path) {
        this.$router.push({
          path: path,
        });
      }
    },
  },
};
</script>
<style scoped>
.notice-title-box {
  overflow: hidden;
  margin-bottom: 2rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.notice-title {
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
.notice-content-box {
  overflow: hidden;
  height: auto;
  width: 100%;
}
.noticeItem {
  cursor: pointer;
  display: flex;
  flex-direction: column;
  text-align: left;
  font-size: 1.5rem;
  line-height: 3rem;
  margin-bottom: 0.5rem;
}
.noticeItem:hover .notice-date {
  color: #333333;
}
.noticeItem:hover .notice-thing {
  color: #008cd6;
}
.noticeItem .notice-date {
  text-align: left;
  color: #008cd6;
  font-size: 2rem;
  font-weight: bold;
}
.noticeItem .notice-thing {
  /* 最多两行,超出两行的直接省略 */
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  color: #333333;
  font-size: 1.5rem;
}
</style>
