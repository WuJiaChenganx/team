<template>
  <div class="doctor">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="doctorContent">
      <div class="doctorAside">
        <div class="doctorAsideTitle">团队概况</div>
        <div class="doctorAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="doctorAsideItem"
              v-for="(menuItem, menuIndex) in Menu"
              :key="menuIndex"
              :index="menuItem.path"
            >
              <i class="el-icon-sunny"></i>
              <span>{{ menuItem.name }}</span>
            </el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="doctorDetail">
        <div class="doctorTitle">
          <div class="title">博士生</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/team/doctor' }"
                >博士生</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="doctorItem">
          <div
            class="detailItem"
            v-for="memberItem in studentAllInfo"
            :key="memberItem.id"
            style="cursor: pointer"
            @click="gotoDetail(memberItem)"
          >
            <div class="detailItemImg"><img :src="memberItem.picUrl" /></div>
            <div class="detailItemInfo">
              {{ memberItem.name }} {{ memberItem.title }}
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
      title: "团队概况",
      currentMenu: "博士生",
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      studentAllInfo: [
        {
          id: 1,
          name: "张恒聪",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "机器翻译、自然语言处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
        {
          id: 2,
          name: "马云",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
        {
          id: 3,
          name: "马化腾",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
        {
          id: 4,
          name: "赵云",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
        {
          id: 5,
          name: "赵云123",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
        {
          id: 6,
          name: "赵云456",
          title: "博士研究生",
          email: "zhangshaolei20z@ict.ac.cn",
          direction: "深度学习图像处理",
          education: [
            { time: "2016-2020", experience: "北京邮电大学,工学硕士" },
            {
              time: "2020-present",
              experience: "中科院计算技术研究所,博士在读",
            },
          ],
          paperList: [
            {
              id: 1,
              paper:
                "Shaolei Zhang, Yang Feng. Modeling Dual Read/Write Paths for Simultaneous Machine Translation",
            },
            {
              id: 2,
              paper:
                "Shaolei Zhang, Yang Feng. Reducing Position Bias in Simultaneous Machine Translation with Length-Aware Framework.",
            },
          ],
          picUrl: require("../../assets/images/teacherPhoto/lq.jpg"),
        },
      ],
    };
  },
  created() {},
  methods: {
    gotoDetail(item) {
      this.$router.push({
        path: "/team/studentDetail",
        name: "学生详情",
        // 用query传参,在地址栏后面加东西如 ?id=1这种跟在网址后面
        query: {
          // 传参数的时候注意将对象转化成字符串并且加密,在接收端使用解析
          // 如果不这样做的话就会导致,刷新一下传参的东西解析不了
          item: encodeURIComponent(JSON.stringify(item)),
        },
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .doctor {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .doctorContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .doctorAside {
    width: 25%;
  }
  .doctorAsideTitle {
    background: url(../../assets/images/background/zryy-menu-t-bg.png) no-repeat;
    border-radius: 0.6rem;
    background-size: cover !important;
    font-weight: bold;
    color: #fff;
    font-size: 2rem;
    line-height: 3rem;
    height: 3rem;
    padding: 2rem 3rem;
    margin-bottom: 0.5rem;
  }
  .doctorAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .doctorDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .doctorTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .doctorItem {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
    padding: 3rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
    padding: 1rem;
    width: 20rem;
  }

  .detailItem img {
    width: 100%;
    height: 23rem;
  }

  .detailItem .detailItemInfo {
    padding: 1rem 0;
  }
}
/* 移动端  */
@media screen and (max-width: 1000px) {
  .doctor {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .doctorContent {
    display: flex;
    flex-direction: column;
  }

  .doctorAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .doctorAsideTitle {
    display: none;
  }
  .doctorAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .doctorDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .doctorTitle {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 2rem 0;
    border-bottom: 1px solid #dfdfdf;
  }
  .title {
    color: #333333;
    font-weight: bold;
    font-size: 2.5rem;
  }
  .breadCrumb {
    padding-top: 1rem;
  }
  /* 选中侧边导航的背景颜色 */
  .el-menu-item.is-active {
    background: #008cd6 !important;
  }

  .doctorItem {
    display: flex;
    flex-direction: column;
    padding: 2rem 0;
  }
  .detailItem {
    cursor: pointer;
    text-decoration: none;
    margin-bottom: 2rem;
  }

  .detailItem img {
    width: 20rem;
    height: 23rem;
  }

  .detailItem .detailItemInfo {
    padding: 1rem 0;
  }
}
</style>
