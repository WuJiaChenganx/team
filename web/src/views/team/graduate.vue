<template>
  <div class="graduate">
    <!-- default-active表示是当前选中的菜单的index -->
    <div class="graduateContent">
      <div class="graduateAside">
        <div class="graduateAsideTitle">团队概况</div>
        <div class="graduateAsideContent">
          <el-menu
            :default-active="this.$route.path"
            router
            mode="vertical"
            background-color="#ffffff"
            text-color="#000"
            active-text-color="#fff"
          >
            <el-menu-item
              class="graduateAsideItem"
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
      <div class="graduateDetail">
        <div class="graduateTitle">
          <div class="title">毕业生</div>
          <div class="breadCrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }"
                >首页</el-breadcrumb-item
              >
              <el-breadcrumb-item :to="{ path: '/team/graduate' }"
                >毕业生</el-breadcrumb-item
              >
            </el-breadcrumb>
          </div>
        </div>
        <div class="graduateItem">
          <div
            class="detailItem"
            v-for="(memberItem, index) in studentCover"
            :key="index"
            @click="gotoDetail(memberItem.id)"
          >
            <div class="detailItemImg">
              <img :src="memberItem.picUrl" @error="setDefaultImage" />
            </div>
            <div class="detailItemInfo">
              {{ memberItem.comeInDate }}届 {{ memberItem.name }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getMemberCover } from "@/api/api";
// 设置默认缺失的图片
import defaultImage from "@/assets/images/member/default.png";
export default {
  data() {
    return {
      Menu: [
        { name: "团队简介", path: "/team/profile" },
        { name: "导师", path: "/team/teacher" },
        { name: "博士生", path: "/team/doctor" },
        { name: "硕士生", path: "/team/master" },
        { name: "毕业生", path: "/team/graduate" },
      ],
      studentCover: [],
    };
  },
  created() {
    this.getMemberCoverList();
  },
  methods: {
    // async和await用于同步,就是按顺序执行
    async getMemberCoverList() {
      let params = {
        start: 0,
        end: 100,
        memberType: "graduate",
      };
      await getMemberCover(params).then((res) => {
        this.studentCover = res.data;
      });
    },
    // 设置默认缺失的图片
    setDefaultImage(e) {
      e.target.src = defaultImage;
    },
    gotoDetail(id) {
      this.$router.push({
        path: "/team/studentDetail",
        name: "学生详情",
        query: {
          id: id,
        },
      });
    },
  },
};
</script>
<style scoped>
/* PC端  */
@media screen and (min-width: 1000px) {
  .graduate {
    padding: 3rem 0;
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .graduateContent {
    width: 75%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .graduateAside {
    width: 25%;
  }
  .graduateAsideTitle {
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
  .graduateAsideItem {
    font-size: 2rem;
    text-align: left;
    cursor: pointer;
  }

  .graduateDetail {
    width: 73%;
    padding: 0 3rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .graduateTitle {
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

  .graduateItem {
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
  .graduate {
    background: url(../../assets/images/background/contentBackground.jpg)
      no-repeat;
  }

  .graduateContent {
    display: flex;
    flex-direction: column;
  }

  .graduateAside {
    width: 100%;
  }
  /* 不显示侧边导航栏上面的标题 */
  .graduateAsideTitle {
    display: none;
  }
  .graduateAsideItem {
    font-size: 2rem;
    text-align: center;
    cursor: pointer;
  }

  .graduateDetail {
    width: 100%;
    padding: 0 1.5rem;
    box-sizing: border-box;
    background-color: #fff;
    border: 1px solid #dfdfdf;
  }

  .graduateTitle {
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

  .graduateItem {
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
/* .resourceSharing {
  padding: 30px 0 50px 0;
  background: url(../../assets/images/background/contentBackground.jpg)
    no-repeat;
  width: 100%;
  height: auto;
}

.resourceContent {
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
}

.detailTitle {
  height: 30px;
  border-bottom: 1px solid #dfdfdf;
  padding-top: 32px;
  padding-bottom: 20px;
  margin-bottom: 20px;
}

.detailItem {
  float: left;
  padding: 10px;
  width: 200px;
  height: auto;
}

.detailItem img {
  width: 200px;
  height: 230px;
}

.detailItem .memberInfo {
  width: 100%;
  padding: 10px 0;
} */
</style>
