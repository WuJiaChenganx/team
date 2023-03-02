<template>
  <div>
    <div class="logoAndHeader">
      <navigationBar></navigationBar>
    </div>
    <div class="firstContainer">
      <!-- 内容展示 -->
      <div class="firstAllContent">
        <!-- 图片展示的盒子 -->
        <div class="firstPhotoContent">
          <activityPhoto></activityPhoto>
        </div>
        <div class="firstMessageContent">
          <newsList></newsList>
        </div>
      </div>
    </div>

    <div class="secondContainer">
      <div class="secondAllContent">
        <div class="second-left">
          <!-- hover问题没有解决 -->
          <!-- 放的是学术动态 -->
          <academicTrend></academicTrend>
        </div>
        <div class="second-right">
          <notice-and-research></notice-and-research>
        </div>
      </div>
    </div>

    <div class="lastContainer">
      <div class="lastAllContent">
        <div class="last-left">
          <div class="left-title-box">
            <!-- 放的团队成员上面的背景部分 -->
            <researchTeam></researchTeam>
          </div>
          <div class="left-content-box">
            <div>
              <!-- 放的是成员图像轮播图 -->
              <memberPhoto></memberPhoto>
            </div>
          </div>
        </div>
        <div class="last-right">
          <!-- 友情链接 -->
          <friendlyLink></friendlyLink>
        </div>
      </div>
    </div>
    <div>
      <myFooter></myFooter>
    </div>
  </div>
</template>

<script>
import newsList from "./newsList.vue";
import memberPhoto from "./memberPhoto.vue";
import friendlyLink from "./friendlyLink.vue";
import researchTeam from "./researchTeam.vue";
import myFooter from "./myFooter.vue";
import activityPhoto from "./activityPhoto.vue";
import academicTrend from "./academicTrend.vue";
import noticeAndResearch from "./noticeAndResearch.vue";
import navigationBar from "./navigationBar.vue";
export default {
  components: {
    newsList,
    memberPhoto,
    friendlyLink,
    researchTeam,
    myFooter,
    activityPhoto,
    academicTrend,
    noticeAndResearch,
    navigationBar,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
}

.firstContainer {
  height: 484px;
  background: #deecf9;
}

.firstContainer .firstAllContent {
  width: 75%;
  height: 100%;
  /* 居中对齐 */
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  /* 内减模式 */
  box-sizing: border-box;
}

.firstContainer > .firstAllContent .firstPhotoContent {
  margin-top: 20px;
  width: 60%;
}

.firstContainer > .firstAllContent .firstMessageContent {
  width: 39%;
  height: 410px;
}

.secondContainer {
  position: relative;
  height: 583px;
  background: #fff;
  margin-top: 20px;
  margin-bottom: 20px;
}
.secondContainer .secondAllContent {
  position: absolute;
  width: 75%;
  height: 100%;
  /* 起点移动到了参照物的50%位置 */
  left: 50%;
  /* 上面注释掉的可以用下面的来替代 位移宽度和高度的一半*/
  transform: translate(-50%);
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.second-left {
  width: 68%;
}
.second-right {
  width: 31%;
}
.lastContainer {
  position: relative;
  height: 247px;
  background: #fff;
  margin-bottom: 20px;
}
.lastContainer .lastAllContent {
  position: absolute;
  width: 75%;
  height: 100%;
  /* 起点移动到了参照物的50%位置 */
  left: 50%;
  /* 上面注释掉的可以用下面的来替代 位移宽度和高度的一半*/
  transform: translate(-50%);
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.last-left {
  width: 68%;
}
.lastContainer .lastAllContent .left-title-box {
  width: 100%;
  height: 38px;
  padding-bottom: 0;
  position: relative;
  overflow: hidden;
  margin-bottom: 20px;
}

.left-content-box {
  height: 184px;
}

.last-right {
  width: 31%;
  border: 1px solid #d1e4f0;
  border-radius: 4px;
  border-top: none;
}
</style>