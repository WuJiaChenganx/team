<template>
  <div class="international">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="internationalContent">
      <div class="breadCrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">{{
            pageItem.home
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/cooperation' }">{{
            pageItem.allTitle
          }}</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/cooperation/international' }">{{
            pageItem.subTitle
          }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="internationalAside">
        <div class="internationalAsideTitle">
          <span>
            <img src="../../assets/images/background/asideTitle.png" alt="" />{{
              pageItem.allTitle
            }}
          </span>
        </div>
        <div class="internationalAsideContent">
          <el-menu :default-active="this.$route.path" router text-color="#444">
            <el-menu-item
              class="internationalAsideItem"
              v-for="(menuItem, menuIndex) in menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <span>
                <img
                  src="../../assets/images/background/asideSubtitle.png"
                  alt=""
                />
                {{ menuItem.name }}
              </span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="internationalDetail">
        <div class="internationalTitle">
          {{ pageItem.subTitle }}
        </div>
        <div
          class="internationalItem"
          v-for="(detailItem, detailIndex) in internationals"
          :key="detailIndex"
        >
          <div class="internationalItemName">
            <img src="../../assets/images/background/list.png" alt="" />
            {{ detailItem.name }}
          </div>
          <div class="internationalItemUrl">
            <a
              :href="detailItem.url"
              target="_blank"
              class="internationalItemLink"
            >
              [ 详情 ]
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getInternationalURL } from "@/api/api";
export default {
  data() {
    return {
      pageItem: {},
      chineseItem: {
        allTitle: "交流合作",
        subTitle: "国际交流",
        home: "首页",
      },
      englishItem: {
        allTitle: "Cooperation",
        subTitle: "International",
        home: "home",
      },
      menu: [],
      menuZH: [
        { name: "国内交流", path: "/cooperation/domestic" },
        { name: "国际交流", path: "/cooperation/international" },
      ],
      menuEN: [
        { name: "Domestic", path: "/cooperation/domestic" },
        { name: "International", path: "/cooperation/international" },
      ],
      internationals: [],
    };
  },
  created() {
    this.getInternationalList();
    this.changUI();
  },
  methods: {
    changUI() {
      if (this.$store.getters.getLanguageType == "Chinese") {
        this.menu = this.menuZH;
        this.pageItem = this.chineseItem;
      } else if (this.$store.getters.getLanguageType == "English") {
        this.menu = this.menuEN;
        this.pageItem = this.englishItem;
      }
    },
    // async和await用于同步,就是按顺序执行
    async getInternationalList() {
      let params = {
        languageType: this.$store.getters.getLanguageType,
      };
      await getInternationalURL(params).then((res) => {
        this.internationals = res.data;
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .international {
    width: 100%;
  }
  .internationalContent {
    width: 85%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    margin-bottom: 15px;
  }
  .breadCrumb {
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
    margin-bottom: 15px;
  }
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }

  .internationalAside {
    width: 20%;
    padding-right: 30px;
  }

  .internationalAsideTitle {
    background: #fff;
    height: 47px;
    border-top: 3px solid #0c568e;
    border-bottom: 1px solid #0c568e;
    margin-bottom: 2px;
  }
  .internationalAsideTitle span {
    float: left;
    height: 47px;
    line-height: 47px;
    font-size: 20px;
    color: #4b74bb;
    font-weight: bold;
  }
  .internationalAsideTitle span img {
    float: left;
    margin-top: 15px;
    margin-left: 5px;
    margin-right: 10px;
  }
  .internationalAsideContent {
    width: 100%;
  }
  /* 去除侧边栏自带的边框 */
  .el-menu {
    border: none !important;
  }
  /* 去除侧边导航自带的边距 */
  .el-menu-item {
    padding: 0 !important;
  }
  /* 侧边栏悬浮的背景颜色 */
  .el-menu-item:hover {
    color: #fff !important;
    font-weight: bold;
    background-color: #4b74bb;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    color: #fff;
    font-weight: bold;
    background-color: #4b74bb;
  }

  .internationalAsideItem {
    position: relative;
    width: 100%;
    height: 46px;
    line-height: 46px;
    font-size: 18px;
    text-align: left;
    cursor: pointer;
    border-bottom: 1px solid #dfdfdf;
  }
  /* 最后一个侧边栏没有下划线 */
  .internationalAsideItem:last-child {
    border-bottom: none;
  }
  .internationalAsideItem span {
    font-size: 18px;
    line-height: 46px;
  }

  .internationalAsideItem span img {
    height: 18px;
    width: 18px;
    line-height: 46px;
    margin-top: -3px;
    padding: 8px 12px;
  }
  .internationalDetail {
    flex: 1 1 auto;
    min-height: calc(100vh - 29rem - 58px);
  }

  .internationalTitle {
    font-size: 22px;
    font-weight: bold;
    line-height: 40px;
    color: #113f95;
    margin: 15px 0;
  }

  .internationalItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    border-bottom: 1px dashed #b2b2b2;
  }
  .internationalItemName {
    width: 80%;
    text-align: left;
    font-size: 1.8rem;
    line-height: 3.5rem;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .internationalItemName img {
    width: 15px;
    height: 15px;
  }
  .internationalItemUrl {
    flex: 1 1 auto;
    text-align: right;
  }
  .internationalItemLink {
    font-size: 1.8rem;
    line-height: 3.5rem;
    text-decoration: none;
    color: #7db0cb;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .international {
    width: 100%;
  }
  .internationalContent {
    display: flex;
    flex-direction: column;
  }

  .internationalAside {
    order: 1;
    background: url(../../assets/images/background/contentBackground.jpg) center
      0 no-repeat;
    background-size: cover;
  }
  .internationalAsideTitle {
    font-size: 20px;
    padding: 10px 1.6%;
    line-height: 30px;
    font-weight: bold;
    text-align: left;
    color: #014da1;
  }
  .internationalAsideTitle span img {
    display: none;
  }
  /* 菜单横向排列 */
  .el-menu {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    width: 100%;
    background-color: rgba(0, 0, 0, 0) !important;
  }

  .el-menu-item {
    padding: 0 !important;
    border: 1px solid #ccc;
    width: 30%;
    line-height: 36px;
    height: 40px;
    margin: 0 1.6% 15px;
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
    background-color: #fff;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #014da1;
    color: #fff;
    font-weight: bold;
    border: #014da1 solid 1px;
  }
  .internationalAsideItem span img {
    display: none;
  }
  .breadCrumb {
    order: 2;
    width: 100%;
    background: #eee;
    box-sizing: border-box;
    padding: 10px 15px;
  }
  /* 不被选中时的颜色 */
  .el-breadcrumb ::v-deep .el-breadcrumb__inner {
    color: #999 !important;
    font-weight: 400 !important;
  }
  /* 被选中时的颜色 */
  .el-breadcrumb__item:last-child ::v-deep .el-breadcrumb__inner {
    color: black !important;
    font-weight: 800 !important;
  }
  .internationalDetail {
    order: 3;
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    min-height: calc(100vh - 29rem - 139px);
  }
  .internationalTitle {
    font-size: 3rem;
    font-weight: bold;
    line-height: 36px;
    color: #113f95;
    margin: 1rem 0;
  }
  .internationalItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    border-bottom: 1px dashed #b2b2b2;
  }
  .internationalItemName {
    width: 80%;
    text-align: left;
    font-size: 1.8rem;
    line-height: 3.5rem;
    display: -webkit-box;
    /* 一行直接省略 */
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
  }
  .internationalItemName img {
    width: 10px;
    height: 10px;
  }
  .internationalItemUrl {
    flex: 1 1 auto;
    text-align: right;
  }
  .internationalItemLink {
    font-size: 1.8rem;
    line-height: 3.5rem;
    text-decoration: none;
    color: #7db0cb;
  }
}
</style>
