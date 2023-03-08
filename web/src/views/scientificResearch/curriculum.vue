<template>
  <div class="resourceSharing">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="resourceContent">
      <div class="aside">
        <div class="asideTitle">
          {{ title }}
        </div>
        <div class="asideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="contentItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span slot="title">{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="details">
        <div class="detailTitle">
          <div class="currentTitle">
            {{ currentMenu }}
          </div>
          <div style="float: right; color: #999; font-size: 15px">
            您当前的位置: 首页 > {{ title }} >{{ currentMenu }}
          </div>
        </div>
        <div
          class="detailItem"
          v-for="(courseItem, index) in courses"
          :key="courseItem.courseType"
        >
          <div class="courseType">
            {{ index + 1 }}. {{ courseItem.courseType }}
          </div>
          <div class="courseProfile">{{ courseItem.profile }}</div>
          <div
            v-for="courseListItem in courseItem.courseList"
            :key="courseListItem.id"
          >
            <div class="courseName">
              {{ courseListItem.id }}. {{ courseListItem.courseName }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "科研教学",
      currentMenu: "课程教学",
      Menu: [
        { name: "科研方向", path: "/scientificResearch/direction" },
        { name: "科研项目", path: "/scientificResearch/project" },
        { name: "科研平台", path: "/scientificResearch/platform" },
        { name: "课程教学", path: "/scientificResearch/curriculum" },
      ],
      courses: [
        {
          courseType: " 本科生教学",
          profile:
            "主讲:《人工智能导论》、《Principles of Computer Networks》(《计算机网络原理》留学生)、《计算机网络原理》、《无线传感器网络》",
          courseList: [
            {
              id: 1,
              courseName:
                "教育部2018年第一批产学合作协同育人项目，“基于Python的程序设计课程教学改革”，2019.02-2020.02，项目负责人，排名：1/4；",
            },
            {
              id: 2,
              courseName:
                "浙江工业大学校级教学改革项目，“物联网工程专业国际化人才培养模式的创新与实践”，2015.08-2016.12，项目负责人，排名1/6；",
            },
            {
              id: 3,
              courseName:
                "2018全国高校计算机教育大会优秀论文奖，“面向国际化人才培养的物联网工程专业课程体系改革探索-以浙江工业大学为例”，2018.04，教育部高等学校计算机类专业教学指导委员会，排名：1/4；",
            },
          ],
        },
        {
          courseType: " 研究生教学",
          profile:
            "主讲:《人工智能及其应用》、《Principles and Design of Wireless Sensor Networks》",
          courseList: [
            {
              id: 1,
              courseName:
                "浙江省“十四五”研究生课程思政示范课程，“人工智能及其应用”，2022.12，项目负责人，1/6；",
            },
            {
              id: 2,
              courseName:
                "浙江工业大学校级研究生核心课程建设项目，“人工智能及其应用”，2022.11-2023.12，项目负责人，1/4；",
            },
          ],
        },
      ],
    };
  },
  created() {},
  methods: {},
};
</script>
<style scoped>
.resourceSharing {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.resourceContent {
  padding-top: 20px;
  width: 75%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.aside {
  width: 25%;
  height: auto;
  padding: 0 15px;
  float: left;
}

.asideTitle {
  background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat
    center;
  border-radius: 6px;
  background-size: cover !important;
  font-weight: bold;
  color: #fff;
  font-size: 22px;
  line-height: 30px;
  height: 30px;
  padding: 20px 30px;
  margin-bottom: 10px;
}

.asideContent {
  height: auto;
  border: 1px solid #eee;
}

.currentTitle {
  float: left;
  color: #333333;
  font-weight: bold;
  font-size: 25px;
}

.contentItem {
  font-weight: bold;
  font-size: 20px;
  text-align: left;
  cursor: pointer;
  padding: 0 20px;
  border-bottom: 1px solid #eee;
}

.el-menu-item.is-active {
  background: #008cd6 !important;
}

.details {
  float: left;
  position: relative;
  padding: 0 15px;
  width: 75%;
  height: auto;
  background-color: #fff;
  border: 1px solid #dfdfdf;
  padding-bottom: 150px;
}

.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
}

.detailItem {
  word-wrap: break-word;
  word-break: break-all;
  width: 100%;
  height: auto;
  line-height: 30px;
  margin-top: 30px;
  text-align: left;
}
.courseType {
  font-size: 16px;
  font-weight: bold;
}
.courseProfile {
  font-size: 15px;
}
.courseName {
  text-indent: 2em;
  font-size: 14px;
}
</style>
